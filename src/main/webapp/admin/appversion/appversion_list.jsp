<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="res/DigitalOA/css/style.css" />
    <link rel="stylesheet" type="text/css" href="res/DigitalOA/css/WdatePicker.css" />
    <link rel="stylesheet" type="text/css" href="res/DigitalOA/css/skin_/table.css" />
    <link rel="stylesheet" type="text/css" href="res/DigitalOA/css/jquery.grid.css" />
    <link rel="stylesheet" href="res/bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="res/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="res/layer/layer.js"></script>
    <script type="text/javascript" src="res/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="res/js/global.js"></script>
    <title>日志列表</title>
</head>

<body>
<div id="container">
    <div id="hd"></div>
    <div id="bd">
        <div id="main">
            <div class="search-box ue-clear">
                <div class="search-area">
                    <div class="kv-item ue-clear">
                        <label>选择时间：</label>
                        <div class="kv-item-content ue-clear">
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">全部</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">近3天</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">近一周</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">近一月</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" data-define="define" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">自定义</span>
                            </span>
                            <span class="define-input">
                            	<input type="text" placeholder="开始时间" />
                                <span class="division"></span>
                                <input type="text" placeholder="结束时间" />
                            </span>
                        </div>
                    </div>
                </div>
                <div class="search-button">
                    <input class="button" type="button" value="搜索一下" />
                </div>
            </div>

            <div class="table">
                <div class="opt ue-clear">
                	<span class="sortarea">
                    	<span class="sort">
                        	<label>排序：</label>
                            <span class="name">
                            	<i class="icon"></i>
                                <span class="text">名称</span>
                            </span>
                        </span>

                        <i class="list"></i>
                        <i class="card"></i>
                    </span>
                    <span class="optarea">
                        <a href="javascript:;" class="add">
                            <i class="icon"></i>
                            <span class="text">添加</span>
                        </a>
                        <a href="javascript:;" class="delete">
                            <i class="icon"></i>
                            <span class="text">删除</span>
                        </a>

                        <a href="javascript:;" class="statistics">
                            <i class="icon"></i>
                            <span class="text">统计</span>
                        </a>

                        <a href="javascript:;" class="config">
                            <i class="icon"></i>
                            <span class="text">配置</span>
                        </a>
                    </span>
                </div>

                <div class="grid">
                    <table class="table table-hover table-bordered">
                        <thead>
                        <tr>
                            <th class="text-center"><input type="checkbox"/></th>
                            <th class="text-center">ID</th>
                            <th class="text-center">版本号</th>
                            <th class="text-center">强制升级</th>
                            <th class="text-center">下载地址</th>
                            <th class="text-center">发布日期</th>
                            <th class="text-center">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${page.list }" var="version">
                                <tr>
                                    <td class="text-center"><input type="checkbox"/></td>
                                    <td class="text-center">${version.avId}</td>
                                    <td class="text-center">${version.avCode}</td>
                                    <td class="text-center">
                                        <c:if test="${version.avForceUpdate ==0}"><font>否</font></c:if>
                                        <c:if test="${version.avForceUpdate ==1}"><font color="red">是</font></c:if>
                                    </td>
                                    <td class="text-center">
                                        ${version.avUrl}
                                    </td>
                                    <td class="text-center">
                                        <jsp:useBean id="dateValue" class="java.util.Date"/>
                                        <jsp:setProperty name="dateValue" property="time" value="${version.avPushDate}"/>
                                        <fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd HH:mm"/>
                                    </td>
                                    <td class="text-center">
                                        <button type="button" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-pencil"></span> 编辑</button>
                                        <button type="button" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span> 删除</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <nav aria-label="">
                        <ul class="pager">
                            <c:if test="${page.currentPage==1}">
                                <li class="disabled"><a href="javascript:;">首页</a></li>
                                <li class="disabled"><a href="javascript:;">上一页</a></li>
                            </c:if>
                            <c:if test="${page.currentPage!=1}">
                                <li><a href="admin/notepad/getNotePads.shtml?currentPage=1">首页</a></li>
                                <li><a href="admin/notepad/getNotePads.shtml?currentPage=${page.currentPage-1}">上一页</a></li>
                            </c:if>
                              &nbsp;&nbsp;当前 ${page.currentPage} / ${page.pageNum} 页&nbsp;&nbsp;
                            <c:if test="${page.currentPage==page.pageNum}">
                                <li class="disabled"><a href="javascript:;">下一页</a></li>
                                <li class="disabled"><a href="javascript:;">末页</a></li>
                            </c:if>
                            <c:if test="${page.currentPage!=page.pageNum}">
                                <li><a href="admin/notepad/getNotePads.shtml?currentPage=${page.currentPage+1}">下一页</a></li>
                                <li><a href="admin/notepad/getNotePads.shtml?currentPage=${page.pageNum}">末页</a></li>
                            </c:if>
                        </ul>
                    </nav>
                </div>

                <div class="pagination"></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

