# <center>Springboot Personal Website Server

<p align="center">
   <a target="_blank" href="#">
      <img src="https://img.shields.io/hexpm/l/plug.svg"/>
      <img src="https://img.shields.io/badge/JDK-1.8+-green.svg"/>
      <img src="https://img.shields.io/badge/springboot-2.4.2.RELEASE-green"/>
      <img src="https://img.shields.io/badge/vue-2.5.17-green"/>
      <img src="https://img.shields.io/badge/mysql-8.0.20-green"/>
      <img src="https://img.shields.io/badge/mybatis--plus-3.4.0-green"/>
      <img src="https://img.shields.io/badge/redis-6.0.5-green"/>
      <img src="https://img.shields.io/badge/elasticsearch-7.9.2-green"/>
      <img src="https://img.shields.io/badge/rabbitmq-3.8.5-green"/>
   </a>
</p>

![](https://cdn.jsdelivr.net/gh/Wayne-HJ/pictures@main/img/20230518210626.png)

[Project Features](#project-features) | [Project Introduction](#project-introduction) | [Technologies](#technologies) | [Runtime Environment](#runtime-environment) | [Development Environment](#development-environment) | [Project Screenshots](#project-screenshots) | [Getting Started](#getting-started)

[Chinese(中文)](README_CN.md)
## Project Features

- The project is based on the personal blog of Feng Yu, and is further developed.
- The front-end design is inspired by "Butterfly" in "Hexo", which is beautiful, concise, and has a responsive user experience.
- The back-end design is inspired by "element-admin" with a sidebar, historical tags, and automatically generated breadcrumbs.
- Markdown editor for easy writing.
- Comments support emoji input and replies, with styles inspired by Valine.
- Music player that supports online song search.
- Frontend and backend separation deployment to adapt to the current trend.
- Support publishing "shuoshuo" (short posts) to share interesting things at any time.
- Message board in the style of danmaku (bullet screen comments).
- Support code highlighting and copying, image preview, dark mode, and other features to enhance user experience.
- Search articles with highlighted word segmentation for fast response.
- Online chat room with features like message retraction, voice input, and unread message count.
- Support logging management with AOP annotations.
- Backend supports dynamic permission modification and uses the RBAC model. Frontend menus and backend permissions are updated in real-time.
- Backend management supports modifying background images, blog configurations, and other information. It provides simple operations and supports uploading photo albums.
- Code supports multiple search modes (Elasticsearch or MySQL).
- Support multiple file upload modes (Alibaba Cloud OSS, MinIO, local storage, picgo image hosting), which can be configured as needed.
- The code follows the Alibaba development specifications, which is conducive to developers' learning.

## Project Introduction

This is the Server of the whole project 

The SQL file is located in the root directory as "blog-mysql8.sql" and requires MySQL 8 or above.

You can directly import this project to your local environment, modify the database connection information in the backend configuration fileand configure the Minio Cloud object storage related settings used in the project.

After cloning the project to your local environment, you can use the email account: admin@qq.com and password: 1234567 to log in. Alternatively, you can register your own account and modify its role to "admin".

Access the local API documentation at [http://localhost:8089/doc.html](http://localhost:8089/doc.html).

**Note: Please run the backend project first and then start the frontend project. The frontend project configuration is dynamically loaded from the backend.**

```
blog-springboot
├── annotation    --  Custom annotations
├── aspect        --  AOP modules
├── config        --  Configuration modules
├── constant      --  Constants modules
├── consumer      --  MQ consumer modules
├── controller    --  Controller modules
├── dao           --  Framework core modules
├── dto           --  DTO modules
├── enums         --  Enum modules
├── exception     --  Custom exception modules
├── handler       --  Handler modules (extend Security filters, customize Security prompt messages, etc.)
├── service       --  Service modules
├── strategy      --  Strategy modules (used for extending third-party login, search mode, file upload mode, etc.)
├── util          --  Utility class modules
└── vo            --  VO modules
```

## Technologies

**Backend:** SpringBoot + Nginx + Docker + Spring Security + Swagger2 + MyBatis Plus + MySQL + Redis + Elasticsearch + RabbitMQ + MaxWell + Websocket

**Others:** Integration of QQ, Weibo third-party login, integration of Tencent Cloud human-machine verification, websocket

## Runtime Environment

**Server:** Oracle 1 core 1G CentOS 7.6

**Object Storage:** MinIO

## Development Environment

|Development Tools|Description|
|-|-|
|IDEA|Java development IDE|
|Navicat|MySQL remote connection tool|
|Another Redis Desktop Manager|Redis remote connection tool|
|X-shell|Linux remote connection tool|
|Xftp|Linux file upload tool|

|Development Environment|Version|
|-|-|
|JDK|1.8|
|MySQL|8.0.20|
|Redis|6.0.5|
|Elasticsearch|7.9.2|
|RabbitMQ|3.8.5|

## Project Screenshots
**Website Frontend**
![](https://cdn.jsdelivr.net/gh/Wayne-HJ/pictures@main/img/20230518210853.png)
![](https://cdn.jsdelivr.net/gh/Wayne-HJ/pictures@main/img/20230518210948.png)
**Admin Backend**
![](https://cdn.jsdelivr.net/gh/Wayne-HJ/pictures@main/img/20230603234349.png)
![](https://cdn.jsdelivr.net/gh/Wayne-HJ/pictures@main/img/202306111700664.png)

## Getting Started
Backend Project
Make sure that Redis and MySQL components are running, and relevant configurations have been modified in the application.yml file. Simply run the BlogApplication class.

Please let me know if you need any further assistance!