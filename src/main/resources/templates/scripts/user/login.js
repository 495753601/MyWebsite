$(document).ready(function(){
    $("#button_login").click(function(){
        var userName = $("#userName").val();
        var password = $("#password").val();
        if(userName == "" || userName == null){
            alert("请输入账号");
        }else if(password == "" || password == null){
            alert("请输入密码");
        }else {
            $.ajax({
                //请求方式
                type : "POST",
                //请求的媒体类型
                contentType: "application/json;charset=UTF-8",
                //请求地址
                url : "http://localhost:8080/mow/user/login",
                //数据，json字符串
                data : JSON.stringify({"userName":$("#userName").val(),"password":$("#password").val()}),
                //数据类型
                dataType: "json",
                //请求成功
                success : function(result) {
                     console.log(result);
                    //alert("提交成功"+JSON.stringify(result));
                    if(result.code == 0){
                        window.location.href = "index.html";
                        sessionStorage.setItem("token", result.data.token);
                    }else{
                        alert(result.msg);
                    }
                },
                //请求失败，包含具体的错误信息
                error : function(e){
                    console.log(e.status);
                    console.log(e.responseText);
                }
            });
        }

        
    });

    $("body").keydown(function() {
        if (event.keyCode == "13") {//keyCode=13是回车键
            $('#button_login').click();
        }
    });

    $("#button_reset").click(function(){
        window.location.href = "register.html"
    });
});