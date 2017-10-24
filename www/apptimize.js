var Apptimize = function () {
}

/* Apptimize start is done automatically and the appkey is set via the config.xml preference */
/*
Apptimize.prototype.start = function(appKey) {
    cordova.exec(function(success){}, function(err) {}, "ApptimizeCordovaPlugin", "startApptimize", [appKey]);
};
*/

Apptimize.prototype.runTest = function(testName, baseline, variationNames, variationBlocks) {
    cordova.exec(function(codeblockNumber){
        if ( codeblockNumber === 0 || codeblockNumber > variationBlocks.length ) {
            baseline();
        }
        else {
            variationBlocks[codeblockNumber-1]();
        }
    }, function(err) {}, "ApptimizeCordovaPlugin", "runTest", [testName, variationNames]);
};

Apptimize.prototype.track = function(eventName) {
    cordova.exec(function(suc){}, function(err) {}, "ApptimizeCordovaPlugin", "track", [eventName]);
};

Apptimize.prototype.trackValue = function(eventName, value) {
    cordova.exec(function(suc){}, function(err) {}, "ApptimizeCordovaPlugin", "trackValue", [eventName, value]);
};

Apptimize.prototype.isFeatureFlagOn = function(name) {
    cordova.exec(function(suc){
        alert(suc);
    }, function(err) {}, "ApptimizeCordovaPlugin", "isFeatureFlagOn", [name]);
};

Apptimize.prototype.testInfo = function() {
    cordova.exec(function(suc){}, function(err) {}, "ApptimizeCordovaPlugin", "testInfo", []);
};

Apptimize.prototype.integerWithName = function(name, defaultInteger) {
    cordova.exec(function(suc){}, function(err) {}, "ApptimizeCordovaPlugin", "integerWithName", [name, defaultInteger]);
};

Apptimize.prototype.stringWithName = function(name, defaultString) {
    cordova.exec(function(suc){}, function(err) {}, "ApptimizeCordovaPlugin", "stringWithName", [name, defaultString]);
};

module.exports = new Apptimize();
