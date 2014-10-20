#import <Foundation/Foundation.h>

#import <JavaScriptCore/JavaScriptCore.h>
#import "BaseDatabaseManager.h"

@class GBYFetchedResultsController;

@protocol DatabaseManager <JSExport>

-(NSArray*)getBooks;
-(NSArray*)getSessions;

- (GBYFetchedResultsController*)createShrimpFetchedResultsController;

@end


@interface DatabaseManager : BaseDatabaseManager<DatabaseManager>

@end
