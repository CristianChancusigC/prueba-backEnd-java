# 💻 Proyecto Java Spring Boot + MySQL con Docker

Este proyecto implementa una API REST desarrollada con **Java y Spring Boot**, que permite la gestión de cuentas bancarias, clientes y movimientos. La aplicación está contenedorizada usando Docker y conectada a una base de datos MySQL.

## 📦 Tecnologías utilizadas

- Java 17+
- Spring Boot
- MySQL 8
- Maven
- Docker & Docker Compose

---

## ✅ Funcionalidades principales

### 🔹 F1: Generación de CRUDs

Se implementaron los endpoints para **crear, leer, actualizar y eliminar** registros de las siguientes entidades:

- `Cliente`
- `Cuenta`
- `Movimiento`

---

### 🔹 F2: Registro de Movimientos

- Se permite registrar **movimientos con valores positivos o negativos**.
- Al realizar un movimiento, **se actualiza automáticamente el saldo** disponible de la cuenta.
- Se lleva el **historial completo de transacciones**.

### 🔹 F3: Validación de saldo insuficiente

- Al intentar realizar un movimiento que supere el saldo disponible, el sistema retorna el siguiente mensaje de error:

```bash
{
    "message": "Saldo insuficiente para realizar el movimiento"
}
```

- Este error se captura y gestiona utilizando **manejadores de excepciones personalizados (Exception Handling)** en Spring.

---

## 🔬 Pruebas

El proyecto incluye pruebas unitarias y de integración para garantizar el correcto funcionamiento de la lógica de negocio, especialmente para:

- Validación del saldo
- Actualización de saldos en movimientos
- Comprobación de los endpoints principales

---

## 🛠️ Configuración del entorno

### 1. Clonar el repositorio

```bash
git clone https://github.com/CristianChancusigC/prueba-backEnd-java.git
cd prueba-java
```

### 2. Construir el archivo `.jar`

```bash
./mvnw clean package
```

⚠️ Asegúrate de compilar el .jar cada vez que hagas cambios en la app Java.

### 3. Construir el servicio Docker Compose

```bash
docker-compose build java_app
```

### 4. Levantar los contenedores con Docker Compose

```bash
docker-compose up
```

Esto iniciará:

- Un contenedor para la app Java (java_app)
- Un contenedor para MySQL (java_db)

### Autor

- Cristian Chancusig
- [LinkedIn](www.linkedin.com/in/cristian-chancusig-153520247) / [GitHub](https://github.com/CristianChancusigC) / [Portafolio](https://cristianchancusigc.github.io/my-portfolio/)
