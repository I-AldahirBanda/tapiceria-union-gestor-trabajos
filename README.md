# Tapicería UNIÓN — Gestor de Trabajos (Java)

## Resumen ejecutivo
**Descripción:** App en Java (consola + demo Swing) para registrar, listar, actualizar estado y eliminar trabajos de tapicería.  
**Problema:** Control manual en libreta/Excel genera errores y demoras.  
**Solución:** Sistema simple con persistencia local (.txt/.csv), CLI y una UI de demostración (Swing).  
**Arquitectura:** CLI/ Swing → Lógica (Trabajo/Repositorio/Servicio) → Persistencia en archivos → SO.  
DevOps: GitHub (issues/PR/tags), Trello (tareas), Travis CI (CI, JUnit).

## Tabla de contenidos
- [Requerimientos](#requerimientos)
- [Instalación](#instalación)
- [Configuración](#configuración)
- [Uso](#uso)
  - [Consola (CLI)](#consola-cli)
  - [Demo visual (Swing)](#demo-visual-swing)
- [Contribución](#contribución)
- [Roadmap](#roadmap)
- [Arquitectura (detalle)](#arquitectura-detalle)
- [Créditos y licencia](#créditos-y-licencia)

## Requerimientos
- Java **17+**
- Maven **3.8+**
- Sistema de archivos local
- (Opcional) Travis CI

## Instalación
```bash
git clone https://github.com/I-AldahirBanda/tapiceria-union-gestor-trabajos.git
cd tapiceria-union-gestor-trabajos
mvn -q -B test
