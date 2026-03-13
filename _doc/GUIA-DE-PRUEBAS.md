# Guia de Pruebas - SER Inventarios App Unificada

**Version:** 1.0
**Fecha:** 2026-03-13
**App:** SER Inventarios (com.seretail.inventarios)
**Plataforma:** Android (SDK 26-35)

---

## Requisitos Previos

### Hardware Necesario
| Equipo | Proposito | Obligatorio |
|--------|-----------|-------------|
| Telefono/tablet Android 8.0+ | Ejecutar la app | Si |
| Lector RFID UHF (Gexiang GX o generico serial) | Pruebas RFID | Solo para modulo RFID |
| Impresora Bluetooth ESC/POS (termica) | Pruebas de impresion ticket | Solo para modulo impresion |
| Impresora Zebra CPCL (MZ220, QLn220, etc.) | Pruebas de impresion etiqueta | Solo para modulo impresion |
| Codigos de barras impresos (Code128, EAN-13, QR) | Pruebas de escaneo | Recomendado |
| PC con Android Studio | Compilar APK e instalar | Si |

### Software / Servicios
| Servicio | URL | Credenciales |
|----------|-----|-------------|
| Web Platform (Laravel) | http://localhost:8000 (dev) / app.seretail.com.mx (prod) | alan / admin123 |
| MySQL 8.0 | localhost:3306 | seretail / seretail_pass |
| Docker containers | web-platform/ | `docker compose up -d` |

### Datos de Prueba
- Crear al menos 1 empresa con 2 sucursales en la web
- Crear al menos 1 usuario por rol: Super Admin, Supervisor, Capturista, Supervisor Invitado
- Importar un catalogo de productos (minimo 50 productos con codigos de barras)
- Crear al menos 1 inventario y 1 sesion de activo fijo desde la web
- Tener archivos Excel (.xlsx) y CSV listos para importacion de catalogo

---

## Convenciones

- **[P]** = Paso a ejecutar
- **[E]** = Resultado esperado
- **[PRE]** = Precondicion
- **PASS / FAIL** = Marcar resultado
- Severidad: **CRITICO** (bloquea uso), **ALTO** (funcionalidad rota), **MEDIO** (inconveniente), **BAJO** (cosmetico)

---

## MODULO 1: Autenticacion y Sesion

### 1.1 Login Online Exitoso
> Verifica que un usuario puede iniciar sesion con credenciales validas cuando hay conexion al servidor.

- [PRE] Servidor web activo, usuario creado en la web
- [P] Abrir la app
- [P] Ingresar usuario: `alan`, password: `admin123`
- [P] Tocar "Iniciar Sesion"
- [E] Se muestra indicador de carga
- [E] Se redirige a pantalla de seleccion de Empresa/Sucursal (o Dashboard si ya configurado)
- [E] No se muestra error
- **Severidad si falla:** CRITICO

### 1.2 Login con Credenciales Incorrectas
> Verifica que se muestra error adecuado con credenciales invalidas.

- [PRE] Servidor web activo
- [P] Ingresar usuario: `alan`, password: `wrongpass`
- [P] Tocar "Iniciar Sesion"
- [E] Se muestra mensaje de error: "Credenciales incorrectas" o similar
- [E] No se redirige a otra pantalla
- [E] El campo de password se limpia o permite correccion
- **Severidad si falla:** CRITICO

### 1.3 Login Offline (Fallback)
> Verifica que un usuario previamente autenticado puede entrar sin conexion.

- [PRE] Haber iniciado sesion exitosamente al menos una vez
- [P] Desactivar WiFi y datos moviles del dispositivo
- [P] Abrir la app
- [P] Ingresar las mismas credenciales usadas anteriormente
- [P] Tocar "Iniciar Sesion"
- [E] Se permite el acceso usando las credenciales cacheadas localmente
- [E] Se muestra indicador de modo offline en Dashboard
- **Severidad si falla:** CRITICO

### 1.4 Configuracion de URL del Servidor
> Verifica que el usuario puede cambiar la URL del servidor API.

- [P] En la pantalla de Login, tocar el icono/boton de configuracion de servidor
- [E] Se muestra dialogo con campo para URL del servidor
- [P] Ingresar URL: `http://192.168.1.100:8000/api`
- [P] Guardar
- [E] La URL se persiste (verificar cerrando y abriendo la app)
- [E] Intentos de login usan la nueva URL
- **Severidad si falla:** ALTO

### 1.5 Logout
> Verifica que el usuario puede cerrar sesion correctamente.

- [PRE] Sesion activa
- [P] Navegar a la pantalla de Perfil (icono de usuario en barra inferior)
- [P] Tocar "Cerrar Sesion"
- [E] Se muestra confirmacion
- [P] Confirmar
- [E] Se redirige a pantalla de Login
- [E] Los datos de sesion se limpian (token, usuario actual)
- [E] No se puede navegar atras al Dashboard
- **Severidad si falla:** ALTO

### 1.6 Persistencia de Sesion
> Verifica que la sesion se mantiene al cerrar y reabrir la app.

- [PRE] Sesion activa
- [P] Cerrar la app completamente (quitar de recientes)
- [P] Abrir la app nuevamente
- [E] Se muestra el Dashboard directamente sin pedir login
- [E] Los datos del usuario se muestran correctamente
- **Severidad si falla:** ALTO

---

## MODULO 2: Seleccion de Empresa y Sucursal

### 2.1 Seleccion Inicial (Primer Uso)
> Verifica el flujo de onboarding multi-tenant.

- [PRE] Login exitoso, primera vez que el usuario usa la app
- [E] Se muestra pantalla de seleccion con lista de empresas disponibles para este usuario
- [P] Seleccionar una empresa de la lista
- [E] Se avanza al paso 2: seleccion de sucursal
- [E] Se muestran solo las sucursales de la empresa seleccionada
- [P] Seleccionar una sucursal
- [E] Se avanza al paso 3: confirmacion
- [P] Confirmar seleccion
- [E] Se redirige al Dashboard
- [E] La empresa y sucursal seleccionadas se muestran en el Dashboard
- **Severidad si falla:** CRITICO

### 2.2 Auto-Skip (Ya Configurado)
> Verifica que si empresa/sucursal ya estan configuradas, se salta la seleccion.

- [PRE] Empresa y sucursal previamente seleccionadas
- [P] Cerrar y reabrir la app
- [E] Se muestra el Dashboard directamente sin pasar por seleccion
- **Severidad si falla:** MEDIO

### 2.3 Busqueda de Empresa
> Verifica que se puede filtrar empresas por nombre.

- [PRE] Multiples empresas en el sistema
- [P] En pantalla de seleccion, escribir parte del nombre de una empresa en el buscador
- [E] La lista se filtra mostrando solo empresas que coinciden
- [E] La busqueda no distingue mayusculas/minusculas
- **Severidad si falla:** BAJO

### 2.4 Cambio de Empresa/Sucursal
> Verifica que se puede cambiar la empresa y sucursal despues de la seleccion inicial.

- [PRE] Empresa/sucursal ya configuradas
- [P] Navegar a Ajustes o Perfil
- [P] Buscar opcion para cambiar empresa/sucursal
- [P] Seleccionar una empresa y sucursal diferentes
- [E] El Dashboard se actualiza con los datos de la nueva empresa/sucursal
- [E] Las sesiones de inventario mostradas corresponden a la nueva seleccion
- **Severidad si falla:** ALTO

---

## MODULO 3: Dashboard

### 3.1 Visualizacion de Estadisticas
> Verifica que el dashboard muestra metricas correctas.

- [PRE] Sesion activa, datos existentes (inventarios y activos fijos capturados)
- [P] Navegar al Dashboard
- [E] Se muestran tarjetas con conteos: total inventarios, total activos fijos, pendientes de sincronizar
- [E] Se muestra grafica de pastel (pie chart) con desglose por status (Encontrado, No Encontrado, Agregado, Traspasado)
- [E] Se muestra grafica de barras por categoria de activos
- [E] Los numeros coinciden con los datos reales en la base de datos local
- **Severidad si falla:** MEDIO

### 3.2 Indicador de Conexion
> Verifica que se muestra el estado de red en tiempo real.

- [P] Con WiFi activado, observar el indicador de estado en el Dashboard
- [E] Se muestra indicador "En linea" o similar
- [P] Desactivar WiFi y datos moviles
- [E] El indicador cambia a "Sin conexion" o similar en tiempo real
- [P] Reactivar WiFi
- [E] El indicador regresa a "En linea"
- **Severidad si falla:** MEDIO

### 3.3 Sincronizacion Manual desde Dashboard
> Verifica que el boton de sync funciona.

- [PRE] Registros pendientes de sincronizar (sincronizado=false)
- [P] Tocar el boton "Sincronizar" en el Dashboard
- [E] Se muestra indicador de progreso
- [E] Los registros pendientes se envian al servidor
- [E] El contador de "pendientes" disminuye o llega a 0
- [E] Se muestra mensaje de exito al terminar
- **Severidad si falla:** ALTO

### 3.4 Dashboard sin Datos
> Verifica que el dashboard se ve bien cuando no hay datos.

- [PRE] Usuario nuevo sin capturas
- [P] Navegar al Dashboard
- [E] Las tarjetas muestran 0 en todos los conteos
- [E] Las graficas muestran estado vacio (no errores, no pantalla en blanco)
- [E] Se puede navegar normalmente a otras pantallas
- **Severidad si falla:** MEDIO

---

## MODULO 4: Inventario de Productos (Modo Inventario)

### 4.1 Crear Sesion de Inventario
> Verifica la creacion de una nueva sesion de conteo.

- [PRE] Sesion activa con empresa/sucursal seleccionada
- [P] Navegar a "Inventarios" desde la barra inferior
- [P] Tocar boton "+" o "Crear Inventario"
- [E] Se muestra dialogo para ingresar nombre del inventario
- [P] Ingresar nombre: "Inventario Prueba 001"
- [P] Confirmar
- [E] La nueva sesion aparece en la lista
- [E] Se muestra la fecha de creacion, empresa y sucursal
- **Severidad si falla:** CRITICO

### 4.2 Captura con Escaneo de Codigo de Barras (Camara)
> Verifica el flujo completo de captura escaneando con la camara.

- [PRE] Sesion de inventario creada, productos en catalogo con codigos de barras
- [P] Tocar la sesion para entrar a captura
- [P] Tocar el icono de camara/escaner en el campo de codigo de barras
- [E] Se abre la pantalla del escaner con vista previa de la camara
- [E] Se muestra boton de linterna (torch)
- [P] Apuntar la camara a un codigo de barras de un producto conocido
- [E] El codigo se detecta automaticamente (beep o vibracion)
- [E] Se regresa a la pantalla de captura con el codigo en el campo
- [E] Si el producto existe en catalogo: se autocompleta la descripcion
- [P] Ingresar cantidad: `5`
- [P] Ingresar ubicacion: `A-01-03`
- [P] Tocar "Guardar"
- [E] El registro aparece en la tabla/lista inferior
- [E] Los totales se actualizan (cantidad total, numero de registros)
- **Severidad si falla:** CRITICO

### 4.3 Captura con Escaner de Hardware
> Verifica que la app recibe codigos desde un escaner de hardware integrado en el dispositivo.

- [PRE] Dispositivo con escaner de hardware integrado (ej. PDA industrial)
- [P] Entrar a pantalla de captura de inventario
- [P] Presionar el boton fisico del escaner y apuntar a un codigo de barras
- [E] El codigo se captura en el campo de texto automaticamente (via HardwareScannerBus + MainActivity.dispatchKeyEvent)
- [E] Se realiza la busqueda automatica del producto
- **Severidad si falla:** ALTO

### 4.4 Captura Manual de Codigo
> Verifica la entrada manual cuando no se puede escanear.

- [P] En pantalla de captura, escribir manualmente un codigo de barras en el campo de texto
- [P] Presionar Enter o el boton de busqueda
- [E] Si existe: se muestra la descripcion del producto
- [E] Si no existe: se muestra opcion de "codigo forzado" (si esta habilitado en settings)
- **Severidad si falla:** ALTO

### 4.5 Codigo Forzado (Producto No en Catalogo)
> Verifica el registro de productos que no estan en el catalogo.

- [PRE] Setting "Codigos forzados" activado
- [P] Ingresar un codigo que NO existe en el catalogo
- [E] Se muestra mensaje indicando que el producto no fue encontrado
- [E] Se ofrece opcion de registrar como codigo forzado
- [P] Aceptar registro forzado
- [P] Ingresar descripcion manualmente
- [P] Ingresar cantidad y ubicacion
- [P] Guardar
- [E] El registro se guarda marcado como "forzado"
- [E] Aparece en la lista con indicador visual de que es forzado
- **Severidad si falla:** ALTO

### 4.6 Captura con Lote y Caducidad
> Verifica los campos opcionales de lote y fecha de caducidad.

- [PRE] Settings de "Lotes" y "Fecha de caducidad" activados
- [P] Escanear/ingresar un codigo de producto
- [E] Se muestran campos adicionales: Lote y Fecha de Caducidad
- [P] En el campo de Lote, comenzar a escribir
- [E] Se muestran sugerencias de autocompletado basadas en lotes existentes
- [P] Seleccionar un lote o ingresar uno nuevo
- [P] Tocar campo de Fecha de Caducidad
- [E] Se muestra selector de fecha (DatePicker)
- [P] Seleccionar una fecha
- [P] Guardar el registro
- [E] El registro se guarda con lote y fecha de caducidad
- **Severidad si falla:** ALTO

### 4.7 Captura con Numero de Serie
> Verifica el campo de numero de serie para productos individuales.

- [PRE] Setting "Numeros de serie" activado
- [P] Escanear un producto
- [E] Se muestra campo de "Numero de Serie"
- [P] Ingresar un numero de serie unico
- [P] Guardar
- [E] El registro incluye el numero de serie
- **Severidad si falla:** MEDIO

### 4.8 Captura con Factor de Conversion
> Verifica el multiplicador de cantidad por factor.

- [PRE] Setting "Factor" activado, producto con factor definido (ej. factor=12 para docenas)
- [P] Escanear un producto que tiene factor definido
- [E] Se muestra el campo de Factor con el valor precargado del producto
- [P] Ingresar cantidad: `3`
- [E] Se calcula total_factor = cantidad * factor (3 * 12 = 36)
- [P] Guardar
- [E] El registro almacena tanto la cantidad como el factor y total_factor
- **Severidad si falla:** MEDIO

### 4.9 Captura con GPS
> Verifica que las coordenadas GPS se capturan con cada registro.

- [PRE] Setting "Coordenadas" activado, GPS del dispositivo activado
- [P] Escanear y guardar un producto
- [E] El registro se guarda con latitud y longitud (verificar en base de datos local)
- [E] Si GPS no disponible, se guarda con coordenadas null (no debe bloquear la captura)
- **Severidad si falla:** MEDIO

### 4.10 Eliminar Registro de Inventario
> Verifica que se puede eliminar un registro individual.

- [P] En la lista de registros capturados, seleccionar un registro
- [P] Tocar opcion de eliminar (icono papelera o deslizar)
- [E] Se pide confirmacion
- [P] Confirmar eliminacion
- [E] El registro desaparece de la lista
- [E] Los totales se actualizan
- [E] El registro se marca como eliminado (soft delete), no se borra fisicamente
- **Severidad si falla:** ALTO

### 4.11 Conteo Multiple (n_conteo)
> Verifica que se puede realizar mas de un conteo en la misma sesion.

- [PRE] Setting "Conteo" activado, registros ya capturados en conteo 1
- [P] Cambiar el numero de conteo a 2 (toggle o selector en captura)
- [P] Escanear los mismos productos nuevamente
- [E] Se crean nuevos registros con n_conteo = 2
- [E] Los registros del conteo 1 no se sobreescriben
- **Severidad si falla:** ALTO

### 4.12 Cantidades Decimales
> Verifica el manejo de cantidades con decimales.

- [PRE] Setting "Permitir decimales" activado con n_decimales=2
- [P] Ingresar cantidad: `1.75`
- [P] Guardar
- [E] Se acepta la cantidad decimal
- [E] Se almacena con la precision configurada (2 decimales)
- **Severidad si falla:** MEDIO

### 4.13 Cantidades Cero y Negativas
> Verifica el manejo de cantidades limite.

- **Caso A: Cantidad cero (si permitido)**
  - [PRE] Setting "Cantidad cero" activado
  - [P] Ingresar cantidad: `0`
  - [E] Se permite guardar

- **Caso B: Cantidad cero (si no permitido)**
  - [PRE] Setting "Cantidad cero" desactivado
  - [P] Ingresar cantidad: `0`
  - [E] Se muestra error de validacion, no se guarda

- **Caso C: Cantidad negativa (si permitido)**
  - [PRE] Setting "Cantidades negativas" activado
  - [P] Ingresar cantidad: `-3`
  - [E] Se permite guardar

- **Severidad si falla:** MEDIO

---

## MODULO 5: Inventario de Activo Fijo

### 5.1 Crear Sesion de Activo Fijo
> Verifica la creacion de una sesion de auditoria de activos.

- [P] Navegar a "Activo Fijo" desde la barra inferior
- [P] Tocar boton "+" o "Crear Sesion"
- [P] Ingresar nombre: "Auditoria Activos Q1-2026"
- [P] Confirmar
- [E] La sesion aparece en la lista con fecha, empresa y sucursal
- **Severidad si falla:** CRITICO

### 5.2 Captura de Activo Encontrado
> Verifica el flujo completo de captura de un activo fijo encontrado.

- [PRE] Sesion de activo fijo creada, catalogo de activos importado
- [P] Entrar a la sesion de captura
- [P] Escanear el codigo de barras de un activo que pertenece a la sucursal actual
- [E] Se autocompletan: descripcion, categoria, marca, modelo, color, serie
- [E] El status se establece automaticamente a "Encontrado" (status 1)
- [P] Ingresar ubicacion: `Piso 2 - Oficina 201`
- [P] Ingresar area (con autocompletado de sugerencias)
- [P] Opcionalmente agregar comentarios
- [P] Guardar
- [E] El registro aparece en la lista con indicador de color verde (encontrado)
- **Severidad si falla:** CRITICO

### 5.3 Captura de Activo con Fotos (3 fotos)
> Verifica la captura de hasta 3 fotografias por activo.

- [PRE] Setting "Foto" activado
- [P] Escanear un activo
- [E] Se muestran 3 slots de foto (imagen1, imagen2, imagen3)
- [P] Tocar el slot de foto 1
- [E] Se abre la camara del dispositivo
- [P] Tomar una foto
- [E] La foto se muestra en el slot 1 como miniatura
- [P] Repetir para foto 2 y foto 3
- [E] Las 3 fotos se muestran correctamente
- [P] Guardar el registro
- [E] Las 3 fotos se almacenan localmente (verificar que los URIs son validos)
- [E] Al sincronizar, las fotos se codifican en base64 y se envian al servidor
- **Severidad si falla:** ALTO

### 5.4 Activo No Encontrado
> Verifica el registro de activos que no se encontraron fisicamente.

- [P] En la lista de activos de una sesion, identificar un activo que deberia existir pero no fue encontrado
- [P] Marcar como "No Encontrado" (status 2)
- [E] Se crea un registro NoEncontradoEntity con coordenadas GPS y timestamp
- [E] El activo aparece en la lista con indicador de color rojo
- **Severidad si falla:** ALTO

### 5.5 Activo Agregado (Nuevo)
> Verifica el registro de un activo que no estaba en el catalogo.

- [P] Escanear un codigo que NO existe en el catalogo de activos
- [E] Se muestra opcion de agregar como nuevo activo
- [P] Llenar manualmente: descripcion, categoria, marca, modelo, ubicacion
- [P] Tomar fotos del activo nuevo
- [P] Guardar con status "Agregado" (status 3)
- [E] El registro se guarda correctamente marcado como nuevo
- [E] Se distingue visualmente en la lista (color diferente)
- **Severidad si falla:** ALTO

### 5.6 Activo Traspasado (Transferencia entre Sucursales)
> Verifica la deteccion automatica de activos que pertenecen a otra sucursal.

- [PRE] Un activo registrado en Sucursal A; usuario esta en Sucursal B
- [P] Escanear el codigo de ese activo en Sucursal B
- [E] Se detecta automaticamente que el activo pertenece a otra sucursal
- [E] Se muestra dialogo de confirmacion de traspaso con nombre de sucursal origen
- [P] Confirmar traspaso
- [E] Se crea registro con status "Traspasado" (status 4)
- [E] Se crea un TraspasoEntity con sucursal_origen y sucursal_destino
- [E] El registro aparece con indicador visual de traspaso
- **Severidad si falla:** ALTO

### 5.7 Editar Registro de Activo Fijo
> Verifica que se puede editar un registro ya capturado.

- [P] En la lista de registros, tocar un registro existente
- [E] Se abre el formulario en modo edicion con datos precargados
- [P] Modificar la ubicacion y agregar un comentario
- [P] Guardar cambios
- [E] Los cambios se reflejan en la lista
- [E] El registro se marca como pendiente de sincronizar
- **Severidad si falla:** MEDIO

### 5.8 Campos Tag Nuevo y Serie Revisado
> Verifica las casillas de verificacion especificas de activos.

- [P] En captura de activo, activar checkbox "Tag Nuevo"
- [P] Activar checkbox "Serie Revisado"
- [P] Guardar
- [E] Ambos campos se almacenan como true en el registro
- **Severidad si falla:** BAJO

### 5.9 Filtrado por Categoria en Lista de Activos
> Verifica el filtro de categorias en la lista de sesiones.

- [PRE] Multiples registros con diferentes categorias capturados
- [P] En la lista de activo fijo, tocar el filtro de categoria
- [E] Se muestran las categorias disponibles
- [P] Seleccionar una categoria
- [E] La lista se filtra mostrando solo activos de esa categoria
- **Severidad si falla:** BAJO

### 5.10 Comparacion de Conteo Cruzado
> Verifica la funcionalidad de comparar dos sesiones de conteo.

- [PRE] Dos sesiones de activo fijo completadas en la misma sucursal
- [P] En la lista de sesiones, tocar boton de "Comparar conteos"
- [P] Seleccionar las dos sesiones a comparar
- [E] Se muestra pantalla de CrossCount con las diferencias entre ambas sesiones
- [E] Se identifican activos faltantes, sobrantes y con discrepancias
- **Severidad si falla:** MEDIO

---

## MODULO 6: Escaneo RFID

### 6.1 Conexion al Lector RFID
> Verifica la conexion con hardware RFID UHF.

- [PRE] Dispositivo con lector RFID UHF integrado (puerto serial /dev/ttyS3 o /dev/ttyS4)
- [P] Navegar a "RFID" desde la barra inferior
- [P] Tocar "Conectar"
- [E] Se establece conexion con el lector (indicador verde/activo)
- [E] Se muestra informacion del lector conectado
- **Severidad si falla:** CRITICO (para modulo RFID)

### 6.2 Escaneo Masivo de Tags
> Verifica el escaneo de multiples tags RFID simultaneamente.

- [PRE] Lector RFID conectado, tags RFID UHF disponibles
- [P] Seleccionar una sesion de activo fijo
- [P] Tocar "Iniciar Escaneo"
- [E] Se comienza la lectura continua de tags
- [E] Los tags detectados aparecen en la lista en tiempo real
- [E] Se muestra EPC, RSSI (intensidad de senal) y conteo de lecturas por tag
- [E] Se escucha beep por cada tag nuevo detectado
- [P] Tocar "Detener Escaneo"
- [E] La lectura se detiene
- [E] Se mantiene la lista de tags capturados
- **Severidad si falla:** CRITICO (para modulo RFID)

### 6.3 Ajuste de Potencia RF
> Verifica el control de potencia del lector.

- [PRE] Lector RFID conectado
- [P] Mover el slider de potencia al minimo (0 dBm)
- [P] Iniciar escaneo cerca de un tag
- [E] El rango de lectura se reduce significativamente
- [P] Mover el slider al maximo (30 dBm)
- [P] Escanear de nuevo
- [E] El rango de lectura aumenta (puede leer a mayor distancia)
- **Severidad si falla:** MEDIO

### 6.4 Matching de Tags con Catalogo
> Verifica que los tags se emparejan con activos del catalogo.

- [PRE] Tags RFID programados con EPCs que corresponden a activos en el catalogo
- [P] Iniciar escaneo
- [E] Los tags que coinciden con activos se muestran como "matched" (emparejados)
- [E] Los tags sin coincidencia se muestran como "unmatched"
- [P] Tocar toggle "Solo emparejados"
- [E] Se filtran mostrando solo tags con coincidencia
- [P] Tocar toggle "Solo no emparejados"
- [E] Se filtran mostrando solo tags sin coincidencia
- **Severidad si falla:** ALTO

### 6.5 Desconexion del Lector
> Verifica que la desconexion se maneja correctamente.

- [P] Con lector conectado, tocar "Desconectar"
- [E] El lector se desconecta limpiamente
- [E] El indicador cambia a desconectado
- [E] Los datos capturados se mantienen
- [P] Verificar que la app no se congela si el lector se desconecta fisicamente
- **Severidad si falla:** ALTO

---

## MODULO 7: Escaner de Codigo de Barras

### 7.1 Escaneo con Camara (ML Kit)
> Verifica el funcionamiento del escaner de camara.

- [P] Desde cualquier pantalla de captura, tocar icono de escaner
- [E] Se abre pantalla de escaner con vista previa de la camara
- [E] Se muestra guia visual de enfoque
- [P] Apuntar a un codigo de barras
- [E] El codigo se detecta automaticamente
- [E] Se retorna a la pantalla anterior con el codigo capturado en el campo correspondiente
- **Severidad si falla:** CRITICO

### 7.2 Formatos de Codigo Soportados
> Verifica que se reconocen los formatos comunes de codigos.

Probar con cada formato:
- [P] Code 128 → [E] Se detecta correctamente
- [P] Code 39 → [E] Se detecta correctamente
- [P] EAN-13 → [E] Se detecta correctamente
- [P] EAN-8 → [E] Se detecta correctamente
- [P] UPC-A → [E] Se detecta correctamente
- [P] UPC-E → [E] Se detecta correctamente
- [P] QR Code → [E] Se detecta correctamente
- [P] ITF → [E] Se detecta correctamente
- **Severidad si falla:** ALTO

### 7.3 Linterna (Torch)
> Verifica el control de la linterna para escaneo en condiciones de poca luz.

- [P] En la pantalla del escaner, tocar boton de linterna
- [E] Se enciende el flash LED de la camara en modo continuo
- [P] Tocar nuevamente
- [E] Se apaga la linterna
- **Severidad si falla:** BAJO

### 7.4 Dispositivo sin Camara (Fallback)
> Verifica que la app no se cae en dispositivos sin camara.

- [PRE] Dispositivo sin camara o con camara deshabilitada
- [P] Tocar icono de escaner
- [E] Se muestra mensaje informando que no hay camara disponible
- [E] Se permite entrada manual del codigo como alternativa
- [E] La app no se cierra inesperadamente
- **Severidad si falla:** ALTO

---

## MODULO 8: Catalogo de Productos

### 8.1 Navegar Catalogo
> Verifica la visualizacion del catalogo de productos.

- [P] Navegar a Ajustes → Catalogo de Productos
- [E] Se muestra lista de productos de la empresa actual
- [E] Cada producto muestra: codigo, descripcion, categoria, precio
- [P] Hacer scroll hacia abajo
- [E] Se cargan mas productos (paginacion o scroll infinito)
- **Severidad si falla:** MEDIO

### 8.2 Crear Producto Nuevo
> Verifica la creacion manual de un producto.

- [P] Tocar boton "+" para nuevo producto
- [E] Se muestra formulario con campos: codigo de barras, descripcion, categoria, marca, modelo, color, serie, precio venta, cantidad teorica, unidad de medida, factor
- [P] Escanear un codigo de barras para el nuevo producto
- [E] Se verifica que el codigo no sea duplicado (verificacion contra base de datos)
- [P] Llenar todos los campos
- [P] Guardar
- [E] El producto aparece en el catalogo
- **Severidad si falla:** ALTO

### 8.3 Editar Producto Existente
> Verifica la edicion de productos.

- [P] Tocar un producto en el catalogo
- [E] Se abre el formulario con datos precargados
- [P] Modificar la descripcion y el precio
- [P] Guardar
- [E] Los cambios se reflejan en la lista
- **Severidad si falla:** MEDIO

### 8.4 Deteccion de Codigo Duplicado
> Verifica que no se permiten codigos de barras duplicados.

- [P] Crear un producto nuevo
- [P] Ingresar un codigo de barras que ya existe en el catalogo
- [E] Se muestra advertencia de codigo duplicado
- [E] No se permite guardar (o se advierte al usuario)
- **Severidad si falla:** MEDIO

### 8.5 Importacion de Catalogo desde Archivo
> Verifica la importacion masiva de productos.

- [PRE] Archivo Excel (.xlsx) o CSV con productos preparado en el dispositivo
- [P] Navegar a Ajustes → Importar Catalogo
- [P] Seleccionar el archivo desde el almacenamiento del dispositivo
- [E] Se muestra progreso de importacion
- [E] Se indican cuantos productos se importaron exitosamente
- [E] Los productos importados aparecen en el catalogo
- [P] Verificar que duplicados se manejaron correctamente (no duplicar existentes)
- **Severidad si falla:** ALTO

### 8.6 Busqueda de Productos
> Verifica la busqueda dentro del catalogo.

- [P] Escribir parte del nombre o codigo de un producto en el campo de busqueda
- [E] Los resultados se filtran en tiempo real
- [E] La busqueda funciona por codigo_1, codigo_2, codigo_3 y descripcion
- **Severidad si falla:** MEDIO

---

## MODULO 9: Sincronizacion de Datos

### 9.1 Sync Manual Completo
> Verifica la sincronizacion bidireccional completa.

- [PRE] Registros locales sin sincronizar + datos nuevos en el servidor
- [P] Navegar al Dashboard
- [P] Tocar "Sincronizar"
- [E] **Fase de subida (upload):** Los registros locales pendientes se envian al servidor
- [E] **Fase de descarga (download):** Se descargan empresas, sucursales, productos, lotes, sesiones
- [E] El indicador de progreso refleja el avance
- [E] Al terminar, el contador de "pendientes" es 0
- [E] Los nuevos datos del servidor aparecen localmente
- **Severidad si falla:** CRITICO

### 9.2 Sync en Background (WorkManager)
> Verifica que la sincronizacion automatica funciona en segundo plano.

- [PRE] App configurada, registros pendientes
- [P] Verificar que SyncWorker esta programado (en Ajustes o logs)
- [P] Esperar al intervalo de sync automatico
- [E] Los registros se sincronizan sin intervencion del usuario
- [E] Se muestra notificacion (opcional) al completar
- **Severidad si falla:** ALTO

### 9.3 Sync de Imagenes
> Verifica que las fotos de activos se suben correctamente.

- [PRE] Registros de activo fijo con fotos capturadas
- [P] Sincronizar
- [E] Las imagenes se codifican en base64 y se envian via `POST /activo-fijo/upload-imagen` (multipart)
- [E] Verificar en la web que las fotos se muestran correctamente
- [E] Las 3 fotos por activo se suben (imagen1, imagen2, imagen3)
- **Severidad si falla:** ALTO

### 9.4 Sync de Traspasos
> Verifica que los traspasos se sincronizan como entidad separada.

- [PRE] Registros de traspaso pendientes
- [P] Sincronizar
- [E] Los traspasos se envian via `POST /activo-fijo/traspasos`
- [E] En la web, los traspasos aparecen con sucursal origen y destino
- **Severidad si falla:** ALTO

### 9.5 Sync de No Encontrados
> Verifica que los activos no encontrados se sincronizan.

- [PRE] Registros "no encontrado" pendientes
- [P] Sincronizar
- [E] Se envian via `POST /activo-fijo/no-encontrados`
- [E] En la web, los activos se marcan como no encontrados
- **Severidad si falla:** ALTO

### 9.6 Sync de Tags RFID
> Verifica que los tags RFID se sincronizan.

- [PRE] Tags RFID capturados y pendientes
- [P] Sincronizar
- [E] Se envian via `POST /activo-fijo/rfid-tags`
- [E] Se incluyen: EPC, RSSI, readCount, matched, matchedRegistroId
- **Severidad si falla:** ALTO (para modulo RFID)

### 9.7 Manejo de Error de Sync
> Verifica que la app maneja fallos de sincronizacion.

- [P] Iniciar sincronizacion
- [P] Durante la sincronizacion, desactivar WiFi
- [E] La sincronizacion falla gracefully con mensaje de error
- [E] Los registros NO se marcan como sincronizados
- [E] Al reconectar, se puede reintentar la sincronizacion
- [E] No se pierden datos locales
- **Severidad si falla:** CRITICO

### 9.8 Sync con Volumen Grande de Datos
> Verifica el rendimiento con grandes cantidades de registros.

- [PRE] 1000+ registros pendientes de sincronizar
- [P] Sincronizar
- [E] La sincronizacion se realiza en lotes (batched by sessionId)
- [E] No se agota la memoria del dispositivo
- [E] El progreso se muestra incrementalmente
- [E] La app no se congela (ANR)
- **Severidad si falla:** ALTO

---

## MODULO 10: Impresion Bluetooth

### 10.1 Descubrimiento de Impresoras
> Verifica la deteccion de impresoras Bluetooth pareadas.

- [PRE] Impresora Bluetooth encendida y pareada con el dispositivo
- [P] Navegar a Ajustes → Impresoras
- [E] Se muestra lista de dispositivos Bluetooth pareados
- [E] Se identifica la impresora por nombre y direccion MAC
- [P] Seleccionar la impresora
- [E] La MAC se guarda en la configuracion
- **Severidad si falla:** ALTO (para modulo impresion)

### 10.2 Impresion ESC/POS (Ticket Termico)
> Verifica la impresion en formato ticket.

- [PRE] Impresora ESC/POS configurada
- [P] Realizar una captura de inventario o activo fijo
- [P] Tocar opcion "Imprimir" (desde reporte o captura)
- [E] Se envia el contenido a la impresora
- [E] Se imprime un ticket con: encabezado, lista de productos/activos, totales, fecha y hora
- [E] El formato es legible (alineacion correcta, caracteres especiales en espanol)
- **Severidad si falla:** MEDIO

### 10.3 Impresion Zebra CPCL (Etiqueta)
> Verifica la impresion en formato etiqueta Zebra.

- [PRE] Impresora Zebra CPCL configurada
- [P] Seleccionar formato de impresora como "CPCL" en ajustes
- [P] Tocar opcion "Imprimir"
- [E] Se genera etiqueta con formato CPCL correcto
- [E] La etiqueta incluye codigo de barras y datos del activo/producto
- **Severidad si falla:** MEDIO

### 10.4 Impresion sin Impresora Conectada
> Verifica manejo de error cuando no hay impresora disponible.

- [P] Sin impresora configurada o con impresora apagada, intentar imprimir
- [E] Se muestra mensaje de error claro: "No se encontro impresora" o "Impresora no disponible"
- [E] La app no se cuelga
- **Severidad si falla:** MEDIO

---

## MODULO 11: Reportes

### 11.1 Reporte Agrupado por Producto
> Verifica el reporte tipo 1.

- [PRE] Registros de inventario capturados
- [P] Navegar a Reportes desde la lista de inventarios
- [P] Seleccionar "Agrupacion por Producto"
- [E] Se muestra tabla con: cantidad total, codigo, descripcion, precio, importe (cantidad * precio)
- [E] Los productos con multiples registros se agrupan correctamente
- [E] Se muestra total general al final
- **Severidad si falla:** MEDIO

### 11.2 Reporte por Producto y Ubicacion
> Verifica el reporte tipo 2.

- [P] Seleccionar "Agrupacion por Producto y Ubicacion"
- [E] Se muestra tabla con desglose por almacen y ubicacion
- [E] El mismo producto en diferentes ubicaciones aparece en filas separadas
- **Severidad si falla:** MEDIO

### 11.3 Reporte a Detalle
> Verifica el reporte tipo 3.

- [P] Seleccionar "Conteo a Detalle"
- [E] Se muestra cada registro individual con todos los campos: usuario, fecha, hora, ubicacion, GPS, etc.
- **Severidad si falla:** MEDIO

### 11.4 Reporte de Diferencias (GNC)
> Verifica el reporte de articulos no contados.

- [PRE] Conteo cruzado realizado (dos conteos en la misma sesion/ubicacion)
- [P] Seleccionar reporte de diferencias
- [E] Se muestran items con discrepancias entre conteo 1 y conteo 2
- [E] Se calcula variacion en cantidad y valor monetario
- **Severidad si falla:** MEDIO

### 11.5 Exportar a CSV/Excel
> Verifica la exportacion de reportes.

- [P] En cualquier tipo de reporte, tocar "Exportar"
- [E] Se genera archivo CSV o Excel
- [E] Se ofrece opcion de compartir (WhatsApp, email, etc.)
- [E] El archivo contiene todos los datos del reporte con headers correctos
- [P] Abrir el archivo en una computadora y verificar contenido
- **Severidad si falla:** ALTO

---

## MODULO 12: Configuracion (Settings)

### 12.1 Toggles de Captura
> Verifica que cada toggle de configuracion afecta la pantalla de captura.

Para cada setting, verificar:

| Setting | Activado | Desactivado |
|---------|----------|-------------|
| Factor | Campo factor visible en captura | Campo oculto |
| Numeros de serie | Campo serie visible | Campo oculto |
| Lotes | Campo lote visible con autocompletado | Campo oculto |
| Codigos forzados | Permite registrar codigos desconocidos | Solo catalogo |
| Validar catalogo | Busca en catalogo al escanear | No valida |
| Conteo | Selector de n_conteo visible | Siempre conteo 1 |
| Coordenadas | GPS se captura automaticamente | Sin GPS |
| Fotos | Slots de foto visibles (activo fijo) | Sin fotos |

- [P] Activar/desactivar cada setting
- [P] Ir a pantalla de captura
- [E] Los campos correspondientes se muestran u ocultan segun la configuracion
- **Severidad si falla:** ALTO

### 12.2 Configuracion de Impresora
> Verifica que se puede configurar la impresora desde ajustes.

- [P] Tocar seccion "Impresoras" en Ajustes
- [E] Se muestran campos para MAC de impresora y formato (ESC/POS o CPCL)
- [P] Configurar una impresora
- [E] La configuracion se persiste al cerrar y reabrir la app
- **Severidad si falla:** MEDIO

### 12.3 Pantalla Acerca De
> Verifica la informacion de la app.

- [P] Navegar a Ajustes → Acerca de
- [E] Se muestra: version de la app, nombre del desarrollador, creditos
- **Severidad si falla:** BAJO

---

## MODULO 13: Control de Acceso por Roles (RBAC)

### 13.1 Rol Super Admin
> Verifica acceso completo.

- [PRE] Login como Super Admin
- [E] Acceso a todas las funciones: inventarios, activos, RFID, configuracion, catalogo
- [E] Puede crear/eliminar sesiones
- [E] Puede ver datos de todas las empresas/sucursales
- **Severidad si falla:** CRITICO

### 13.2 Rol Supervisor
> Verifica acceso de supervision.

- [PRE] Login como Supervisor
- [E] Puede crear sesiones de inventario y activo fijo
- [E] Puede ver reportes
- [E] Restricciones: solo su empresa/sucursal asignada
- **Severidad si falla:** ALTO

### 13.3 Rol Capturista
> Verifica acceso limitado a captura.

- [PRE] Login como Capturista
- [E] Puede capturar inventario y activo fijo
- [E] NO puede crear sesiones (solo entrar a sesiones existentes)
- [E] NO puede eliminar sesiones
- [E] Puede ver datos limitados (solo su trabajo)
- **Severidad si falla:** ALTO

### 13.4 Rol Supervisor Invitado
> Verifica acceso especial para traspasos.

- [PRE] Login como Supervisor Invitado
- [E] Puede confirmar/gestionar traspasos entre sucursales
- [E] Acceso limitado a funciones de traspaso
- **Severidad si falla:** MEDIO

---

## MODULO 14: Funcionamiento Offline

### 14.1 Captura Completa sin Conexion
> Verifica que toda la funcionalidad de captura opera offline.

- [PRE] Catalogo previamente sincronizado, sesiones creadas
- [P] Desactivar WiFi y datos moviles completamente
- [P] Abrir sesion de inventario → capturar 10 productos
- [P] Abrir sesion de activo fijo → capturar 5 activos con fotos
- [E] Todas las capturas se guardan localmente sin error
- [E] Los datos aparecen en listas y reportes
- [P] Reactivar WiFi
- [P] Sincronizar
- [E] Todos los registros se suben correctamente al servidor
- **Severidad si falla:** CRITICO

### 14.2 Navegacion Offline
> Verifica que todas las pantallas funcionan sin conexion.

- [P] Sin conexion, navegar por: Dashboard, Inventarios, Activo Fijo, Catalogo, Ajustes
- [E] Todas las pantallas cargan con datos locales
- [E] Funciones que requieren servidor (crear sesion online) muestran mensaje apropiado
- [E] No hay crashes ni pantallas en blanco
- **Severidad si falla:** CRITICO

---

## MODULO 15: Rendimiento y Estabilidad

### 15.1 Volumen Grande de Productos en Catalogo
> Verifica rendimiento con catalogo extenso.

- [PRE] Importar 70,000+ productos al catalogo
- [P] Navegar al catalogo de productos
- [E] La lista carga en menos de 3 segundos
- [P] Buscar un producto por codigo
- [E] La busqueda responde en menos de 1 segundo
- [P] Escanear un codigo de barras
- [E] La busqueda en catalogo responde en menos de 500ms
- **Severidad si falla:** ALTO

### 15.2 Volumen Grande de Registros por Sesion
> Verifica rendimiento con muchos registros.

- [PRE] Sesion con 5,000+ registros capturados
- [P] Abrir la sesion de captura
- [E] La lista de registros se renderiza sin lag
- [P] Agregar un nuevo registro
- [E] Se guarda en menos de 500ms
- [E] La lista se actualiza sin parpadeo (flicker)
- **Severidad si falla:** ALTO

### 15.3 Uso Prolongado (Sesion de 8 Horas)
> Simula una jornada laboral completa de captura.

- [P] Mantener la app abierta y activa durante 8+ horas
- [P] Capturar registros periodicamente durante toda la jornada
- [E] La app no se cierra inesperadamente
- [E] No se degrada el rendimiento con el tiempo
- [E] La memoria no crece indefinidamente (verificar con Android Profiler)
- [E] La bateria se consume a un ritmo razonable
- **Severidad si falla:** ALTO

### 15.4 Rotacion de Pantalla
> Verifica que la app maneja correctamente la orientacion.

- [P] Rotar el dispositivo durante la captura de datos
- [E] No se pierden datos del formulario
- [E] La app no se cierra
- [E] El layout se ajusta (o se mantiene en portrait si es fijo)
- **Severidad si falla:** MEDIO

### 15.5 Interrupcion por Llamada Telefonica
> Verifica que los datos no se pierden si la app se interrumpe.

- [P] Estar capturando datos (formulario parcialmente lleno)
- [P] Recibir o realizar una llamada telefonica
- [P] Regresar a la app despues de la llamada
- [E] Los datos del formulario se mantienen
- [E] La sesion sigue activa
- **Severidad si falla:** ALTO

### 15.6 Memoria Baja
> Verifica comportamiento cuando el dispositivo tiene poca memoria.

- [P] Abrir multiples apps pesadas para consumir memoria
- [P] Regresar a SER Inventarios
- [E] La app se restaura correctamente (datos no perdidos)
- [E] Si se cierra por el sistema, al reabrir no pierde registros guardados
- **Severidad si falla:** ALTO

---

## MODULO 16: Navegacion y UX

### 16.1 Barra de Navegacion Inferior
> Verifica que la navegacion inferior funciona en todas las pantallas principales.

- [P] Tocar cada icono de la barra inferior: Dashboard, Inventarios, Activo Fijo, RFID, Ajustes
- [E] Se navega correctamente a cada seccion
- [E] El icono activo se resalta visualmente
- [E] El estado de cada pantalla se preserva al navegar entre ellas
- **Severidad si falla:** MEDIO

### 16.2 Boton Atras (Back)
> Verifica el comportamiento del boton atras del sistema.

- [P] Navegar Dashboard → Inventarios → Captura → Escaner
- [P] Presionar boton atras repetidamente
- [E] La navegacion se deshace en orden correcto
- [E] Desde Dashboard, atras no regresa al Login
- [E] Desde Login, atras cierra la app
- **Severidad si falla:** MEDIO

### 16.3 Permisos del Sistema
> Verifica que se solicitan permisos adecuadamente.

- [P] Instalar la app en un dispositivo limpio
- [P] Intentar usar el escaner de camara
- [E] Se solicita permiso de CAMARA
- [P] Intentar usar GPS
- [E] Se solicita permiso de UBICACION
- [P] Intentar conectar impresora Bluetooth
- [E] Se solicitan permisos de BLUETOOTH
- [P] Denegar un permiso
- [E] Se muestra mensaje explicando por que se necesita, sin crash
- **Severidad si falla:** ALTO

---

## MODULO 17: Integracion Web-Movil (End to End)

### 17.1 Ciclo Completo de Inventario de Productos
> Prueba end-to-end del flujo de inventario de productos.

1. [P] **Web:** Crear empresa "Test E2E", sucursal "Sucursal Central", usuario capturista
2. [P] **Web:** Importar catalogo de 100 productos via Excel
3. [P] **Web:** Crear inventario "Inventario E2E Marzo 2026"
4. [P] **Movil:** Login con credenciales del capturista
5. [P] **Movil:** Seleccionar empresa y sucursal
6. [P] **Movil:** Sincronizar para descargar catalogo y sesion
7. [P] **Movil:** Entrar al inventario y capturar 20 productos con diferentes ubicaciones
8. [P] **Movil:** Capturar 5 codigos forzados (no en catalogo)
9. [P] **Movil:** Sincronizar los registros al servidor
10. [P] **Web:** Verificar que los 25 registros aparecen en el inventario
11. [P] **Web:** Exportar reporte Excel y verificar datos
- [E] Los datos en la web coinciden exactamente con lo capturado en el movil
- **Severidad si falla:** CRITICO

### 17.2 Ciclo Completo de Activo Fijo
> Prueba end-to-end del flujo de activos fijos.

1. [P] **Web:** Crear sesion de activo fijo
2. [P] **Movil:** Sincronizar
3. [P] **Movil:** Capturar 10 activos encontrados con fotos (2 fotos cada uno)
4. [P] **Movil:** Registrar 3 activos no encontrados
5. [P] **Movil:** Registrar 2 activos nuevos (agregados)
6. [P] **Movil:** Registrar 1 traspaso
7. [P] **Movil:** Sincronizar todo
8. [P] **Web:** Verificar registros por status: 10 encontrados, 3 no encontrados, 2 agregados, 1 traspasado
9. [P] **Web:** Verificar que las 20 fotos se ven correctamente
10. [P] **Web:** Verificar el traspaso con sucursal origen y destino
- [E] Todos los datos, fotos y traspasos coinciden
- **Severidad si falla:** CRITICO

### 17.3 Multi-Dispositivo Simultaneo
> Verifica que multiples dispositivos pueden trabajar en la misma sesion.

1. [P] Instalar la app en 2 dispositivos
2. [P] Login con diferentes usuarios en cada dispositivo
3. [P] Ambos dispositivos abren la misma sesion de inventario
4. [P] Dispositivo A captura productos en ubicacion "A-01"
5. [P] Dispositivo B captura productos en ubicacion "B-01"
6. [P] Ambos sincronizan
7. [P] **Web:** Verificar que los registros de ambos usuarios aparecen correctamente
- [E] No hay conflictos, duplicados ni datos perdidos
- **Severidad si falla:** ALTO

---

## Resumen de Casos de Prueba

| Modulo | Casos | Criticos | Altos | Medios | Bajos |
|--------|-------|----------|-------|--------|-------|
| 1. Autenticacion | 6 | 2 | 3 | 0 | 1 |
| 2. Empresa/Sucursal | 4 | 1 | 1 | 1 | 1 |
| 3. Dashboard | 4 | 0 | 1 | 3 | 0 |
| 4. Inventario Productos | 13 | 2 | 5 | 6 | 0 |
| 5. Activo Fijo | 10 | 1 | 5 | 2 | 2 |
| 6. RFID | 5 | 2 | 2 | 1 | 0 |
| 7. Escaner Codigo Barras | 4 | 1 | 2 | 0 | 1 |
| 8. Catalogo Productos | 6 | 0 | 2 | 4 | 0 |
| 9. Sincronizacion | 8 | 2 | 5 | 0 | 1 |
| 10. Impresion Bluetooth | 4 | 0 | 1 | 3 | 0 |
| 11. Reportes | 5 | 0 | 1 | 4 | 0 |
| 12. Configuracion | 3 | 0 | 1 | 1 | 1 |
| 13. RBAC (Roles) | 4 | 1 | 2 | 1 | 0 |
| 14. Offline | 2 | 2 | 0 | 0 | 0 |
| 15. Rendimiento | 6 | 0 | 4 | 2 | 0 |
| 16. Navegacion/UX | 3 | 0 | 1 | 2 | 0 |
| 17. Integracion E2E | 3 | 2 | 1 | 0 | 0 |
| **TOTAL** | **90** | **16** | **37** | **30** | **7** |

---

## Orden de Ejecucion Recomendado

Ejecutar las pruebas en este orden para maximizar cobertura y detectar bloqueantes tempranamente:

1. **Modulo 1** (Autenticacion) — Sin login, nada funciona
2. **Modulo 2** (Empresa/Sucursal) — Requerido para acceder a datos
3. **Modulo 7** (Escaner) — Prerequisito para captura eficiente
4. **Modulo 4** (Inventario Productos) — Flujo principal #1
5. **Modulo 5** (Activo Fijo) — Flujo principal #2
6. **Modulo 9** (Sincronizacion) — Datos deben llegar al servidor
7. **Modulo 14** (Offline) — Critico para uso en campo
8. **Modulo 13** (RBAC) — Seguridad de acceso
9. **Modulo 6** (RFID) — Requiere hardware especifico
10. **Modulo 8** (Catalogo) — Gestion de datos
11. **Modulo 3** (Dashboard) — Visualizacion
12. **Modulo 11** (Reportes) — Salida de datos
13. **Modulo 10** (Impresion) — Salida fisica
14. **Modulo 12** (Configuracion) — Ajustes
15. **Modulo 15** (Rendimiento) — Stress testing
16. **Modulo 16** (Navegacion) — UX polish
17. **Modulo 17** (E2E) — Validacion final completa
