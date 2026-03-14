# Guía de Pruebas — Semana 4
**Proyecto:** SER Inventarios
**Fecha:** 13 de marzo, 2026
**Para:** Alan Villegas — SER

---

## Objetivo

Esta guía le permite verificar las funcionalidades completadas en la **Semana 4**:

1. Sincronización Android ↔ Servidor
2. Sistema de Traspasos
3. Impresión Bluetooth
4. Importación de Catálogos
5. Mejoras de Interfaz (Dashboard, navegación)
6. Migración de Base de Datos

---

## Requisitos para las Pruebas

### Lo que necesita
| Elemento | Detalle |
|----------|---------|
| Teléfono Android | Android 8.0 o superior |
| APK instalado | SER Inventarios v1.0.0 (proporcionado) |
| Acceso a la web | https://app-test.seretail.com.mx |
| Conexión WiFi | Para pruebas de sincronización |
| Impresora Bluetooth (opcional) | Cualquier impresora térmica ESC/POS o Zebra |

### Credenciales de acceso
| Plataforma | Usuario | Contraseña | Rol |
|------------|---------|------------|-----|
| Web + App | `alan` | `admin123` | Super Admin |

---

## PRUEBA 1: Login y Selección de Empresa

### 1.1 — Iniciar sesión en la app
**Tiempo estimado:** 2 minutos

| Paso | Acción |
|------|--------|
| 1 | Abrir la app SER Inventarios en su teléfono |
| 2 | Ingresar usuario: `alan` |
| 3 | Ingresar contraseña: `admin123` |
| 4 | Tocar **"Iniciar Sesión"** |

**¿Qué debe pasar?**
- Se muestra un indicador de carga
- Aparece la pantalla de selección de Empresa

| Paso | Acción |
|------|--------|
| 5 | Seleccionar su empresa de la lista |
| 6 | Seleccionar la sucursal |
| 7 | Confirmar la selección |

**¿Qué debe pasar?**
- Se abre el **Dashboard** (pantalla principal)
- Se muestran las tarjetas de Inventario, Activo Fijo y RFID

**Si algo falla:** Tome captura de pantalla del error y envíela.

---

## PRUEBA 2: Dashboard y Estadísticas

### 2.1 — Verificar el Dashboard rediseñado
**Tiempo estimado:** 3 minutos

| Paso | Acción |
|------|--------|
| 1 | Observar la pantalla principal después de iniciar sesión |

**¿Qué debe verificar?**
- [ ] Se ven **3 tarjetas principales**: Inventario, Activo Fijo, RFID
- [ ] Se muestra el **estado de conexión** (En línea / Sin conexión)
- [ ] Se muestra el **contador de registros pendientes** de sincronizar
- [ ] Se ve la **gráfica de pastel** con desglose por status (Encontrado, No Encontrado, Agregado, Traspasado)
- [ ] Se ve la **gráfica de barras** por categoría de activos
- [ ] La **barra de navegación inferior** tiene 5 pestañas: Inicio, Inventario, Activo Fijo, RFID, Ajustes

### 2.2 — Navegar por las pestañas
| Paso | Acción |
|------|--------|
| 1 | Tocar cada pestaña de la barra inferior una por una |

**¿Qué debe verificar?**
- [ ] Cada pestaña abre su pantalla correspondiente sin error
- [ ] Al regresar a "Inicio", el Dashboard se muestra correctamente
- [ ] El ícono de la pestaña activa se resalta

---

## PRUEBA 3: Sincronización Android ↔ Servidor

Esta es la funcionalidad **más importante** de la Semana 4.

### 3.1 — Sincronización manual (descarga de catálogos)
**Tiempo estimado:** 5 minutos

| Paso | Acción |
|------|--------|
| 1 | Asegurarse de tener **conexión WiFi activa** |
| 2 | En el Dashboard, tocar el botón **"Sincronizar"** |

**¿Qué debe pasar?**
- Se muestra un **indicador de progreso**
- Se descargan del servidor: empresas, sucursales, productos, lotes, sesiones
- Al terminar, se muestra mensaje de éxito
- Los conteos del Dashboard se actualizan

### 3.2 — Capturar datos y sincronizar al servidor
**Tiempo estimado:** 10 minutos

| Paso | Acción |
|------|--------|
| 1 | Ir a pestaña **"Inventario"** |
| 2 | Tocar **"+"** para crear un nuevo inventario |
| 3 | Ingresar nombre: "Prueba Sync Semana 4" |
| 4 | Confirmar |
| 5 | Entrar al inventario creado |
| 6 | Escanear o escribir un código de barras de un producto que exista en su catálogo |
| 7 | Ingresar cantidad: `5` |
| 8 | Ingresar ubicación: `A-01` |
| 9 | Tocar **"Guardar"** |
| 10 | Repetir pasos 6-9 con **2 productos más** |
| 11 | Regresar al Dashboard |
| 12 | Verificar que el **contador de pendientes muestra 3** (o el número de registros capturados) |
| 13 | Tocar **"Sincronizar"** |

**¿Qué debe pasar?**
- Los 3 registros se envían al servidor
- El contador de pendientes baja a **0**
- Se muestra mensaje de éxito

### 3.3 — Verificar datos en la web
| Paso | Acción |
|------|--------|
| 1 | Abrir en su navegador: **https://app-test.seretail.com.mx** |
| 2 | Iniciar sesión con `alan` / `admin123` |
| 3 | Ir a **Inventarios** |
| 4 | Buscar el inventario "Prueba Sync Semana 4" |
| 5 | Verificar que los 3 registros aparecen con las cantidades y ubicaciones correctas |

**¿Qué debe verificar?**
- [ ] Los registros se ven en la web con los datos exactos que capturó en el teléfono
- [ ] Las fechas y horas de captura son correctas
- [ ] El usuario que capturó aparece como "alan"

### 3.4 — Sincronización automática al reconectar
**Tiempo estimado:** 5 minutos

| Paso | Acción |
|------|--------|
| 1 | **Desactivar WiFi** en su teléfono |
| 2 | Capturar 2 productos más en el inventario |
| 3 | Verificar que los registros se guardan localmente (aparecen en la lista) |
| 4 | **Reactivar WiFi** |
| 5 | Esperar 15-30 segundos |

**¿Qué debe pasar?**
- Los registros pendientes se sincronizan **automáticamente** al detectar conexión
- El contador de pendientes baja a 0 sin tocar "Sincronizar"
- Verificar en la web que los 2 nuevos registros aparecen

---

## PRUEBA 4: Activo Fijo con Fotos

### 4.1 — Capturar activos con fotografías
**Tiempo estimado:** 10 minutos

| Paso | Acción |
|------|--------|
| 1 | Ir a pestaña **"Activo Fijo"** |
| 2 | Tocar **"+"** para crear nueva sesión |
| 3 | Ingresar nombre: "Auditoría Prueba S4" |
| 4 | Confirmar y entrar a la sesión |
| 5 | Escanear o escribir el código de un activo |
| 6 | Verificar que se autocompletan: descripción, categoría, marca, modelo |
| 7 | Ingresar ubicación: "Piso 1 - Oficina 101" |
| 8 | Tocar el **slot de Foto 1** |
| 9 | Tomar una foto del activo |
| 10 | Tocar el **slot de Foto 2** y tomar otra foto |
| 11 | Verificar que el status dice **"Encontrado"** |
| 12 | Tocar **"Guardar"** |

**¿Qué debe verificar?**
- [ ] Las 2 fotos se muestran como miniaturas en los slots
- [ ] El registro aparece en la lista con indicador de color verde (Encontrado)
- [ ] La ubicación y comentarios se guardaron correctamente

### 4.2 — Sincronizar activos con fotos
| Paso | Acción |
|------|--------|
| 1 | Regresar al Dashboard |
| 2 | Tocar **"Sincronizar"** |
| 3 | Abrir la web → Activo Fijo → "Auditoría Prueba S4" |

**¿Qué debe verificar?**
- [ ] El registro del activo aparece en la web
- [ ] Las **fotos se ven correctamente** en la web
- [ ] El status "Encontrado" se refleja correctamente

---

## PRUEBA 5: Sistema de Traspasos

### 5.1 — Detectar un activo de otra sucursal
**Tiempo estimado:** 5 minutos

**Preparación necesaria (en la web):**
| Paso | Acción |
|------|--------|
| 1 | En la web, asegurarse de tener **2 sucursales** creadas (ej. "Sucursal Central" y "Sucursal Norte") |
| 2 | Tener al menos un activo registrado en la **sucursal diferente** a la que seleccionó en la app |

**En la app:**
| Paso | Acción |
|------|--------|
| 1 | En la sesión de Activo Fijo, escanear el código de un activo que pertenece a **otra sucursal** |

**¿Qué debe pasar?**
- Se muestra un **diálogo de confirmación de traspaso**
- El diálogo indica el nombre de la sucursal de origen del activo
- Al confirmar, el registro se guarda con status **"Traspasado"** (color diferente en la lista)

| Paso | Acción |
|------|--------|
| 2 | Confirmar el traspaso |
| 3 | Sincronizar |
| 4 | En la web → **Traspasos**, verificar que aparece el traspaso con sucursal origen y destino |

**¿Qué debe verificar?**
- [ ] El diálogo de traspaso muestra la sucursal correcta
- [ ] En la web, el traspaso muestra sucursal origen y sucursal destino
- [ ] El activo se marca como "Traspasado" en ambos lados (app y web)

---

## PRUEBA 6: Importación de Catálogos

### 6.1 — Importar catálogo desde el servidor
**Tiempo estimado:** 5 minutos

| Paso | Acción |
|------|--------|
| 1 | Ir a **Ajustes** (última pestaña) |
| 2 | Tocar **"Catálogo de Productos"** |
| 3 | Verificar que los productos se muestran (fueron descargados con la sincronización) |

**¿Qué debe verificar?**
- [ ] Los productos aparecen con código, descripción, categoría y precio
- [ ] La lista corresponde a los productos que tiene en la web

### 6.2 — Importar catálogo desde archivo Excel
**Tiempo estimado:** 5 minutos

**Preparación:** Tener un archivo Excel (.xlsx) o CSV en su teléfono con productos. El archivo debe tener columnas como: Código, Descripción, Categoría, Marca, Precio.

| Paso | Acción |
|------|--------|
| 1 | Ir a **Ajustes → Importar Catálogo** |
| 2 | Seleccionar el archivo Excel desde su teléfono |
| 3 | Esperar a que se procese |

**¿Qué debe pasar?**
- Se muestra barra de progreso durante la importación
- Al terminar, se indica cuántos productos se importaron
- Los productos nuevos aparecen en el Catálogo

### 6.3 — Crear producto nuevo manualmente
| Paso | Acción |
|------|--------|
| 1 | Ir a **Ajustes → Catálogo de Productos** |
| 2 | Tocar **"+"** para nuevo producto |
| 3 | Escanear o escribir un código de barras nuevo |
| 4 | Llenar: descripción, categoría, marca, precio |
| 5 | Guardar |

**¿Qué debe verificar?**
- [ ] El producto aparece en el catálogo
- [ ] Si intenta usar un código que ya existe, se muestra advertencia de duplicado

---

## PRUEBA 7: Impresión Bluetooth

> **Nota:** Esta prueba solo aplica si tiene una impresora Bluetooth disponible. Si no tiene una, puede omitirla y solo reportar qué modelo(s) de impresora utilizan para que verifiquemos compatibilidad.

### 7.1 — Configurar impresora
**Tiempo estimado:** 5 minutos

| Paso | Acción |
|------|--------|
| 1 | Encender su impresora Bluetooth y vincularla con el teléfono desde Ajustes de Android |
| 2 | En la app, ir a **Ajustes → Impresoras** |
| 3 | La impresora vinculada debe aparecer en la lista |
| 4 | Seleccionar la impresora |
| 5 | Seleccionar formato: **ESC/POS** (para ticket térmico) o **CPCL** (para etiquetas Zebra) |

**¿Qué debe verificar?**
- [ ] La impresora aparece en la lista con su nombre y dirección
- [ ] Se puede seleccionar sin error

### 7.2 — Imprimir prueba
| Paso | Acción |
|------|--------|
| 1 | Tocar botón **"Imprimir prueba"** |

**¿Qué debe pasar?**
- La impresora imprime un ticket de prueba con texto legible
- Los caracteres en español (á, é, ñ, etc.) se imprimen correctamente

### 7.3 — Imprimir reporte de inventario
| Paso | Acción |
|------|--------|
| 1 | Ir a una sesión de inventario o activo fijo con registros capturados |
| 2 | Buscar la opción de **"Imprimir"** |
| 3 | Tocar imprimir |

**¿Qué debe pasar?**
- Se imprime un resumen con: encabezado, lista de productos/activos, cantidades, totales
- El formato es legible y organizado

---

## PRUEBA 8: Migración de Base de Datos

### 8.1 — Verificar datos migrados en la web
**Tiempo estimado:** 5 minutos

| Paso | Acción |
|------|--------|
| 1 | Abrir la web: **https://app-test.seretail.com.mx** |
| 2 | Iniciar sesión |
| 3 | Ir a **Activo Fijo** |
| 4 | Verificar que existen registros de activos previamente capturados (los 63,000+ registros de las bases de datos originales) |

**¿Qué debe verificar?**
- [ ] Los datos históricos están presentes en el sistema
- [ ] Las empresas y sucursales se migraron correctamente
- [ ] Los productos/activos tienen sus códigos, descripciones y categorías intactos

---

## PRUEBA 9: Funcionamiento Sin Conexión

### 9.1 — Captura completa offline
**Tiempo estimado:** 10 minutos

| Paso | Acción |
|------|--------|
| 1 | Asegurarse de haber sincronizado al menos una vez (para tener catálogos locales) |
| 2 | **Activar modo avión** en el teléfono |
| 3 | Abrir la app (debe entrar sin problema con credenciales cacheadas) |
| 4 | Ir a Inventario → entrar a una sesión existente |
| 5 | Capturar **5 productos** con cantidades y ubicaciones |
| 6 | Ir a Activo Fijo → entrar a una sesión existente |
| 7 | Capturar **3 activos** con fotos |
| 8 | Verificar que todos los registros aparecen en las listas |
| 9 | **Desactivar modo avión** |
| 10 | Ir al Dashboard y tocar **"Sincronizar"** |

**¿Qué debe verificar?**
- [ ] Todas las capturas se realizaron sin error mientras estaba sin conexión
- [ ] Las búsquedas de producto funcionaron con el catálogo local
- [ ] Al sincronizar, los 8 registros se subieron correctamente al servidor
- [ ] En la web, todos los datos aparecen completos (incluyendo las fotos de los activos)

---

## PRUEBA 10: Flujo Completo (End to End)

Esta prueba valida todo el ciclo de trabajo que realizarán sus usuarios en campo.

### 10.1 — Simulación de jornada de trabajo
**Tiempo estimado:** 20 minutos

| # | Plataforma | Acción |
|---|------------|--------|
| 1 | **Web** | Crear un inventario nuevo: "Inventario Final Marzo" |
| 2 | **Web** | Crear una sesión de activo fijo: "Auditoría Oficinas" |
| 3 | **App** | Sincronizar para descargar las sesiones nuevas |
| 4 | **App** | Verificar que ambas sesiones aparecen en sus listas respectivas |
| 5 | **App** | Entrar al inventario → Capturar 5 productos escaneando códigos |
| 6 | **App** | Capturar 2 productos con código forzado (productos que no están en el catálogo) |
| 7 | **App** | Entrar a Activo Fijo → Capturar 3 activos encontrados con fotos |
| 8 | **App** | Marcar 1 activo como "No Encontrado" |
| 9 | **App** | Si es posible: capturar 1 activo de otra sucursal (traspaso) |
| 10 | **App** | Sincronizar todos los datos |
| 11 | **Web** | Verificar inventario: 7 registros (5 normales + 2 forzados) |
| 12 | **Web** | Verificar activo fijo: 3 encontrados, 1 no encontrado |
| 13 | **Web** | Verificar traspaso (si se realizó) |
| 14 | **Web** | Verificar que las fotos se ven correctamente |
| 15 | **Web** | Exportar un reporte Excel del inventario y abrirlo |

**¿Qué debe verificar?**
- [ ] Los datos de la web y la app coinciden exactamente
- [ ] Las fotos llegaron completas al servidor
- [ ] Los códigos forzados se distinguen de los productos del catálogo
- [ ] El reporte Excel contiene todos los datos correctos
- [ ] Los status de activos (Encontrado, No Encontrado, Traspasado) son correctos

---

## Formato de Retroalimentación

Por favor, para cada prueba, indíquenos:

```
PRUEBA #: [número]
RESULTADO: PASÓ / FALLÓ / NO APLICA
COMENTARIOS: [descripción de lo que pasó si falló, o sugerencias de mejora]
CAPTURA DE PANTALLA: [adjuntar si es posible]
```

### Preguntas adicionales que necesitamos que responda:

| # | Pregunta |
|---|----------|
| 1 | ¿La nueva navegación con 5 pestañas (Inicio, Inventario, Activo Fijo, RFID, Ajustes) es clara y cómoda? |
| 2 | ¿Qué modelo(s) de **impresora Bluetooth** utilizan? (marca, modelo) |
| 3 | ¿El **dominio app.seretail.com.mx** ya está configurado en HostGator para apuntar al servidor de producción? |
| 4 | ¿Cuándo podemos coordinar una **videollamada** para probar el lector RFID Rugline RT501 juntos? |
| 5 | ¿Hay alguna función que sienta que **falta o que no funciona** como esperaría? |

---

## Resumen Rápido

| Prueba | Funcionalidad | Prioridad |
|--------|---------------|-----------|
| 1 | Login y selección de empresa | Alta |
| 2 | Dashboard rediseñado | Media |
| 3 | **Sincronización Android ↔ Servidor** | **Crítica** |
| 4 | Activo Fijo con fotos | Alta |
| 5 | Sistema de traspasos | Alta |
| 6 | Importación de catálogos | Media |
| 7 | Impresión Bluetooth | Media (si tiene impresora) |
| 8 | Migración de base de datos | Alta |
| 9 | Funcionamiento sin conexión | Alta |
| 10 | **Flujo completo end-to-end** | **Crítica** |

**Tiempo total estimado:** 60-90 minutos

---

*Quedo al pendiente de sus resultados y comentarios. Si tiene cualquier duda durante las pruebas, no dude en contactarme.*
