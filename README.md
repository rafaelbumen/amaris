# Proyecto AMARIS

## 📌 Requisitos Previos
Antes de empezar, asegúrate de tener instalado:
- **Java 17** ([Descargar](https://adoptium.net/))
- **Maven** (`mvn -v` para verificar)
- **Node.js** y **npm** (`node -v` y `npm -v` para verificar) ([Descargar](https://nodejs.org/))
- **Git** (`git --version` para verificar)

---

## 🚀 Instalación y Ejecución

### 1️⃣ Clonar el Repositorio
```sh
git clone <URL_DEL_REPOSITORIO>
cd <NOMBRE_DEL_PROYECTO>
```

---

## ⚙️ Backend (Spring Boot)
📌 **Ubicación:** `backend/`

### 2️⃣ Configurar y Ejecutar el Backend

#### ✅ Verificar Java 17
```sh
java -version
```
Si no tienes Java 17, instálalo o usa **SDKMAN**:
```sh
sdk install java 17.0.9-tem
```

#### ✅ Compilar el Backend
```sh
cd backend
mvn clean package
```
Esto generará `backend-1.0.0.war` en `target/`.

#### ✅ Ejecutar el Backend
```sh
java -jar target/backend-1.0.0.war
```
Para desarrollo con **Spring Boot Devtools**, usa:
```sh
mvn spring-boot:run
```
📌 El backend estará disponible en: `http://localhost:8080`

---

## 💻 Frontend (React + Vite)
📌 **Ubicación:** `frontend/`

### 3️⃣ Configurar y Ejecutar el Frontend

#### ✅ Verificar Node.js
```sh
node -v
npm -v
```
Si no lo tienes, descárgalo desde [Node.js](https://nodejs.org/).

#### ✅ Instalar Dependencias
```sh
cd frontend
npm install
```

#### ✅ Ejecutar el Frontend
```sh
npm run dev
```
📌 El frontend estará disponible en: `http://localhost:5173`

---

## 🎯 Desplegar con Backend y Frontend Juntos

### 4️⃣ Generar el Build del Frontend
```sh
cd frontend
npm run build
```
Esto generará la carpeta `dist/` con los archivos estáticos.

### 5️⃣ Copiar los Archivos al Backend
```sh
cp -r frontend/dist/* backend/src/main/resources/static/
```

### 6️⃣ Recompilar el Proyecto
```sh
cd backend
mvn clean package
```

### 7️⃣ Ejecutar la Aplicación con Todo Integrado
```sh
java -jar target/backend-1.0.0.war
```
📌 Ahora, la aplicación React se servirá desde `http://localhost:8080/index.html`.

---

✅ ¡Listo! La aplicación está configurada y lista para usarse. 🚀