//localStorage
var northwind = new localStorageDB('northwindSSM', localStorage);
//SQLite
var base_datos = null;

function eliminaBDLocal() {
    try {
        northwind.drop();
        console.log('BD eliminada');
        northwind = new localStorageDB('northwindSSM', localStorage);

        //Después de eliminar la BD la creamos nuevamente
        creaBDLocal();

    }
    catch (err) {
        console.log(err.message);
    }
}

//Validamos si existe la BD, la creamos y configuramos la base de de datos en caso de que no exista
function validaBDLocal() {

    creaBDLocal();

    var nTablas = northwind.tableCount();

    if (nTablas === 0) {
        creaBDLocal();
    }
    else {
        actualizaBDLocal();
    }
    creaBDSQLite();

}

function creaBDLocal() {
    try {

        northwind.createTable('sesion_actual', ['datos_sesion']);

        // creamos las tablas de la bd
        northwind.createTable('permisos', ['id_activacion', 'cliente', 'fecha_inicio', 'fecha_fin', 'vigente', 'prueba', 'codigo_activacion', 'llave_activacion', 'lista_negra', 'eliminado']);

        northwind.createTable('producto_info', ['nombre_app', 'version_producto', 'codigo_producto', 'version_actual']);

        northwind.createTable('configuraciones', ['modo_online', 'ip_servidor', 'nombre_servidor', 'mac_impresora_0', 'nombre_impresora_0', 'mac_impresora_1', 'nombre_impresora_1']);

        northwind.createTable('configuraciones_lectura', ['ubicacion_obligatoria', 'validar_catalogo', 'codigos_forzados', 'descripcion_codigo_forzado', 'lotes', 'n_series', 'fecha_caducidad', 'fecha_fabricacion', 'cantidad_cero', 'cantidades_negativas', 'usar_camara', 'busqueda_catalogo', 'comentarios', 'foto', 'nfc', 'rfid', 'coordenadas', 'inventario_en_linea', 'permitir_decimales', 'n_decimales']);

        northwind.createTable('usuarios', ['nombre_usuario', 'usuario', 'password', 'administrador', 'eliminado']);

        northwind.createTable('inventarios', ['id_inventario', 'nombre_inventario', 'fecha_creacion', 'usuario', 'eliminado']);

        northwind.createTable('almacenes', ['id_almacen', 'inventario', 'nombre_almacen', 'eliminado', 'n_conteo']);

        northwind.createTable('catalogos', ['inventario', 'id_producto', 'codigo_1', 'codigo_2', 'codigo_3', 'descripcion', 'precio_venta', 'modelo', 'marca', 'categoria', 'subcategoria', 'precio_compra', 'unidad_medida', 'observaciones', 'cantidad_teorica', 'forzado', 'sincronizado', 'eliminado']);

        northwind.createTable('registros', ['inventario', 'id_producto', 'almacen', 'nombre_almacen', 'n_conteo', 'ubicacion', 'cantidad', 'codigo_1', 'codigo_2', 'codigo_3', 'descripcion', 'modelo', 'marca', 'categoria', 'subcategoria', 'precio_compra', 'precio_venta', 'unidad_medida', 'observaciones', 'lote', 'fecha_caducidad', 'n_serie', 'fecha_captura', 'hora_captura', 'usuario', 'nombre_usuario', 'cantidad_teorica', 'latitud', 'longitud', 'forzado', 'sincronizado', 'eliminado']);

        northwind.createTable('sesionesSSM', ['id_usuario', 'nombre_usuario', 'es_administrador', 'usuario_conteo', 'fecha_hora']);

        northwind.createTable('datos_pago', ['orden_id', 'metodo_pago', 'tipo_licencia', 'cliente_id', 'email', 'cliente', 'fecha_inicio', 'hora_inicio', 'fecha_fin', 'codigo_activacion', 'llave_activacion', 'fecha_hora', 'otros_datos', 'sincronizado']);

        northwind.createTable('datos_pago_error', ['metodo_pago', 'tipo_licencia', 'orden_status', 'orden_id', 'cliente_id', 'email', 'cliente', 'fecha_hora', 'otros_datos', 'sincronizado']);

        //inventario cruzado
        northwind.createTable('registros_cruzados', ['inventario', 'id_producto', 'almacen', 'nombre_almacen', 'n_conteo', 'ubicacion', 'cantidad', 'codigo_1', 'codigo_2', 'codigo_3', 'descripcion', 'modelo', 'marca', 'categoria', 'subcategoria', 'precio_compra', 'precio_venta', 'unidad_medida', 'observaciones', 'lote', 'fecha_caducidad', 'n_serie', 'fecha_captura', 'hora_captura', 'usuario', 'nombre_usuario', 'cantidad_teorica', 'latitud', 'longitud', 'forzado', 'sincronizado', 'eliminado']);


        // insertamos datos en las tablas
        northwind.insertOrUpdate('configuraciones', { ID: 1 }, {
            'modo_online': modo_online,
            'ip_servidor': ip_servidor,
            'nombre_servidor': nombre_servidor,
            'mac_impresora_0': mac_impresora_0,
            'nombre_impresora_0': nombre_impresora_0,
            'mac_impresora_1': mac_impresora_1,
            'nombre_impresora_1': nombre_impresora_1
        });

        northwind.insertOrUpdate('configuraciones_lectura', { ID: 1 }, {
            'ubicacion_obligatoria': 1,
            'validar_catalogo': 1,
            'codigos_forzados': 1,
            'descripcion_codigo_forzado': 1,
            'lotes': 0,
            'n_series': 0,
            'fecha_caducidad': 0,
            'fecha_fabricacion': 0,
            'cantidad_cero': 0,
            'cantidades_negativas': 0,
            'usar_camara': 1,
            'busqueda_catalogo': 0,
            'comentarios': 1,
            'foto': 0,
            'nfc': 0,
            'rfid': 0,
            'coordenadas': 0,
            'inventario_en_linea': 0,
            'permitir_decimales': 1,
            'n_decimales': 2

        });

        northwind.insertOrUpdate('producto_info', { ID: 1 }, {
            'nombre_app': nombre_app,
            'version_producto': version_producto,
            'codigo_producto': producto,
            'version_actual': version_actual
        });

        northwind.insertOrUpdate('sesionesSSM', { ID: 1 }, {
            'id_usuario': 0,
            'nombre_usuario': 'Supervisor',
            'es_administrador': 1,
            'usuario_conteo': 'Supervisor',
            'fecha_hora': strFecha(0)
        });

        //northwind.insert('usuarios', {
        //    'nombre_usuario': 'Administrador',
        //    'usuario': 'Admin',
        //    'password': '95958bacbe7cc778cb7361c1453ff77ac1b1b7cca5d099ee19977d6a2cd06292',
        //    'administrador': 0,
        //    'eliminado': 0
        //});

        northwind.insertOrUpdate('inventarios', { ID: 1 }, {
            'id_inventario': 1,
            'nombre_inventario': 'Inventario general',
            'fecha_creacion': strFecha(0),
            'usuario': 'Supervisor',
            'eliminado': 0
        });

        northwind.insertOrUpdate('almacenes', { ID: 1 }, {
            'id_almacen': 1,
            'inventario': 1,
            'nombre_almacen': 'Almacén general',
            'eliminado': 0
        });

        northwind.commit();

        var nTablas = northwind.tableCount();

        console.log('Base de datos local creada exitosamente. Tablas: ' + nTablas);

        //si actualizamos la estructura de la base de datos

    }
    catch (err) {
        console.log('Error: ' + err.message);
    }
    //
}

function actualizaBDLocal() {
    try {

        //tabla registros
        // Multiple columns can also added at once
        if (!(northwind.columnExists('registros', 'latitud') && northwind.columnExists('registros', 'longitud'))) {
            northwind.alterTable('registros', ['latitud', 'longitud'], { latitud: 0, longitud: 0 });
            northwind.commit(); // commit the deletions to localStorage
        }

        if (!northwind.columnExists('registros', 'n_conteo')) {
            northwind.alterTable('registros', 'n_conteo', { n_conteo: 0 });
            northwind.commit(); // commit the deletions to localStorage
        }

        if (!northwind.columnExists('almacenes', 'n_conteo')) {
            northwind.alterTable('almacenes', 'n_conteo', { n_conteo: 0 });
            northwind.commit(); // commit the deletions to localStorage
        }

        //si no existen las tablas en la base de datos las creamos
        if (!northwind.tableExists('producto_info')) {

            northwind.createTable('producto_info', ['nombre_app', 'version_producto', 'codigo_producto', 'version_actual']);

            northwind.insertOrUpdate('producto_info', { ID: 1 }, {
                nombre_app: nombre_app,
                version_producto: version_producto,
                codigo_producto: producto,
                version_actual: version_actual
            });
            northwind.commit();

        }

        //inventario cruzado
        if (!northwind.tableExists('registros_cruzados')) {
            northwind.createTable('registros_cruzados', ['inventario', 'id_producto', 'almacen', 'nombre_almacen', 'n_conteo', 'ubicacion', 'cantidad', 'codigo_1', 'codigo_2', 'codigo_3', 'descripcion', 'modelo', 'marca', 'categoria', 'subcategoria', 'precio_compra', 'precio_venta', 'unidad_medida', 'observaciones', 'lote', 'fecha_caducidad', 'n_serie', 'fecha_captura', 'hora_captura', 'usuario', 'nombre_usuario', 'cantidad_teorica', 'latitud', 'longitud', 'forzado', 'sincronizado', 'eliminado']);
            northwind.commit();
        }

        //tabla datos pago Paypal
        if (!northwind.tableExists('datos_pago')) {
            northwind.createTable('datos_pago', ['orden_id', 'metodo_pago', 'tipo_licencia', 'cliente_id', 'email', 'cliente', 'fecha_inicio', 'hora_inicio', 'fecha_fin', 'codigo_activacion', 'llave_activacion', 'fecha_hora', 'otros_datos', 'sincronizado']);
            northwind.commit();
        }
        if (!northwind.columnExists('datos_pago', 'cliente_id')) {
            northwind.alterTable('datos_pago', ['cliente_id']);
            northwind.commit();
        }
        if (!northwind.columnExists('datos_pago', 'email')) {
            northwind.alterTable('datos_pago', ['email']);
            northwind.commit();
        }
        if (!northwind.columnExists('datos_pago', 'hora_inicio')) {
            northwind.alterTable('datos_pago', ['hora_inicio']);
            northwind.commit();
        }
        if (!northwind.columnExists('datos_pago', 'orden_id')) {
            northwind.alterTable('datos_pago', ['orden_id']);
            northwind.commit();
        }


        if (!northwind.tableExists('datos_pago_error')) {
            northwind.createTable('datos_pago_error', ['metodo_pago', 'tipo_licencia', 'orden_status', 'orden_id', 'cliente_id', 'email', 'cliente', 'fecha_hora', 'otros_datos', 'sincronizado']);
            northwind.commit();
        }

        //tabla de sesiones

        if (!northwind.tableExists('sesionesSSM')) {
            northwind.createTable('sesionesSSM', ['id_usuario', 'nombre_usuario', 'es_administrador', 'usuario_conteo', 'fecha_hora']);
            northwind.insert('sesionesSSM', {
                'id_usuario': id_usuario_logueado,
                'nombre_usuario': nombre_usuario_logueado,
                'es_administrador': es_administrador,
                'usuario_conteo': nombre_usuario_logueado,
                'fecha_hora': strFecha(0)
            });
            northwind.commit();
        }

        //creamos las columnas nuevas de las tablas en la bd
        //configuraciones
        if (!northwind.columnExists('configuraciones', 'marca_impresora_0')) {
            northwind.alterTable('configuraciones', ['marca_impresora_0']);
            northwind.commit();
        }
        if (!northwind.columnExists('configuraciones', 'marca_impresora_1')) {
            northwind.alterTable('configuraciones', ['marca_impresora_1']);
            northwind.commit();
        }

        //tabla configuraciones de captura

        if (!northwind.tableExists('configuraciones_lectura')) {
            northwind.createTable('configuraciones_lectura', ['ubicacion_obligatoria', 'validar_catalogo', 'codigos_forzados', 'descripcion_codigo_forzado', 'lotes', 'n_series', 'fecha_caducidad', 'fecha_fabricacion', 'cantidad_cero', 'cantidades_negativas', 'usar_camara', 'busqueda_catalogo', 'comentarios', 'foto', 'nfc', 'rfid', 'coordenadas', 'inventario_en_linea', 'permitir_decimales', 'n_decimales']);

            northwind.insertOrUpdate('configuraciones_lectura', { ID: 1 }, {
                'ubicacion_obligatoria': 1,
                'validar_catalogo': 1,
                'codigos_forzados': 1,
                'descripcion_codigo_forzado': 1,
                'lotes': 0,
                'n_series': 0,
                'fecha_caducidad': 0,
                'fecha_fabricacion': 0,
                'cantidad_cero': 0,
                'cantidades_negativas': 0,
                'usar_camara': 1,
                'busqueda_catalogo': 0,
                'comentarios': 1,
                'foto': 0,
                'nfc': 0,
                'rfid': 0,
                'coordenadas': 0,
                'inventario_en_linea': 0,
                'permitir_decimales': 1,
                'n_decimales': 2

            });

            northwind.commit();

        }
        //creamos las columnas nuevas de las tablas en la bd
        //configuraciones_lectura
        if (!northwind.columnExists('configuraciones_lectura', 'usar_camara')) {
            northwind.alterTable('configuraciones_lectura', ['usar_camara']);
            northwind.commit();

            northwind.insertOrUpdate('configuraciones_lectura', { ID: 1 }, {
                'usar_camara': 1
            });
            northwind.commit();
        }

        if (!northwind.columnExists('configuraciones_lectura', 'busqueda_catalogo')) {
            northwind.alterTable('configuraciones_lectura', ['busqueda_catalogo']);
            northwind.commit();

            northwind.insertOrUpdate('configuraciones_lectura', { ID: 1 }, {
                'busqueda_catalogo': 0
            });
            northwind.commit();
        }

        if (!northwind.columnExists('configuraciones_lectura', 'comentarios')) {
            northwind.alterTable('configuraciones_lectura', ['comentarios']);
            northwind.commit();

            northwind.insertOrUpdate('configuraciones_lectura', { ID: 1 }, {
                'comentarios': 0
            });
            northwind.commit();
        }

        if (!northwind.columnExists('configuraciones_lectura', 'foto')) {
            northwind.alterTable('configuraciones_lectura', ['foto']);
            northwind.commit();

            northwind.insertOrUpdate('configuraciones_lectura', { ID: 1 }, {
                'foto': 0
            });
            northwind.commit();
        }

        if (!northwind.columnExists('configuraciones_lectura', 'nfc')) {
            northwind.alterTable('configuraciones_lectura', ['nfc']);
            northwind.commit();

            northwind.insertOrUpdate('configuraciones_lectura', { ID: 1 }, {
                'nfc': 0
            });
            northwind.commit();
        }

        if (!northwind.columnExists('configuraciones_lectura', 'rfid')) {
            northwind.alterTable('configuraciones_lectura', ['rfid']);
            northwind.commit();

            northwind.insertOrUpdate('configuraciones_lectura', { ID: 1 }, {
                'rfid': 0
            });
            northwind.commit();
        }

        if (!northwind.columnExists('configuraciones_lectura', 'coordenadas')) {
            northwind.alterTable('configuraciones_lectura', ['coordenadas']);
            northwind.commit();

            northwind.insertOrUpdate('configuraciones_lectura', { ID: 1 }, {
                'coordenadas': 0
            });
            northwind.commit();
        }

        if (!northwind.columnExists('configuraciones_lectura', 'inventario_en_linea')) {
            northwind.alterTable('configuraciones_lectura', ['inventario_en_linea']);
            northwind.commit();

            northwind.insertOrUpdate('configuraciones_lectura', { ID: 1 }, {
                'inventario_en_linea': 0
            });
            northwind.commit();
        }

        if (!northwind.columnExists('configuraciones_lectura', 'permitir_decimales')) {
            northwind.alterTable('configuraciones_lectura', ['permitir_decimales']);
            northwind.commit();

            northwind.insertOrUpdate('configuraciones_lectura', { ID: 1 }, {
                'permitir_decimales': 1
            });
            northwind.commit();
        }

        if (!northwind.columnExists('configuraciones_lectura', 'n_decimales')) {
            northwind.alterTable('configuraciones_lectura', ['n_decimales']);
            northwind.commit();

            northwind.insertOrUpdate('configuraciones_lectura', { ID: 1 }, {
                'n_decimales': 2
            });
            northwind.commit();
        }


        if (!northwind.columnExists('registros', 'factor')) {
            northwind.alterTable('registros', ['factor']);
            northwind.commit();
        }
        if (!northwind.columnExists('registros', 'total_factor')) {
            northwind.alterTable('registros', ['total_factor']);
            northwind.commit();
        }
        if (!northwind.columnExists('registros', 'fecha_elaboracion')) {
            northwind.alterTable('registros', ['fecha_elaboracion']);
            northwind.commit();
        }
        if (!northwind.columnExists('registros', 'lectura_array')) {
            northwind.alterTable('registros', ['lectura_array']);
            northwind.commit();
        }
        console.log('Base de datos actualizada exitosamente');
        //
    }
    catch (err) {
        alert(err.message);
    }
}

//abrimos la conexión a la bd SQLite
function abre_conexion_bd() {
    try {
        base_datos = (window.cordova.platformId === 'browser') ?
            window.openDatabase('Northwind', '1.0', 'Data', 2 * 1024 * 1024) :
            window.sqlitePlugin.openDatabase({ name: 'Northwind.db', location: 'default' });
    }
    catch (err) {
        muestraAlerta3(err.message, 'error');
    }
}

function creaBDSQLite() {
    //SQLite
    try {
        abre_conexion_bd();
        //creamos las tablas de la bd
        base_datos = (window.cordova.platformId === 'browser') ?
            window.openDatabase('Northwind', '1.0', 'Data', 2 * 1024 * 1024) :
            window.sqlitePlugin.openDatabase({ name: 'Northwind.db', location: 'default' });

        var query0 = 'CREATE TABLE IF NOT EXISTS catalogos (inventario, id_producto, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, modelo, marca, categoria, subcategoria, precio_compra, unidad_medida, observaciones, cantidad_teorica, forzado, sincronizado, eliminado, cantidad_real);';
        var query1 = "CREATE TABLE IF NOT EXISTS registros (id_registro, inventario, id_producto, almacen, nombre_almacen, ubicacion, cantidad, codigo_1, codigo_2, codigo_3, descripcion, modelo, marca, categoria, subcategoria, precio_compra, precio_venta, unidad_medida, observaciones, lote, fecha_caducidad, n_serie, fecha_captura, hora_captura, usuario, nombre_usuario, cantidad_teorica, forzado, sincronizado, eliminado)";
        //+ "PRIMARY KEY (id_registro),"
        //+ "INDEX inventario (inventario),"
        //+ "INDEX eliminado (eliminado)"

        base_datos.transaction(function (ts) {
            ts.executeSql(query0);
            ts.executeSql(query1);
            console.log('Base de datos 2 creada exitosamente');
        }, function (error) {
            muestraAlerta3(error.message, 'error');
        }, function () {
            //alert('OK');
        });

        var query2 = "ALTER TABLE catalogos ADD COLUMN cantidad_real DECIMAL(10,2) NULL DEFAULT '0'";

        //creamos columnas nuevas en las tablas existentes, en caso de error no mandamos alerta
        base_datos.transaction(function (ts) {
            ts.executeSql(query2);
        }, function (error) {
            //alert(error.message);
        }, function () {
            //alert('OK');
        });
    }
    catch (err) {
        alert(err.message);
    }
}



//configuramos los parametros para las conexiones de las impresoras configuradas
function consulta_lista_impresoras() {
    try {
        var datos_tabla = northwind.queryAll('configuraciones', { query: { ID: 1 } });
        var x = datos_tabla.length;
        //alert(datos_tabla);
        //alert(x);
        for (var i = 0; i < x; i++) {
            mac_impresora_0 = datos_tabla[i].mac_impresora_0;
            nombre_impresora_0 = datos_tabla[i].nombre_impresora_0;
            mac_impresora_1 = datos_tabla[i].mac_impresora_1;
            nombre_impresora_1 = datos_tabla[i].nombre_impresora_1;
            //alert(mac_impresora_0 + '\n' + nombre_impresora_0 + '\n' + mac_impresora_1 + '\n' + nombre_impresora_1);
        }
    }
    catch (err) {
        alert(err.message);
    }
}

var NConteoGuardado = 0;

function consulta_almacenes() {
    try {
        MuestraLoader('');
        var datos_tabla = northwind.queryAll('almacenes', { query: { ID: 1 } });
        var x = datos_tabla.length;
        //console.log('Tbl almacenes: ' + JSON.stringify(datos_tabla));
        //alert(x);
        id_almacen = datos_tabla[0].id_almacen;
        nombre_almacen = datos_tabla[0].nombre_almacen;
        NConteoGuardado = datos_tabla[0].n_conteo;
        //alert(id_almacen + '\n' + nombre_almacen);
        OcultaLoader();
    }
    catch (err) {
        alert(err.message);
    }
}

function consulta_producto_info() {
    try {
        var datos_tabla = northwind.queryAll('producto_info', { query: { ID: 1 } });
        //alert(JSON.stringify(datos_tabla));
        var x = datos_tabla.length;
        //alert(x);
        for (var i = 0; i < x; i++) {
            nombre_app = datos_tabla[i].nombre_app;
            //version_producto = datos_tabla[i].version_producto;
            codigo_producto = datos_tabla[i].codigo_producto;
            version_actual = datos_tabla[i].version_actual;
        }
        //setTimeout(function () {
        //alert(version_actual + '\n' + version_producto);
        if (version_actual !== version_producto) {
            //deshabilita_controles(); //debemos crear esta función en cualquier script donde ejecutemos valida_version()
            //vibraAlerta(1000);
            //alert('La versión ' + version_actual + ' ya está disponible, se recomienda actualizar para disfrutar de nuevas características del software.');
            //$(location).attr('href', 'https://play.google.com/store/apps/details?id=simple.stock.mobile');
            return;
        }
        //}, 500);
    }
    catch (err) {
        alert(err.message);
    }
}

function actualiza_producto_info(va) {
    try {
        //si esxite un registro con el id 1 se actualiza de lo contrario lo guarda como un nuevo registro
        northwind.insertOrUpdate('producto_info', { ID: 1 }, {
            nombre_app: nombre_app,
            version_producto: version_producto,
            codigo_producto: producto,
            version_actual: va
        });
        northwind.commit();
    }
    catch (err) {
        alert(err.message);
    }
}

//consultamos los datos del inventario asignado al dispositivo
function consulta_datos_inventario() {
    try {
        var datos_tabla = northwind.queryAll('inventarios', { query: { ID: 1 } });
        var x = datos_tabla.length;

        for (var i = 0; i < x; i++) {
            var id = datos_tabla[i].ID;
            if (id === 1) {
                id_inventario = datos_tabla[i].id_inventario;
                nombre_inventario = datos_tabla[i].nombre_inventario;
                fecha_creacion_inventario = datos_tabla[i].fecha_creacion;
                //alert(id_inventario + '\n' + nombre_inventario + '\n' + fecha_creacion_inventario);
            }
        }
    }
    catch (err) {
        alert(err.message);
    }
}

//consultamos los datos de acceso
function consulta_datos_sesiones() {

    try {
        var datos_tabla = northwind.queryAll('sesionesSSM', { query: { ID: 1 } });
        //console.log('Tbl sesionesSSM: ' + JSON.stringify(datos_tabla));

        var x = datos_tabla.length;
        //var id_sesion = datos_tabla[0].ID;
        id_usuario_logueado = datos_tabla[0].id_usuario;
        usuario_logueado = datos_tabla[0].usuario;
        nombre_usuario_logueado = datos_tabla[0].nombre_usuario;
        usuario_conteo = datos_tabla[0].usuario_conteo;
        es_administrador = datos_tabla[0].es_administrador;
        fechaUltimoAcceso = datos_tabla[0].fecha_hora;

    }
    catch (err) {
        alert(err.message);
    }
}

//Guardamos datos de sesión
function guarda_datos_sesion(id_usuario, usuario, nombre_usuario, administrador, fecha) {
    try {
        northwind.truncate('sesionesSSM');
        //si esxite un registro con el id 1 se actualiza de lo contrario lo guarda como un nuevo registro
        northwind.insertOrUpdate('sesionesSSM', { ID: 1 }, {
            id_usuario: id_usuario,
            usuario: usuario,
            nombre_usuario: nombre_usuario,
            es_administrador: administrador,
            fecha_hora: fecha
        });

        northwind.commit();
    }
    catch (err) {
        muestraAlerta1(mensaje);
    }
}

//Guardamos los datos del último acceso a la aplicación
function actualizaFechaSesion(fecha) {
    try {

        northwind.update('sesionesSSM', { ID: 1 }, function (row) {
            row.fecha_hora = fecha;
            // the update callback function returns to the modified record
            return row;
        });

        northwind.commit();
    }
    catch (err) {
        muestraAlerta1(mensaje);
    }
}

function n_usuarios() {
    //consultamos el número de usuarios de registrados en la bd
    var n_registros = northwind.rowCount('usuarios');
    return n_registros;
}

function consultaConfiguracionesLectura() {
    var datos_tabla = northwind.queryAll('configuraciones_lectura', { query: { ID: 1 } });
    //alert(JSON.stringify(datos_tabla));
    return datos_tabla;
}

function guardaDatosConexion(ModoOnline, ServidorNombre, ServidorIP) {
    try {
        northwind.update('configuraciones', { ID: 1 }, function (fila) {
            fila.modo_online = ModoOnline;
            fila.nombre_servidor = ServidorNombre;
            fila.ip_servidor = ServidorIP;
            return fila;
        });
        northwind.commit();
        console.log('Datos guardados exitosamente');
        consultaDatosServidor();
    } catch (err) {
        alert(err.message);
    }
}

function esIpValida(str) {
    // Regular expression to check if string is an IP address
    var regexExp = /^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$/gi;
    return regexExp.test(str);
}


//consultamos los parametros para la conexión con el servidor configurado
function consultaDatosServidor() {
    try {
        var datos_tabla = northwind.queryAll('configuraciones', { query: { ID: 1 } });
        var x = datos_tabla.length;
        console.log('Tbl configuraciones: ' + JSON.stringify(datos_tabla));

        var id_configuracion = datos_tabla[0].ID;
        modo_online = datos_tabla[0].modo_online;
        ip_servidor = datos_tabla[0].ip_servidor;
        nombre_servidor = datos_tabla[0].nombre_servidor;

        mac_impresora_0 = datos_tabla[0].mac_impresora_0;
        nombre_impresora_0 = datos_tabla[0].nombre_impresora_0;
        marca_impresora_0 = datos_tabla[0].marca_impresora_0;
        //marca_impresora_0 = 'Zebra';

        mac_impresora_1 = datos_tabla[0].mac_impresora_1;
        nombre_impresora_1 = datos_tabla[0].nombre_impresora_1;
        marca_impresora_1 = datos_tabla[0].marca_impresora_1;
        //marca_impresora_1 = 'Zebra';

        ruta_php = 'https://' + nombre_servidor + '/myAssets/api/movil/V1.0.0/';

        if (esIpValida(nombre_servidor)) {
            ruta_php = 'http://' + nombre_servidor + '/SER/PanelInventarioFijo/myAssets/api/movil/V1.0.0/';
        }

        var datos = 'modo_online: ' + modo_online +
            '\nip_servidor: ' + ip_servidor +
            '\nnombre_servidor: ' + nombre_servidor +
            '\nmac_impresora_0: ' + mac_impresora_0 +
            '\nnombre_impresora_0: ' + nombre_impresora_0 +
            '\nmarca_impresora_0: ' + marca_impresora_0 +
            '\nmac_impresora_1: ' + mac_impresora_1 +
            '\nnombre_impresora_1: ' + nombre_impresora_1 +
            '\nmarca_impresora_1: ' + marca_impresora_1 +
            '\nruta_php: ' + ruta_php;

        //return datos_tabla;


    }
    catch (err) {
        alert(err.message);
    }
}


//Guardamos datos de sesión
function guardaDatosSesion(datosSesion) {
    try {
        //si esxite un registro con el id 1 se actualiza de lo contrario lo guarda como un nuevo registro
        northwind.insertOrUpdate('sesion_actual', { ID: 1 }, {
            'datos_sesion': datosSesion,
        });
        northwind.commit();

        console.log('Datos de sesión guadados');
    }
    catch (err) {
        alert(err.message);
    }
}



//consulta los datos de la sesión iniciada
function consultaDatoSesionActual() {
    try {
        var datosTabla = northwind.queryAll('sesion_actual', { query: { ID: 1 } });
        console.log('Datos sesión actual: ' + JSON.stringify(datosTabla[0].datos_sesion));
        return datosTabla[0].datos_sesion;
    }
    catch (err) {
        console.log('Error consultaDatoSesionActual: ' + err);
        //alert('Tu sesión ha expirado, captura tus datos de acceso nuevamente para continuar.');
        return [];
    }
}

function eliminaDatosSesion() {
    try {
        northwind.truncate('sesion_actual');
        northwind.commit();
        console.log('Datos de sesión eliminados');
        return true;
    }
    catch (err) {
        console.log('Error eliminaDatosSesion: ' + err.message);
        return false;
    }
}

function ConsultaActualizacionApp() {
    try {

        var rutaPhp = 'https://glint.codigofractal.com/GlintV3/ConsultarActualizaciones.php';
        var codigo_producto = configuracionesApp.codigoSoftware;
        var version_producto = configuracionesApp.versionSoftware;
        var id_dispositivo = device.uuid;
        var origen_instalacion = configuracionesApp.origenInstalacion;

        var datos = 'codigo_producto=' + codigo_producto +
            '&version_producto=' + version_producto +
            '&id_dispositivo=' + id_dispositivo +
            '&origen_instalacion=' + origen_instalacion;

        console.log('rutaPhp: ' + rutaPhp);
        console.log('datos: ' + datos);

        $.ajax({
            type: 'POST',
            url: encodeURI(rutaPhp),
            data: datos,
            crossDomain: true,
            cache: false,
            async: true,
            dataType: 'json',
            encode: true,
            timeout: 20000,
            success: function (respuesta) {
                console.warn('Respuesta servidor: ' + JSON.stringify(respuesta));
                var status = respuesta.status || '';
                var mensaje = respuesta.mensaje || '';
                var datosRegistros = respuesta.datos || [];

                if (status === 'success') {
                    var versionActual = datosRegistros[0].versionActual || '';
                    var fechaLanzamiento = datosRegistros[0].fechaLanzamiento || '';
                    var ligaDescarga = datosRegistros[0].ligaDescarga || '';

                    var mensaje = 'Existe una nueva versión de la aplicación disponible.\n\nVersión: ' + versionActual + '\nFecha de lanzamiento: ' + fechaLanzamiento;

                    if (version_producto !== versionActual) {
                        MensajeAlerta('Hay una actualización de la aplicación disponible, descarga y ejecuta el archivo de instalación para instalarala.', 'info', ['Actualizar'], false, function () {
                            cordova.InAppBrowser.open(ligaDescarga, '_system', 'location=yes');
                        });
                    }

                } else {
                    console.error('Error ConsultaActualizacionApp: ' + mensaje);
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error('Error ConsultaActualizacionApp:', JSON.stringify(jqXHR), textStatus, errorThrown);
                OcultaLoader();
                if (jqXHR.status === 0) {
                    alert("No se pudo conectar. Verifica tu red o la URL del servidor.");
                } else if (jqXHR.status == 404) {
                    alert("Página solicitada no encontrada [404].");
                } else if (jqXHR.status == 500) {
                    alert("Error interno del servidor [500].");
                } else if (textStatus === 'parsererror') {
                    alert("Error al analizar JSON solicitado.");
                } else if (textStatus === 'timeout') {
                    alert("Error de tiempo de espera.");
                } else if (textStatus === 'abort') {
                    alert("Petición AJAX abortada.");
                } else {
                    alert("Error desconocido: " + jqXHR.responseText);
                }
            },
            complete: function () {
                OcultaLoader();
            }
        });

    }
    catch (err) {
        alert('Error ConsultaActualizacionApp: ' + err.message);
    }
}
