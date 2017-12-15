//
//  CodeGenViewController.m
//  marathon
//
//  Created by wrong on 2017/12/15.
//  Copyright © 2017年 peoeleSameWay. All rights reserved.
//

#import "CodeGenViewController.h"
#import <SFScan/SFScanCodeGenerator.h>

@interface CodeGenViewController ()
@property (weak, nonatomic) IBOutlet UIImageView *imageView;

@end

@implementation CodeGenViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.imageView.image = [SFScanCodeGenerator createQRWithString:@"http://10.2.4.63:8080/" QRSize:CGSizeMake(250, 250) QRColor:[UIColor purpleColor] bkColor:[UIColor whiteColor]];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/


@end
