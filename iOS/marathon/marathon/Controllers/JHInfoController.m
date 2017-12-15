//
//  JHInfoController
//  marathon
//
//  Created by wrong on 2017/12/15.
//  Copyright © 2017年 peoeleSameWay. All rights reserved.
//

#import "JHInfoController.h"
#import <AFNetworking/AFNetworking.h>
#import <YYModel/YYModel.h>
#import <FMDB/FMDB.h>
#import <MBProgressHUD/MBProgressHUD.h>
#import "Person.h"
#import "JoinViewController.h"


@interface JHInfoController ()
@property (weak, nonatomic) IBOutlet UILabel *groupTitleLable;
@property (weak, nonatomic) IBOutlet UILabel *weighRangeLable;
@property (weak, nonatomic) IBOutlet UILabel *minDailyLable;
@property (weak, nonatomic) IBOutlet UILabel *minPriceLable;
@property (weak, nonatomic) IBOutlet UILabel *baseWeight;
@property (weak, nonatomic) IBOutlet UIView *percentageView;
@property (weak, nonatomic) IBOutlet UILabel *personLeftLable;
@property (weak, nonatomic) IBOutlet UILabel *endTimeLable;
@property (weak, nonatomic) IBOutlet UITextView *useRequireView;
@property (weak, nonatomic) IBOutlet UILabel *currentPersonLable;
@property (weak, nonatomic) IBOutlet UILabel *percentageLable;

@property (nonatomic, copy) NSString *groupID;
@property (nonatomic, copy) NSString *groupName;

@end

@implementation JHInfoController

- (void)viewDidLoad {
    [super viewDidLoad];
    NSDictionary *dataDict = [self.data objectForKey:@"obj"];
    
    NSDictionary *group  = [dataDict objectForKey:@"group"];
    NSString *groupTitle = [group objectForKey:@"group_name"];
    NSString *end_time = [group objectForKey:@"end_time"];
    NSString *banner = [group objectForKey:@"banner"];
    NSString *current_count = [group objectForKey:@"current_count"];
    NSString *group_id = [group objectForKey:@"id"];
    self.groupID = group_id;
    self.groupName = groupTitle;
    
    NSDictionary *market = [dataDict objectForKey:@"market"];

    NSString *weight_max = [market objectForKey:@"weight_max"];
    
    NSNumber *group_limit = [market objectForKey:@"group_limit"];
    NSString *daily_min_packages = [market objectForKey:@"daily_min_packages"];
    NSString *weight_min = [market objectForKey:@"weight_min"];
    NSString *base_price = [market objectForKey:@"base_price"];
    NSString *use_require = [market objectForKey:@"use_require"];
    NSString *group_duration = [market objectForKey:@"group_duration"];
    NSString *mkt_id = [market objectForKey:@"mkt_id"];
    
    NSNumber *currentCount = [dataDict objectForKey:@"num"];
    
    self.groupTitleLable.text = groupTitle;
    self.weighRangeLable.text = [NSString stringWithFormat:@"%@-%@kg",weight_min,weight_max];
    self.minDailyLable.text = [NSString stringWithFormat:@"每日最低需寄%@件",daily_min_packages];
    self.minPriceLable.text = [NSString stringWithFormat:@"%@",base_price];
    self.baseWeight.text = [NSString stringWithFormat:@"%@kg",weight_min];
    
    CGFloat percentage = [currentCount floatValue] / [group_limit floatValue];
    int percent = percentage * 100;
    self.percentageLable.text = [NSString stringWithFormat:@"%d%%",percent];
    
    CGPoint percentageSubzero = self.percentageView.frame.origin;
    self.percentageView.frame = CGRectMake(percentageSubzero.x, percentageSubzero.y, 200 * percentage, 28);
    int personLeft = [group_limit intValue] - [currentCount intValue];
    self.personLeftLable.text = [NSString stringWithFormat:@"还差%d人即可成团",personLeft];
    
    NSDate *date = [NSDate dateWithTimeIntervalSince1970:[end_time longLongValue]];
    NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
    [dateFormatter setDateFormat:@"MM-dd"];
    NSString *dateStr = [dateFormatter stringFromDate:date];
    self.endTimeLable.text = [NSString stringWithFormat:@"%@",dateStr];
    self.currentPersonLable.text = [NSString stringWithFormat:@"已有%@人参团",currentCount];
    self.useRequireView.text = use_require;

}


- (void)testGET
{
    AFHTTPSessionManager *manager = [AFHTTPSessionManager manager];
    [manager GET:@"http://10.2.4.90:6968/ananlyser/push/getPushArrivalRate" parameters:nil progress:nil success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
        NSLog(@"ok.\n");
        NSDictionary *response = (NSDictionary *)responseObject;
        NSLog(@"response is %@",response);
    } failure:^(NSURLSessionDataTask * _Nullable task, NSError * _Nonnull error) {
        NSLog(@"failed.");
    }];
}

- (void)testPOST
{
    AFHTTPSessionManager *manager = [AFHTTPSessionManager manager];
    
    NSMutableDictionary *paraDict = [NSMutableDictionary dictionary];
    
    NSDate *currentDate = [NSDate date];
    //用于格式化NSDate对象
    NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
    //设置格式：zzz表示时区
    [dateFormatter setDateFormat:@"yyyy-MM-dd HH:mm:ss"];
    //NSDate转NSString
    NSString *dateString = [dateFormatter stringFromDate:currentDate];
    dateString = @"2017-11-29 14:00:00";
    
    [paraDict setObject:dateString forKey:@"time"];
    manager.requestSerializer = [AFJSONRequestSerializer serializer];
    [manager POST:@"http://10.2.4.90:6968/ananlyser/push/postRequest" parameters:[paraDict copy] progress:nil success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
        NSLog(@"ok.\n");
        NSDictionary *response = (NSDictionary *)responseObject;
        NSLog(@"response is %@",response);
    } failure:^(NSURLSessionDataTask * _Nullable task, NSError * _Nonnull error) {
        NSLog(@"failed.");
    }];
}

- (void)testLogin
{
    AFHTTPSessionManager *manager = [AFHTTPSessionManager manager];
    
    NSDictionary *userDict = @{@"username":@"mls",@"password":@"123456"};
    
    manager.requestSerializer = [AFJSONRequestSerializer serializer];
    [manager POST:@"http://10.2.4.90:6968/ananlyser/user/dologin" parameters:userDict progress:nil success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
        NSLog(@"ok.\n");
        NSDictionary *response = (NSDictionary *)responseObject;
        NSLog(@"response is %@",response);
    } failure:^(NSURLSessionDataTask * _Nullable task, NSError * _Nonnull error) {
        NSLog(@"failed.");
    }];
}


- (IBAction)joinNow:(id)sender
{
    
    JoinViewController *joinVC = [[UIStoryboard storyboardWithName:@"Main" bundle:nil] instantiateViewControllerWithIdentifier:@"join"];
    joinVC.group_id = self.groupID;
    joinVC.group_name = self.groupTitleLable.text;
    joinVC.user_id = self.userID;
    [self.navigationController pushViewController:joinVC animated:YES];
}

- (IBAction)shareNow:(id)sender
{
    
}


@end
