
#if __has_include("RCTBridgeModule.h")
#import "RCTBridgeModule.h"
#else
#import <React/RCTBridgeModule.h>
#endif
#import <topmind_sdk/topmind_sdk.h>

@interface RNTopmind : NSObject <RCTBridgeModule>

@end
