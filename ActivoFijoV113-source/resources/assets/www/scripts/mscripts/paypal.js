paypal.Buttons({
    style: {
        shape: 'rect',
        color: 'blue',
        layout: 'vertical',
        label: 'buynow'
    },
    createOrder: function (data, actions) {
        return actions.order.create({
            purchase_units: [{
                amount: {
                    value: $('#lblImporte').text()
                }
            }]
        });
    },
    onApprove: function (data, actions) {
        return actions.order.capture().then(function (details) {
            guardaDatos(details);
        });
    }
}).render('#paypal-button-container');


function guardaDatos(details) {
    try {
        MuestraLoader('');
        //alert(JSON.stringify(details));
        //creaDirectoriosExtras('respuestaPayPal', details);
        var fecha_hora_compra = details.create_time || '';
        var fecha_compra = fecha_hora_compra.substring(0, 10);
        var hora_compra = fecha_hora_compra.substring(11, 19);

        var orden_id = details.id || '';
        var orden_status = details.status || '';
        var cliente_nombre = details.payer.name.given_name || '';
        var cliente_apellido = details.payer.name.surname || '';
        var email = details.payer.email_address || '';
        var cliente_id_pp = details.payer.payer_id || '';

        var purchase_units = details.purchase_units[0];
        var datos_direccion = purchase_units.shipping.address;
        var datos_pago = purchase_units.payments.captures[0];

        var fecha_hora = fecha_compra + ' ' + hora_compra;
        var fecha_inicio = fecha_compra;
        var hora_inicio = hora_compra;

        //calculamos la fecha en que la licencia expirará 
        var nMeses = 0;
        var nDias = 0;
        var fecha_fin = strFecha(0); //inicializamos con la fecha actual
        
        if (tipoLicencia === '1') {
            nDias = 7;
            fecha_fin = strFecha(nDias);
        }
        else if (tipoLicencia === '4') {
            nMeses = 1;
            fecha_fin = strFechaMes(nMeses);
        }
        else if (tipoLicencia === '6') {
            nMeses = 3;
            fecha_fin = strFechaMes(nMeses);
        }
        else if (tipoLicencia === '7') {
            nMeses = 6;
            fecha_fin = strFechaMes(nMeses);
        }else if (tipoLicencia === '8') {
            nMeses = 12;
            fecha_fin = strFechaMes(nMeses);
        }
        
        var codigo_activacion = orden_id.substring(0, 12);
        var llave_activacion = str_llave_activacion(producto + codigo_activacion + serie_dispositivo + modelo_dispositivo + fabricante_dispositivo);

        //var datosTransaccion = 'Id Orden: ' + orden_id + '\nStatus: ' + orden_status + '\nCliente: ' + cliente_nombre;
        //alert(datosTransaccion);
        if (orden_status === 'COMPLETED') {
            actualiza_licencia(orden_id, cliente_nombre + ' ' + cliente_apellido, fecha_inicio, fecha_fin, codigo_activacion, llave_activacion, 0);
            guardaDatosPago(orden_id, 'PayPal', tipoLicencia, cliente_id_pp, email, cliente_nombre + ' ' + cliente_apellido, fecha_inicio, hora_inicio, fecha_fin, codigo_activacion, llave_activacion, fecha_hora, details);

            actualizaFechaSesion('2020-07-01'); //actualizamos la fecha de la última sesión para evitar errores y perdida de información del cliente tramposo
            consultaDatosPago(false); //consultamos los datos del pago

            setTimeout(function () {

                OcultaLoader();
                //alert('Producto activado exitosamente');
                alert('La activación fue exitosa, le haremos llegar un correo con la información de su licencia a la dirección ' + email + '. Si no lo recibe en las siguientes 2 horas revise también su bandeja de spam o contactenos a ventas@codigofractal.com para apoyarle.');
                $(location).attr('href', 'inicio.html'); //regresamos a la pantalla principal de la aplicación

            }, 10000);


        }
        else {
            OcultaLoader();
            //alert('Hubo un problema al procesar tu pago, por favor solicita a tu banco la autorización de tu compra y verifíca que tu cuenta tiene los fondos suficientes para realizar la operación e intenta nuevamente.');
            //guardaDatosPagoError('PayPal', tipoLicencia, orden_status, orden_id, cliente_id_pp, email, cliente_nombre, fecha_hora, otros_datos);
        }

    }
    catch (err) {
        alert(err.message);
    }
}
