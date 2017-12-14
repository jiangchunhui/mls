//
//  PersonalViewController.m
//  marathon
//
//  Created by wrong on 2017/12/14.
//  Copyright © 2017年 peoeleSameWay. All rights reserved.
//

#import "PersonalViewController.h"

@interface PersonalViewController ()
@property (nonatomic, strong) UITableView *tableView;
@property (nonatomic, strong) NSMutableArray *data;
@end

@implementation PersonalViewController

- (void)viewDidLoad {
    [super viewDidLoad];
//    UITableView *tableView = [[UITableView alloc] initWithFrame:self.view.frame];
//    tableView.delegate = self;
//    tableView.dataSource = self;
//    self.tableView = tableView;
//    [self.view addSubview:tableView];
//
//    self.data = [[NSMutableArray alloc] initWithArray:
//                 @[
//                   @[@"个人信息",@"地址管理",@"安全设置"],
//                   @[@"1234",@"按钮5"],
//                   @[@"登出"]]
//                 ];
//    [self.tableView reloadData];
}

//- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
//{
//    return self.data.count;
//}
//
//- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
//{
//    NSArray *sectionArray = self.data[section];
//    return sectionArray.count;
//}
//
//
//- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
//{
//    UITableViewCell *cell = [[UITableViewCell alloc]
//                             initWithStyle:UITableViewCellStyleDefault reuseIdentifier:@"marathonCell"];
//    NSArray *sectionArray = self.data[indexPath.section];
//    NSString *title = sectionArray[indexPath.row];
//    cell.textLabel.text = title;
//    cell.textLabel.font = [UIFont systemFontOfSize:18];
//    return cell;
//}
//
//- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
//{
//    [tableView deselectRowAtIndexPath:indexPath animated:YES];
//}
//
//- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
//{
//    return 50;
//}


@end
