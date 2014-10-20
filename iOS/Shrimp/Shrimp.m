#import "Shrimp.h"


@implementation Shrimp

@dynamic name;
@dynamic edible;
@dynamic desc;

- (void)setEdibleFlag:(JSValue *)edibleFlag
{
    self.edible = [edibleFlag toNumber];
}

- (JSValue*)edibleFlag {
    return [JSValue valueWithBool:self.edible.boolValue inContext:[JSContext currentContext]];
}

@end
