//
//  SwiftObserverPatternController.swift
//  DesignPattern
//
//  Created by ljtwan on 2018/11/12.
//  Copyright © 2018 iCourt. All rights reserved.
//

import UIKit

class SwiftObserverPatternController: UIViewController {

    @IBOutlet weak var infoTextView: KVOTextView!
    
    @IBOutlet weak var funcSwitch: UISwitch!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        title = "观察者模式"
        // 1. 添加 通知
        addReceiveNotify()
        // 2. KVO 在  KVOTextView 的实现中
    }
    
    override func viewWillAppear(_ animated: Bool) {
        // 有趣的问题
        infoTextView.text = "代码设置就有效的问题"
    }
    
    // MARK: 通知
    
    @IBAction func valueChange(_ sender: UISwitch) {
        let on = sender.isOn;
        let name = NSNotification.Name("UISwitchOn")
        NotificationCenter.default.post(name: name, object: self, userInfo: ["command":"clear",
                                                                            "on": on])
    }
   
    func addReceiveNotify() {
        let name = NSNotification.Name("UISwitchOn")
        NotificationCenter.default.addObserver(forName: name, object: self, queue: OperationQueue.init()) { [weak self](notification) in
          self?.receiveNotify(notification: notification)
        }
        
    }
    
    func receiveNotify(notification:Notification) {
        let userInfo = notification.userInfo
        print("userInfo: \(String(describing: userInfo))")
    }
    
    deinit {
         
        if let _ = funcSwitch {
            let name = NSNotification.Name("UISwitchOn")
            NotificationCenter.default.removeObserver(self, name: name, object: nil)
        }
    }
}
