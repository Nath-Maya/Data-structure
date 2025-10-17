# Actividad 3 — Operaciones con matrices 🎯

Breve

Programa en Java con un menú que permite crear dos matrices (enteros), imprimirlas y hacer operaciones: suma, resta, multiplicación matricial y multiplicación por escalar. Todo implementado con funciones y paso de parámetros.

Funciones clave

- Crear/llenar/mostrar matriz 🧾
- Sumar / Restar ✅
- Multiplicar matrices × (si dimensiones compatibles) ➗
- Multiplicar por escalar ✖️

Validaciones rápidas

- Rechazar dimensiones ≤ 0
- Suma/resta: mismas dimensiones
- Producto matricial: A.columns == B.rows
- Revisar que las matrices existan antes de operar

Ejemplo de menú (resumen)

1. Crear matrices A y B
2. Imprimir A / Imprimir B
3. Sumar A + B
4. Restar A - B
# Actividad 3 — Operaciones con matrices 🧮

Objetivo

Crear un programa con menú que permita trabajar con dos matrices de enteros: crearlas, llenarlas, mostrarlas (con posiciones) y realizar operaciones (suma, resta, multiplicación por escalar y multiplicación matricial). Todo debe implementarse usando funciones y paso de parámetros. ✨

Funcionalidades principales

- Generar dos matrices de enteros de cualquier tamaño, insertar elementos e imprimirlas con sus posiciones 📋
- Sumar y restar las matrices (validando dimensiones) ➕➖
- Multiplicar una matriz por un escalar (pedir un entero y calcular el producto escalar) 🔢✖️
- Multiplicar las dos matrices (validando compatibilidad de dimensiones) ✖️🔁

Validaciones rápidas

- Dimensiones > 0
- Suma/ resta: mismas filas y columnas
- Multiplicación matricial: columnas de A == filas de B
- Verificar que las matrices estén creadas antes de operar ✅

Uso breve

1. Ejecuta el programa y usa el menú para crear/llenar las matrices.
2. Selecciona la operación que quieras realizar.

Compilar y ejecutar (ejemplo genérico Java)

```bash
javac -d out "Activity 3"/*.java
java -cp out Main
```

Notas

- Mantén la lógica en funciones separadas y evita variables globales.
- El README es intencionalmente corto; si quieres, puedo añadir ejemplos de entrada/salida o generar la plantilla Java con funciones listas. �
