//
//  NotifyTextField.m
//  DesignPattern
//
//  Created by ljtwan on 2018/11/12.
//  Copyright © 2018 iCourt. All rights reserved.
//

#import "NotifyTextField.h"

NSString *const NotifyTextFieldEmptyInvocationKey = @"NotifyTextFieldEmptyInvocationKey";

NSString *const NotifyTextFieldEmptyCommandKey = @"NotifyTextFieldEmptyCommandKey";


@implementation NotifyTextField

- (void)awakeFromNib {
    [super awakeFromNib];
    [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(emptyContent:) name:NotifyTextFieldEmptyInvocationKey object:nil];
}

- (void)emptyContent:(NSNotification*)notification {
    NSDictionary *userInfo = notification.userInfo;
    NSString *command = [userInfo objectForKey:NotifyTextFieldEmptyCommandKey];
    NSLog(@"command: %@",command);
    
    self.text = @"";
}

- (void)dealloc {
    [[NSNotificationCenter defaultCenter] removeObserver:self];
}

@end
