<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="${pageContext.request.contextPath}/">
    <meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" href="res/DigitalOA/css/style.css" />
    <link rel="stylesheet" href="res/DigitalOA/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="res/DigitalOA/css/skin_/nav.css" />
    <script type="text/javascript" src="res/DigitalOA/js/jquery.js"></script>
    <script type="text/javascript" src="res/DigitalOA/js/global.js"></script>
    <title>left</title>
</head>

<body>
<div id="container">
    <div id="bd">
        <div class="sidebar">
            <div class="sidebar-bg"></div>
            <i class="sidebar-hide"></i>
            <h2><a href="javascript:;"><i class="h2-icon"></i><span>菜单</span></a></h2>
            <ul class="nav">
                <li class="nav-li current">
                    <a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">我的主页</span></a>
                    <ul class="subnav">
                        <li class="subnav-li current" href="home.shtml" data-id="1"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">我的主页</span></a></li>
                       <%-- <li class="subnav-li" href="form.html" data-id="9"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">新闻频道管理</span></a></li>
                        <li class="subnav-li" href="table.html" data-id="10"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">地方新闻管理</span></a></li>
                        <li class="subnav-li" data-id="11"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">自定义设置1</span></a></li>--%>
                    </ul>
                </li>
                <li class="nav-li">
                    <a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">用户管理</span></a>
                    <ul class="subnav">
                        <li class="subnav-li" href="index.html" data-id="8"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">用户列表</span></a></li>
<%--                        <li class="subnav-li" href="form.html" data-id="2"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">表单</span></a></li>
                        <li class="subnav-li" href="table.html" data-id="3"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">表格</span></a></li>
                        <li class="subnav-li" data-id="4"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">自定义设置2</span></a></li>--%>
                    </ul>
                </li>
                <li class="nav-li">
                    <a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">日志管理</span></a>
                    <ul class="subnav">
                        <li class="subnav-li" href="admin/notepad/getNotePads.shtml" data-id="2"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">日志列表</span></a></li>
                        <li class="subnav-li" href="admin/notepad/getNotePads.shtml" data-id="4"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">新增日志</span></a></li>
                        <%--                        <li class="subnav-li" href="form.html" data-id="2"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">表单</span></a></li>
                                                <li class="subnav-li" href="table.html" data-id="3"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">表格</span></a></li>
                                                <li class="subnav-li" data-id="4"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">自定义设置2</span></a></li>--%>
                    </ul>
                </li>
                <li class="nav-li">
                    <a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">内部邮箱</span></a>
                    <ul class="subnav">
                        <li class="subnav-li" data-id="5"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">写邮件</span></a></li>
                        <li class="subnav-li" data-id="6"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">收件箱</span></a></li>
                        <li class="subnav-li" data-id="16"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">草稿箱</span></a></li>
                        <li class="subnav-li" data-id="17"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">已发送</span></a></li>
                        <li class="subnav-li" data-id="18"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">已删除</span></a></li>
                        <li class="subnav-li" data-id="19"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">垃圾箱</span></a></li>
                    </ul>
                </li>
                <li class="nav-li last-nav-li">
                    <a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">系统管理</span></a>
                    <ul class="subnav">
                        <li class="subnav-li" href="admin/appversion/getAppVersionAll.shtml" data-id="13"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">App版本管理</span></a></li>
                        <li class="subnav-li" href="admin/actionlog/getActionLog.shtml" data-id="14"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">系统操作日志</span></a></li>
                        <li class="subnav-li" data-id="15"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">反馈意见</span></a></li>
                    </ul>
                </li>
            </ul>
            <div class="tree-list outwindow">
                <div class="tree ztree"></div>
            </div>
        </div>
        <div class="main">
            <div class="title">
                <i class="sidebar-show"></i>
                <ul class="tab ue-clear">

                </ul>
                <i class="tab-more"></i>
                <i class="tab-close"></i>
            </div>
            <div class="content">
            </div>
        </div>
    </div>
</div>

<div class="more-bab-list">
    <ul></ul>
    <div class="opt-panel-ml"></div>
    <div class="opt-panel-mr"></div>
    <div class="opt-panel-bc"></div>
    <div class="opt-panel-br"></div>
    <div class="opt-panel-bl"></div>
</div>
</body>
<script type="text/javascript" src="res/DigitalOA/js/nav.js"></script>
<script type="text/javascript" src="res/DigitalOA/js/Menu.js"></script>
<script type="text/javascript" src="res/DigitalOA/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">
    var menu = new Menu({
        defaultSelect: $('.nav').find('li[data-id="1"]')
    });



    $('.sidebar h2').click(function(e) {
        $('.tree-list').toggleClass('outwindow');
    });

    $(document).click(function(e) {
        if(!$(e.target).is('.tab-more')){
            $('.tab-more').removeClass('active');
            $('.more-bab-list').hide();
        }
    });
</script>
</html>
