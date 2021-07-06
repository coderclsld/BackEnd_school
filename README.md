## school-后端

#### 介绍

这是我和我的三个小伙伴一起做的一个项目`校园社交平台`的后端代码，

`校园社交平台`是一个可以*发表问题*、*回答问题*、*对回答进行评论*，对每个回答、每个问题、每个评论都精确到用户的*个人信息*的社区，

通过每一个设定的入口链接到每个用户的个人信息页面，可对每个用户的回答问题情况、发表问题情况进行查看，

对每个用户进行一对一的即时聊天，实现社区模式+聊天应用模式的完美结合。

小程序端页码连接：https://gitee.com/clsld/school/

#### 软件架构

后端使用SpringBoot框架作为开发的基础，将整个软件架构分为chat和communicaty两个模块，即聊天模块和社区模块。

笼统的来讲：chat模块主要负责对图片文件的上传和即时聊天功能、communicaty模块主要负责社区中用户、问题、回答、评论的增删改查


#### 功能实现方式

##### 即时聊天

首先我先大致讲一下我这个聊天系统的实现机制，首先这个项目是考虑与前端的微信小程序相连接的，那么我就使用了微信小程序的openid作为唯一id,

当微信小程序对我的后端程序发起websocket请求时顺便将该小程序使用者的openid发送过来，而我后端监听到有连接请求事件的话，

就将此openid作为key，websocket会话作为values存入currenthashmap中，并且一直保存连接。

如果有微信小程序用户想要发送信息给其他用户时，会将自己和对方的openid以及信息发送给后端，后端判断map中对方的openid在不在，如果存在的话，

就get(openid)获得此用户的websocket session会话，并调用服务端对客户端的发送信息函数进行信息的传递；如果此用户的openid不存在，即说明此用户，

没有连接websocket请求也就说不在线，那么我就把信息存储到redis中，等该用户上线时再将消息取出发送给该用户。



然后下面是快速实现websocket聊天的事例，如果对我实现的聊天机制有兴趣，

请下载我的代码查看，如果对你有用请毫不吝啬的star。
   
使用springboot+websocket+redis的方式实现即时聊天，首先需要导入springboot整合redis的依赖

```xml
 <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-websocket</artifactId>
        <version>2.4.2</version>
    </dependency>
```
然后新建WebSocketConfig开启消息推送

```java
@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
```
新建WebSocketServer类对请求过来的websocket请求进行处理

![路径映射](https://images.gitee.com/uploads/images/2021/0706/075640_10bdc63d_5688172.png "屏幕截图.png")

![方法映射](https://images.gitee.com/uploads/images/2021/0706/075947_3d146be2_5688172.png "屏幕截图.png")


#### 评论的多级转换



#### 参与贡献

陈霖 https://gitee.com/clsld

钟科杰 https://gitee.com/zkj_123


