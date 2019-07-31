
#import "RNTopmind.h"
#import <topmind_sdk/topmind_sdk.h>

@implementation RNTopmind {
    TopMind *topmind;
}

RCT_EXPORT_MODULE()

- (dispatch_queue_t)methodQueue {
    return dispatch_get_main_queue();
}

RCT_EXPORT_METHOD(initialize) {
    topmind = [[TopMind alloc] init];
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

@end
