//
//  SFScanView.h
//  ScanDemo
//
//  Created by wrong on 2017/11/1.
//  Copyright © 2017年 wrong. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <Foundation/Foundation.h>
#import "SFScanResult.h"
@class SFBaseScanView;

//JS接口
//isShowCarmerIcon={true}
//cropMarginLeft={15}
//cropMarginTop={30}
//cropMarginRight={15}
//cropMarginBottom={60}
//permissionSuc={this.state.permissionSuc}
//isShowScanBarAnim={true}
//isShowScanBar={true}
//scanBarColor="#00AEFF"
//cornerColor="#00AEFF"
//style={{height:440, backgroundColor: '#fcffff'}}
//onScanResult={(data)=>{SfToast.showLong(JSON.stringify(data));}}


/**
 SFScanView - 无样式，无UI，只提供基础接口 (需要UI请使用SF__Style系列类)
 */


// 要处理扫描结果，需要遵守SFScanViewDelegate协议、
@protocol SFScanViewDelegate <NSObject>

@optional

//使用该方法处理扫描结果，array是一个SFScanResult数组。
- (void)sfscanView:(id)scanView scanResultWithArray:(NSArray<SFScanResult *>*)array;

@end


@interface SFBaseScanView : UIView <UIImagePickerControllerDelegate,UINavigationControllerDelegate>

//delegate一般设为目标ViewController，实现scanResultWithArray协议方法即可
@property (nonatomic, weak) id<SFScanViewDelegate> delegate;

- (instancetype)initWithWithCenterUpOffset:(CGFloat)centerUpOffset andMarginX:(CGFloat)marginX WHRatio:(CGFloat)whRatio andFrame:(CGRect)frame;
/**
 开始扫描
 */
- (void)startScan;

/**
 停止扫描
 */
- (void)stopScan;

/**
 打开系统照片库
 */
- (void)openPhotoLibrary;

/**
 开/关闪光灯
 */
- (void)openOrCloseFlash;

/**
 开/关自动对焦
 */
- (void)openOrCloseAF;


@end

