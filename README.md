# 农民接力棒

## 环境准备

### 安装VirtualBox
VirtualBox是一个虚拟机软件，下载地址见[这里][virtual-box-download]，根据自己的系统下载相对应的安装文件然后进行安装，安装VirtualBox是为了启动后面的Vagrant虚拟机。  
  
### 安装Vagrant
Vagrant是一个虚拟机管理工具，使用它可以很方便地管理虚拟机，下载地址见[这里][vagrant-box-download]，根据提示进行安装即可。  

#### Vagrant命令介绍
* vagrant box add: 添加box文件到本机环境中。
* vagrant box list: 显示所有的box。
* vagrant up: 启动虚拟机。
* vagrant halt: 关闭虚拟机。
* vagrant destroy: 销毁虚拟机。
* vagrant status: 显示虚拟机状态。
* vagrant ssh \[vm\]: ssh到虚拟机。

### 安装Git
如果操作系统是Linux环境，请执行以下命令:  
  
```shell
// CentOS或Redhat系统
$ sudo yum install git 
// Ubuntu或Debian系统
$ sudo apt-get install git
```
  
如果是Windows系统，请到这里[下载][git-download]安装文件进行安装。  

#### git命令介绍
  
* git init . : 初始化工程为git工程。
* git add . : 添加文件到git版本管理中。
* git commit -m ‘commit message’ : 提交修改到本地代码库。
* git push : 将本地修改内容推送到服务器。
* git pull : 从服务器拉代码到本地，如果有冲突会自动合并。
  
### 安装Gradle
到[Gradle网站][gradle-download]下载压缩包，解压后将`解压目录/bin`添加环境变量PATH中，这样Gradle就安装完了。    
  
## 安装步骤

### 下载项目工程
  
```shell
git clone https://farmer-dev1@bitbucket.org/farmer-dev1/pebms.git
```
  
### 安装DB环境
  
* 下载box文件: [这里][box-download]
* **进到工程目录**，执行以下命令。
  
```shell
$ vagrant box add --name pebms box.file.path(刚下载的box文件路径)    
$ vagrant up
```
  
`请注意，vagrant box add 可以在工程目录外，vagrant up必须在工程目录内执行`  
  
* 环境验证，在浏览器中输入`http://192.168.36.10/phpmyadmin/`，用户名密码为: `farmer/farmer`，成功的话登陆可以进到我们搭建好的DB环境。  
  
### 初始化工程

* 进到工程目录，执行以下命令获得工程文件，然后就可以通过IDE加载工程文件了。

```shell
$ gradle eclipse //如果你用eclipse，可以使用这个命令得到eclipse工程文件
$ gradle idea //如果你用Intellij IDEA，可以使用这个命令得到IDEA工程文件
```
  
* 运行应用: `$ gradle clean jettyrun`，执行命令之后，在浏览器中打开`http://localhost:9898/pebms`就访问应用了。    
* 打包: `$ gradle clean build`, 执行命令后在`build/libs`目录下可以看到war文件。  
  
## 其他资源
**[Semantic UI][semantic-ui]**   
**[Vagrant][vagrant]**  
**[Gradle][gradle]**  
**[Vagrant][vagrant]**  
**[Angular JS][angular-js]**  
**[Git][git]**  

[virtual-box-download]: https://www.virtualbox.org/wiki/Downloads
[vagrant-box-download]: https://www.vagrantup.com/downloads.html
[git-download]: http://git-scm.com/download/win
[gradle-download]: https://services.gradle.org/distributions/gradle-2.1-all.zip
[box-download]: http://pan.baidu.com/s/1dDiYNsd
[semantic-ui]: http://semantic-ui.com/
[gradle]: http://www.gradle.org/
[vagrant]: https://www.vagrantup.com/
[angular-js]: https://angularjs.org/
[git]: http://git-scm.com/