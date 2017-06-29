/**
 * Created by Administrator on 2017/6/28.
 */
$(function () {
    $('.loginButton').click(function(e) {
        if($("#account").val()==""){
            layer.msg("请输入用户名");
        }else if($("#pwd").val()==""){
            layer.msg("请输入密码");
        }else if($("#code").val()==""){
            layer.msg("请输入验证码");
        }else{
            layer.load(2);
            var data={"adLoginname":$("#account").val(),"adPwd":$("#pwd").val(),"adName":$("#code").val()};
            $.ajax({
                type:"POST",
                url:"admin/admin_login.shtml",
                dataType:"json",
                contentType:"application/json",
                data:JSON.stringify(data),
                success:function(data1){
                    layer.closeAll('loading');
                    var obj = eval(data1);
                    if(obj.code!="10000"){
                        layer.msg(obj.description);
                    }else{
                        layer.msg(obj.description);
                        setTimeout("location.href='index.shtml'", 1500);
                    }
                }
            });
        }
    });

    $(".exit").click(function(e){
        layer.confirm('你确定要退出系统？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            location.href="logout.shtml";
        }, function(){
            //取消
        });
    });
});