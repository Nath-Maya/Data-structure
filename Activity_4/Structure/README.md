# Gestión de Estudiantes — Estructuras y responsabilidades

Este programa gestiona estudiantes con datos personales y sus notas. A continuación se describe, las estructuras anidadas y la responsabilidad de cada una.

## Estructuras principales

- `Student` (clase principal)
  - Contiene los atributos básicos del estudiante:
    - `identificationCode` (int)
    - `name` (String)
    - `lastName` (String)
    - `age` (int)
  - Agrupa las siguientes estructuras anidadas:
    - `Birthdate birthdate` 
    - `Address address`
    - `Grades grades`
  - Responsabilidad: representar un estudiante completo y exponer getters y un `toString()` legible.

- `Birthdate` 
  - Representa la fecha de nacimiento como un arreglo de 3 enteros: día, mes, año.
  - Responsabilidad: encapsular la fecha y proveer métodos para obtener día/mes/año y `toString()`.

- `Address` 
  - Almacena dirección como un arreglo de Strings: dirección, estrato, barrio, ciudad.
  - Responsabilidad: encapsular la dirección y ofrecer acceso a cada campo y `toString()` para impresión.

- `Grades` 
  - Usa un `HashMap<String, Double>` para almacenar las notas (`"Nota 1"`, `"Nota 2"`, `"Nota 3"`).
  - Responsabilidad: guardar las notas y calcular el promedio (`calculateAverage()`).

## Managers 

- `StudentManager`
  - Mantiene una `List<Student>` interna.
  - Encargado de crear estudiantes a partir de la entrada del usuario (`createStudent(Scanner)`), validar algunos campos (p. ej. `identificationCode`) y almacenar los objetos.
  - Provee métodos de consulta/estadística:
    - `getStudents()`
    - `calculateAverageAge()` — promedio de edades
    - `getAdults()` — lista de estudiantes con edad >= 18
    - `getStudentWithHighestAverage()` — el estudiante con mayor promedio
    - `getStudentWithLowestAverage()` — el estudiante con menor promedio
    - `getStudentWithLowestNota1()` — el estudiante con la nota1 más baja

- `BirthdateManager`, `AddressManager`, `GradesManager`
  - Cada uno se encarga exclusivamente de capturar y validar la entrada correspondiente (fecha, dirección, notas).
  - Responsabilidad: aislar la lógica de entrada/validación de `StudentManager` para seguir el principio de responsabilidad única.

## `Main` 

- Coordina el flujo: crea un `StudentManager`, solicita repetidamente la creación de estudiantes hasta que el usuario responda `N`, y luego muestra las estadísticas solicitadas (promedio de edades, mayores de edad, mejor/peor promedio, nota1 más baja).
- También contiene constantes ANSI para colorear/negrita el texto en consola para mejor UX en terminales compatibles.
