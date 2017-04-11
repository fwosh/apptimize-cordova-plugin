#import "ApptimizeCordovaPlugin.h"
#import <Cordova/CDVPlugin.h>
#import <Apptimize/Apptimize.h>

@implementation ApptimizeCordovaPlugin

- (void)startApptimize:(CDVInvokedUrlCommand*)command
{
    NSString* callbackId = [command callbackId];
    NSString* appKey = [[command arguments] objectAtIndex:0];
    [Apptimize startApptimizeWithApplicationKey:appKey];
    
    CDVPluginResult* result = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@"Apptimize Started"];
    [self.commandDelegate sendPluginResult:result callbackId:callbackId];
}


- (void)runTest:(CDVInvokedUrlCommand*)command
{
    NSString* callbackId = [command callbackId];
    NSString* testName = [[command arguments] objectAtIndex:0];
    NSArray* variationNames = [[command arguments] objectAtIndex:1];

    NSMutableArray *apptimizeCodeBlocks = [NSMutableArray new];
    for ( int i = 0; i < variationNames.count; i++ ) {
        ApptimizeCodeBlock *apptimizeCodeBlock = [[ApptimizeCodeBlock alloc] initWithName:variationNames[i]
                                                                                 andBlock:^()
        {
            CDVPluginResult* result = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsInt:i+1];
            [self.commandDelegate sendPluginResult:result callbackId:callbackId];
        }];
        [apptimizeCodeBlocks addObject:apptimizeCodeBlock];
    }
    [Apptimize runTest:testName withBaseline:^() {
        CDVPluginResult* result = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsInt:0];
        [self.commandDelegate sendPluginResult:result callbackId:callbackId];
    } andApptimizeCodeBlocks:apptimizeCodeBlocks];
}

@end