## wx-dump-4j启动助手

---

### 环境准备

##### 环境要求

​    1.JDK 11+
​    2.Node.js 18+
​    3.Maven 3.5.0+

##### 安装帮助

###### 1.JDK

&emsp;&emsp;1.1 安装指南：https://blog.csdn.net/ACE_U_005A/article/details/114840497
&emsp;&emsp;1.2 确认JDK版本
&emsp;&emsp;&emsp;a. windows+R 打开搜索框
&emsp;&emsp;&emsp;b. 输入cmd命令，回车
&emsp;&emsp;&emsp;c.输入命令java -version,回车（注：java后的空格不可以省略）
&emsp;&emsp;1.3 JDK版本切换
&emsp;&emsp;&emsp;若之前使用的JDK版本不是11+，下载JDK11+后需要切换JDK版本至11+。
&emsp;&emsp;&emsp;具体操作指南：https://blog.csdn.net/qq_40543170/article/details/88391838
    

    提示：命令行显示是JDK11+后才能正常使用平台，之前安装版本不足11+的需要重新安装新版本并进行JDK版本切换！！

###### 2.Node.js

&emsp;&emsp;2.1 安装指南：https://blog.csdn.net/WHF__/article/details/129362462

​	提示：若后续需要本地部署，Node.js版本不能选择19.x.x版本以及15.x.x版本(最好选择14.x.x版本本地部署不会报错) 

###### 3.Maven

&emsp;3.1 Maven软件的下载
&emsp;&emsp;maven官网（http://maven.apache.org/download.cgi）下载maven安装软件。

![在这里插入图片描述](https://i-blog.csdnimg.cn/blog_migrate/e8ec0f6ebddf22a93389013cfd2cc1a3.jpeg)

&emsp;&emsp;或使用百度网盘进行下载
&emsp;&emsp;链接：https://pan.baidu.com/s/12SuxtOXiUhNgkb0DH1eyCw
&emsp;&emsp;提取码：gnaf

&emsp;3.2. Maven软件的安装
&emsp;&emsp;Maven 下载完成后，将 Maven 解压到一个**没有中文没有空格**的路径下

&emsp;3.3. Maven环境变量配置
	配置 MAVEN_HOME ，变量值就是你的 maven 安装的路径（bin 目录之前一级目录）

![在这里插入图片描述](https://i-blog.csdnimg.cn/blog_migrate/5725ba0f4d6bbda4b2258908b89bfb30.jpeg) 
	将MAVEN_HOME 添加到Path系统变量，“系统变量”->"path"->"编辑"->"新建"->

![在这里插入图片描述](https://i-blog.csdnimg.cn/blog_migrate/ccabf8a831c9dd07dae9f920c8732e9f.jpeg)

4. Maven 软件版本测试
   win+R 打开dos窗口，通过 mvn -v命令检查 maven 是否安装成功，看到 maven 的版本为 3.6.3 及 java 版本为 jdk-11 即为安装 成功。 打开命令行，输入 mvn –v命令，如下图： 

   ![在这里插入图片描述](https://i-blog.csdnimg.cn/blog_migrate/253e413d621504a65a00c763ca37ab2f.jpeg)

以上操作即可完成本平台所需的maven配置，更多信息详见原文链接：https://blog.csdn.net/u012660464/article/details/114113349



### 二进制部署

- 点击下载最新版 [wx-dump-4j-bin.tar.gz](https://github.com/xuchengsheng/wx-dump-4j/releases/download/v1.1.0/wx-dump-4j-bin.tar.gz)。
- 解压缩 `wx-dump-4j-bin.tar.gz` 文件，并进入 `bin` 目录。
- 双击 `start.bat` 启动文件。
- 启动成功后，在浏览器中访问 [http://localhost:8080](http://localhost:8080/) 以查看应用。



### 常见报错

1. java.lang.UnsupportedClassVersionError

 	问题：JDK版本不正确

​	解决方法：切换JDK版本，详见1.3内容
