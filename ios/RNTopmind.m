
#import "RNTopmind.h"
#import <topmind_sdk/topmind_sdk.h>

@implementation RNTopmind {
    TopMind *topmind;
}

- (instancetype) init {
    self = [super init];

    NSLog(@"-----------------ewretrerweqwwewr------------------");
    return self;
}

RCT_EXPORT_MODULE()

- (dispatch_queue_t)methodQueue {
    return dispatch_get_main_queue();
}

RCT_EXPORT_METHOD(initialize) {
    NSLog(@"234567543345353245643565465478546");
    NSLog(@"-----------------------------------");
    topmind = [[TopMind alloc] init];
}

RCT_EXPORT_METHOD(logEvent: (NSString *) name params:(NSDictionary *) params) {

}

@end
