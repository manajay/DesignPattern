//
//  SwiftDistributionInvocationController.swift
//  DesignPattern
//
//  Created by ljtwan on 2018/11/12.
//  Copyright © 2018 iCourt. All rights reserved.
//

import UIKit

enum DistributionInvocationType:Int {
    case observer
    case none
}

class SwiftDistributionInvocationController: UITableViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let invocationType = DistributionInvocationType.init(rawValue: indexPath.row) ?? DistributionInvocationType.none
        switch invocationType {
        case .observer:
            print("观察者模式")
            let observerVC = SwiftObserverPatternController.init(nibName: String(describing: SwiftObserverPatternController.self), bundle: nil)
            navigationController?.pushViewController(observerVC, animated: true)
        case .none:
            print("待续")
        }
    }

     override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
 
}
