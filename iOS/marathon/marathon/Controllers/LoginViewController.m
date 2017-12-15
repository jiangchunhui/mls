//
//  LoginViewController
//  marathon
//
//  Created by wrong on 2017/12/15
//  Copyright © 2017年 peoeleSameWay. All rights reserved.
//

#import "LoginViewController.h"
#import "NaviViewController.h"
#import <AFNetworking.h>
#import "JHInfoController.h"
#import <MBProgressHUD/MBProgressHUD.h>

@interface LoginViewController ()
@property (weak, nonatomic) IBOutlet UITextField *phoneNumberTextField;
@end

@implementation LoginViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)login:(id)sender {
    NSString *phoneNumberString = self.phoneNumberTextField.text;
    if (![self checkTelNumber:phoneNumberString]) {
        MBProgressHUD *hud = [MBProgressHUD showHUDAddedTo:self.view animated:YES];
        hud.mode = MBProgressHUDModeText;
        hud.label.text = @"手机号格式错误";
        hud.margin = 10.f;
        [hud setOffset:CGPointMake(0, 130)];
        hud.removeFromSuperViewOnHide = YES;
        [hud hideAnimated:YES afterDelay:2];
        return;
    }
    
    
    AFHTTPSessionManager *manager = [AFHTTPSessionManager manager];
    
    NSDictionary *userDict = @{@"username":self.phoneNumberTextField.text};
    
    manager.requestSerializer = [AFJSONRequestSerializer serializer];
    [manager POST:@"http://10.2.4.90:6968/ananlyser/user/dologin" parameters:userDict progress:nil success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject)
    {
        NSLog(@"ok.\n");
        NSDictionary *response = (NSDictionary *)responseObject;
        NSString *userID = [response objectForKey:@"obj"];
        NSLog(@"response is %@",response);
        [self goToNextPageWithUserID:userID];
    } failure:^(NSURLSessionDataTask * _Nullable task, NSError * _Nonnull error) {
        NSLog(@"failed.");
    }];
    
}

#pragma 正则匹配手机号
- (BOOL)checkTelNumber:(NSString *) telNumber
{
    NSString *pattern = @"^1+[3578]+\\d{9}";
    NSPredicate *pred = [NSPredicate predicateWithFormat:@"SELF MATCHES %@", pattern];
    BOOL isMatch = [pred evaluateWithObject:telNumber];
    return isMatch;
}

- (void)goToNextPageWithUserID:(NSString *)userID
{
    
    AFHTTPSessionManager *manager = [AFHTTPSessionManager manager];
    manager.requestSerializer = [AFJSONRequestSerializer serializer];
    [manager POST:@"http://10.2.4.90:6968/ananlyser/market/getMarketList" parameters:nil progress:nil success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
        NSLog(@"ok.\n");
        NSDictionary *response = (NSDictionary *)responseObject;
        NSArray *obj = (NSArray *)[response objectForKey:@"obj"];
        NSDictionary *dict = [obj firstObject];
        NSLog(@"response is %@",response);
        
        NaviViewController *naviVC = [[UIStoryboard storyboardWithName:@"Main" bundle:nil] instantiateViewControllerWithIdentifier:@"navi"];
        naviVC.data = obj;
        naviVC.userID = userID;
        [self presentViewController:naviVC animated:YES completion:nil];
        
    } failure:^(NSURLSessionDataTask * _Nullable task, NSError * _Nonnull error) {
        NSLog(@"failed.");
        MBProgressHUD *hud = [MBProgressHUD showHUDAddedTo:self.view animated:YES];
        hud.mode = MBProgressHUDModeText;
        hud.label.text = @"登录失败，请检查网络设置";
        hud.margin = 10.f;
        [hud setOffset:CGPointMake(0, 130)];
        hud.removeFromSuperViewOnHide = YES;
        [hud hideAnimated:YES afterDelay:2];
    }];
}

@end
