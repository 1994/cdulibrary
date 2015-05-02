# cdulibrary
成都大学图书提醒服务
目前运行在http://cdulibrary.aliapp.com/

##这是一个什么网站
这个网站是我在业余时间独立完成并维护的，目前完成了几下功能：

基本功能：

输入图书馆账号能查看到当前借阅的书籍，仅限成都大学在读学生账号登陆，借助于bootstrap，能够很好为不同的设备提供相同的浏览体验。
一图胜千言：
![](http://7xawrk.com1.z0.glb.clouddn.com/CDUlibrary_01.png)
提醒功能：

需要填写邮箱后方可使用，填写成功之后会收到一封大致这样的测试邮件，目前未做修改账号等相关个人功能，所以提交邮箱前请确认。邮箱只需注册一次，以后程序会每天自动帮你同步借书的信息。
 
![](http://7xawrk.com1.z0.glb.clouddn.com/CDUlibrary_mail1.png)

提醒邮件如下面有图所示，在邮件的平台适应性上我下了很大功夫，目前已经适应了绝大部分的邮件客户端。另外不要问我为什么那么难看


![](http://7xawrk.com1.z0.glb.clouddn.com/CDUlibrary_mail2.png)

##是否还有除了邮件之外的通知方式
目前来说没有，使用邮箱作为提醒方式的原因是邮箱服务有免费而且可靠的提供商。我建议各位在手机上装一个邮箱客户端并开启提醒功能。
我不知道这个程序有多少人会需要，如果用户上来的话会在后续版本中考虑加入短信功能，短信功能开发起来其实没什么难度，唯一的障碍是钱，成熟的短信平台大概6分一条。我能想到的最好方案是学校的公众微信账号能够加入这一功能。

##感谢
这个项目使用了以下免费资源或者服务，在此表示由衷的感谢
 - Jodd
 - Spring
 - Mailgun
 - SendCloud
 - fastjson
 - druid
 - QINIU

##暂时只想到那么多，以后填坑