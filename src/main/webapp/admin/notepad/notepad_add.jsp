<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="${pageContext.request.contextPath}/">
    <meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="res/DigitalOA/css/style.css" />
    <link rel="stylesheet" type="text/css" href="res/DigitalOA/css/WdatePicker.css" />
    <link rel="stylesheet" type="text/css" href="res/DigitalOA/css/skin_/form.css" />
    <script type="text/javascript" src="res/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="res/js/global.js"></script>
    <title>新增日志</title>
    <script charset="utf-8" src="res/kindeditor/kindeditor.js"></script>
    <link rel="stylesheet" href="res/kindeditor/themes/default/default.css" />
    <script charset="utf-8" src="res/kindeditor/kindeditor-min.js"></script>
    <script charset="utf-8" src="res/kindeditor/lang/zh_CN.js"></script>
    <script>
        KindEditor.ready(function(K) {
            K.create('textarea[name="content"]', {
                autoHeightMode : true,
                resizeType:0,
                afterCreate : function() {
                    this.loadPlugin('autoheight');
                },
                cssPath : 'res/kindeditor/plugins/code/prettify.css',
                uploadJson : 'res/kindeditor/jsp/upload_json.jsp',
                fileManagerJson : 'res/kindeditor/jsp/file_manager_json.jsp',
            });
        });

        KindEditor.ready(function(K) {
            var editor = K.editor({
                allowFileManager : true
            });
            K('#insertfile').click(function() {
                editor.loadPlugin('insertfile', function() {
                    editor.plugin.fileDialog({
                        fileUrl : K('#url').val(),
                        UploadJson: 'res/kindeditor/jsp/upload_json.jsp',
                        fileManagerJson : 'res/kindeditor/jsp/file_manager_json.jsp',
                        allowFileManager : true,
                        clickFn : function(url, title) {
                            K('#url').val(url);
                            editor.hideDialog();
                        }
                    });
                });
            });
        });
    </script>
</head>
<body>
<div id="container">
    <div id="hd">
    </div>
    <div id="bd">
        <div id="main">
            <h2 class="subfild">
                <span>日志信息</span>
            </h2>
            <div class="subfild-content base-info">
                <div class="kv-item ue-clear">
                    <label><span class="impInfo">*</span>标题</label>
                    <div class="kv-item-content">
                        <input type="text" placeholder="标题" />
                    </div>
                </div>
                <div class="kv-item ue-clear">
                    <label><span class="impInfo">*</span>文章内容</label>
                    <div class="kv-item-content">
                        <textarea placeholder="文章内容" name="content" id="content" style="width:800px;height:240px;"></textarea>
                    </div>
                </div>
                <div class="buttons">
                    <input class="button" type="button" value="确认添加" />
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

