//
//  JHListViewController
//  marathon
//
//  Created by wrong on 2017/12/15.
//  Copyright © 2017年 peoeleSameWay. All rights reserved.
//

#import "JHListViewController.h"
#import "JHInfoController.h"
#import "NaviViewController.h"
#import <AFNetworking.h>

@interface JHListViewController ()
@property (nonatomic, strong) UITableView *tableView;

@end

@implementation JHListViewController

- (void)viewDidLoad {
    [super viewDidLoad];
        self.title = @"集货团列表";
        UITableView *tableView = [[UITableView alloc] initWithFrame:self.view.frame];
        tableView.delegate = self;
        tableView.dataSource = self;
        self.tableView = tableView;
        [self.view addSubview:tableView];
        NaviViewController *naviVC = (NaviViewController *)self.navigationController;
        self.data = naviVC.data;
        self.userID = naviVC.userID;
        [self.tableView reloadData];
}

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return self.data.count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    UITableViewCell *cell = [[UITableViewCell alloc]
                             initWithStyle:UITableViewCellStyleDefault reuseIdentifier:@"marathonCell"];
    
    NSDictionary *rowData = self.data[indexPath.row];
    NSString *title = [rowData objectForKey:@"group_name"];
    cell.textLabel.text = title;
    cell.textLabel.font = [UIFont systemFontOfSize:18];
    return cell;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{

    NSDictionary *rowData = self.data[indexPath.row];
    NSString *groupID = [rowData objectForKey:@"id"];
    NSString *marketID = [rowData objectForKey:@"market_id"];
    
    
    NSDictionary *argu = @{@"groupId":groupID,@"marketId":marketID};
    AFHTTPSessionManager *manager = [AFHTTPSessionManager manager];
    manager.requestSerializer = [AFJSONRequestSerializer serializer];
    
    [manager GET:@"http://10.2.4.90:6968/ananlyser/market/getMarketDetails" parameters:argu progress:nil success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
        NSLog(@"ok.\n");
        NSDictionary *response = (NSDictionary *)responseObject;
        NSLog(@"response is %@",response);
 
        JHInfoController *infoVC = [[UIStoryboard storyboardWithName:@"Main" bundle:nil] instantiateViewControllerWithIdentifier:@"info"];
        infoVC.data = response;
        infoVC.userID = self.userID;
        [self.navigationController pushViewController:infoVC animated:YES];

        
    } failure:^(NSURLSessionDataTask * _Nullable task, NSError * _Nonnull error) {
        NSLog(@"failed.");
    }];
    
    [tableView deselectRowAtIndexPath:indexPath animated:YES];
}

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
    return 70;
}


@end
