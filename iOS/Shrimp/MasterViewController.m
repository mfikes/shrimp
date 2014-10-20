#import "MasterViewController.h"

#import "GBYTableView.h"

@interface MasterViewController ()

@end

@implementation MasterViewController

- (void)handleViewDidLoad {
    
    [[self getFunction:@"view-did-load!"]
     callWithArguments:@[self,
                         [GBYTableView wrap:self.tableView]]];
}

- (NSString*)getSubNamespace
{
    return @"master-view-controller";
}


@end
