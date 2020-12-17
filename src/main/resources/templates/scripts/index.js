$(document).ready(function(){
    var token = sessionStorage.getItem("token");
        if(token == "" || token == null){
            $("#user_one").append("登陆");
            $("#user_one").attr("href","../login.html");
            $("#user_two").append("注册");
            $("#user_two").attr("href","../register.html");
            $("#user_portrait").attr("src","../images/two.jpg");
            $("#user_name").append("未登录");
        }else {
            $.ajax({
                //请求方式
                type : "POST",
                headers: {
                    Accept: "application/json;charset=utf-8",
                    token: "" + token
                },
                //请求的媒体类型
                contentType: "application/json;charset=UTF-8",
                //请求地址
                url : "http://localhost:8080/mow/user/queryUserMsg",
                //数据，json字符串
                data : JSON.stringify(),
                //数据类型
                dataType: "json",
                //请求成功
                success : function(result) {
                    console.log(result);
                    //alert("提交成功"+JSON.stringify(result));
                    $("#user_one").append("用户设置");
                    $("#user_one").attr("href","");
                    $("#user_two").append("我的收藏");
                    $("#user_two").attr("href","");
                    $("#user_three").append("登出");
                    $("#user_three").attr("href","../register.html");
                    $("#user_portrait").attr("src",result.data.icon);
                    $("#user_name").append(result.data.nickName);
                },
                //请求失败，包含具体的错误信息
                error : function(e){
                    console.log(e.status);
                    console.log(e.responseText);
                }
            });
        }
});