//
//  SFScanResult.h
//  ScanDemo
//
//  Created by wrong on 2017/11/10.
//  Copyright © 2017年 wrong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

/**
 扫码结果
 */
@interface SFScanResult : NSObject

/**
 @brief  解码得到的字符串
 */
@property (nonatomic, copy) NSString *strScanned;


/**
 @brief  码的图像
 */
@property (nonatomic, strong) UIImage *imgScanned;


/**
 @brief  码的类型：如AVMetadataObjectTypeQRCode，AVMetadataObjectTypeEAN13Code
 */
@property (nonatomic, copy) NSString *strBarCodeType;

@end

