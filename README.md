# 🎵 Mini-Spotify

Un sistema de gestión musical inspirado en Spotify, desarrollado en Java que implementa conceptos avanzados de Programación Orientada a Objetos (POO).

## 📋 Descripción

Mini-Spotify es una aplicación de consola que simula las funcionalidades básicas de un reproductor de música. Permite gestionar bibliotecas musicales, crear playlists personalizadas, y reproducir canciones, todo ello aplicando principios de POO como herencia, polimorfismo, interfaces y composición.

## ✨ Características

- **Gestión de Bibliotecas Musicales**: Organiza y almacena colecciones de canciones
- **Playlists Personalizadas**: Crea y administra listas de reproducción
- **Sistema de Cuentas**: Autenticación de usuarios con gestión de sesiones
- **Reproducción de Canciones**: Simula la reproducción y detención de música
- **Búsqueda de Canciones**: Encuentra canciones por título en tu biblioteca
- **Interfaz de Consola**: Menús interactivos para una navegación intuitiva

## 🏗️ Arquitectura del Proyecto

El proyecto está estructurado siguiendo principios de diseño orientado a objetos:

### Clases Principales

- **`Canción`**: Extiende `Multimedia` e implementa `Reproducible`. Representa una canción individual con su artista y duración.
- **`Playlist`**: Gestiona colecciones de canciones con capacidad máxima definida.
- **`BibliotecaMusical`**: Almacena y organiza el catálogo completo de canciones disponibles.
- **`CuentaSpotify`**: Administra las credenciales del usuario, sus playlists y bibliotecas.
- **`App`**: Clase principal que maneja la interfaz de usuario y el flujo de la aplicación.

### Jerarquía y Relaciones

```
Multimedia (Clase Abstracta)
    ↑
    └── Canción (implementa Reproducible)
    
CuentaSpotify
    ├── BibliotecaMusical → Canción
    └── Playlist → Canción
```

## 🚀 Comenzando

### Prerequisitos

- Java JDK 8 o superior
- IDE compatible con Java (Eclipse, IntelliJ IDEA, NetBeans, VS Code)

### Instalación

1. Clona este repositorio:
```bash
git clone https://github.com/ManuelBth/mini-spotify.git
```

2. Navega al directorio del proyecto:
```bash
cd mini-spotify
```

3. Compila el proyecto:
```bash
javac App.java
```

4. Ejecuta la aplicación:
```bash
java App
```

## 💻 Uso

### Iniciar Sesión

Al ejecutar la aplicación, se te solicitará ingresar tus credenciales:
- Usuario
- Contraseña

### Menú Principal

Una vez iniciada la sesión, tendrás acceso a tres opciones principales:

1. **Gestionar Biblioteca**
   - Listar todas las canciones
   - Agregar nuevas canciones
   - Buscar canciones por título

2. **Gestionar Playlists**
   - Crear nuevas playlists
   - Agregar canciones a playlists existentes
   - Ver canciones de una playlist

3. **Reproducir Música**
   - Seleccionar playlist
   - Elegir canción a reproducir
   - Detener reproducción

## 📊 Diagrama de Clases

El proyecto implementa el siguiente diagrama UML:

- **Herencia**: `Canción` hereda de `Multimedia`
- **Interfaces**: `Canción` implementa `Reproducible`
- **Composición**: `CuentaSpotify` contiene `Playlist` y `BibliotecaMusical`
- **Agregación**: `Playlist` y `BibliotecaMusical` agregan objetos `Canción`

## 🎯 Conceptos de POO Implementados

- ✅ **Encapsulamiento**: Atributos privados con getters y setters
- ✅ **Herencia**: Clase abstracta `Multimedia` como base
- ✅ **Polimorfismo**: Interface `Reproducible` con métodos abstractos
- ✅ **Abstracción**: Clase abstracta con método `getInfo()`
- ✅ **Composición y Agregación**: Relaciones entre clases
- ✅ **Sobrescritura**: Método `toString()` personalizado

## 🛠️ Tecnologías

- **Lenguaje**: Java
- **Paradigma**: Programación Orientada a Objetos
- **Entrada/Salida**: Scanner para consola

## 📝 Estructura de Archivos

```
mini-spotify/
│
├── App.java
├── CuentaSpotify.java
├── BibliotecaMusical.java
├── Playlist.java
├── Cancion.java
├── Multimedia.java
├── Reproducible.java
└── README.md
```

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor:

1. Haz un Fork del proyecto
2. Crea una rama para tu feature (`git checkout -b feature/NuevaFuncionalidad`)
3. Commit tus cambios (`git commit -m 'Agrega nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/NuevaFuncionalidad`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

## ✍️ Autor

**Manuel Betancourth**
- GitHub: [@mbth](https://github.com/ManuelBth)

## 🙏 Agradecimientos

- Proyecto desarrollado como parte del Módulo 2 de POO avanzado
- Inspirado en la plataforma Spotify

---

⭐️ Si este proyecto te fue útil, no olvides darle una estrella en GitHub
