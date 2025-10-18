# 🪐 Galactic Competition

**Galactic Competition** es una API REST desarrollada con **Spring Boot** que simula una competencia interestelar entre especies.
Permite registrar especies, hacer que luchen entre sí y consultar un ranking de las más poderosas.

---

## 🚀 Características principales

* **Agregar especies** con nombre, habilidad especial y nivel de poder.
* **Realizar combates** entre dos especies y determinar al ganador.
* **Consultar el ranking** de las especies según sus victorias.
* **Documentación automática** con **Swagger / OpenAPI**.

---

## 🧩 Tecnologías utilizadas

* **Java 21**
* **Spring Boot 3.5.6**
* **Lombok**
* **Springdoc OpenAPI 2.7.0**
* **Maven**

---

## 📦 Instalación y ejecución

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/Marcel202101/Galactic-Competition
cd galactic_competition
```

### 2️⃣ Compilar el proyecto

```bash
mvn clean install
```

### 3️⃣ Ejecutar la aplicación

```bash
mvn spring-boot:run
```

Por defecto, la aplicación estará disponible en:

```
http://localhost:8080
```

---

## 🔍 Documentación Swagger

Una vez iniciada la aplicación, accede a la documentación interactiva en:

👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 🧠 Endpoints principales

### ➕ **Agregar especie**

**POST** `/addSpecies`

#### Ejemplo de request:

```json
{
  "name": "Monkey",
  "special": "DROP BANANAS",
  "powerLevel": 15
}
```

#### Ejemplo de respuesta:

```json
{
  "species": [
    {
      "name": "Monkey",
      "special": "DROP BANANAS",
      "powerLevel": 15
    }
  ]
}
```

---

### ⚔️ **Realizar combate**

**POST** `/fight`

#### Ejemplo de request:

```json
{
  "fighter1": "Monkey",
  "fighter2": "Lizard"
}
```

#### Ejemplo de respuesta:

```json
{
  "fighter1": {
    "name": "Monkey",
    "special": "DROP BANANAS",
    "powerLevel": 15
  },
  "fighter2": {
    "name": "Lizard",
    "special": "TOXIC BREATH",
    "powerLevel": 10
  },
  "winner": "Monkey"
}
```

---

### 🏆 **Consultar ranking**

**GET** `/ranking`

#### Ejemplo de respuesta:

```json
[
  {
    "position": 1,
    "name": "Monkey",
    "wins": 3
  },
  {
    "position": 2,
    "name": "Lizard",
    "wins": 1
  }
]
```

---

## ⚙️ Estructura del proyecto

```
src/main/java/com/galactic_competition/galactic_competition
├── constants/          # Textos y descripciones HTML para Swagger
├── controllers/        # Controladores REST
├── entities/           # Entidades del dominio (Species, Combat)
├── models/             # Modelos de request/response
├── repository/         # Clases en memoria que simulan persistencia
├── service/            # Lógica de negocio
└── GalacticCompetitionApplication.java
```

---

## 🧰 Requisitos previos

* JDK **21**
* Maven **3.9+**
* IDE compatible con Lombok (IntelliJ, Eclipse, VS Code)

  ⚠️ Asegúrate de tener **Lombok habilitado** en tu IDE
  (plugin instalado y “Annotation Processing” activado)

---

## ✨ Autor

**Marcel González**
📧 Contacto: [marcel202101@gmail.com](mailto:marcel202101@gmail.com)


