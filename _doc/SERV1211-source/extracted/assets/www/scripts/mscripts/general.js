//datos app
var nombre_app = 'SER Inventarios';
var version_producto = '1.2.1.1';
var origen_instalacion = 'APK';
var id_empresa = '1';
var nombre_empresa = 'Código Fractal';
var producto = 'SERSSMAND'; //consultar catálogo de productos
var version_actual = version_producto;
var sitioWeb = 'www.simplestockmobile.com';

//datos del usuario
var id_usuario = 0;
var nombre_usuario = '';
var usuario = '';
var administrador = 0;
var permisos = 0;

//información de la sesion iniciada
var id_usuario_logueado = 0;
var usuario_logueado = 'admin';
var nombre_usuario_logueado = 'Supervisor';
var es_administrador = 0;
var usuario_conteo = '';
var fechaUltimoAcceso = strFecha(0);

//información de inventarios
var id_inventario = 1;
var nombre_inventario = 'Inventario general';
var fecha_creacion_inventario = strFecha(0);

//información del dispositivo
var id_dispositivo = '';
var serie_dispositivo = '';
var plataforma_dispositivo = '';
var modelo_dispositivo = '';
var fabricante_dispositivo = '';
var version_dispositivo = '';
var nombre_dispositivo = '';
var es_virtual = '';


//datos de la impresora de tickets
var mac_impresora_0 = '';
var nombre_impresora_0 = '';
var marca_impresora_0 = 'CF';

//datos de la impresora de etiquetas
var mac_impresora_1 = '';
var nombre_impresora_1 = '';
var marca_impresora_1 = '';

//información de conexión
var modo_prueba = 0;
var modo_online = 0;

var ip_servidor = '';

var nombre_servidor = '';
var ruta_php = 'http://' + nombre_servidor + '/inventario_ssm/BlankApp/www/php/';

var nombre_servidor_licencia = '';
var ruta_php_licencia = 'http://' + nombre_servidor_licencia + '/validacion_licencias/';

if (modo_prueba === 0) {
    nombre_servidor = 'simplestockmobile.com';
    ruta_php = 'https://' + nombre_servidor + '/SER/InventariosAPIV3/';

    nombre_servidor_licencia = 'glint.codigofractal.com';
    ruta_php_licencia = 'https://' + nombre_servidor_licencia + '/GlintScriptsV2/';
}


//datos exclusivos de la app
//almacen
var id_almacen = '';
var nombre_almacen = '';

//mostramos el loader

function MuestraLoader(mensaje) {
    try {
        //$('#contenido').css('display', 'none');
        if (mensaje === 'GPS') {
            mensaje = 'Encienda el GPS del dispositivo.';
        }
        else {
            mensaje = '';
        }

        $.LoadingOverlaySetup({
            background: 'rgba(0, 0, 0, 0.7)',

            imageAnimation: '1.5s fadein',
            //imageColor: '#ffcc00',  
            text: mensaje,
            textResizeFactor: 0.15,
            textAutoResize: true,
            textColor: '#fff'
            //textOrder: 1
        });

        $.LoadingOverlay('show');


    }
    catch (err) {
        //
    }
}


//ocultamos el loader

function OcultaLoader() {
    try {
        $.LoadingOverlay("hide", true);
    }
    catch (err) {
        //
    }
}


function suenaBeep(n) {
    try {
        navigator.notification.beep(n); //número de veces del beep
    }
    catch (err) {
        //
    }
}

function suenaAlerta() {
    try {
        var nRepeticiones = 3;
        // var audio = new Media('/android_asset/www/sounds/decode.wav');
        // audio.play({ numberOfLoops: 3 });


        //este código si funciona en navegadores y en versiones 9 para abajo de tCordova 
        var nRepeticiones = 3;
        var audio = new Audio();
        audio.src = 'sounds/decode.wav';
        audio.addEventListener('ended', function () {
            nRepeticiones = nRepeticiones - 1;
            if (nRepeticiones > 0) {
                this.currentTime = 0;
                this.play();
            }
        }, false);

        audio.play();

    } catch (err) {
        alert(err.message);
    }
}

function suenaExito() {
    try {
        // var media = new Media('/android_asset/www/sounds/success.wav');
        // media.play();


        var audio = new Audio();
        audio.src = 'sounds/success.wav';
        audio.play();

    } catch (err) {
        alert(err.message);
    }
}

function suenaError() {
    try {

        // var media = new Media('/android_asset/www/sounds/error.wav');
        // media.play();
        var audio = new Audio();
        audio.src = 'sounds/error.wav';
        audio.play();

    } catch (err) {
        alert(err.message);
    }
}

function MuestraAlerta1(mensaje) {
    try {
        navigator.notification.alert(mensaje, '', 'Atención', 'OK');
    }
    catch (err) {
        console.error(mensaje);
    }
}


function MuestraAlerta3(mensaje, tipo_mensaje) {
    try {
        console.log(tipo_mensaje + ': ' + mensaje);
        var duracion = 'long';
        var color_fondo = '#008000';
        if (tipo_mensaje === 'error') {
            color_fondo = '#FF0000';
        }
        else if (tipo_mensaje === 'warning') {
            color_fondo = '#FF4000';


        }
        else if (tipo_mensaje === 'warning_long') {

            duracion = 20000;
            color_fondo = '#FF4000';
        }
        else if (tipo_mensaje === 'success_s') {
            duracion = 'short';
            color_fondo = '#008000';
        }
        else if (tipo_mensaje === 'success_l') {
            duracion = 20000;
            color_fondo = '#008000';
        }
        var plataformaCordova = window.cordova.platformId;
        if (plataformaCordova === 'browser' || plataformaCordova === 'electron') {
            toastr.warning(mensaje, '', {
                "positionClass": "md-toast-bottom-center",
                "progressBar": true,
                "preventDuplicates": true,
                "timeOut": 3000
            });
        }
        else {
            window.plugins.toast.showWithOptions({
                message: mensaje,
                duration: duracion, // duration: 'short', 'long', '3000', 900 (the latter are milliseconds)
                position: 'bottom', // 'top', 'center', 'bottom'
                styling: {
                    opacity: 0.75, // 0.0 (transparent) to 1.0 (opaque). Default 0.8
                    backgroundColor: color_fondo, // make sure you use #RRGGBB. Default #333333
                    textColor: '#FFFFFF', // Ditto. Default #FFFFFF
                    textSize: 20.5, // Default is approx. 13.
                    cornerRadius: 16, // minimum is 0 (square). iOS default 20, Android default 100
                    horizontalPadding: 20, // iOS default 16, Android default 50
                    verticalPadding: 16 // iOS default 12, Android default 30
                }
            });
        }
    }
    catch (err) {
        console.error(err.message);
        MuestraAlerta1(mensaje);
    }
}

function vibraAlerta(n) {
    try {
        navigator.vibrate(n); //tiempo de vibración en milisegundos
    }
    catch (err) {
        //
    }
}

/*
* Obtenemos la fecha deseada sumando o restando los días deseados
* Ej.: para obtener la fecha de hoy solo ejecutamos strFecha(0);
*/

function strFecha(n) {
    var fecha = new Date();
    fecha.setDate(fecha.getDate() + n);
    var anio = fecha.getFullYear();
    var mes = fecha.getMonth() + 1;
    var dia = fecha.getDate();
    if (mes < 10) { mes = '0' + mes; }
    if (dia < 10) { dia = '0' + dia; }
    return fecha = anio + '-' + mes + '-' + dia;
}



function strFechaMes(m) {
    var fecha = new Date();
    fecha.setMonth(fecha.getMonth() + m);
    var anio = fecha.getFullYear();
    var mes = fecha.getMonth() + 1;
    var dia = fecha.getDate();
    if (mes < 10) { mes = '0' + mes; }
    if (dia < 10) { dia = '0' + dia; }
    return fecha = anio + '-' + mes + '-' + dia;
}

function strHora() {
    var now = new Date();
    var hora = now.getHours();
    if (hora < 10) { hora = '0' + hora; }
    var minutos = now.getMinutes();
    if (minutos < 10) { minutos = '0' + minutos; }
    var segundos = now.getSeconds();
    if (segundos < 10) { segundos = '0' + segundos; }
    return hora = hora + ':' + minutos + ':' + segundos;

}

var normalizaStr = (function () {
    var from = "ÃÀÁÄÂÈÉËÊÌÍÏÎÒÓÖÔÙÚÜÛãàáäâèéëêìíïîòóöôùúüûÑñÇç",
        to = "AAAAAEEEEIIIIOOOOUUUUaaaaaeeeeiiiioooouuuunncc",
        mapping = {};

    for (var i = 0, j = from.length; i < j; i++)
        mapping[from.charAt(i)] = to.charAt(i);

    return function (str) {
        var ret = [];
        for (var i = 0, j = str.length; i < j; i++) {
            var c = str.charAt(i);
            if (mapping.hasOwnProperty(str.charAt(i)))
                ret.push(mapping[c]);
            else
                ret.push(c);
        }
        return ret.join('');
    }

})();


function consultaInfoConexion() {

    try {
        var networkState = navigator.connection.type;
        var states = {};
        states[Connection.UNKNOWN] = 'Unknown';
        states[Connection.ETHERNET] = 'Ethernet';
        states[Connection.WIFI] = 'WiFi';
        states[Connection.CELL_2G] = 'Cell2G';
        states[Connection.CELL_3G] = 'Cell3G';
        states[Connection.CELL_4G] = 'Cell4G';
        states[Connection.CELL] = 'CellGeneric';
        states[Connection.NONE] = 'NoNetwork';

        var tipo_conexion = states[networkState];

        //alert('Connection type: ' + states[networkState]);
        //alert(networkState);
        /*
        if(tipo_conexion === 'NoNetwork'){
            vibraAlerta(1000);
            MuestraAlerta1('Algunas funciones de la aplicación requieren conexión a Internet, para continuar valide que su dispositivo se encuentre conectado a una red.');
            $('*').attr('disabled', 'disabled');
            //return;
        }

        if(tipo_conexion === 'Cell2G' || tipo_conexion === 'CellGeneric'){
            vibraAlerta(1000);
            MuestraAlerta1('Su dispositivo tiene conexión a Internet de mala calidad, lo que puede afectar algunas funciones de la aplicación.');
            return;
        }
        */
        return tipo_conexion;
    }
    catch (err) {
        return 'Unknown';
    }
}

/**
* información del dispositivo
*/
function consultaInfoDispositivo() {
    try {
        modelo_dispositivo = device.model;
        plataforma_dispositivo = device.platform;
        id_dispositivo = device.uuid;
        version_dispositivo = device.version;
        fabricante_dispositivo = device.manufacturer;
        serie_dispositivo = device.serial;
        if (serie_dispositivo === 'unknown') {
            serie_dispositivo = id_dispositivo; // si no pudimos conseguir el número de serie del equipo lo sustituimos por el id del dispositivo
        }
        nombre_dispositivo = modelo_dispositivo;
        es_virtual = device.isVirtual;

        console.log('Datos dispositivo: ' + JSON.stringify(device));

    }
    catch (err) {
        console.log('Error consultaInfoDispositivo: ' + err.message);
    }
}

/*
*navegador local
*/
function abreUrlLocal(url) {
    try {
        cordova.InAppBrowser.open(url, '_blank').show();
    } catch (err) {
        $(location).attr('href', url);
        //alert(err.message);
    }
}

/*
Crear directorios y archivos extras
*/
function creaDirectoriosExtras(archivo_nombre, datos, modo_exportacion) {
    var folderArchivos = 'SER';
    var folderApp = 'Download';
    if (modo_exportacion === 1 || modo_exportacion === 2) { //si el archivo se va a compartir 
        folderArchivos = 'TempSSM';
        folderApp = 'Download';
    }

    //console.log(cordova.file.externalRootDirectory.toString());
    window.resolveLocalFileSystemURL(cordova.file.externalRootDirectory, successCallback, errorCallback);

    function successCallback(fs) {
        //fs.getFile('SSMDemo.txt', { create: true, exclusive: true }, function (fileEntry) {
        //    alert('File creation successfull!');
        //}, errorCallback);
        fs.getDirectory(folderApp, { create: true, exclusive: false },
            function (dir) {
                dir.getDirectory(folderArchivos, { create: true, exclusive: false },
                    function (dir) {
                        creaArchivo(dir, archivo_nombre, datos, modo_exportacion);

                        //dir.getFile('Reporte Conteo ' + strFecha(0) + '.csv', { create: true, exclusive: true }, null, errorCallback);
                    }, errorCallback);
            }, errorCallback);
    }

    function onGetDirectorySuccess(dir) {
        console.log('Directorio ' + dir.name + ' creado exitosamente');
    }

    function errorCallback(error) {
        //console.log(JSON.stringify(error));
        alert('Error: ' + error.code + ', hubo un error al crear la ruta de acceso de los reportes, intente nuevamente y si el problema persiste contactenos a soporte@codigofractal.com.');


    }
}

function creaArchivo(dir, archivo_nombre, datos, modo_exportacion) {

    // Creates a new file or returns the file if it already exists.
    //dir.getFile(archivo_nombre, { create: true, exclusive: true }, null, null);

    dir.getFile(archivo_nombre, { create: true, exclusive: true }, function (archivo) {
        //alert(datos);
        escribeArchivo(archivo, datos, modo_exportacion);
    }, errorCallback);

    function errorCallback(error) {
        // suenaError();
        console.log(JSON.stringify(error));
        if (error.code === 12) {

            if (modo_exportacion === 3) {
                suenaError();
                vibraAlerta(500);
                var dialog = confirm('Ya existe un reporte con el nombre ' + archivo_nombre + ' ¿Desea reemplazarlo?');
                if (dialog === false) {
                    return;
                }
            }

            eliminaArchivo(dir, archivo_nombre, datos, modo_exportacion);

        }
        else {

            alert('Error: ' + error.code + ', hubo un error al crear el archivo, intente nuevamente y si el problema persiste contactenos a soporte@codigofractal.com.');
        }

    }

}

function escribeArchivo(archivo, datos, modo_exportacion) {
    try {
        // Create a FileWriter object for our file.
        archivo.createWriter(function (fileWriter) {


            // If data object is not passed in,
            // create a new Blob instead.
            if (!datos) {
                datos = new Blob(['No hay datos registrados'], { type: 'text/plain' });
            }

            //var uint8 = new Uint8Array(datos.length);
            //for (var i = 0; i < uint8.length; i++) {
            //    uint8[i] = datos.charCodeAt(i);
            //}

            fileWriter.write(datos);

            fileWriter.onwriteend = function () {
                suenaExito();

                if (modo_exportacion === 1) { //si el archivo se envía por Whats App
                    //MuestraAlerta1('Se ha creado el archivo con el reporte seleccionado en la ruta /Simple Stock Mobile/Reportes exportados/, conecte este dispositivo a la PC para descargarlo.');

                }
                else if (modo_exportacion === 2) { //si el archivo se envía por Email
                    //MuestraAlerta1('Se ha creado el archivo con el reporte seleccionado en la ruta /Simple Stock Mobile/Reportes exportados/, conecte este dispositivo a la PC para descargarlo.');
                    //MuestraAlerta3('Archivo creado exitosamente.', 'success');        
                }
                else { ////si el archivo solo se guarda por correo
                    MuestraAlerta3('Reporte creado exitosamente.', 'success');
                    MuestraAlerta1('Se ha creado el archivo con el reporte seleccionado en la ruta "' + archivo.fullPath + '", conecte este dispositivo a la PC para descargarlo.');
                    //MuestraAlerta3('Archivo creado exitosamente.', 'success');             
                }
            };

            fileWriter.onerror = function (e) {
                MuestraAlerta1("Error: " + e.toString());
            };


        });

    } catch (err) {
        alert(err.message);
    }
}


function leerArchivo(archivo) {

    archivo.file(function (file) {

        var reader = new FileReader();
        reader.onloadend = function () {
            alert(archivo.fullPath + ': ' + this.result);

        };
        reader.readAsText(file);
    }, errorCallback);

    function errorCallback(error) {
        console.log(JSON.stringify(error));
        alert("Error: " + error.code);
    }
}


function eliminaArchivo(dir, archivo_nombre, datos, modo_exportacion) {

    //eliminamos el archivo dato y volvemos a crearlo
    dir.getFile(archivo_nombre, { create: false, exclusive: false },
        function (archivo) {

            archivo.remove(function () {
                if (datos !== "") {
                    creaArchivo(dir, archivo_nombre, datos, modo_exportacion);
                }
            }, function (error) {
                //suenaError();
                alert('Error: ' + error.code + ', hubo un error al eliminar el archivo anterior, intente nuevamente y si el problema persiste contactenos a soporte@codigofractal.com.');
            });
        }
        , null);
}


/**
* memoria caché
*/
function eliminaCache() {
    var success = function (status) {
        //alert('Message: ' + status);
    };
    var error = function (status) {
        //alert('Error: ' + status);
    };
    window.CacheClear(success, error);
}


//notificaciones locales NO FUNCIONA
function notificacionLocal() {
    try {
        cordova.plugins.notification.local.schedule({
            title: 'My first notification',
            text: 'Thats pretty easy...',
            foreground: true
        });
    } catch (err) {
        alert(err.message);
    }
}
//

// left padding string with ' ' to a total of n chars
function padLeft(str, n) {
    var res = str.toString();
    var c = ' ';
    for (var i = 0; i < n; i++) {
        c += c;
    }
    var str_nvo = c.substring(0, n - res.length) + res;
    return str_nvo;
}

function padRight(str, n) {
    var res = str.toString();
    var c = ' ';
    for (var i = 0; i < n; i++) {
        c += c;
    }
    var str_nvo = res + c.substring(0, n - res.length);
    return str_nvo;
}


function consultaHardware() {
    var memoriaDispositivo = 'Memoria RAM ' + navigator.deviceMemory;
    //var txt = "";
    //txt += "<p>Total width/height: " + screen.width + "*" + screen.height + "</p>";
    //txt += "<p>Available width/height: " + screen.availWidth + "*" + screen.availHeight + "</p>";
    //txt += "<p>Color depth: " + screen.colorDepth + "</p>";
    //txt += "<p>Color resolution: " + screen.pixelDepth + "</p>";
    $('#demo').text(memoriaDispositivo);
}

function validaEmail(email) {
    var arroba_pos = email.indexOf("@");
    var punto_pos = email.lastIndexOf(".");
    if (arroba_pos < 1 || punto_pos < arroba_pos + 2 || punto_pos + 1 >= email.length) {
        return false;
    }
    else {
        return true;
    }
}

////método para mostrar n decimales de un flotante sin redondearla


function hideKeyboard() {
    //this set timeout needed for case when hideKeyborad
    //is called inside of 'onfocus' event handler
    setTimeout(function () {

        //creating temp field
        var field = document.createElement('input');
        field.setAttribute('type', 'text');
        //hiding temp field from peoples eyes
        //-webkit-user-modify is nessesary for Android 4.x
        field.setAttribute('style', 'position:absolute; top: 0px; opacity: 0; -webkit-user-modify: read-write-plaintext-only; left:0px;');
        document.body.appendChild(field);

        //adding onfocus event handler for out temp field
        field.onfocus = function () {
            //this timeout of 200ms is nessasary for Android 2.3.x
            setTimeout(function () {

                field.setAttribute('style', 'display:none;');
                setTimeout(function () {
                    document.body.removeChild(field);
                    document.body.focus();
                }, 14);

            }, 200);
        };
        //focusing it
        field.focus();

    }, 50);
}

$(document).ready(function () {
    $('#lbl_footer').text('Versión ' + version_producto);
});