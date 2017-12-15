//
//  SFScanCodeGenerator.h
//  ScanDemo
//
//  Created by wrong on 2017/11/10.
//  Copyright © 2017年 wrong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <CoreGraphics/CoreGraphics.h>
#import <UIKit/UIKit.h>


/**
 二维码生成工具类
 */
@interface SFScanCodeGenerator : NSObject

/**
 根据给定的文本和尺寸生成二维码图片

 @param text 待编码的内容文本
 @param size 二维码图像的尺寸
 @return 二维码图像
 */
+ (UIImage *)createQRWithString:(NSString *)text QRSize:(CGSize)size;

/**
 根据给定的文本/尺寸/码颜色/背景色生成二维码图片

 @param text 待编码的内容文本
 @param size 二维码图像的尺寸
 @param qrColor 二维码的颜色
 @param bkColor 二维码的背景色
 @return 二维码图像
 */
+ (UIImage *)createQRWithString:(NSString *)text QRSize:(CGSize)size
                        QRColor:(UIColor  *)qrColor bkColor:(UIColor*)bkColor;

/**
 根据给定的文本的尺寸生成Code128条形码图像

 @param text 待编码的内容文本
 @param size 条形码图像的尺寸
 @return 条形码图像
 */
+ (UIImage *)create128BarCodeWithString:(NSString *)text QRSize:(CGSize)size;

/**
 根据给定的文本和尺寸生成PDF417条形码图像

 @param text 待编码的内容文本
 @param size 条形码图像的尺寸
 @return 条形码图像
 */
+ (UIImage *)createPDF417BarCodeWithString:(NSString *)text QRSize:(CGSize)size;

@end
