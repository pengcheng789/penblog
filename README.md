# PenBlog

*****

## 简介
  为了了解Java Web的开发流程，也为了搭建一个自己的博客，就写了这个项目。

  预期使用一个月的时间完成并优化它。

  准备实现的功能是博主自己能够发表文章，注册的读者能够对文章进行收藏和评论，以及对评论进行回复。

***

## 结构
  采用传统的MVC架构进行开发。

  controller -- 各种servlet。

  service -- 博客的业务逻辑处理包。

  model -- 模型包。

  util -- 各种强大的工具类。

***

## URL
  GET:/ -- 主页。


  GET:/user/register -- 用户注册界面。

  POST:/user/register -- 用户注册表单提交。

  GET:/user/list -- 用户列表。
  
  GET:/user/profile?id={id} -- 查看用户详情， {id}为用户id。

  DELETE:/user/profile?id={id} -- 删除用户， {id}为用户id。
  
  PUT:/user/profile?id={id} -- 更新用户信息， {id}为用户id。
    
***

## 参考书籍
  [1]黄勇著.架构探险：从零开始写Java Web框架[M].北京：电子工业出版社，2015.8

  [2]（美）Craig Walls著.Spring实战[M].张卫滨译.第4版.北京：人民邮电出版社，2016.4

***

## 更新
### v0.1
  + 建立项目结构。
  + 完成数据库操作处理。
  + 完成用户注册、用户删除、用户查询，但还没有对表单数据进行过滤。
  + 完成until包内的主要工具类。
  + 还没有认证和授权功能。

### v0.2
  + 增加用户详情查看。
  + 增加用户修改昵称、性别的功能。
  + 调整了一下项目结构。
  + 调整了部分URL。
  + 还没有对表单的空值进行验证。
  + 还没有认证和授权功能。
  
### v0.2.1
  + 增加用户上传头像功能
  + 还没有对表单的空值进行验证。
  + 还没有认证和授权功能。
  
### v0.2.2
  + 修改首页UI和个人信息UI。
  + 增加管理员的个人信息界面。
  + 还没有对表单的空值进行验证。
  + 还没有认证和授权功能。
  
### v0.3
  + 修改个人信息UI。
  + 完场添加文章分类的功能。
  + 修复一些bug。
  + 还没有对表单的空值进行验证。
  + 还没有认证和授权功能。
  
### v0.3.1
  + 添加用户登录界面。
  + 由于代码结构臃肿，近期准备重构。
  
### v0.4
  + 进行代码重构。
  + 添加类操作工具类和助手类，负责对应用包的类进行加载和管理。
  + 添加反射工具类和Bean助手类，负责对加载的类进行实例化和管理。
  + 添加依赖注入助手类，负责对存在依赖的成员变量进行注入。
  + 添加Request,Handler,View,Data等bean类，对请求信息、请求处理、返回信息进行封装。
  + 添加控制器助手类，对请求信息和请求处理的映射关系进行封装。
  
### v0.4.1
  + 添加核心请求转发器 DispatcherServlet ，负责对请求适配控制器。
  + 将部分 User Servlet 转移至 UserController ，采用新架构开发。
  + 完善工具类。
  
### v0.4.2
  + 添加 AOP 架构，支持 AOP 特性。
  + 重构文件上传功能。
  + 重构核心请求转发器 DispatcherServlet 。
  + 优化 Action 参数。
  + 添加 ServletHelper 助手类， 负责封装 Request 和 Response 对象，实现 Servlet API 的解耦。

### v0.4.3
  + 添加安全机制，包括认证、授权机制