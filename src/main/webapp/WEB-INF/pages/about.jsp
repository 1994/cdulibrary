<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>关于这个项目</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link rel="shorticon icon" type="image/x-icon" href="http://1994.github.com/favicon.ico?v=0.4.2">
    <style>
        .mail {
            height: 550px;
            /*margin-left: 100px;*/
        }

        .center {
            width: auto;
            display: table;
            margin-left: auto;
            margin-right: auto;
        }

        .text-center {
            text-align: center;
        }

        * {
            font-family: "Helvetica Neue", Helvetica, "Segoe UI", Ubuntu, "Hiragino Sans GB", "Microsoft YaHei", "WenQuanYi Micro Hei", sans-serif;
        }

        html,
        body {
            height: 100%;
        }

        #wrap {
            min-height: 100%;
            height: auto !important;
            height: 100%;
            margin: 0 auto -60px;
        }

        #footer {
            height: 60px;
        }

        #footer {
            background-color: #f5f5f5;
        }

        @media (max-width: 767px) {
            #footer {
                margin-left: -20px;
                margin-right: -20px;
                padding-left: 20px;
                padding-right: 20px;
            }
        }

        #footer .container {
            width: auto;
            max-width: 680px;
        }

        #footer_text {
            margin-top: 20px;

        }

    </style>
</head>
<body>

    <nav class="navbar navbar-inverse">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="http://reecoblog.info">我的博客</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">关于</a></li>
                <li><a href="/">首页</a></li>
            </ul>
        </div>
    </nav>

    <div class="container">

        <div class="row">
            <div class="col-md-12">
                <h3>#这是一个什么网站</h3>
                <hr>
                <p>这个网站是我在业余时间独立完成并维护的，目前完成了几下功能：</p>

                <h4>基本功能：</h4>

                <p>输入图书馆账号能查看到当前借阅的书籍，仅限成都大学在读学生账号登陆，借助于<code>bootstrap</code>，能够很好为不同的设备提供相同的浏览体验。<br>一图胜千言：<br><img
                        src="http://7xawrk.com1.z0.glb.clouddn.com/CDUlibrary_01.png" class="img-responsive"></p>

                <br>
                <h4>提醒功能：</h4>

                <p>需要填写邮箱后方可使用，填写成功之后会收到一封大致这样的测试邮件，目前未做修改账号等相关个人功能，所以提交邮箱前请确认。邮箱只需注册一次，以后程序会每天自动帮你同步借书的信息。

                    <br>

                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
                            <div align="center">
                                <img class="mail" src="http://7xawrk.com1.z0.glb.clouddn.com/CDUlibrary_mail1.png"
                                     class="img-responsive center">

                            </div>
                        </div>
                        <div class="col-md-6">
                            <div align="center">
                                <img class="mail" src="http://7xawrk.com1.z0.glb.clouddn.com/CDUlibrary_mail2.png"
                                     class="img-responsive center">
                            </div>
                        </div>
                    </div>
                </div>
                </p>
                <p>提醒邮件如上面有图所示，在邮件的平台适应性上我下了很大功夫，目前已经适应了绝大部分的邮件客户端。另外不要问我为什么那么难看</p>
                <br>

                <h3>#为什么不推荐使用QQ邮箱</h3>
                <hr>
                <p>简单而言，使用QQ邮箱你很有可能收不到提醒的邮件，如果你有兴趣想听详细解释的话，往下看：<br>目前我使用了<code>SendCloud</code>和<code>Mailgun</code>两家免费的邮件服务提供商。在系统划分上，我采用了<code>SendCloud</code>发送QQ邮箱，<code>Mailgun</code>发送非QQ邮箱的策略。但是<code>SendCloud</code>五一放假了，迟迟不审核我提交的邮件样本，所以我只好用<code>Mailgun</code>先扛着，<code>Mailgun</code>是国外的一家提供商，加上QQ邮箱非常牛逼的反垃圾邮件系统，<code>Mailgun</code>发的很多邮件不是进了垃圾箱就是彻底没收到。
                </p>
                <br>

                <h3>#是否还有除了邮件之外的通知方式</h3>
                <hr>
                <p>目前来说没有，使用邮箱作为提醒方式的原因是邮箱服务有免费而且可靠的提供商。我建议各位在手机上装一个邮箱客户端并开启提醒功能。<br>我不知道这个程序有多少人会需要，如果用户上来的话会在后续版本中考虑加入短信功能，短信功能开发起来其实没什么难度，唯一的障碍是钱，成熟的短信平台大概6分一条。我能想到的最好方案是学校的公众微信账号能够加入这一功能。
                </p>

                <br>

                <h3>#最多支持多少人用户</h3>
                <hr>
                <p>目前程序的瓶颈来源于以下两点，</p>
                <ul>
                    <li>学校图书馆的服务器：我不知道学校的服务器能抗下多少的请求，也不知道学校的服务器是否有针对同一IP的防御措施（目测是没有的），具体也没办法测试，目前我采用的查询策略是多线程加每隔5秒的阻塞队列。
                    </li>
                    <li>免费邮件：Mailgun每个月免费额度为10000封，SendCloudm每个月免费额度为4800封。</li>
                </ul>
                <br>

                <h3>#感谢</h3>
                <hr>
                <p>这个项目使用了以下免费资源或者服务，在此表示由衷的感谢</p>
                <ul>
                    <li><a href="http://jodd.org/">Jodd</a></li>
                    <li><a href="https://spring.io/">Spring</a> <span>PS：对<code>Spring</code>有兴趣的同学，欢迎加入<a
                            href="http://git.oschina.net/free/spring-framework-reference">Spring文档翻译项目</a></span></li>
                    <li><a href="http://www.mailgun.com/">Mailgun</a></li>
                    <li><a href="https://sendcloud.sohu.com/">SendCloud</a></li>
                    <li><a href="http://getbootstrap.com/">bootstrap</a></li>
                    <li><a href="http://www.qiniu.com/">QINIU</a></li>
                </ul>

                <br>
                <h3>#暂时只想到那么多，以后填坑</h3>

            </div>
        </div>
    </div>

</div>


<div id="footer">
    <div class="container">
        <div align="center">
            <p id="footer_text" class="credit">没个footer显得很不专业的样子，但又不知道放什么好</p>
        </div>
    </div>
</div>

</body>
</html>
