# Activity_9 — Gestión de Profesores (Profesor + BST + Persistencia)

[![Lenguaje](https://img.shields.io/github/languages/top/Nath-Maya/Data-structure?color=blue&label=Lenguaje)](https://github.com/Nath-Maya/Data-structure/tree/main/Activity_9) [![Commits (week)](https://img.shields.io/github/commit-activity/w/Nath-Maya/Data-structure?label=Commits%20(week))](https://github.com/Nath-Maya/Data-structure/commits/main) [![Último commit](https://img.shields.io/github/last-commit/Nath-Maya/Data-structure?label=%C3%9Altimo%20commit)](https://github.com/Nath-Maya/Data-structure/commits/main)
![Lenguaje Java](https://img.shields.io/badge/Lenguaje-Java-blue)

Resumen
-------
En este programa se refactoriza el ejercicio de gestión de profesores. A diferencia del ejercicio inicial, los cambios son:

- una clase `Profesor` (registro) para representar cada profesor;
- una `List<Profesor>` (ArrayList) para conservar el orden de inserción y manejo general;
- un `BinarySearchTree` para búsquedas y eliminación eficiente por código (criterio de ordenamiento: código del profesor);
- persistencia en disco (serialización) para guardar y recuperar el listado completo.

Estructura de archivos
----------------------
- `Profesor.java` — clase que representa el registro del profesor (serializable).
- `BinarySearchTree.java` — implementación simple de BST para `Profesor` (orden por `code`).
- `ProfesorManager.java` — coordina la lista, el árbol y la persistencia (guardar/recuperar).
- `Main.java` — menú principal y puntos de entrada del programa (interacción por consola).
- `diagram.puml` — diagrama de clases en PlantUML (describe `Profesor`, `BinarySearchTree`, `ProfesorManager`, `Main`).
- NOTA: los archivos heredados de la copia original (`Professor.java`, `Node.java`, `ProfessorList.java`, `ProfessorManager.java`) están incluidos para referencia histórica pero la implementación activa usa las clases nuevas (`Profesor*`).

Características principales
-------------------------
- Menú completo con opciones para registrar, mostrar, guardar, recuperar, buscar y eliminar profesores.
- Búsqueda y eliminación realizadas mediante un árbol binario de búsqueda (criterio: `codigo`).
- Persistencia: guardar/recuperar la `List<Profesor>` mediante serialización de Java (`profesores.dat` por defecto).
- Mensajes en consola (español), con estilo y separación para facilitar su uso.


