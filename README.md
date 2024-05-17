<div align="center">
    <img alt="logo" src="image/banner.png" style="height: 80px">
</div>
<div align="center">
    <h2>Java版微信聊天记录备份与管理工具</h2>
    <h4>一站式微信数据整合与分析，实现聊天记录无限留存与深度挖掘</h4>
</div>
<p align="center">
    <a href="https://github.com/xuchengsheng/spring-reading/stargazers"><img src="https://img.shields.io/github/stars/xuchengsheng/wx-dump-4j?logo=github&logoColor=%23EF2D5E&label=Stars&labelColor=%23000000&color=%23EF2D5E&cacheSeconds=3600" alt="Stars Badge"/></a>
    <a href="https://github.com/xuchengsheng"><img src="https://img.shields.io/github/followers/xuchengsheng?label=Followers&logo=github&logoColor=%23FC521F&labelColor=%231A2477&color=%23FC521F&cacheSeconds=3600" alt="Follow Badge"></a>
    <a href="https://github.com/xuchengsheng/wx-dump-4j/fork"><img src="https://img.shields.io/github/forks/xuchengsheng/wx-dump-4j?label=Forks&logo=github&logoColor=%23F2BB13&labelColor=%23BE2323&color=%23F2BB13" alt="Fork Badge"></a>
    <a href="https://github.com/xuchengsheng/wx-dump-4j/watchers"><img src="https://img.shields.io/github/watchers/xuchengsheng/wx-dump-4j?label=Watchers&logo=github&logoColor=%23FF4655&labelColor=%234169E1&color=%23FF4655&cacheSeconds=3600" alt="Watchers Badge"></a>
</p>
<p align="center">
    <img src="https://img.shields.io/badge/WeChat-spring_reading-%2307C160?logo=wechat" alt="Wechat Badge"/>
    <a href="https://blog.csdn.net/duzhuang2399"><img src="https://img.shields.io/badge/dynamic/xml?url=https%3A%2F%2Fblog.csdn.net%2Fduzhuang2399&query=%2F%2F*%5B%40id%3D%22userSkin%22%5D%2Fdiv%5B1%5D%2Fdiv%5B2%5D%2Fdiv%5B1%5D%2Fdiv%2Fdiv%5B2%5D%2Fdiv%5B1%5D%2Fdiv%5B1%5D%2Fdiv%5B2%5D%2Fspan&logo=C&logoColor=red&label=CSDN&color=red&cacheSeconds=3600" alt="CSDN Badge"></a>
</p>
<p align="center">
    ⚡ <a href="#技术">技术</a>
    |
    👋 <a href="#功能">功能</a>
    |
    🚀 <a href="#快速启动">快速启动</a>
    |
    ⚠️ <a href="#免责声明">免责声明</a>
    |
    ⛔️ <a href="#使用限制">使用限制</a>
    |
    ⛵ <a href="#欢迎贡献">欢迎贡献</a>
    |
    💻 <a href="#我的 GitHub 统计">统计</a>
    |
    👥 <a href="#加入我们">加入我们</a>
</p>


---

## ⚡技术

<div align="left">
    <img src="https://img.shields.io/badge/Java-8%2B-%23437291?logo=openjdk&logoColor=%23437291"/>
    <img src="https://img.shields.io/badge/Spring-5.3.10-%23437291?logo=Spring&logoColor=%236DB33F&color=%236DB33F"/>
    <img src="https://img.shields.io/badge/SpringBoot-2.5.5-%23437291?logo=SpringBoot&logoColor=%236DB33F&color=%236DB33F"/>
    <img src="https://img.shields.io/badge/JNA-5.8.0-%23437291?logo=JNA&logoColor=%23228B22&color=%23228B22"/>
    <img src="https://img.shields.io/badge/Hutool-5.8.16-%23437291?logo=JNA&logoColor=%23F08080&color=%23F08080"/>
    <img src="https://img.shields.io/badge/easyexcel-5.8.16-%23437291?logo=JNA&logoColor=%23D2691E&color=%23D2691E"/>
    <img src="https://img.shields.io/badge/protobuf-3.25.1-%23437291?logo=JNA&logoColor=%23800080&color=%23800080"/>
    <img src="https://img.shields.io/badge/mapstruct-1.4.2-%23437291?logo=JNA&logoColor=%23DC143C&color=%23DC143C"/>
    <img src="https://img.shields.io/badge/druid-1.2.20-%23437291?logo=JNA&logoColor=%23C71585&color=%23C71585"/>
    <img src="https://img.shields.io/badge/mybatisPlus-3.5.4.1-%23437291?logo=JNA&logoColor=%234B0082&color=%234B0082"/>
    <img src="https://img.shields.io/badge/sqlite-3.34.0-%23437291?logo=JNA&logoColor=%230000CD&color=%230000CD"/>
    <img src="https://img.shields.io/badge/lombok-1.18.20-%23437291?logo=JNA&logoColor=%23008B8B&color=%23008B8B"/>

</div>


## 👋功能

[点击此处查看功能展示](docs/display.md)

+ 获取当前登录微信的微信昵称、账号、手机号、邮箱、秘钥、微信Id、文件夹路径
+ 将微信PC的多个聊天记录数据库合并为单一数据库文件
+ 支持微信聊天对话窗口（文本消息，引用消息，图片消息，表情消息，卡片链接消息，系统消息，等）
+ 综合管理微信会话、联系人、群聊与朋友圈
+ 支持导出微信各类记录(聊天记录，联系人，群聊，等)
+ 查看历史朋友圈记录，超越三日限制，随时回看朋友圈历史
+ 展示好友数、群聊数及今日收发消息总量的微信统计功能
+ 过去15天内每日微信消息数量统计
+ 最近一个月内微信互动最频繁的前10位联系人
+ 展示微信消息类别占比图表
+ 展示微信最近使用的关键字词云图

### 🚀快速启动

**安装包方式部署**

- 点击下载 [wx-dump-4j-bin.tar.gz](https://github.com/xuchengsheng/wx-dump-4j/releases/download/v1.0.0/wx-dump-4j-bin.tar.gz)

- 解压缩 `wx-dump-4j-bin.tar.gz`，进入 bin 目录

- 双击`start.bat`启动文件

- 启动成功后访问：[http://localhost:8080](http://localhost:8080)

**源码方式部署**

+ 下载源码`git clone https://github.com/xuchengsheng/wx-dump-4j.git`

+ 安装后端依赖`cd wx-dump-4j & mvn clean install`

+ 使用开发工具启动 `com.xcs.wx.WxDumpApplication`

+ 安装前端依赖`cd wx-dump-ui & npm install`

+ 启动前端服务`npm run start`

+ 访问：[http://localhost:8000](http://localhost:8000)

### 📚实现原理

+ [微信SQLite数据库文件解密实现，基于HmacSHA1的安全解密算法](docs/decrypt.md)

### ⛔️使用限制

本软件仅适用于Windows操作系统。我们目前不支持macOS、Linux或其他操作系统。如果你在尝试在非Windows系统上运行本软件时可能遇到兼容性问题，这些问题可能导致软件无法正常运行或产生其他意外后果。

| 操作系统 | 支持情况     |
|:--------:|:----------:|
| Windows  | 支持   |
| macOS    | 不支持     |
| Linux    | 不支持    |

### ⚠️免责声明

本软件仅供技术研究和教育目的使用，旨在解密用户个人微信聊天记录。严禁将本软件用于任何非法目的，包括但不限于侵犯隐私权或非授权数据访问。作为软件开发者，我不对因使用或滥用本软件产生的任何形式的损失或损害承担责任。

## ⛵欢迎贡献！

如果你发现任何错误🔍或者有改进建议🛠️，欢迎提交 issue 或者 pull request。你的反馈📢对于我非常宝贵💎！

## 💻我的 GitHub 统计

[![Star History Chart](https://api.star-history.com/svg?repos=xuchengsheng/wx-dump-4j&type=Date)](https://star-history.com/#xuchengsheng/wx-dump-4j&Date)

## 🍱请我吃盒饭？

作者晚上还要写博客✍️,平时还需要工作💼,如果帮到了你可以请作者吃个盒饭🥡
<div>
<img alt="logo" src="image/WeChatPay.png" style="width: 280px;height: 300px">
<img alt="logo" src="image/Alipay.png" style="width: 280px;height: 300px">
</div>



## 👥扫码关注微信公众号

关注后，回复关键字 “加群”，即可加入我们的技术交流群，与更多开发者一起交流学习。

<div>
<img alt="logo" src="image/wechat-mp.png">
</div>