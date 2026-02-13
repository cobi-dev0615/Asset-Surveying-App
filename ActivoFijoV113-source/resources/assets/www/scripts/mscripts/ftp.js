function exportaFTP() {

    if (cordova && cordova.file) {
        var url = cordova.file.externalRootDirectory + '/Alloys Automotive Recycling/Reportes/REPORTE GENERAL 2019-08-27.csv';
        console.debug('url=' + url);
    } else {
        alert('cordova-plugin-file not ready');
        return;
    }

    var scope = {};
    scope.data = {
        ftp: {
            ADDRESS: '200.200.200.204',
            USERNAME: 'anonymous',
            PASSWORD: 'anonymous@',
            HOME_PATH: '/'
        },
        remote: {
            PATH: '/androidftp/'
        },
        local: {
            FILE: url
        }
    };

    var FTP = {
        ADDRESS: scope.data.ftp.ADDRESS,
        USERNAME: scope.data.ftp.USERNAME,
        PASSWORD: scope.data.ftp.PASSWORD,
        HOME_PATH: scope.data.ftp.HOME_PATH
    };

    var localFile = scope.data.local.FILE;
    var localFile1 = localFile + '.1';
    var remotePath = scope.data.remote.PATH;
    if (remotePath.substr(-1) !== '/') {
        remotePath += '/';
    }
    var remoteFile = remotePath + scope.data.local.FILE.substr(localFile.lastIndexOf('/') + 1);

    $('#lbl_mensaje').text('ftp connecting');
    console.info('ftp connecting');
    window.cordova.plugin.ftp.connect(FTP.ADDRESS, FTP.USERNAME, FTP.PASSWORD, function () {
        $('#lbl_mensaje').text('ftp connected');
        console.info('ftp connected');
        window.cordova.plugin.ftp.upload(
            localFile, remoteFile,
            function (percent) {
                if (percent === 1) {
                    $('#lbl_mensaje').text('ftp uploaded');
                    console.info('ftp uploaded');

                } else {
                    $('#lbl_mensaje').text('ftp uploaded');
                    console.debug('ftp uploaded');

                }
            }, function (error) {
                alert('ftp upload error=' + error);
            });
    }, function (error) {
        alert('ftp connect error=' + error);
    });
}


document.addEventListener('deviceready', function () {
    exportaFTP();
});