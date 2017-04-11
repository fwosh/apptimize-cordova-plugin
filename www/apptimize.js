window.apptimizeStart = function(appKey) {
    cordova.exec(function(success){}, function(err) {}, "ApptimizeCordovaPlugin", "startApptimize", [appKey]);
};

window.runTest = function(testName, baseline, variationNames, variationBlocks) {
    cordova.exec(function(codeblockNumber){
        if ( codeblockNumber === 0 ) {
            baseline();
        }
        else {
            variationBlocks[codeblockNumber-1]();
        }
    }, function(err) {}, "ApptimizeCordovaPlugin", "runTest", [testName, variationNames]);
};


/* Example Usage */

/*

    window.apptimizeStart("INSERT_APP_KEY_HERE");

    window.runTest("New Experiment 9",
        function() {
            alert("baseline");
        },
        ["variation1"],
        [
            function() {
                alert("variation1");
            }
        ]
    );

*/