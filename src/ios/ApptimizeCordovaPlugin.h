#import <Cordova/CDVPlugin.h>
#import <Apptimize/Apptimize.h>

@interface ApptimizeCordovaPlugin : CDVPlugin
//- (void)startApptimize:(CDVInvokedUrlCommand*)command;
- (void)runTest:(CDVInvokedUrlCommand*)command;
- (void)track:(CDVInvokedUrlCommand*)command;
- (void)trackValue:(CDVInvokedUrlCommand*)command;
@end
