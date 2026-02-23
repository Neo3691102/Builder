# 🏗 Patrón de Diseño Builder -- Ejemplo en Java

![Java](https://img.shields.io/badge/Java-POO-orange) ![Design
Pattern](https://img.shields.io/badge/Pattern-Builder-blue)
![Paradigm](https://img.shields.io/badge/Paradigm-Object%20Oriented-green)

------------------------------------------------------------------------

## 📌 Descripción

Este proyecto implementa el **Patrón de Diseño Builder** utilizando
Java, aplicándolo a la construcción de un objeto `Casa` con atributos
obligatorios y opcionales.

El objetivo del proyecto es demostrar cómo el patrón Builder:

-   Mejora la legibilidad del código
-   Evita constructores telescópicos
-   Permite crear objetos inmutables
-   Facilita validaciones previas a la construcción
-   Separa la lógica de construcción de la representación final

------------------------------------------------------------------------

## 🧠 ¿Qué es el Patrón Builder?

El **Builder** es un patrón de diseño creacional que permite construir
objetos complejos paso a paso, proporcionando mayor control sobre el
proceso de creación.

Se utiliza especialmente cuando:

-   Hay muchos parámetros en el constructor
-   Existen atributos opcionales
-   Se necesita validación antes de crear el objeto
-   Se desea inmutabilidad

------------------------------------------------------------------------

## 🏠 Caso de Estudio: Clase `Casa`

### 🔹 Atributos Obligatorios

-   `puertas`
-   `color`

### 🔹 Atributos Opcionales

-   `chimenea`
-   `ventanas`
-   `arbustos`

La clase es **inmutable**, ya que:

-   Todos los atributos son `final`
-   No existen setters
-   Solo se inicializa mediante constructor y Builder

------------------------------------------------------------------------

## 🏗 Implementación del Builder

La clase contiene una clase interna estática:

``` java
public static class CasaBuilder
```

### 🔹 Constructor del Builder (obligatorios)

``` java
new Casa.CasaBuilder(int puertas, String color)
```

### 🔹 Métodos Encadenados (opcionales)

``` java
.conChimenea()
.conVentanas(3)
.conArbustos()
```

### 🔹 Construcción final

``` java
.build()
```

Incluye validación antes de crear el objeto:

``` java
if (this.puertas <= 0) {
    throw new Exception("La casa debe tener al menos una puerta");
}
```

------------------------------------------------------------------------

## 🚀 Ejemplo de Uso

### ❌ Sin Builder

``` java
Casa casa = new Casa(true, 0, false, 1, "azul");
```

### ✅ Con Builder

``` java
Casa casa = new Casa.CasaBuilder(1, "verde")
        .conArbustos()
        .build();
```

------------------------------------------------------------------------

## 🧩 Flujo de Construcción

Cliente → CasaBuilder → Validación → Creación de Casa

------------------------------------------------------------------------

## 📂 Estructura del Proyecto

    PatronBuilder/
     ├── Casa.java
     └── Contexto.java

------------------------------------------------------------------------

## 🎯 Objetivos Académicos

Este proyecto demuestra:

-   Aplicación práctica de patrón creacional
-   Encapsulamiento
-   Inmutabilidad
-   Encadenamiento de métodos (Fluent Interface)
-   Validación previa a construcción
-   Buenas prácticas en diseño orientado a objetos

------------------------------------------------------------------------

## 📄 Conclusión

El patrón Builder es ideal cuando se necesita construir objetos
complejos con múltiples configuraciones posibles. En este proyecto, se
demuestra cómo estructurarlo correctamente en Java, incluyendo
validación y separación clara de responsabilidades.
