//
//  ObserverPatternController.m
//  DesignPattern
//
//  Created by ljtwan on 2018/11/12.
//  Copyright © 2018 iCourt. All rights reserved.
//

#import "ObserverPatternController.h"
#import "NotifyTextField.h"

@interface ObserverPatternController ()<UITextViewDelegate>
@property (weak, nonatomic) IBOutlet UISlider *slide;
@property (weak, nonatomic) IBOutlet UITextView *textView;

@end

@implementation ObserverPatternController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.title = @"观察者模式";
    // 1. sendNotification 为通知
    // 2. 为键值观察
    [self addSwitchObserver];
    [self addTextObserver];
}

#pragma mark - KVO
// UIKit 的 KVO 问题
- (void)addTextObserver {
    
    // 1. receiver 被观察者, addObserver 观察者, forKeyPath 被观察者的属性 options 观察的类型(新值 旧值 初始值...)
    // 一定要注意谁添加观察者, 谁在适当的时机移除
    [self.textView addObserver:self forKeyPath:NSStringFromSelector(@selector(text)) options:NSKeyValueObservingOptionNew | NSKeyValueObservingOptionOld context:nil];
    
    // 2. 注意!!! 注意!!! UIKit 不支持 KVO, 界面修改 UI 是收不到 变化监听的,只有代码中使用 了点语法 `setter` 才可以
    // 所以 示例要在代理方法中 调用 setter
    self.textView.delegate = self;
    
    // 安全使用 KVO 的话, 建议使用  [Facebook - KVOController](https://github.com/facebook/KVOController)
}

- (void)addSwitchObserver {
    [self.slide addObserver:self forKeyPath:NSStringFromSelector(@selector(value)) options:NSKeyValueObservingOptionNew | NSKeyValueObservingOptionOld context:nil];
}


- (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey,id> *)change context:(void *)context {
    NSLog(@"object: 被观察者: %@",object);
    NSNumber *newValue = [change objectForKey:NSKeyValueChangeNewKey];
    NSNumber *oldValue = [change objectForKey:NSKeyValueChangeOldKey];
    
    NSLog(@"oldValue:%@ \n oldValue: %@",oldValue,newValue);
    
    NSLog(@"keypath:%@",keyPath);
}

#pragma mark - UITextViewDelegate
- (void)textViewDidChange:(UITextView *)textView {
    textView.text = textView.text;
}

#pragma mark - Notification

- (IBAction)sendNotification:(UIButton *)sender {
    // post notification
    NSDictionary * userInfo = @{NotifyTextFieldEmptyCommandKey:@"赶紧清空自己"};
    
    [[NSNotificationCenter defaultCenter] postNotificationName:NotifyTextFieldEmptyInvocationKey object:self userInfo:userInfo];
}

- (void)dealloc {
    if (_slide) {
        [_slide removeObserver:self forKeyPath:NSStringFromSelector(@selector(value))];
    }
    
    if (_textView) {
        [_textView removeObserver:self forKeyPath:NSStringFromSelector(@selector(text))];
    }
}
@end
