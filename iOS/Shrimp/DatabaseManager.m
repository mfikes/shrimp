#import "DatabaseManager.h"
#import <CoreData/CoreData.h>

#import "GBYFetchedResultsController.h"

#import "Shrimp.h"

@implementation DatabaseManager

-(void)createShrimpWithName:(NSString*)name desc:(NSString*)desc edible:(BOOL)edible
{
    Shrimp* shrimp = [NSEntityDescription insertNewObjectForEntityForName:@"Shrimp" inManagedObjectContext:self.managedObjectContext];
    shrimp.name = name;
    shrimp.edible = @(edible);
    shrimp.desc = desc;
}

-(id)init
{
    if (self = [super init]) {
        
        if (!self.getShrimp.count) {
            [self createShrimpWithName:@"Foo" desc:@"Food" edible:YES];
            [self createShrimpWithName:@"Bar" desc:@"Not food" edible:NO];

            [self saveContext];
        }
        
    }
    return self;
}

-(NSString*)momdName
{
    return @"Shrimp";
}

-(NSString*)dbFilename
{
    return @"Shrimp.sqlite";
}

-(NSArray*)getShrimp
{
    return [self getEntitiesWithName:@"Shrimp" satisfyingPredicate:nil];
}

- (NSArray *)shrimpSortDescriptors
{
    NSSortDescriptor	*sortDescriptor0	= [[NSSortDescriptor alloc] initWithKey:@"name" ascending:YES];
    
    return [NSArray arrayWithObjects:sortDescriptor0, nil];
}

- (GBYFetchedResultsController*)createShrimpFetchedResultsController
{
    // Create the fetch request for the entity.
    NSFetchRequest		*fetchRequest	= [[NSFetchRequest alloc] init];
    NSEntityDescription *entity			= [NSEntityDescription entityForName:@"Shrimp" inManagedObjectContext:self.managedObjectContext];
    [fetchRequest setEntity:entity];
    
    // Set the batch size to a suitable number.
    [fetchRequest setFetchBatchSize:20];
    
    [fetchRequest setSortDescriptors:[self shrimpSortDescriptors]];
    
    // Edit the section name key path and cache name if appropriate.
    // nil for section name key path means "no sections".
    GBYFetchedResultsController *aFetchedResultsController = [[GBYFetchedResultsController alloc] initWithFetchRequest:fetchRequest managedObjectContext:self.managedObjectContext sectionNameKeyPath:nil cacheName:nil];
    
    return aFetchedResultsController;
}

@end
