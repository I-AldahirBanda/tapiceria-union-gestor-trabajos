# Tapicería UNIÓN — Gestor de Trabajos (Java)

## Resumen ejecutivo
**Descripción:** Aplicación en Java (consola) para registrar, listar, actualizar estado y eliminar trabajos de tapicería.  
**Problema identificado:** El control manual con libreta/Excel genera pérdida de información, poca trazabilidad y demoras en entregas.  
**Solución propuesta:** Un sistema sencillo que permita gestionar trabajos con **persistencia local** en `.csv`, ejecutable desde consola y con pruebas unitarias básicas (JUnit).  
**Arquitectura (alto nivel):**  
CLI (consola) → Lógica (Trabajo/Repositorio/Servicio) → Persistencia local (`data/trabajos.csv`) → Sistema de archivos.  
DevOps: GitHub (issues/PR/milestones), Trello (tareas), Travis CI (CI, pendiente build).

## 📥 Descargar la última versión
[![Descargar JAR](https://img.shields.io/badge/Descargar%20JAR-v0.1.0-blue)](https://github.com/I-AldahirBanda/tapiceria-union-gestor-trabajos/releases/download/v0.1.0/gestor-trabajos-0.1.0-SNAPSHOT.jar)

> Requisitos: Java 17+. Ejecuta:
>
> ```bash
> java -jar gestor-trabajos-0.1.0-SNAPSHOT.jar
> ```

**Release completo:** [v0.1.0 — Versión Beta](https://github.com/I-AldahirBanda/tapiceria-union-gestor-trabajos/releases/tag/v0.1.0)



## Tabla de contenidos
- [Requerimientos](#requerimientos)
- [Instalación](#instalación)
  - [Ambiente de desarrollo](#ambiente-de-desarrollo)
  - [Pruebas manuales](#pruebas-manuales)
  - [Producción local (JAR)](#producción-local-jar)
  - [Despliegue en la nube (opcional)](#despliegue-en-la-nube-opcional)
- [Configuración](#configuración)
- [Uso](#uso)
  - [Manual de usuario final](#manual-de-usuario-final)
  - [Manual de administrador](#manual-de-administrador)
- [Contribución](#contribución)
- [Roadmap](#roadmap)
- [Arquitectura (detalle)](#arquitectura-detalle)
- [Créditos y licencia](#créditos-y-licencia)

---

## Requerimientos
- **Java 17+**
- **Maven 3.8+**
- **Sistema de archivos local** accesible (Windows/macOS/Linux)
- (Opcional) **Travis CI** conectado al repo para correr JUnit
- (Opcional) Hosting (Heroku u otro) — *en este release se considera ejecución local*

> **Servidores requeridos:** No aplica (app local de consola).  
> **Base de datos:** No aplica (persistencia en archivos `.csv`).  
> **Paquetes adicionales:** Ninguno fuera de Maven (JUnit incluido vía `pom.xml`).

---

## Instalación

### Ambiente de desarrollo
```bash
git clone https://github.com/I-AldahirBanda/tapiceria-union-gestor-trabajos.git
cd tapiceria-union-gestor-trabajos
mvn -q -B test
