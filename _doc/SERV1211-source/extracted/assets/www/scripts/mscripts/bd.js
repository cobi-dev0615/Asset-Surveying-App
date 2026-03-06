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
        // creaBDLocal();


        try {
            AbreConexionBD();
            base_datos.transaction(function (tx) {
                // Tabla 1
                tx.executeSql('DELETE FROM catalogos;', [], function (tx, res) {
                    console.log('Se eliminaron todas las filas de la tabla catalogos');
                }, function (error) {
                    console.error('Error al eliminar filas de la tabla catalogos: ' + error.message);
                });

                // Tabla 2
                tx.executeSql('DELETE FROM lotes_caducidades;', [], function (tx, res) {
                    console.log('Se eliminaron todas las filas de la tabla lotes_caducidades');
                }, function (error) {
                    console.error('Error al eliminar filas de la tabla lotes_caducidades: ' + error.message);
                });

                // Agrega más consultas DELETE para cada tabla que necesites limpiar
            }, function (error) {
                console.error('Error al abrir la transacción: ' + error.message);
            }, function () {
                console.log('Se eliminaron todas las filas de todas las tablas');
            });
        } catch (err) {
            console.error('Error en la función eliminarTodo: ' + err.message);
        }



    }
    catch (err) {
        console.log(err.message);
    }
}

//Validamos si existe la BD, la creamos y configuramos la base de de datos en caso de que no exista
function validaBDLocal() {

    var nTablas = northwind.tableCount() || 0;
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


        // creamos las tablas de la bd
        if (!northwind.tableExists('permisos')) {
            northwind.createTable('permisos', ['id_activacion', 'cliente', 'fecha_inicio', 'fecha_fin', 'vigente', 'prueba', 'codigo_activacion', 'llave_activacion', 'lista_negra', 'eliminado']);
        }
        if (!northwind.tableExists('producto_info')) {
            northwind.createTable('producto_info', ['nombre_app', 'version_producto', 'codigo_producto', 'version_actual']);
        }
        if (!northwind.tableExists('configuraciones')) {
            northwind.createTable('configuraciones', ['modo_online', 'ip_servidor', 'nombre_servidor', 'mac_impresora_0', 'nombre_impresora_0', 'mac_impresora_1', 'nombre_impresora_1']);
        }
        if (!northwind.tableExists('configuraciones_lectura')) {
            northwind.createTable('configuraciones_lectura', ['ubicacion_obligatoria', 'validar_catalogo', 'codigos_forzados', 'descripcion_codigo_forzado', 'lotes', 'n_series', 'fecha_caducidad', 'fecha_fabricacion', 'cantidad_cero', 'cantidades_negativas', 'usar_camara', 'busqueda_catalogo', 'comentarios', 'foto', 'nfc', 'rfid', 'coordenadas', 'inventario_en_linea', 'permitir_decimales', 'n_decimales']);
        }
        if (!northwind.tableExists('usuarios')) {
            northwind.createTable('usuarios', ['nombre_usuario', 'usuario', 'password', 'administrador', 'eliminado']);
        }
        if (!northwind.tableExists('inventarios')) {
            northwind.createTable('inventarios', ['id_inventario', 'nombre_inventario', 'fecha_creacion', 'usuario', 'eliminado']);
        }
        if (!northwind.tableExists('almacenes')) {
            northwind.createTable('almacenes', ['id_almacen', 'inventario', 'nombre_almacen', 'eliminado', 'n_conteo']);
        }
        
        if (!northwind.tableExists('registros')) {
            northwind.createTable('registros', ['inventario', 'id_producto', 'almacen', 'nombre_almacen', 'n_conteo', 'ubicacion', 'cantidad', 'codigo_1', 'codigo_2', 'codigo_3', 'descripcion', 'modelo', 'marca', 'categoria', 'subcategoria', 'precio_compra', 'precio_venta', 'unidad_medida', 'observaciones', 'lote', 'fecha_caducidad', 'n_serie', 'fecha_captura', 'hora_captura', 'usuario', 'nombre_usuario', 'cantidad_teorica', 'latitud', 'longitud', 'forzado', 'sincronizado', 'eliminado']);
        }
        if (!northwind.tableExists('sesionesSSM')) {
            northwind.createTable('sesionesSSM', ['id_usuario', 'nombre_usuario', 'es_administrador', 'usuario_conteo', 'fecha_hora']);
        }
        if (!northwind.tableExists('datos_pago')) {
            northwind.createTable('datos_pago', ['orden_id', 'metodo_pago', 'tipo_licencia', 'cliente_id', 'email', 'cliente', 'fecha_inicio', 'hora_inicio', 'fecha_fin', 'codigo_activacion', 'llave_activacion', 'fecha_hora', 'otros_datos', 'sincronizado']);
        }
        if (!northwind.tableExists('datos_pago_error')) {
            northwind.createTable('datos_pago_error', ['metodo_pago', 'tipo_licencia', 'orden_status', 'orden_id', 'cliente_id', 'email', 'cliente', 'fecha_hora', 'otros_datos', 'sincronizado']);
        }
        if (!northwind.tableExists('registros_cruzados')) {
            northwind.createTable('registros_cruzados', ['inventario', 'id_producto', 'almacen', 'nombre_almacen', 'n_conteo', 'ubicacion', 'cantidad', 'codigo_1', 'codigo_2', 'codigo_3', 'descripcion', 'modelo', 'marca', 'categoria', 'subcategoria', 'precio_compra', 'precio_venta', 'unidad_medida', 'observaciones', 'lote', 'fecha_caducidad', 'n_serie', 'fecha_captura', 'hora_captura', 'usuario', 'nombre_usuario', 'cantidad_teorica', 'latitud', 'longitud', 'forzado', 'sincronizado', 'eliminado']);
        }

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
            'n_decimales': 2,
            'factor': 0

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
        console.error('Error creaBDLocal: ' + err.message);
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
            northwind.createTable('configuraciones_lectura', ['ubicacion_obligatoria', 'validar_catalogo', 'codigos_forzados', 'descripcion_codigo_forzado', 'lotes', 'n_series', 'fecha_caducidad', 'fecha_fabricacion', 'cantidad_cero', 'cantidades_negativas', 'usar_camara', 'busqueda_catalogo', 'comentarios', 'foto', 'nfc', 'rfid', 'coordenadas', 'inventario_en_linea', 'permitir_decimales', 'n_decimales', 'factor']);

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
                'n_decimales': 2,
                'factor': 0
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

        if (!northwind.columnExists('configuraciones_lectura', 'factor')) {
            northwind.alterTable('configuraciones_lectura', ['factor']);
            northwind.commit();

            northwind.insertOrUpdate('configuraciones_lectura', { ID: 1 }, {
                'factor': 0
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
function AbreConexionBD() {
    try {
        var plataformaCordova = window.cordova.platformId;
        console.log('Plataforma: ' + plataformaCordova);
        base_datos = (plataformaCordova === 'browser' || plataformaCordova === 'electron') ?
            window.openDatabase('Northwind', '1.0', 'Data', 2 * 1024 * 1024) :
            window.sqlitePlugin.openDatabase({ name: 'Northwind.db', location: 'default' });

        console.log('Conexión a la base de datos SQLite exitosa');
    }
    catch (err) {
        MuestraAlerta3(err.message, 'error');
    }
}

function creaBDSQLite() {
    //SQLite
    try {
        AbreConexionBD();
        // var plataformaCordova = window.cordova.platformId;
        // base_datos = (plataformaCordova === 'browser') ?
        //     window.openDatabase('Northwind', '1.0', 'Data', 2 * 1024 * 1024) :
        //     window.sqlitePlugin.openDatabase({ name: 'Northwind.db', location: 'default' });

        var query1 = 'CREATE TABLE IF NOT EXISTS catalogos (' +
            'inventario INTEGER, ' +
            'id_producto INTEGER, ' +
            'codigo_1 VARCHAR(50), ' +
            'codigo_2 VARCHAR(50), ' +
            'codigo_3 VARCHAR(50), ' +
            'descripcion VARCHAR(50), ' +
            'precio_venta DECIMAL, ' +
            'modelo VARCHAR(50), ' +
            'marca VARCHAR(50), ' +
            'categoria VARCHAR(50), ' +
            'subcategoria VARCHAR(50), ' +
            'precio_compra DECIMAL, ' +
            'unidad_medida VARCHAR(50), ' +
            'observaciones VARCHAR(50), ' +
            'cantidad_teorica INTEGER, ' +
            'forzado INTEGER, ' +
            'sincronizado INTEGER, ' +
            'eliminado INTEGER, ' +
            'cantidad_real INTEGER, ' +
            'factor INTEGER' +
            ');';
        base_datos.transaction(function (ts) {
            ts.executeSql(query1);
        }, function (error) {
            console.error('Error al crear la tabla catalogos: ' + error.message);
            MuestraAlerta3('Error al crear la tabla catalogos: ' + error.message, 'error');
        }, function () {
            console.log('Tabla catalogos creadas exitosamente');
        });

        var query2 = "CREATE TABLE IF NOT EXISTS registros (" +
            "id_registro INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "inventario INTEGER, " +
            "id_producto INTEGER, " +
            "almacen VARCHAR(50), " +
            "nombre_almacen VARCHAR(50), " +
            "ubicacion VARCHAR(50), " +
            "cantidad INTEGER, " +
            "codigo_1 VARCHAR(50), " +
            "codigo_2 VARCHAR(50), " +
            "codigo_3 VARCHAR(50), " +
            "descripcion VARCHAR(128), " +
            "modelo VARCHAR(50), " +
            "marca VARCHAR(50), " +
            "categoria VARCHAR(50), " +
            "subcategoria VARCHAR(50), " +
            "precio_compra DECIMAL, " +
            "precio_venta DECIMAL, " +
            "unidad_medida VARCHAR(50), " +
            "observaciones VARCHAR(50), " +
            "lote VARCHAR(50), " +
            "fecha_caducidad VARCHAR(50), " +
            "n_serie VARCHAR(50), " +
            "fecha_captura VARCHAR(50), " +
            "hora_captura VARCHAR(50), " +
            "usuario VARCHAR(50), " +
            "nombre_usuario VARCHAR(50), " +
            "cantidad_teorica INTEGER, " +
            "forzado INTEGER, " +
            "sincronizado INTEGER, " +
            "eliminado INTEGER" +
            ");";
        base_datos.transaction(function (ts) {
            ts.executeSql(query2);
        }, function (error) {
            console.error('Error al crear la tabla registros: ' + error.message);
            MuestraAlerta3('Error al crear la tabla registros: ' + error.message, 'error');
        }, function () {
            console.log('Tabla registros creadas exitosamente');
        });

        var query3 = "CREATE TABLE IF NOT EXISTS lotes_caducidades (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "inventario INTEGER, " +
            "cantidad DECIMAL, " +
            "codigo1 VARCHAR(50), " +
            "codigo2 VARCHAR(50), " +
            "codigo3 VARCHAR(50), " +
            "lote VARCHAR(50), " +
            "fechaCaducidad VARCHAR(50)" +
            "); " +
            "CREATE INDEX IF NOT EXISTS idx_codigo2 ON lotes_caducidades(codigo2);";


        base_datos.transaction(function (ts) {
            ts.executeSql(query3);
        }, function (error) {
            console.error('Error al crear la tabla lotes_caducidades: ' + error.message);
            MuestraAlerta3('Error al crear la tabla lotes_caducidades: ' + error.message, 'error');
        }, function () {
            console.log('Tabla lotes_caducidades creadas exitosamente');
        });


        // var query = 'CREATE TABLE IF NOT EXISTS catalogos (inventario, id_producto, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, modelo, marca, categoria, subcategoria, precio_compra, unidad_medida, observaciones, cantidad_teorica, forzado, sincronizado, eliminado, cantidad_real, factor);';
        // base_datos.transaction(function (ts) {
        //     ts.executeSql(query);
        // }, function (error) {
        //     MuestraAlerta3('Error al crear la tabla catalogos: ' + error.message, 'error');
        // }, function () {
        //     console.log('Tabla catalogos creadas exitosamente');
        // });

        // query = "CREATE TABLE IF NOT EXISTS registros (id_registro, inventario, id_producto, almacen, nombre_almacen, ubicacion, cantidad, codigo_1, codigo_2, codigo_3, descripcion, modelo, marca, categoria, subcategoria, precio_compra, precio_venta, unidad_medida, observaciones, lote, fecha_caducidad, n_serie, fecha_captura, hora_captura, usuario, nombre_usuario, cantidad_teorica, forzado, sincronizado, eliminado)";

        // base_datos.transaction(function (ts) {
        //     ts.executeSql(query);
        // }, function (error) {
        //     MuestraAlerta3('Error al crear la tabla registros: ' + error.message, 'error');
        // }, function () {
        //     console.log('Tabla registros creadas exitosamente');
        // });

        // query = "CREATE TABLE IF NOT EXISTS lotes_caducidades (" +
        //     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
        //     "inventario INTEGER, " + //INTEGER UNIQUE Índice único en la columna inventario
        //     "cantidad DECIMAL, " +
        //     "codigo1 VARCHAR(50), " +
        //     "codigo2 VARCHAR(50), " +
        //     "codigo3 VARCHAR(50), " +
        //     "lote VARCHAR(100), " +
        //     "fechaCaducidad VARCHAR(20)" +
        //     ");" +
        //     "CREATE INDEX IF NOT EXISTS idx_codigo2 ON lotes_caducidades(codigo2);";

        // base_datos.transaction(function (ts) {
        //     ts.executeSql(query);
        // }, function (error) {
        //     MuestraAlerta3('Error al crear la tabla lotes_caducidades: ' + error.message, 'error');
        // }, function () {
        //     console.log('Tabla lotes_caducidades creadas exitosamente');
        // });

       var query4 = "ALTER TABLE catalogos ADD COLUMN cantidad_real DECIMAL(10,2) NULL DEFAULT '0'";

        base_datos.transaction(function (ts) {
            ts.executeSql(query4);
        }, function (error) {
            console.error('Error al actualizar la tabla catalogos en la columna cantidad_real: ' + error.message);
            // MuestraAlerta3('Error al actualizar la tabla catalogos en la columna cantidad_real: ' + error.message, 'error');
        }, function () {
            console.log('Tabla catalogos actualizada exitosamente');
        });


        var query5 = "ALTER TABLE catalogos ADD COLUMN factor DECIMAL(10,2) NULL DEFAULT '0'";

        base_datos.transaction(function (ts) {
            ts.executeSql(query5);
        }, function (error) {
            console.error('Error al actualizar la tabla catalogos en la columna factor: ' + error.message);
            // MuestraAlerta3('Error al actualizar la tabla catalogos en la columna factor: ' + error.message, 'error');
        }, function () {
            console.log('Tabla catalogos actualizada exitosamente');
        });

        base_datos.transaction(function (tx) {
            tx.executeSql("CREATE INDEX IF NOT EXISTS indexCodigo1 ON catalogos(codigo_1)",
                [],
                function (tx, result) {
                    console.log('Índice creado exitosamente');
                },
                function (tx, error) {
                    console.error('Error al crer el índice: ' + error.message);
                });
        });
        base_datos.transaction(function (tx) {
            tx.executeSql("CREATE INDEX IF NOT EXISTS indexCodigo2 ON catalogos(codigo_2)",
                [],
                function (tx, result) {
                    console.log('Índice creado exitosamente');
                },
                function (tx, error) {
                    console.error('Error al crer el índice: ' + error.message);
                });
        });
        base_datos.transaction(function (tx) {
            tx.executeSql("CREATE INDEX IF NOT EXISTS indexCodigo3 ON catalogos(codigo_3)",
                [],
                function (tx, result) {
                    console.log('Índice creado exitosamente');
                },
                function (tx, error) {
                    console.error('Error al crer el índice: ' + error.message);
                });
        });

    }
    catch (err) {
        alert('Error creaBDSQLite: ' + err.message);
    }
}


//consultamos los parametros para la conexión con el servidor configurado
function consultaDatosServidor() {
    try {
        var datos_tabla = northwind.queryAll('configuraciones', { query: { ID: 1 } });
        var x = datos_tabla.length;
        console.log('Tbl configuraciones: ' + JSON.stringify(datos_tabla));
        //alert(x);

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

        ruta_php = 'http://' + nombre_servidor + '/Bee/App/BlankApp/www/php/';
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
        OcultaLoader();
        console.log('Error consulta_almacenes: ' + err.message);
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
        MuestraAlerta1(mensaje);
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
        MuestraAlerta1('Error actualizaFechaSesion: ' + err.message);
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

function GuardaDatosConexion(ModoOnline, ServidorNombre, ServidorIP) {
    northwind.update('configuraciones', { ID: 1 }, function (fila) {
        fila.modo_online = ModoOnline;
        fila.nombre_servidor = ServidorNombre;
        fila.ip_servidor = ServidorIP;
        return fila;
    });
    northwind.commit();


}