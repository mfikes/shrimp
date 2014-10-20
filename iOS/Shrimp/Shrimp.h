#import <Foundation/Foundation.h>
#import <CoreData/CoreData.h>
#import <JavaScriptCore/JavaScriptCore.h>

@class Shrimp;

@protocol Shrimp<JSExport>

@property (nonatomic, retain) NSString * name;
@property (nonatomic, retain) JSValue * edibleFlag;
@property (nonatomic, retain) NSString *desc;

@end


@interface Shrimp : NSManagedObject<Shrimp>

@property (nonatomic, retain) NSNumber * edible;

@end
