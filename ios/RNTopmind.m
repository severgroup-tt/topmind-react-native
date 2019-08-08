
#import "RNTopmind.h"
#import "topmind_sdk.h"

@implementation RNTopmind {
    TopMindSDK *topmind;
}

RCT_EXPORT_MODULE()

- (dispatch_queue_t)methodQueue {
    return dispatch_get_main_queue();
}

RCT_EXPORT_METHOD(initialize) {
    topmind = [[TopMindSDK alloc] init];
}

RCT_EXPORT_METHOD(logEvent: (NSString *) name params:(NSDictionary *) params) {
    if(topmind != nil) {
        [topmind logEvent:name withEventProperties:params];
    }
}

RCT_EXPORT_METHOD(logout) {
    if(topmind != nil) [topmind logout];
}

RCT_EXPORT_METHOD(setUserId: (NSString *) userId) {
    if(topmind != nil) [topmind setUserId:userId];
}

RCT_EXPORT_METHOD(applicationStarted) {
    if(topmind != nil) [topmind applicationStarted];
}

RCT_REMAP_METHOD(getInstallId, getInstallIdWithResolver:(RCTPromiseResolveBlock)resolve getInstallIdWithRejecter:(RCTPromiseRejectBlock)reject) {
	if(topmind != nil) {
		resolve([topmind getInstallId]);
	} else {
		reject(@"error", @"TopMindSDK instance is null", nil);
	}
}

RCT_REMAP_METHOD(isFirstRun, isFirstRunWithResolver:(RCTPromiseResolveBlock)resolve isFirstRunWithRejecter:(RCTPromiseRejectBlock)reject) {
	if(topmind != nil) {
		resolve(@([topmind isFirstRun]));
	} else {
		reject(@"error", @"TopMindSDK instance is null", nil);
	}
}

@end
