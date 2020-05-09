# 后台技术选型：
- JDK8
- MySQL
- Spring-boot
- Spring-data-jpa
- Lombok
- Freemarker
- Bootstrap
- Websocket

# 小程序端技术选型
- 微信小程序

# 老规矩先看效果图
### 管理后台
![菜品管理](https://upload-images.jianshu.io/upload_images/6273713-928017278f465cbd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![订单管理](https://upload-images.jianshu.io/upload_images/6273713-4edede33faa7ea72.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
小程序下单完成后会有消息推送，如下
![消息推送](https://upload-images.jianshu.io/upload_images/6273713-2391a83091740991.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
可以直接操作订单
![操作订单](https://upload-images.jianshu.io/upload_images/6273713-5b25bd1e569113e3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 小程序端
![小程序端功能](https://upload-images.jianshu.io/upload_images/6273713-8d6c2b81701d32cd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
如上图，目前实现了如下功能。
- 扫码点餐
- 菜品分类显示
- 模拟支付
- 评论系统

---
#小程序代码
### 一，导入源码到小程序开发工具
![image.png](https://upload-images.jianshu.io/upload_images/6273713-78a2e556b1a65726.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
你如果没有小程序开发基础，只需要看下这个视频学习下如何导入小程序源码到开发者工具即可
[https://edu.csdn.net/course/play/9531/234418](https://edu.csdn.net/course/play/9531/234418)

### 二，导入成功后直接就可以用了
> 如果你想用扫码点餐，就把下面注释打开

![真机调试才可以扫码点餐](https://upload-images.jianshu.io/upload_images/6273713-5e4b91caa68e0148.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![扫码点餐代码](https://upload-images.jianshu.io/upload_images/6273713-2637e6bd904eec0b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 三，如果要扫码点餐的话，就扫码下面二维码。识别桌号
![image.png](https://upload-images.jianshu.io/upload_images/6273713-d213da9873e4cebd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)









