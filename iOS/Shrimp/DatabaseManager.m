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
            [self createShrimpWithName:@"Penaeus monodon" desc:@"The giant tiger prawn or Asian tiger shrimp." edible:YES];
            [self createShrimpWithName:@"Pandalus borealis" desc:@"A species of caridean shrimp found in cold parts of the Atlantic and Pacific Oceans." edible:YES];
            [self createShrimpWithName:@"Procarididea" desc:@"An infraorder of decapods, comprising only eleven species." edible:NO];
            [self createShrimpWithName:@"Stenopodidea" desc:@"A small group of decapod crustaceans." edible:NO];
            [self createShrimpWithName:@"Artemia" desc:@"A genus of aquatic crustaceans known as brine shrimp." edible:NO];
            [self createShrimpWithName:@"Conchostraca" desc:@"Clam shrimp are a taxon of bivalved branchiopod crustaceans that resemble the unrelated bivalved molluscs." edible:NO];
            [self createShrimpWithName:@"Anostraca" desc:@"One of the four orders of crustaceans in the class Branchiopoda." edible:NO];
            [self createShrimpWithName:@"Notostraca" desc:@"The single family Triopsidae, containing the tadpole shrimp or shield shrimp." edible:NO];
            [self createShrimpWithName:@"Lophogastrida" desc:@"An order of malacostracan crustaceans in the superorder Peracarida." edible:NO];
            [self createShrimpWithName:@"Stomatopods" desc:@"Marine crustaceans, the members of the order Stomatopoda." edible:NO];
            [self createShrimpWithName:@"Mysida" desc:@"An order of small, shrimp-like crustaceans in the malacostracan superorder Peracarida." edible:NO];
            [self createShrimpWithName:@"Caprellidae" desc:@"A family of amphipods commonly known as skeleton shrimps." edible:NO];
            [self createShrimpWithName:@"Ostracod" desc:@"A class of the Crustacea (class Ostracoda), sometimes known as seed shrimp." edible:NO];

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
