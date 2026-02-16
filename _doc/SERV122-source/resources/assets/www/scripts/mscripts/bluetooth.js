function habilitaBluetooth(str_impresion) {
    
    try {
        //la función enable le solicita al usuario habilitar el Bluetooth si está inhabilitado
        //función solamente soportada en Android, no funciona en iOS o Windows Phone.
        bluetoothSerial.enable(
            function () {
                //si la petición fue aceptada
                //alert('Bluetooth is enabled');
            },
            function () {
                //si la petición fue rechazada
                MuestraAlerta3('Se requiere habilitar el bluetooth del dispositivo.', 'warning');
                mostrarConfiguracionesBluetooth();
                //alert('The user did *not* enable Bluetooth');
               
            }
        );
    }
    catch (err) {
        alert(err.message);
        
    }
}

function mostrarConfiguracionesBluetooth() {
    try {
        //la función showBluetoothSettings abre las configuraciones Bluetooth del sistema operativo
        //función no soportada en iOS.
        bluetoothSerial.showBluetoothSettings(
            function () {
                //si la función fue exitosamente
            },
            function () {
                //si ocurrió un error
            }
        );
    }
    catch (err) {
        //alert('Encienda el bluetooth del dispositivo');
        //alert(err.message);
    }
}

function imprimeZebraBluetooth(mac_address, str_impresion) {
    try {
        //impresión Bluetooth, actualmente se realiza a través del plugin de Zebra
        window.cordova.plugins.zbtprinter.print(mac_address, str_impresion,
            function (success) {
                OcultaLoader();
                
                

            }, function (fail) {
                suenaAlerta();
                vibraAlerta(500);
                OcultaLoader();
                MuestraAlerta3('Error: ' + fail + '\n' + mac_address, 'error');
                deferred.reject(fail);
            }
        );
    }
    catch (err) {
        alert(err.message);
    }
}

var logo = '';

function imprimeBluetooth(mac_address, str_impresion) {
    try {

        bluetoothSerial.enable(
            function () {
                //si la petición fue aceptada
                if (mac_address.length === 0 || mac_address === '') {
                    vibraAlerta(500);
                    OcultaLoader();
                    MuestraAlerta3('Debe configurar una impresora portátil Bluetooth para continuar.', 'error');
                    return;
                }
                bluetoothSerial.disconnect();
                bluetoothSerial.connect(mac_address, function () {
                    bluetoothSerial.write(str_impresion,
                        function () {

                            //bluetoothSerial.read(function (data) {
                            //    //alert(data);
                            //},
                            //function (fail) {
                            //    //MuestraAlerta3('Error: ' + fail + '\n' + mac_address, 'error');
                            //});
                            setTimeout(function () {
                                //OcultaLoader();
                                bluetoothSerial.disconnect();
                                OcultaLoader();
                            }, 7000);
                        },
                        function (fail) {
                            bluetoothSerial.disconnect();
                            vibraAlerta(500);
                            OcultaLoader();
                            MuestraAlerta3('Error: ' + fail + '\n' + mac_address, 'error');
                        });
                }, function (fail) {
                    vibraAlerta(500);
                    bluetoothSerial.disconnect();
                    OcultaLoader();
                    MuestraAlerta3('Error: ' + fail + '\n' + mac_address, 'error');
                });

            },
            function () {
                //si la petición fue rechazada
                OcultaLoader();
                MuestraAlerta3('Se requiere habilitar el bluetooth del dispositivo.', 'warning');
                //mostrarConfiguracionesBluetooth();
                //alert('The user did *not* enable Bluetooth');

            }
        );

    }
    catch (err) {
        OcultaLoader();
        alert(err.message);
    }

}