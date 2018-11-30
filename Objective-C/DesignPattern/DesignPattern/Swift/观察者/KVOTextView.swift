//
//  KVOTextField.swift
//  DesignPattern
//
//  Created by ljtwan on 2018/11/12.
//  Copyright © 2018 iCourt. All rights reserved.
//

import UIKit

//UIKit is not guaranteed to be KVO compliant
// 有趣的问题 https://stackoverflow.com/questions/7010547/uitextfield-text-change-event
class KVOTextView: UITextView, UITextViewDelegate {
    
    override func awakeFromNib() {
        // 注意!!! 注意!!! UIKit 不支持 KVO, 界面修改 UI 是收不到 变化监听的,只有代码中使用 了点语法 `setter` 才可以
        // 所以 示例要在代理方法中 调用 setter
        addObserver(self, forKeyPath: "text", options: [.new , .old], context: nil)
        delegate = self;
    }
    
    override var text: String?{
        didSet{
            print("old: \(oldValue ?? "ha")  \n  new: \(text ?? "oa")  \n")
            print("\n")
        }
    }
    
    override func observeValue(forKeyPath keyPath: String?, of object: Any?, change: [NSKeyValueChangeKey : Any]?, context: UnsafeMutableRawPointer?) {
        print("keyPath: \(String(describing: keyPath))")
        print("object: \(String(describing: object))")
        print("change: \(String(describing: change))" )
    }
    
    func textViewDidChange(_ textView: UITextView) {
        text = textView.text;
    }

    deinit {
        removeObserver(self, forKeyPath: "text")
    }
}
