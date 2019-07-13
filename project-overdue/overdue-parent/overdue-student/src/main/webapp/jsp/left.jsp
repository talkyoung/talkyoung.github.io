<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>学生积欠系统 ——后台管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="This is my page"/>
    <link href="${ctx}/css/css.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
    <script language="javascript" type="text/javascript">
        $(function () {
            /** 给左侧功能菜单绑定点击事件  */
            $("td[id^='navbg']").click(function () {
                /** 获取一级菜单的id */
                var navbgId = this.id;
                /** 获取对应的二级菜单id */
                var submenuId = navbgId.replace('navbg', 'submenu');
                /** 控制二级菜单显示或隐藏  */
                $("#" + submenuId).toggle();
                /** 控制关闭或者开启的图标*/
                $("#" + navbgId).toggleClass("left_nav_expand");

                /** 控制其他的一级菜单的二级菜单隐藏按钮都关闭  */
                $("tr[id^='submenu']").not("#" + submenuId).hide();
                /** 控制其他一级菜单的图片显示关闭  */
                $("td[id^='navbg']").not(this).removeClass().addClass("left_nav_closed");


            })
        })
    </script>
</head>
<body>
<div style="margin:10px;background-color:#FFFFFF; text-align:left;">
    <table width="200" height="100%" border="0" cellpadding="0" cellspacing="0" class="left_nav_bg">
        <tr>
            <td class="left_nav_top">
                <div class="font1">学生界面</div>
            </td>
        </tr>
        <tr valign="top">
            <td class="left_nav_bgshw" height="50">
                <p class="left_nav_link"><img src="${ctx}/images/left_nav_arrow.gif">&nbsp;&nbsp;<a
                        href="/admin/showVideo.html" target="main">视频学习区域</a></p>
                <p class="left_nav_link"><img src="${ctx}/images/left_nav_arrow.gif">&nbsp;&nbsp;<a
                        href="/admin/showFile.html" target="main">文件学习区域</a></p>
                <p class="left_nav_link"><img src="${ctx}/images/left_nav_arrow.gif">&nbsp;&nbsp;<a
                        href="/admin/comments.html" target="main">留言模块</a></p>
            </td>
        </tr>



        <tr valign="top">
            <td height="100%" align="center">
                <div class="copycct"><br/><strong>技术支持：</strong><br><strong>三江学院&计算机学院</strong><br>Http://www.sju.edu.cn
                </div>
            </td>
        </tr>
        <tr>
            <td height="10"><img src="${ctx}/images/left_nav_bottom.gif" height="10"></img></td>
        </tr>
        <tr>
            <td height="10" bgcolor="#e5f0ff">&nbsp;</td>
        </tr>
    </table>
</div>
</body>
</html>