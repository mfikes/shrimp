#import "DetailViewController.h"

#import "GBYTextField.h"
#import "GBYSwitch.h"

@interface DetailViewController ()

@end

@implementation DetailViewController


- (void)handleViewDidLoad {
    
    [[self getFunction:@"view-did-load!"]
     callWithArguments:@[self,
                         [GBYTextField wrap:self.nameTextField],
                         [GBYTextField wrap:self.descriptionTextField],
                         [GBYSwitch wrap:self.edibleSwitch]]];
}

- (NSString*)getNamespace
{
    return @"shrimp.detail-view-controller";
}


@end
