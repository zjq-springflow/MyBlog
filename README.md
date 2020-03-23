# MyBlog

> 基于Spring Boot 的 Java 开源博客

[![https://img.shields.io/badge/JDK-1.8-yellow.svg?style=flat-square](https://camo.githubusercontent.com/2cc01fe5b43b07d95a4ae0423d08aa5ab7b0c680/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a444b2d312e382d79656c6c6f772e7376673f7374796c653d666c61742d737175617265)](https://camo.githubusercontent.com/2cc01fe5b43b07d95a4ae0423d08aa5ab7b0c680/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a444b2d312e382d79656c6c6f772e7376673f7374796c653d666c61742d737175617265)



## 项目简介	

一个简洁好看的博客网站，分为前台和后台。

[通过学习b站视频（没用mybatis，用的jpa）](https://www.bilibili.com/video/av62555970?from=search&seid=9365373471823867400 )

[通过借鉴github（用的mybatis）](https://github.com/gaohan666/blog)



![](https://note.youdao.com/yws/public/resource/5681a0de28b70ad43acf8e1860389927/xmlnote/5E673CD986E744C0926087C2969AB5FE/7490)

## 快速启动

- jdk1.8+
- maven 3.0+
- mysql 5.7+



项目导入后修改`application-dev.xml`的数据库用户名密码。

默认端口8088，启动访问即可。

访问[localhost:8088](localhost:8088)即为前台主页，

访问[localhost:8088/admin](localhost:8088/admin)即为后台主页，账号zjq，密码123456



## 技术栈

- **Mybatis**
- **SpringBoot**
- **SpringMVC**
- **Thymeleaf**
- **Semantic UI**

分页插件`pagehelper`，转换html插件`commonmark`，前端插件等等不再赘述。



## 项目缺陷

- 很多为了适应功能的dto

- 二级评论无法树形展示

- 异常处理有时会无故报500

- 头像固定且单一，博客首图无预览

- 无法上传文件

- 无后台监控

- 安全只是使用的拦截器

- 无密码修改，无注册

- 功能很少

  

## 项目优势

- 简洁明了
- 结构清晰
- 功能具有很大的扩展性