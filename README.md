# Experimental Apptimize Cordova Plugin

## Install

1. Add Experimental Plugin

        cordova plugin add https://github.com/optimizely/optimizely-cordova-plugin

2. Set Apptimize App Keys as preferences in plugin.xml:

        <preference name="com.apptimize.ios.app_key" value="APP_KEY_HERE" />
        <preference name="com.apptimize.android.app_key" value="APP_KEY_HERE" />

3. For iOS: in xcode drag Apptimize.framework to the "embedded binaries" section within the target's general settings.

## Usage:

    Apptimize.runTest("New Experiment 9",
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
    Apptimize.track("event1");
    Apptimize.trackValue("event2", 12.34);

## Experimental Todo:
- ios automatically put framework into embedded binaries
- error handling
- dynamic variable apis
- feature flag apis
- custom attribute apis
- Apptimize setup configurations
- stable via npm