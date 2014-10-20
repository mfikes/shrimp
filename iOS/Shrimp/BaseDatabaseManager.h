#import <Foundation/Foundation.h>
#import <CoreData/CoreData.h>
#import <JavaScriptCore/JavaScriptCore.h>

@class FCJFetchedResultsController;

@protocol BaseDatabaseManager <JSExport>

- (NSManagedObject*)createEntityWithName:(NSString*)name;
- (void)deleteEntity:(NSManagedObject*)object;
- (void)saveContext;

@end

@interface BaseDatabaseManager : NSObject<BaseDatabaseManager>

@property (readonly, strong, nonatomic) NSManagedObjectContext *managedObjectContext;
@property (readonly, strong, nonatomic) NSManagedObjectModel *managedObjectModel;
@property (readonly, strong, nonatomic) NSPersistentStoreCoordinator *persistentStoreCoordinator;

-(NSString*)momdName;
-(NSString*)dbFilename;

-(NSArray*)getEntitiesWithName:(NSString*)entityName satisfyingPredicate:(NSPredicate*)predicate;

@end
