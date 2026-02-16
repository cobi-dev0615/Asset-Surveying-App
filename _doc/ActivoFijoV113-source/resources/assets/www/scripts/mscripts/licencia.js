function str_llave_activacion(str_datos){
    var llave = sha256(str_datos);
    llave = llave.replace(/\D/g, '');
    return llave;
}

//
var status_licencia = 'vigente';
var id_activacion = '0';
var cliente_activacion = 'Demostración';
var fecha_fin_activacion = '';
var llave_activacion = '';

function datosLicencia() {
    var datos_tabla = northwind.queryAll('permisos', { query: { ID: 1 } });
    //alert(JSON.stringify(datos_tabla));
    return datos_tabla;
}

//consultamos los parametros de los permisos de uso de la aplicación
function consulta_permisos_uso() {
    try {
        var datos_tabla = northwind.queryAll('permisos', { query: { ID: 1 } });
        var x = datos_tabla.length;
        console.log('Tbl permisos: ' + JSON.stringify(datos_tabla));
        //si la tabla está vacia insertamos los datos de activación de prueba
        if (x === 0) {
            inicia_prueba();
        }
        else {

            var fecha_dispositivo = strFecha(0);

            id_activacion = datos_tabla[0].id_activacion;
            cliente_activacion = datos_tabla[0].cliente;
            var fecha_inicio = datos_tabla[0].fecha_inicio;
            var fecha_fin = datos_tabla[0].fecha_fin;
            var vigente = datos_tabla[0].vigente;
            var prueba = datos_tabla[0].prueba;
            var codigo_activacion = datos_tabla[0].codigo_activacion;
            llave_activacion = datos_tabla[0].llave_activacion;
            var lista_negra = datos_tabla[0].lista_negra;
            fecha_fin_activacion = fecha_fin;

            var datos = id_activacion + '\n' + id_activacion + '\n' + producto + '\n' + id_dispositivo + '\n' + codigo_activacion + '\n' + llave_activacion + '\n' + str_llave_activacion(producto + codigo_activacion + serie_dispositivo + modelo_dispositivo + fabricante_dispositivo) + '\n' + fecha_inicio + '\n' + fecha_fin_activacion;
            console.log('Datos de licencia actual: ' + datos);

      
                // a partir de la versión 241 la licencia se asociará al número de serie del dispositivo
                //si la llave de activación es diferente a la llave almacenada en la base de datos eliminamos los datos de licencia para bloquear el software
                if (llave_activacion !== str_llave_activacion(producto + codigo_activacion + serie_dispositivo + modelo_dispositivo + fabricante_dispositivo)) {
                    console.log('Las llaves no coinciden: ' + llave_activacion + ' !== ' + str_llave_activacion(producto + codigo_activacion + serie_dispositivo + modelo_dispositivo + fabricante_dispositivo));
                    status_licencia = 'expirado';
                    vibraAlerta(500);
                    eliminaLicencia();
                    muestraAlerta1('Lo sentimos pero su periodo de evaluación ha terminado, si desea adquirir una licencia del producto para su dispositivo dé clic en una opción para adquirirla o comuníquese con nosotros al correo ventas@codigofractal.com');
                    desactiva_aplicacion();
                    return;
                }
       
            //si las fechas almacendas en la base de datos no coinciden eliminamos los datos de licencia para bloquear el software
            if (fecha_fin < fecha_dispositivo || fecha_inicio === '' || fecha_fin === '') {
                console.log('Licencia expirada por fecha.');
                status_licencia = 'expirado';
                vibraAlerta(500);
                eliminaLicencia();
                muestraAlerta1('Lo sentimos pero su periodo de evaluación ha terminado, si desea adquirir una licencia del producto para su dispositivo dé clic en una opción para adquirirla o comuníquese con nosotros al correo ventas@codigofractal.com');
                desactiva_aplicacion();
                return;
            }
            //si el dispositivo es un emulador desactivamos la aplicación
            /*
            if (es_virtual === true) {
                console.log('Licencia expirada porque es un dispositivo virtual.');
                status_licencia = 'expirado';
                vibraAlerta(500);
                eliminaLicencia();
                muestraAlerta1('Lo sentimos pero su periodo de evaluación ha terminado, si desea adquirir una licencia del producto para su dispositivo dé clic en una opción para adquirirla o comuníquese con nosotros al correo ventas@codigofractal.com');
                desactiva_aplicacion();
                return;
            }
            */
            ////si las fechas almacendas en la base de datos no coinciden eliminamos los datos de licencia para bloquear el software
            //if (fecha_inicio > fecha_dispositivo) {
            //    status_licencia = 'expirado';
            //    vibraAlerta(1000);
            //    //eliminaLicencia();
            //    alert('Para poder usar la aplicación es necesario que la fecha y hora del dispositivo sean correctos.');
            //    navigator.app.exitApp();
            //    return;
            //}

            status_licencia = 'vigente';

        }
    }
    catch (err) {
        alert(err.message);
    }

}

function eliminaLicencia() {
    actualiza_licencia(0, '', strFecha(0), strFecha(-1), '', '', 0);
}

/**
 * Si se instala o reinstala la aplicación inicia el periodo de prueba de la aplicación
 *validando si ya fue usado anteriormente en el dispositivo
 */
function inicia_prueba() {
    try {
        //MuestraLoader('');
        var php_consulta = ruta_php_licencia + 'licenciaPrueba.php';
        //alert(php_consulta);

        
        var codigo_activacion = 'CFRACTALDEMO'; //licencia temporal para demo
        var fecha_dispositivo = strFecha(0);
        var status = '';
        var id_mensaje = '';
        var mensaje = '';
        var fecha_inicio = '';
        var fecha_fin = '';
        llave_activacion = str_llave_activacion(producto + codigo_activacion + serie_dispositivo + modelo_dispositivo + fabricante_dispositivo);
        //var llave_activacion = sha256(producto + codigo_activacion + id_dispositivo);
        //llave_activacion = llave_activacion.replace(/\D/g, '');
        var lista_negra = 0;

        //antes de salir a consultar el servidor activamos la app por un periodo de 1 día en caso de que haya algún error durante 
        //el proceso de la activación temporal
      
        actualiza_licencia(0, 'Demostración', strFecha(0), strFecha(1), codigo_activacion, llave_activacion, lista_negra);
        
        var datos = 'codigo_producto=' + producto +
            '&configuracionesApp.versionSoftware=' + configuracionesApp.versionSoftware + 
            '&id_dispositivo=' + id_dispositivo + 
            '&serie_dispositivo=' + serie_dispositivo + 
            '&modelo_dispositivo=' + modelo_dispositivo + 
            '&version_dispositivo=' + version_dispositivo + 
            '&fabricante_dispositivo=' + fabricante_dispositivo + 
            '&tipo_dispositivo=Móvil' + 
            '&plataforma_dispositivo=' + plataforma_dispositivo + 
            '&nombre_dispositivo=' + nombre_dispositivo + 
            '&fecha_dispositivo=' + fecha_dispositivo + 
            '&codigo_activacion=' + codigo_activacion +
            '&es_virtual=' + es_virtual + 
            '&origen_instalacion=' + origen_instalacion;

        //alert(datos);

        $.ajax({
            type: 'POST',
            url: encodeURI(php_consulta),
            data: datos,
            crossDomain: true,
            cache: false,
            success: function (respuesta) {
                // OcultaLoader();

                var datos_tabla = JSON.parse(respuesta);

                console.log('Datos de licencia de prueba recibidos: ' + JSON.stringify(datos_tabla));

                    status = datos_tabla[0].status;
                    id_mensaje = datos_tabla[0].id_mensaje;
                    mensaje = datos_tabla[0].mensaje;
                    fecha_inicio = datos_tabla[0].fecha_inicio;
                    fecha_fin = datos_tabla[0].fecha_fin;
                    llave_activacion = datos_tabla[0].llave_activacion;
                    lista_negra = datos_tabla[0].lista_negra;


                actualiza_licencia(0, 'Demostración', fecha_inicio, fecha_fin, codigo_activacion, llave_activacion, lista_negra);

                if (id_mensaje === '4' || id_mensaje === '5') {
                    //en caso de recibir algún error del servidor activamos la app por un periodo menor
                    actualiza_licencia(0, '1', strFecha(0), strFecha(1), codigo_activacion, llave_activacion, lista_negra);
                }

            },
            error: function (respuesta) {
                //OcultaLoader();
                vibraAlerta(1000);
                //alert(respuesta);
                //alert('No pude acceder al servidor en estos momentos, intente nuevamente y verifíca que el dispositivo tenga conexión a internet. Si el problema persiste comuniquese con el administrador.');
            }
        });
    }
    catch (err) {
        alert(err.message);
    }

}

function actualiza_licencia(id_activacion, cliente, fecha_inicio, fecha_fin, codigo_activacion, llave_activacion, lista_negra) {
    try {
        northwind.insertOrUpdate('permisos', { ID: 1 }, {
            id_activacion: id_activacion,
            cliente: cliente,
            fecha_inicio: fecha_inicio,
            fecha_fin: fecha_fin,
            //vigente: vigente,
            //prueba: prueba,
            codigo_activacion: codigo_activacion,
            llave_activacion: llave_activacion,
            lista_negra: lista_negra,
            eliminado: 0
        });
        northwind.commit();

        

    }
    catch (err) {
        alert(err.message);
    }
}

/////////
function desactiva_aplicacion() {
    eliminaLicencia();
    eliminaDatosPago();
    $(location).attr('href', 'panel_activacion.html');
}

function activa_licencia(codigo_activacion) {

    try {
        if (codigo_activacion.length !== 12) {
            suenaError();
            vibraAlerta(500);
            muestraAlerta1('Código de activación inválido, si desea adquirir el programa comuníquese con nosotros al correo ventas@codigofractal.com.');
            $('#txt_codigo').focus();
            return;
        }

        ////temporal
        //vibraAlerta(1000);
        //muestraAlerta1('Código de activación incorrecto.');
        //$('#txt_codigo').focus();
        //return;
        MuestraLoader('');
        var php_consulta = ruta_php_licencia + 'licenciaActivacion.php';
        console.log(php_consulta);

        //var codigo_activacion = 'SSMDEMOAND01'; //licencia temporal para demo
        var fecha_dispositivo = strFecha(0);
        var status = '';
        var id_mensaje = '';
        var mensaje = '';
        var fecha_inicio = '';
        var fecha_fin = '';
        var lista_negra = 0;

        var cliente = '';
        var id_activacion = '';
        var email = '';
        var llave_activacion = '';
        //antes de salir a consultar el servidor activamos la app por un periodo de 1 días en caso de que haya algún error durante 
        //el proceso de la activación temporal

        //actualiza_licencia(0, 'Demostración', strFecha(0), strFecha(1), codigo_activacion, llave_activacion, lista_negra);

        var datos = 'codigo_producto=' + producto +
            '&configuracionesApp.versionSoftware=' + configuracionesApp.versionSoftware +
            '&id_dispositivo=' + id_dispositivo +
            '&serie_dispositivo=' + serie_dispositivo +
            '&modelo_dispositivo=' + modelo_dispositivo +
            '&version_dispositivo=' + version_dispositivo +
            '&fabricante_dispositivo=' + fabricante_dispositivo +
            '&tipo_dispositivo=Móvil' +
            '&plataforma_dispositivo=' + plataforma_dispositivo +
            '&nombre_dispositivo=' + nombre_dispositivo +
            '&fecha_dispositivo=' + fecha_dispositivo +
            '&codigo_activacion=' + codigo_activacion;

        //alert(datos);

        $.ajax({
            type: 'POST',
            url: encodeURI(php_consulta),
            data: datos,
            crossDomain: true,
            cache: false,
            success: function (respuesta) {
                console.log('Respuesta activacion por código: ' + respuesta);
                OcultaLoader();
                var datos_tabla = JSON.parse(respuesta);
                
                status = datos_tabla[0].status;
                id_mensaje = datos_tabla[0].id_mensaje;
                mensaje = datos_tabla[0].mensaje;

                cliente = datos_tabla[0].cliente;
                id_activacion = datos_tabla[0].id_activacion;
                nombre_empresa = datos_tabla[0].empresa;
                email = datos_tabla[0].email;

                fecha_inicio = datos_tabla[0].fecha_inicio;
                fecha_fin = datos_tabla[0].fecha_fin;
                llave_activacion = datos_tabla[0].llave_activacion;
                lista_negra = datos_tabla[0].lista_negra;


                if (id_mensaje === '4' || id_mensaje === '5' || id_mensaje === '6') {
                    suenaError();
                    vibraAlerta(1000);
                    muestraAlerta1(mensaje);
                    return;

                }
                if (fecha_fin < strFecha(0)) {
                    /**/
                }

                actualiza_licencia(id_activacion, nombre_empresa, fecha_inicio, fecha_fin, codigo_activacion, llave_activacion, lista_negra);

                actualizaFechaSesion('2020-07-01'); //actualizamos la fecha de la última sesión para evitar errores y perdida de información del cliente tramposo

                //suenaExito();
                vibraAlerta(1000);
                alert(mensaje);
                $(location).attr('href', 'inicio.html'); //regresamos a la pantalla principal de la aplicación
                //window.history.back(); //regresamos a la pantalla anterior

            },
            error: function (respuesta) {
                OcultaLoader();
                vibraAlerta(500);
                //alert(JSON.stringify(respuesta));
                muestraAlerta1('No pude acceder al servidor en estos momentos, intente nuevamente y verifíca que el dispositivo tenga conexión a Internet. Si el problema persiste comuníquese con nuestro equipo de soporte a contacto@codigofractal.com.');
            }
        });

    }
    catch (err) {
        OcultaLoader();
        alert(err.message);
    }

}

/*
*Activación silenciosa de la aplicación
 */

function activacionSilenciosaLicencia() {

    try {

        var arrDatosLicencia = datosLicencia();
        var codigo_activacion = arrDatosLicencia[0].codigo_activacion;
        var id_activacion = arrDatosLicencia[0].id_activacion;
        console.log('id_activacion: '+ id_activacion);
        if (id_activacion === 0) { //si está en modo prueba detenemos el proceso
            return;
        }

        //alert(JSON.stringify(arrDatosLicencia));
        //if (arrDatosLicencia.length === 0) {
        //    return;
        //}

       
        var php_consulta = ruta_php_licencia + 'licenciaActivacion.php';
       
        //alert(php_consulta);

        //var codigo_activacion = 'SSMDEMOAND01'; //licencia temporal para demo
        var fecha_dispositivo = strFecha(0);
        var status = '';
        var id_mensaje = '';
        var mensaje = '';
        var fecha_inicio = '';
        var fecha_fin = '';
        var lista_negra = 0;
        var cliente = '';
        var email = '';
        llave_activacion = '';

      
        //antes de salir a consultar el servidor activamos la app por un periodo de 1 días en caso de que haya algún error durante 
        //el proceso de la activación temporal

        //actualiza_licencia(0, 'Demostración', strFecha(0), strFecha(1), codigo_activacion, llave_activacion, lista_negra);

        var datos = 'codigo_producto=' + producto +
            '&configuracionesApp.versionSoftware=' + configuracionesApp.versionSoftware +
            '&id_dispositivo=' + id_dispositivo +
            '&serie_dispositivo=' + serie_dispositivo +
            '&modelo_dispositivo=' + modelo_dispositivo +
            '&version_dispositivo=' + version_dispositivo +
            '&fabricante_dispositivo=' + fabricante_dispositivo +
            '&tipo_dispositivo=Móvil' +
            '&plataforma_dispositivo=' + plataforma_dispositivo +
            '&nombre_dispositivo=' + nombre_dispositivo +
            '&fecha_dispositivo=' + fecha_dispositivo +
            '&codigo_activacion=' + codigo_activacion;

        //console.log(datos);

        $.ajax({
            type: 'POST',
            url: encodeURI(php_consulta),
            data: datos,
            crossDomain: true,
            cache: false,
            async: true,
            dataType: 'json',
            //encode: true,

            success: function (respuesta) {
                //OcultaLoader();
                //var datos_tabla = JSON.parse(respuesta);
                console.log('Activacion silenciosa:' + JSON.stringify(respuesta));

                status = respuesta[0].status;
                id_mensaje = respuesta[0].id_mensaje;
                mensaje = respuesta[0].mensaje;
                cliente = respuesta[0].cliente;
                id_activacion = respuesta[0].id_activacion;
                nombre_empresa = respuesta[0].empresa;
                email = respuesta[0].email;
                fecha_inicio = respuesta[0].fecha_inicio;
                fecha_fin = respuesta[0].fecha_fin;
                llave_activacion = respuesta[0].llave_activacion;
                lista_negra = respuesta[0].lista_negra;

                if (id_mensaje === '4' || id_mensaje === '5' || id_mensaje === '6') {
                    //muestraAlerta1(mensaje);
                    desactiva_aplicacion();
                    return;
                }

                actualiza_licencia(id_activacion, nombre_empresa, fecha_inicio, fecha_fin, codigo_activacion, llave_activacion, lista_negra);
                //suenaError();
                //vibraAlerta(1000);
                //alert(mensaje);
            },
            error: function (respuesta) {
                //OcultaLoader();
                //vibraAlerta(1000);
                console.log('Error activacion silenciosa: ' + JSON.stringify(respuesta));
                //muestraAlerta1('No pude acceder al servidor en estos momentos, intente nuevamente y verifíca que el dispositivo tenga conexión a internet. Si el problema persiste comuniquese con el administrador.');
            }
        });

    }
    catch (err) {
        //OcultaLoader();
        console.log(err.message);
    }

}


/**
*
*/

//validamos la versión de la aplicación para forzar al usuario a actualizarla 
function valida_version() {
    try {
        var va = ''; //versión actual
        var php_consulta = ruta_php_licencia + 'productoVersion.php';
        var datos = 'id_activacion=' + id_activacion +
            '&codigo_producto=' + producto +
            '&configuracionesApp.versionSoftware=' + configuracionesApp.versionSoftware +
            '&id_dispositivo=' + id_dispositivo +
            '&modelo_dispositivo=' + modelo_dispositivo +
            '&os=Android' +
            '&llave_activacion=' + llave_activacion;


       // alert(datos);

        $.ajax({
            type: 'POST',
            url: encodeURI(php_consulta),
            data: datos,
            crossDomain: true,
            cache: false,
            success: function (respuesta) {
                console.log('valida_version_prueba : ' + respuesta);

                //var datos_tabla = JSON.parse(respuesta);
                //var x = datos_tabla.length;
                // va = datos_tabla[0].version; //version_actual está definido en el script general.js            
                //actualiza_producto_info(va); //función definida en el script bd.js
            },
            error: function (respuesta) {
                //alert(respuesta);
            }
        });
    }
    catch (err) {
        //alert(err.message);
    }
}

function activaPruebaSilenciosa() {
    try {
        //MuestraLoader('');
        var php_consulta = ruta_php_licencia + 'licenciaPrueba.php';
        //alert(php_consulta);


        var codigo_activacion = 'CFRACTALDEMO'; //licencia temporal para demo
        var fecha_dispositivo = strFecha(0);
        var status = '';
        var id_mensaje = '';
        var mensaje = '';
        var fecha_inicio = '';
        var fecha_fin = '';
        llave_activacion = str_llave_activacion(producto + codigo_activacion + serie_dispositivo + modelo_dispositivo + fabricante_dispositivo);
        var lista_negra = 0;


       

        //antes de salir a consultar el servidor activamos la app por un periodo de 1 día en caso de que haya algún error durante 
        //el proceso de la activación temporal

        //actualiza_licencia(0, 'Demostración', strFecha(0), strFecha(1), codigo_activacion, llave_activacion, lista_negra);

        var datos = 'codigo_producto=' + producto +
            '&configuracionesApp.versionSoftware=' + configuracionesApp.versionSoftware +
            '&id_dispositivo=' + id_dispositivo +
            '&serie_dispositivo=' + serie_dispositivo +
            '&modelo_dispositivo=' + modelo_dispositivo +
            '&version_dispositivo=' + version_dispositivo +
            '&fabricante_dispositivo=' + fabricante_dispositivo +
            '&tipo_dispositivo=Móvil' +
            '&plataforma_dispositivo=' + plataforma_dispositivo +
            '&nombre_dispositivo=' + nombre_dispositivo +
            '&fecha_dispositivo=' + fecha_dispositivo +
            '&codigo_activacion=' + codigo_activacion +
            '&es_virtual=' + es_virtual +
            '&origen_instalacion=' + origen_instalacion;

        //alert(datos);

        $.ajax({
            type: 'POST',
            url: encodeURI(php_consulta),
            data: datos,
            crossDomain: true,
            cache: false,
            success: function (respuesta) {
                // OcultaLoader();

                var datos_tabla = JSON.parse(respuesta);

                console.log('Datos de licencia de prueba recibidos: ' + JSON.stringify(datos_tabla));

                status = datos_tabla[0].status;
                id_mensaje = datos_tabla[0].id_mensaje;
                mensaje = datos_tabla[0].mensaje;
                fecha_inicio = datos_tabla[0].fecha_inicio;
                fecha_fin = datos_tabla[0].fecha_fin;
                llave_activacion = datos_tabla[0].llave_activacion;
                lista_negra = datos_tabla[0].lista_negra;


                actualiza_licencia(0, 'Demostración', fecha_inicio, fecha_fin, codigo_activacion, llave_activacion, lista_negra);

                if (id_mensaje === '4' || id_mensaje === '5') {
                    //en caso de recibir algún error del servidor activamos la app por un periodo menor
                    actualiza_licencia(0, '1', strFecha(0), strFecha(1), codigo_activacion, llave_activacion, lista_negra);
                }

            },
            error: function (respuesta) {
                //OcultaLoader();
                vibraAlerta(1000);
                //alert(respuesta);
                //alert('No pude acceder al servidor en estos momentos, intente nuevamente y verifíca que el dispositivo tenga conexión a internet. Si el problema persiste comuniquese con el administrador.');
            }
        });
    }
    catch (err) {
        alert(err.message);
    }

}


/////


/////Datos de pago
function guardaDatosPago(orden_id, metodo_pago, tipo_licencia, clienteId, email, cliente, fecha_inicio, hora_inicio, fecha_fin, codigo_activacion, llave_activacion, fecha_hora, otros_datos) {
    try {
        northwind.insertOrUpdate('datos_pago', { ID: 1 }, {
            orden_id: orden_id, 
            metodo_pago: metodo_pago,
            tipo_licencia: tipo_licencia,
            clienteId: clienteId,
            email: email, 
            cliente: cliente,
            fecha_inicio: fecha_inicio,
            hora_inicio: hora_inicio, 
            fecha_fin: fecha_fin,
            codigo_activacion: codigo_activacion,
            llave_activacion: llave_activacion,
            fecha_hora: fecha_hora,
            otros_datos: otros_datos,
            sincronizado: 0
        });
        northwind.commit();
    }
    catch (err) {
        alert(err.message);
    }
}

function eliminaDatosPago() {
    try {
        northwind.truncate('datos_pago');
        northwind.commit();
    }
    catch (err) {
        alert(err.message);
    }
}

function consultaDatosPago(eliminaDatos) {
    try {
        var datos_tabla = northwind.queryAll('datos_pago', { query: { ID: 1 } });

        console.log('Tbl datos_pago: ' + JSON.stringify(datos_tabla));
       // return;
        var x = datos_tabla.length;
        
        
        //si la tabla está vacia insertamos los datos de activación de prueba
        if (x > 0) {
            //creaDirectoriosExtras('JSONPagoPagoPayPal' + strFecha(0) + '.txt', JSON.stringify(datos_tabla), 3);
            var metodo_pago = datos_tabla[0].metodo_pago;
            var details = datos_tabla[0].otros_datos;
            var sincronizado = datos_tabla[0].sincronizado;

            //console.log(JSON.stringify(otros_datos));

            //datos de la compra
            var fecha_hora_compra = datos_tabla[0].fecha_hora;
            var fecha_compra = datos_tabla[0].fecha_inicio;
            var hora_compra = datos_tabla[0].hora_inicio;
            var orden_id = '';
            var orden_status = '';
            var cliente_nombre = '';
            var cliente_apellido = '';
            var email = datos_tabla[0].email;
            var cliente_id_pp = '';
            var purchase_units = '';
            var datos_direccion = '';
            var datos_pago = '';
            //direccion
            var direccion = '';
            var colonia = '';
            var ciudad = '';
            var estado = '';
            var cp = '';
            var pais = '';

            //pago
            var status_pago = '';
            var id_pago = '';
            var importe = '';
            var moneda = '';

            if (metodo_pago === 'PayPal') {
                fecha_hora_compra = details.create_time || '';
                fecha_compra = fecha_hora_compra.substring(0, 10);
                hora_compra = fecha_hora_compra.substring(11, 19);

                orden_id = details.id || '';
                orden_status = details.status || '';
                cliente_nombre = details.payer.name.given_name || '';
                cliente_apellido = details.payer.name.surname || '';
                email = details.payer.email_address || '';
                cliente_id_pp = details.payer.payer_id || '';
                purchase_units = details.purchase_units[0];
                datos_direccion = purchase_units.shipping.address;
                datos_pago = purchase_units.payments.captures[0];

                //direccion
                direccion = datos_direccion.address_line_1;
                colonia = datos_direccion.address_line_2;
                ciudad = datos_direccion.admin_area_2;
                estado = datos_direccion.admin_area_1;
                cp = datos_direccion.postal_code;
                pais = datos_direccion.country_code;

                //pago
                status_pago = datos_pago.status;
                id_pago = datos_pago.id;
                importe = datos_pago.amount.value;
                moneda = datos_pago.amount.currency_code;
            }
            else if (metodo_pago === 'android-playstore') {
                
                status_pago = details.state;
                orden_id = details.transaction.id || '';
                id_pago = orden_id;
                orden_status = details.state || '';
                moneda = details.currency || '';
                cliente_nombre = 'Código Fractal';
                cliente_apellido = '';
                
                cliente_id_pp = '4';
                importe = details.price.substring(1, details.price.length).replace(',', '');
            }
            

            //alert(JSON.stringify(moneda));
            //return;

            var datos = {

                'codigo_producto': producto,
                'configuracionesApp.versionSoftware': configuracionesApp.versionSoftware,
                'id_dispositivo': id_dispositivo,

                'serie_dispositivo': serie_dispositivo,
                'modelo_dispositivo': modelo_dispositivo,
                'version_dispositivo': version_dispositivo,
                'fabricante_dispositivo': fabricante_dispositivo,
                'tipo_dispositivo': 'Móvil',
                'plataforma_dispositivo': plataforma_dispositivo,
                'nombre_dispositivo': nombre_dispositivo,

                //

                'metodo_pago': metodo_pago,
                'tipo_licencia': datos_tabla[0].tipo_licencia,
                'fecha_inicio': datos_tabla[0].fecha_inicio,
                'hora_inicio': datos_tabla[0].hora_inicio,
                'fecha_fin': datos_tabla[0].fecha_fin,
                'codigo_activacion': datos_tabla[0].codigo_activacion,
                'llave_activacion': datos_tabla[0].llave_activacion,
                'fecha_hora_dispositivo': datos_tabla[0].fecha_hora,

                'fecha_compra': fecha_compra,
                'hora_compra': hora_compra,
                'orden_id': orden_id,
                'orden_status': orden_status,
                'cliente_nombre': cliente_nombre,
                'cliente_apellido': cliente_apellido,
                'email': email,
                'cliente_id_pp': cliente_id_pp, 
                'direccion': direccion,
                'colonia': colonia,
                'ciudad': ciudad,
                'estado': estado,
                'cp': cp,
                'pais': pais,
                'status_pago': status_pago,
                'id_pago': id_pago,
                'importe': importe,
                'moneda': moneda
            };

            //alert(JSON.stringify(datos));

            var php_consulta = ruta_php_licencia + 'licenciaActivacionApp.php';

            $.ajax({
                type: 'POST',
                url: encodeURI(php_consulta),
                data: datos,
                crossDomain: true,
                cache: false,
                async: true,
                dataType: 'json',
                encode: true,
                success: function (respuesta) {

                    console.log(JSON.stringify(respuesta));

                    if (respuesta[0].status === 'success') {
                        console.log('Los datos del pago se enviaron al servidor');
                        //activacionSilenciosaLicencia(); //activamos la licencia nuevamente y actualizamos el ID de activación
                        if (eliminaDatos === true) {
                            eliminaDatosPago(); //desactivamos temporalmente para pruebas
                        }
                    }

                },
                error: function (respuesta) {
                    console.log(JSON.stringify(respuesta));
                },
                timeout: 5000 // establecenes un timeout de 5 segundos

            });
        }

    }
    catch (err) {
        alert(err.message);
    }

}

function guardaDatosPagoError(metodo_pago, tipo_licencia, orden_status, orden_id, cliente_id, email, cliente, fecha_hora, otros_datos) {
    try {
        northwind.insertOrUpdate('datos_pago', { ID: 1 }, {
            
            metodo_pago: metodo_pago,
            tipo_licencia: tipo_licencia,
            orden_status: orden_status,
            orden_id: orden_id,
            cliente_id: cliente_id,
            email: email,
            cliente: cliente,
            fecha_hora: fecha_hora,
            otros_datos: otros_datos,
            sincronizado: 0
        });
        northwind.commit();
    }
    catch (err) {
        alert(err.message);
    }
}