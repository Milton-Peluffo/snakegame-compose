## Descripción General ##
Snake Game Compose es una aplicación Android que implementa el clásico juego Snake con una estética retro inspirada en la consola Nintendo GameBoy. La aplicación está construida completamente con Jetpack Compose para el renderizado de UI y gestión de estado.

## Estructura del proyecto ##
com.tomildev.snakegame_compose/  
├── MainActivity.kt  
├── gamelogic/  
│   ├── SnakeGame.kt  
│   └── GameState.kt  
├── ui.gameui/  
│   ├── SnakeGameUI.kt  
│   ├── GameButtons.kt  
│   └── MenuScreen.kt  
├── ui.theme/  
│   ├── Theme.kt  
│   └── Color.kt  
└── ui.assets/  
    └── VectorIcons.kt

# Funcionamiento del juego #

## Movimiento continuo por corrutinas

El juego actualiza el movimiento de la serpiente cada 225 ms, utilizando LaunchedEffect y un while para mantener el bucle de juego activo.

<img width="394" height="79" alt="image" src="https://github.com/user-attachments/assets/2d4b8535-8fd6-475e-8b71-d371ecca059f" />

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
