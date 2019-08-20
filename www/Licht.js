window.licht = function(str, callback) {
    cordova.exec(
        callback,
        function (err) {
            callback('error');
        },
        "Licht",
        "licht",
        [str]);
}
