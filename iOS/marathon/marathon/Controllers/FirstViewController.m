//
//  FirstViewController.m
//  marathon
//
//  Created by wrong on 2017/12/14.
//  Copyright © 2017年 peoeleSameWay. All rights reserved.
//

#import "FirstViewController.h"
#import <AFNetworking/AFNetworking.h>
#import <YYModel/YYModel.h>
#import <FMDB/FMDB.h>
#import <MBProgressHUD/MBProgressHUD.h>
#import "Person.h"

@interface FirstViewController ()
@property (nonatomic, strong) UITableView *tableView;
@property (nonatomic, strong) NSMutableArray *data;
@end

@implementation FirstViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    UITableView *tableView = [[UITableView alloc] initWithFrame:self.view.frame];
    tableView.delegate = self;
    tableView.dataSource = self;
    self.tableView = tableView;
    [self.view addSubview:tableView];
    
    self.data = [[NSMutableArray alloc] initWithArray:
                @[
                  @[@"按钮1",@"按钮2",@"按钮3"],
                  @[@"按钮4",@"按钮5"],
                  @[@"登录"]
                  ]];
    
    Person *p = [Person new];
    p.name = @"tank";
    p.uid = 1234567;
    NSDictionary *dict = [p yy_modelToJSONObject];
    [p yy_modelSetWithJSON:dict];

    NSLog(@"12456");

    NSString *dbPath = [NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES) firstObject];
    [dbPath stringByAppendingString:@"Data.db"];
    FMDatabase *db = [FMDatabase databaseWithPath:dbPath];
    [db open];
    [self.tableView reloadData];
}

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return self.data.count;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    NSArray *sectionArray = self.data[section];
    return sectionArray.count;
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    UITableViewCell *cell = [[UITableViewCell alloc]
                             initWithStyle:UITableViewCellStyleDefault reuseIdentifier:@"marathonCell"];
    NSArray *sectionArray = self.data[indexPath.section];
    NSString *title = sectionArray[indexPath.row];
    cell.textLabel.text = title;
    cell.textLabel.font = [UIFont systemFontOfSize:18];
    return cell;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    [self testLogin];
    [tableView deselectRowAtIndexPath:indexPath animated:YES];
}

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
    return 70;
}

- (void)testGET
{
    AFHTTPSessionManager *manager = [AFHTTPSessionManager manager];
    [manager GET:@"http://10.118.124.77:6968/ananlyser/push/getPushArrivalRate" parameters:nil progress:nil success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
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
    [manager POST:@"http://10.118.124.77:6968/ananlyser/push/postRequest" parameters:[paraDict copy] progress:nil success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
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
    [manager POST:@"http://10.118.124.77:6968/ananlyser/user/dologin" parameters:userDict progress:nil success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
        NSLog(@"ok.\n");
        NSDictionary *response = (NSDictionary *)responseObject;
        NSLog(@"response is %@",response);
    } failure:^(NSURLSessionDataTask * _Nullable task, NSError * _Nonnull error) {
        NSLog(@"failed.");
    }];
}

@end
