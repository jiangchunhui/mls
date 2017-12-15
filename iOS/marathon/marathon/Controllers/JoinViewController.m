//
//  JoinViewController
//  marathon
//
//  Created by wrong on 2017/12/15.
//  Copyright © 2017年 peoeleSameWay. All rights reserved.
//

#import "JoinViewController.h"
#import "AreaModel.h"
#import "CityModel.h"
#import "ProvinceModel.h"
#import <MBProgressHUD/MBProgressHUD.h>
#import <AFNetworking.h>

@interface JoinViewController ()
@property (weak, nonatomic) IBOutlet UITextField *targetAddressTextField;
@property (weak, nonatomic) IBOutlet UITextField *senderNameTextField;
@property (weak, nonatomic) IBOutlet UITextField *senderAddressTextField;
@property (weak, nonatomic) IBOutlet UITextField *mailCountTextField;
@property (weak, nonatomic) IBOutlet UITextField *averageWeightTextField;
@property (weak, nonatomic) IBOutlet UITextField *targetDistrictTextField;
@property (nonatomic, strong)NSDictionary *areaDic;
@property (nonatomic, strong)NSMutableArray *provinceArr;


@end

@implementation JoinViewController

- (void)viewDidLoad {
    
    [super viewDidLoad];
    
//    [self loading];
//    self.picker.delegate = self;
//    self.picker.dataSource = self;
//    [self.picker selectRow:0 inComponent:0 animated:YES];
//
}


//- (void)loading
//{
//    dispatch_queue_t globalQueue = dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_DEFAULT, 0);
//    dispatch_async(globalQueue, ^{
//        [self prepareData];
//    });
//}
//
//- (void)prepareData
//{
//    //area.plist是字典
//    NSString *plistPath = [[NSBundle mainBundle] pathForResource:@"area" ofType:@"plist"];
//    _areaDic = [[NSDictionary alloc]initWithContentsOfFile:plistPath];
//
//    //city.plist是数组
//    NSString *plist = [[NSBundle mainBundle] pathForResource:@"city" ofType:@"plist"];
//    NSMutableArray *dataCity = [[NSMutableArray alloc] initWithContentsOfFile:plist];
//
//    _provinceArr = [[NSMutableArray alloc]init];
//    for (NSDictionary *dic in dataCity) {
//        ProvinceModel *model  = [[ProvinceModel alloc]init];
//        [model setValuesForKeysWithDictionary:dic];
//        model.citiesArr = [[NSMutableArray alloc]init];
//        for (NSDictionary *dic in model.cities) {
//            CityModel *cityModel = [[CityModel alloc]init];
//            [cityModel setValuesForKeysWithDictionary:dic];
//            [model.citiesArr addObject:cityModel];
//        }
//        [_provinceArr addObject:model];
//    }
//
//}
//
//
//- (NSInteger)numberOfComponentsInPickerView:(UIPickerView*)pickerView
//{
//    return 3;
//}
//- (NSInteger)pickerView:(UIPickerView *)pickerView numberOfRowsInComponent:(NSInteger)component{
//    if (0 == component)
//    {
//        return _provinceArr.count;
//    }
//    else if(1==component)
//    {
//        NSInteger rowProvince = [pickerView selectedRowInComponent:0];
//        ProvinceModel *model =   _provinceArr[rowProvince];
//        return model.citiesArr.count;
//    }
//    else
//    {   NSInteger rowProvince = [pickerView selectedRowInComponent:0];
//        NSInteger rowCity = [pickerView selectedRowInComponent:1];
//        ProvinceModel *model = _provinceArr[rowProvince];
//        CityModel *cityModel = model.citiesArr[rowCity];
//        NSString *str = [cityModel.code description];
//        NSArray *arr =  _areaDic[str];
//        return arr.count;
//    }
//}
//- (NSString *)pickerView:(UIPickerView *)pickerView titleForRow:(NSInteger)row forComponent:(NSInteger)component
//{
//    if (0 == component)
//    {
//        ProvinceModel *model = _provinceArr[row];
//        return model.name;
//    }
//    else if(1==component)
//    {
//        NSInteger rowProvince = [pickerView selectedRowInComponent:0];
//        ProvinceModel *model = _provinceArr[rowProvince];
//        CityModel *cityModel = model.citiesArr[row];
//        return cityModel.name;
//    }else
//    {
//        NSInteger rowProvince = [pickerView selectedRowInComponent:0];
//        NSInteger rowCity = [pickerView selectedRowInComponent:1];
//        ProvinceModel *model = _provinceArr[rowProvince];
//        CityModel *cityModel = model.citiesArr[rowCity];
//        NSString *str = [cityModel.code description];
//        NSArray *arr = _areaDic[str];
//        AreaModel *areaModel = [[AreaModel alloc]init];
//        [areaModel setValuesForKeysWithDictionary:arr[row]];
//        return areaModel.name;
//    }
//
//}
//- (void)pickerView:(UIPickerView *)pickerView didSelectRow:(NSInteger)row inComponent:(NSInteger)component
//{
//    if(0 == component)
//    {
//        [pickerView reloadComponent:1];
//        [pickerView reloadComponent:2];
//
//    } if(1 == component)
//    {
//        [pickerView reloadComponent:2];
//    }
//
//    NSInteger selectOne = [pickerView selectedRowInComponent:0];
//    NSInteger selectTwo = [pickerView selectedRowInComponent:1];
//    NSInteger selectThree = [pickerView selectedRowInComponent:2];
//
//    ProvinceModel *model = _provinceArr[selectOne];
//    CityModel *cityModel = model.citiesArr[selectTwo];
//    NSString *str = [cityModel.code description];
//    NSArray *arr = _areaDic[str];
//    AreaModel *areaModel = [[AreaModel alloc]init];
//    [areaModel setValuesForKeysWithDictionary:arr[selectThree]];
//    self.navigationItem.title = [NSString stringWithFormat:@"省:%@  市:%@  区:%@",model.name,cityModel.name,areaModel.name];
//    NSLog(@"省:%@ 市:%@ 区:%@",model.name,cityModel.name,areaModel.name);
//}

- (IBAction)joinNow:(id)sender
{
  
    if (self.senderNameTextField.text.length == 0 || self.senderAddressTextField.text.length == 0 || self.mailCountTextField.text.length == 0 || self.targetAddressTextField.text.length == 0 || self.averageWeightTextField.text.length == 0 || self.targetDistrictTextField.text.length == 0) {
        MBProgressHUD *hud = [MBProgressHUD showHUDAddedTo:self.view animated:YES];
        hud.mode = MBProgressHUDModeText;
        hud.label.text = @"请完整填写信息！";
        hud.margin = 10.f;
        [hud setOffset:CGPointMake(0, 130)];
        hud.removeFromSuperViewOnHide = YES;
        [hud hideAnimated:YES afterDelay:2];
        return;
    }
    
    NSString *phoneNumberString = self.senderAddressTextField.text;
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
    
    NSDictionary *arguDict = @{@"group_id":self.group_id,
                               @"user_id":self.user_id,
                               @"address_1":self.targetAddressTextField.text,
                               @"address_2":self.senderAddressTextField.text,
                               @"name":self.senderNameTextField.text,
                               @"mobile":self.senderAddressTextField.text,
                               @"expect_sum":self.mailCountTextField.text,
                               @"avg_weight":self.averageWeightTextField.text,
                               };

  
    
    manager.requestSerializer = [AFJSONRequestSerializer serializer];
    [manager POST:@"http://10.2.4.90:6968/ananlyser/market/userAddGroup" parameters:arguDict progress:nil success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
        NSLog(@"ok.\n");
        NSDictionary *response = (NSDictionary *)responseObject;
        UIViewController *VC = [[UIStoryboard storyboardWithName:@"Main" bundle:nil] instantiateViewControllerWithIdentifier:@"ok"];
        [self.navigationController pushViewController:VC animated:YES];
        
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

- (BOOL)checkTelNumber:(NSString *) telNumber
{
    NSString *pattern = @"^1+[3578]+\\d{9}";
    NSPredicate *pred = [NSPredicate predicateWithFormat:@"SELF MATCHES %@", pattern];
    BOOL isMatch = [pred evaluateWithObject:telNumber];
    return isMatch;
}


@end
