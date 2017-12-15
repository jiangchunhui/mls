//
//  SFScan.h
//  SFScan
//
//  Created by wrong on 2017/11/17.
//  Copyright © 2017年 wrong. All rights reserved.
//


//经测试，可以最高同时识别3个二维码（但不准确，建议单个扫描），不能同时识别二维码和条形码

#import <UIKit/UIKit.h>

//无样式，提供基础接口的SFScanView
#import "SFBaseScanView.h"

//条形码扫描风格的SFScanView
#import "SFBStyleScanView.h"

//微信风格的SFScanView
#import "SFWStyleScanView.h"

//QQ风格的SFScanView
#import "SFQStyleScanView.h"

//支付宝风格的SFScanView
#import "SFZStyleScanView.h"

//条码生成工具类
#import "SFScanCodeGenerator.h"

//! Project version number for SFScan.
FOUNDATION_EXPORT double SFScanVersionNumber;

//! Project version string for SFScan.
FOUNDATION_EXPORT const unsigned char SFScanVersionString[];

// In this header, you should import all the public headers of your framework using statements like #import <SFScan/PublicHeader.h>


