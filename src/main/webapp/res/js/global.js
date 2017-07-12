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
                    console.log(data1);
                    layer.closeAll('loading');
                    var obj = eval(data1);
                    if(obj.code!=100){
                        layer.msg(obj.msg);
                    }else{
                        layer.msg(obj.msg);
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

function preview(npId) {
    layer.open({
        type: 2,
        title:"预览",
        area: ['800px', '600px'],
        fixed: false, //不固定
        maxmin: true,
        content: 'admin/notepad/showNotePad.shtml?npId='+npId
    });
}