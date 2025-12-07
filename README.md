## Descripción General ##
Snake Game Compose es una aplicación Android que implementa el clásico juego Snake con una estética retro inspirada en la consola Nintendo GameBoy. La aplicación está construida completamente con Jetpack Compose para el renderizado de UI y gestión de estado.

## Estructura del proyecto ##
📂 com.tomildev.snakegame_compose<br>
├── 📄 MainActivity.kt — inicia la app y carga la UI<br>
│    <br>
├── gamelogic/<br>
│ ├── 📄 GameState.kt — estados, posicion, direccion y config del grid<br>
│ └── 📄 SnakeGame.kt — logica del snake: movimiento, colisiones, comida<br>
│<br>
├── ui.gameui/<br>
│ ├── 📄 SnakeGameUI.kt — dibuja la consola, el juego (grid, snake, comida)<br>
│ ├── 📄 GameButtons.kt — botones A/B, start, select y direcciones<br>
│ └── 📄 MenuScreen.kt — menu inicial con splash y “press start”<br>
│<br>
├── ui.theme/<br>
│ ├── 📄 Theme.kt — tema general de la app<br>
│ └── 📄 Color.kt — paleta de colores personalizada estilo retro<br>
│<br>
└── ui.assets/<br>
  └── 📄 VectorIcons.kt — icono vectorial usado en la UI 🎧


# UI del juego

### Toda la UI de la aplicacion está basada en un dieseño retro, simulando la antigua consola de nintendo GameBoy con sus respectivos botones y su pantalla de juego, todo esto diseñado con colores pasteles suaves para darle una agradable vista al usuario <br>

<table>
  <tr>
    <td>
        <img src="https://github.com/user-attachments/assets/5baaeb79-c00a-47eb-a7c8-2b5e775f17ce" width="350" />
    </td>
    <td>
      <h2>Vista con menu de inicio</h2>
      Esta vista contiene la pantalla inicial del juego, con una imagen estilo retro simulando el splash del juego
      y un texto parpadeante en la parte inferior de la imagen con el texto: "PRESS START TO PLAY".
    </td>
  </tr>

  <tr>
    <td>
      <img src="https://github.com/user-attachments/assets/af9b7a1d-2ac2-4d89-ad79-f8f2f8c8b0c0" width="350"/>
    </td>
    <td>
      <h2>Vista con el juego</h2>
      Luego de presionar "START", aparece la serpiente y el jugador puede moverla
      por la pantalla para jugar.
    </td>
  </tr>

  <tr>
    <td>
      <img src="https://github.com/user-attachments/assets/52aff9e7-b4bc-43b6-8d61-98e3ac264880" width="350"/>
    </td>
    <td>
      <h2>Limites de los layouts</h2>
      Vista donde se muestran los limites de cada layout de la pantalla 
      delineados para depuracion.
    </td>
  </tr>
</table>

# Funcionamiento del juego #

## Movimiento continuo por corrutinas

El juego actualiza el movimiento de la serpiente cada 225 ms, utilizando LaunchedEffect y un while para mantener el bucle de juego activo.

<img width="394" height="79" alt="image" src="https://github.com/user-attachments/assets/2d4b8535-8fd6-475e-8b71-d371ecca059f" />

## Movimiento de la serpiente:

A continuacion, esta es la explicacion por partes del movimiento de la serpiente en la cuadricula.

Mediante data classes almacenadas en el archivo GameState.kt,
Se establecen las posibles posiciones para el posicionamiento de las partes de la serpiente en la cuadricula, en este caso X,Y

<img width="236" height="126" alt="image" src="https://github.com/user-attachments/assets/9770a3a8-991e-4732-9e2d-15647eaf940a" />

Y en el mismo archivo, se establecen las posibles direcciones en las que la serpiente puede moverse. [Arriba, abajo, izquierda, derecha]

<img width="252" height="98" alt="image" src="https://github.com/user-attachments/assets/f19304e3-2a51-4a66-bb2d-cf435eb0600f" />

## Codigo del movimiento de la serpiente en la cuadricula

<img width="680" height="479" alt="image" src="https://github.com/user-attachments/assets/a2b85302-cb14-408f-8a2e-ecb6b8bd7ab7" />

### Explicación breve del funcionamiento del movimiento y la posicion de la serpiente en la cuadricula: 

#### Direction.UP<br>
Resta 1 a la coordenada Y para mover la cabeza hacia arriba.<br>
Si newY es menor que 0, significa que se salio del limite superior del grid, por eso retorna null.

#### Direction.DOWN<br>
Suma 1 a Y para bajar una casilla.<br>
Si newY es mayor o igual al numero total de filas (grid.rows), esta fuera del tablero.

#### Direction.LEFT<br>
Resta 1 a X para mover la cabeza hacia la izquierda.<br>
Si newX es menor que 0, se salio por el borde izquierdo.

#### Direction.RIGHT<br>
Suma 1 a X para mover la cabeza hacia la derecha.<br>
Si newX es mayor o igual al total de columnas (grid.columns), significa que se fue del limite derecho.

## Alimento aleatorio
La comida aparece en posiciones aleatorias dentro de una cuadricula de 18x18.

<img width="494" height="34" alt="image" src="https://github.com/user-attachments/assets/4bb21de4-d7b8-484b-93ee-b5f0cd770a7b" />

Si la posicion actual del cuerpo en el grid contiene tambien la posicion de la comida

<img width="356" height="29" alt="image" src="https://github.com/user-attachments/assets/313f4452-0438-4841-ad6b-4d4a3acafe8e" />

La serpiente la come y su tamaño aumenta en una variable llamada bodySize.

<img width="367" height="92" alt="image" src="https://github.com/user-attachments/assets/103b59da-59de-4211-832c-fc9de8b95ea7" />

Y se genera un nuevo alimento de inmediato con una posición aleatoria.

## Colisiones implementadas

### En el juego se manejan dos tipos de colisiones + la colision con la comida anteriormente mencionada
1. Choque con los bordes
  
- Si la serpiente intenta moverse fuera del grid (newHead == null).

2. Choque consigo misma
- Si la nueva cabeza aparece en una posicion donde ya hay una parte de su cuerpo.

<img width="539" height="23" alt="image" src="https://github.com/user-attachments/assets/ff46a26d-8f72-4d51-9ecd-e162af662331" />

Cuando lo anterior pasa, la serpiente parpadea en pantalla con un efecto de parpadeo modificando el alpha.

<img width="697" height="229" alt="image" src="https://github.com/user-attachments/assets/796c87c7-46eb-4eca-9e56-f2c017f93dc5" />

Choque y retorno al menu

Primero esperan 1800 ms para que se vea la animacion de parpadeo.

<img width="282" height="72" alt="image" src="https://github.com/user-attachments/assets/b68f3e87-1dd1-448a-865d-95c79ea7b948" />

Y luego se devuelve al menu principal del juego.

<img width="255" height="33" alt="image" src="https://github.com/user-attachments/assets/fa1051a1-b7c0-4389-95fe-99f9049a3ca0" />


### Reinicio del juego
- Cada partida comienza con:
1. La serpiente en posicion (5,5)
2. Direccion inicial RIGHT
3. Tamaño inicial 3
4. La logica esta centralizada en la funcion lambda StartGame().

<img width="427" height="142" alt="image" src="https://github.com/user-attachments/assets/f237e284-0b20-4799-977c-ec0293ced86b" />
