var tipoLicencia = '4'; //establecemos el tipo de licencia por 1 mes por default

$('#comboTipoLicencia').on('change', function () {
    calculaImporte();
});

function calculaImporte() {
    try {

        /**
        * TIPOS DE LICENCIA
        1 = licencia por 1 mes
        4 = licencia por 1 mes
        6 = licencia por 3 meses
        7 = licencia por 6 meses
        8 = licencia por 1 año
        9 = licencia por tiempo indefinido
         */
        //El precio de venta será de 6 USD al mes
        var precioVenta = 8;
        //precioVenta = 0.10; //precio de prueba

        //var mesesDescuento = 0;
        var descuento = 0;
        var subtotal = precioVenta;
        var total = 0;

        tipoLicencia = $('#comboTipoLicencia').val();
        //alert(tipoLicencia);
        if (tipoLicencia === '1') {
            subtotal = 3;
            total = 3; //3 USD por 7 días
            $('#lblDescuentoConcepto').text('');
            $('#seccionDescuento').removeClass('btn-outline-success');

        }
        else if (tipoLicencia === '4') {
            subtotal = precioVenta * 1;
            descuento = 0;
            total = subtotal - descuento;
            $('#lblDescuentoConcepto').text('');
            $('#seccionDescuento').removeClass('btn-outline-success');

        }
        else if (tipoLicencia === '6') {
            subtotal = precioVenta * 3;
            descuento = precioVenta * 1;
            total = subtotal - descuento;
            $('#lblDescuentoConcepto').text('1 mes de descuento');
            $('#seccionDescuento').addClass('btn-outline-success');
        }
        else if (tipoLicencia === '7') {
            subtotal = precioVenta * 6;
            descuento = precioVenta * 2;
            total = subtotal - descuento;
            $('#lblDescuentoConcepto').text('2 meses de descuento');
            $('#seccionDescuento').addClass('btn-outline-success');
        }
        else if (tipoLicencia === '8') {
            subtotal = precioVenta * 12;
            descuento = precioVenta * 5;
            total = subtotal - descuento;
            $('#lblDescuentoConcepto').text('5 meses de descuento');
            $('#seccionDescuento').addClass('btn-outline-success');
        }
        else if (tipoLicencia === '9') {
            subtotal = 129;
            descuento = 0;
            total = subtotal - descuento;
            $('#lblDescuentoConcepto').text('');
        }
        var strDescuento = 0;
        if (descuento > 0) {
            strDescuento = '-' + descuento.toFixed(2);
        }
        $('#lblSubtotal').text(subtotal.toFixed(2));
        $('#lblDescuento').text(strDescuento);
        $('#lblImporte').text(total.toFixed(2));

    }
    catch (err) {
        alert(err.message);
    }
}

document.addEventListener('deviceready', function () {
    //$(document).ready(function () {
    consultaInfoDispositivo(); //consultamos los datos del dispositivo (id, serie, fabricante, etc.)
    calculaImporte();

    ///////////

});