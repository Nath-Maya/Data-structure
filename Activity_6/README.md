# Activity 6 — Gestión de Pacientes (Lista doblemente enlazada)

Pequeña aplicación en Java para gestionar pacientes de una clínica usando una lista doblemente enlazada propia. Está pensada para ejecutarse por consola y demuestra POO, principio de responsabilidad única y manejo manual de la estructura enlazada.

Características principales
- Estructura dinámica propia: lista doblemente enlazada (no se usan `LinkedList` de Java).
- Menú interactivo en español con mensajes claros y colores ANSI.
- Validaciones básicas (códigos únicos, entradas numéricas).
- Operaciones: registrar, listar (ASC/DSC por código), actualizar, buscar por edad, eliminar y salir.

Estructura de archivos (en `Activity_6`)
- `Patient.java` — clase registro con los campos: `code`, `name`, `lastName`, `address`, `phone`, `age`.
- `Node.java` — nodo de la lista doblemente enlazada (contiene `Patient`, `next`, `previous`).
- `DoublyLinkedList.java` — implementación de la lista y operaciones sobre ella.
- `PatientManager.java` — lógica del menú y la interacción con el usuario (entrada/salida, validaciones).
- `Main.java` — punto de entrada que inicia el gestor.

Cómo compilar y ejecutar
Desde la raíz del proyecto (`Data-structure`) ejecuta:

```bash
javac Activity_6/*.java
java -cp . Activity_6.Main
```

Notas importantes
- Los textos mostrados están en español y con un tono natural para el usuario.
- Los nombres de variables y métodos usan inglés en formato camelCase.
- Para mejores resultados en color, usa una terminal que soporte códigos ANSI (macOS Terminal, iTerm2, Windows Terminal, etc.).

Sugerencias de mejora
- Persistencia en CSV o base de datos para mantener los datos entre ejecuciones.
- Validaciones más estrictas para teléfonos y direcciones.
- Exportar listados a CSV.

Si quieres, puedo:
- Añadir la persistencia a CSV ahora.
- Ejecutar una prueba simulada y pegar la salida de ejemplo.
- Generar un diagrama UML para esta carpeta.
