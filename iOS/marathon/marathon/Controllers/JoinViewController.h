//
//  JoinViewController
//  marathon
//
//  Created by wrong on 2017/12/15.
//  Copyright © 2017年 peoeleSameWay. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface JoinViewController : UIViewController <UIPickerViewDelegate>
@property (nonatomic, strong) NSMutableArray *data;

@property (nonatomic, copy) NSString *group_name;
@property (nonatomic, copy) NSString *group_id;
@property (nonatomic, copy) NSString *user_id;


@end
