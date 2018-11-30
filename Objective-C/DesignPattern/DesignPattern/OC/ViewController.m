//
//  ViewController.m
//  DesignPattern
//
//  Created by ljtwan on 2018/11/12.
//  Copyright © 2018 iCourt. All rights reserved.
//

#import "ViewController.h"
#import "ObserverPatternController.h"

typedef NS_ENUM(NSUInteger, DesignRouterType) {
    DesignRouterTypeObserverPattern,
};

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    Class class = [self superclass];
    NSLog(@"class: %@",class);
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    if (indexPath.row == DesignRouterTypeObserverPattern) {
       ObserverPatternController *destinationVC = [[ObserverPatternController alloc] initWithNibName:NSStringFromClass([ObserverPatternController class]) bundle:nil];
        [self.navigationController pushViewController:destinationVC animated:YES];
    }
}

@end
