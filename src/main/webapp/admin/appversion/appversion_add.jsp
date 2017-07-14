<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>Title</title>
    <link rel="stylesheet" href="res/bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="res/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="res/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="res/js/global.js"></script>
    <script type="text/javascript" src="res/js/ajaxupload.js"></script>
    <link rel="stylesheet" type="text/css" href="res/uploadify/uploadify.css">
    <script type="text/javascript" src="res/uploadify/jquery.uploadify.min.js"></script>
    <script type="text/javascript">
        $(function() {
            $('#file_upload')
                .uploadify(
                    {
                        'swf' : 'res/uploadify/uploadify.swf',
                        'uploader' : '${pageContext.request.contextPath }/uploadFile.shtml',
                        //将要上传的文件对象的名称 必须与后台controller中抓取的文件名保持一致
                        'fileObjName' : 'myfile',
                        //在浏览窗口底部的文件类型下拉菜单中显示的文本
                        'fileTypeDesc' : '支持的格式：',
                        //允许上传的文件后缀
                        'fileTypeExts' : '*.*',
                        'onUploadSuccess' : function(file, data, response) {
                            $(".upload_msg").html("上传成功,路径为："+"upload/" + file.name);
                            $("#subUrl").val("uploadFiles/" + file.name);
                        },
                        'onUploadComplete' : function() {
                        }
                    });
        });
    </script>

</head>
<body>
<div class="container">
    <form class="form-horizontal">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">版本号</label>
            <div class="col-sm-10">
                V<input type="email" class="form-control" id="inputEmail3" placeholder="Email">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">APK文件</label>
            <div class="col-sm-10">
                <input type="file" name="file_upload" id="file_upload"><span class="upload_msg"></span>
                <input type="hidden" id="subUrl">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10 text-right">
                <button type="submit" class="btn btn-default">Sign in</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
