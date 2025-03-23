# RecyclerView en Android
## Descripción
Este proyecto es una práctica para aprender a manejar RecyclerView en Android. La aplicación muestra una lista de personajes con su nombre y foto. Al pulsar en un personaje, se abre una nueva actividad (DetailActivity) que muestra más detalles sobre el personaje seleccionado.

## Tecnologías utilizadas
Lenguaje: Kotlin

IDE: Android Studio

Diseño: XML

Componentes principales:

RecyclerView para mostrar la lista de personajes.

Adapter para gestionar la creación y vinculación de vistas.

Intent para la comunicación entre actividades.

## Funcionamiento
MainActivity inicializa el RecyclerView y carga la lista de personajes desde PersonProvider.

PersonAdapter gestiona la creación de vistas y la vinculación de los datos.

Al hacer clic en un personaje, se envía su ID a DetailActivity mediante un Intent.

DetailActivity recibe el ID, busca la información del personaje y la muestra en pantalla.

## Capturas de pantalla
![image](https://github.com/user-attachments/assets/03767550-0901-427e-9245-49ec12acac7a)
