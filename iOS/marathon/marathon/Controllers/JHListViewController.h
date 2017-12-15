//
//  JHListViewController
//  marathon
//
//  Created by wrong on 2017/12/15.
//  Copyright © 2017年 peoeleSameWay. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface JHListViewController : UIViewController <UITableViewDelegate,UITableViewDataSource>
@property (nonatomic, strong) NSArray *data;
@property (nonatomic, copy) NSString *userID;

@end
