/*
GEOLOCALIZACIÓN
*/
var latitud_actual = 0;
var longitud_actual = 0;

function habilitaGPS() {
    try {
        //cordova.plugins.diagnostic.enableDebug();
        //cordova.plugins.diagnostic.isLocationAvailable(function (available) {
        //    alert('Location is ' + (available ? "available" : "not available"));
        //}, function (error) {
        //    alert('Error: ' + error);
        //});
    }
    catch (err) {
        alert(err.message);
    }
}

function obtenerPosicionActual() {
    try {
        navigator.geolocation.getCurrentPosition(obtenerPosicionGPS, errorPosicionGPS, { maximumAge: 5000, timeout: 9900, enableHighAccuracy: true });
        
    } catch (err) {
        alert(err.message);
    }
}

var watchID = null;

function actualizaPosicionActual() {
    try {
        MuestraLoader('GPS');
        //la función watchPosition regresa la posición actual del dispositivo cuando un cambio de posición es detectado
        watchID = navigator.geolocation.watchPosition(obtenerPosicionGPS, errorPosicionGPS, { maximumAge: 5000, timeout: 10000, enableHighAccuracy: true });
    } catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}

function obtenerPosicionGPS(position) {

    var lat_nuevo = latitud_actual;
    var long_nuevo = longitud_actual;
   
    latitud_actual = position.coords.latitude;
    longitud_actual = position.coords.longitude;

    //var datos = 'Latitude: ' + latitud_actual + '\n' +
    //    'Longitude: ' + longitud_actual + '\n' +
    //    'Altitude: ' + position.coords.altitude + '\n' +
    //    'Accuracy: ' + position.coords.accuracy + '\n' +
    //    'Altitude Accuracy: ' + position.coords.altitudeAccuracy + '\n' +
    //    'Heading: ' + position.coords.heading + '\n' +
    //    'Speed: ' + position.coords.speed + '\n' +
    //    'Timestamp: ' + position.timestamp;

    //muestraAlerta3(datos, 'success');
    OcultaLoader();
    //inserta_marcador(latitud_actual, longitud_actual, latitud_actual + ', ' + longitud_actual);
    //alert(query);
   
    //guardamos la posición del dispostivo en la bd
    if (lat_nuevo.toFixed(4) !== latitud_actual.toFixed(4) && long_nuevo.toFixed(4) !== longitud_actual.toFixed(4)) {
        //guardaGPSLOG(0, '', '');
    }
    
    
}

var strMensajeErrorGPS = '';

function errorPosicionGPS(error) {
   
    latitud_actual = 0;
    longitud_actual = 0;
    if (error.code === 1) {
        strMensajeErrorGPS = 'Ubicación del GPS no disponible en este dispositivo.';
    }
    else if (error.code === 2) {
        strMensajeErrorGPS = 'La aplicación no tiene permisos suficientes permisos para obtener la ubicación del GPS.';
    }
    else if (error.code === 3) {
        strMensajeErrorGPS = 'Encienda el GPS del dispositivo para obtener la ubicación del dispositivo.';
    }
    // muestraAlerta3('GPS error ' + error.code + ': ' + error.message + '.\n' + strMensajeErrorGPS, 'error');

    console.error('GPS error ' + error.code + ': ' + error.message + '.\n' + strMensajeErrorGPS); 
    obtenerPosicionActual();
}

function errorPosicionGPS2(error) {
    
    latitud_actual = 0;
    longitud_actual = 0;
    if (error.code === 1) {
        strMensajeErrorGPS = 'Ubicación del GPS no disponible en este dispositivo.';
    }
    else if (error.code === 2) {
        strMensajeErrorGPS = 'La aplicación no tiene permisos suficientes permisos para obtener la ubicación del GPS.';
    }
    else if (error.code === 3) {
        strMensajeErrorGPS = 'Encienda el GPS del dispositivo para obtener la ubicación del dispositivo.';
    }
    // muestraAlerta3('GPS error ' + error.code + ': ' + error.message + '.\n' + strMensajeErrorGPS, 'error');
    actualizaPosicionActual();
}


function detenerPosicionGPS() {
    try {
        navigator.geolocation.clearWatch(watchID);
    } catch (err) {
        alert(err.message);
    }

} 

//función para guardar la posición del dispostivo en la bd
//function guardaGPSLOG(id_cliente, cliente_nombre, accion) {
//    try {
//        base_datos.transaction(function (ts) {
//            var id_log = strFecha(0).replace(/-/g, '') + strHora().replace(/:/g, '');
//            ts.executeSql('INSERT INTO gps_log VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)', [id_log, empresa, id_usuario_logueado, nombre_usuario_logueado, id_cliente, cliente_nombre, accion, latitud_actual, longitud_actual, strFecha(0) + ' ' + strHora(), 0]);
//        }, function (error) {
//            muestraAlerta3(error.message, 'error');
//        }, function () {
//            //si el registro se guardó exitosamente
//            //muestraAlerta3(latitud_actual + ', ' + longitud_actual, 'success');
//        });
//    } catch (err) {
//        alert(err.message);
//    }
//}
