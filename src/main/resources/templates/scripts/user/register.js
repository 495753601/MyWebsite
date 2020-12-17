$(document).ready(function(){
    $("#submit").click(function(){
        var userName = $("#userName").val();
        var password = $("#password").val();
        var surePassword = $("#surePassword").val();
        var nickName = $("#nickName").val();
        var sex = $("input[name='sex']:checked").val();
        var birthday = $("#birthday").val();
        var email = $("#email").val();
        var introduceText = $("#introduceText").val();

        if(userName == ""){
            alert("请输入账号");
            return false;
        }else if(userName.length < 6){
            alert("账号小于6位");
            return false;
        }else if(userName.length > 12){
            alert("账号大于12位");
            return false;
        }
        if(nickName.length > 7){
            alert("昵称不能大于7位")
            return false;
        }

        if(password != surePassword){
            alert("密码不一致");
            return false;
        }

        $.ajax({
            //请求方式
            type : "POST",
            //请求的媒体类型
            contentType: "application/json;charset=UTF-8",
            //请求地址
            url : "http://localhost:8080/mow/user/regiest",
            //超时
            timeout: 30000,
            //数据，json字符串
            data : JSON.stringify({
                "userName":userName,
                "password":password,
                "surePassword":surePassword,
                "nickName":nickName,
                "sex":sex,
                "birthday":birthday,
                "email":email,
                "introduceText":introduceText
            }),
            //数据类型
            dataType: "json",
            
            beforeSend: function () {
                // 禁用按钮防止重复提交
                $("#submit").attr({ disabled: "disabled" });
            },
            //请求成功
            success : function(result) {
                console.log(result);
                //window.alert("正在提交");
                if(result.code == 0){
                    window.location.href = "../../login.html";
                }else{
                    alert(result.msg);
                }
            },
            //如果请求未成功，移除按钮失效
            complete: function () {
                $("#submit").removeAttr("disabled");
            },
            //请求失败，包含具体的错误信息
            error : function(e){
                console.log(e.status);
                console.log(e.responseText);
            }
        });
    });

    $("body").keydown(function() {
        if (event.keyCode == "13") {//keyCode=13是回车键
            $('#submit').click();
        }
    });
    
});