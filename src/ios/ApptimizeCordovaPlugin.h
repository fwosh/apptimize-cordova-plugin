#import <Cordova/CDVPlugin.h>
#import <Apptimize/Apptimize.h>

@interface ApptimizeCordovaPlugin : CDVPlugin
- (void)startApptimize:(CDVInvokedUrlCommand*)command;
- (void)runTest:(CDVInvokedUrlCommand*)command;
@end
