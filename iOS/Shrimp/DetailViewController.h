#import "BaseViewController.h"

@interface DetailViewController : BaseViewController

@property (weak, nonatomic) IBOutlet UITextField *nameTextField;
@property (weak, nonatomic) IBOutlet UITextField *descriptionTextField;
@property (weak, nonatomic) IBOutlet UISwitch *edibleSwitch;

@end
