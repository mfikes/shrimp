#import <UIKit/UIKit.h>
#import <CoreData/CoreData.h>

@class DatabaseManager;
@class GBYManager;

@interface AppDelegate : UIResponder <UIApplicationDelegate, NSFileManagerDelegate>

@property (strong, nonatomic) UIWindow *window;

@property (strong, nonatomic) DatabaseManager* databaseManager;
@property (strong, nonatomic) GBYManager* cljsManager;

@end

