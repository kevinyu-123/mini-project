let user_func = {
    init:function(){
        $("#btn-save").on("click",()=>{
            this.save();
        });
        $("#btn-check-email").on("click",()=>{
            this.check_email();
        })
    },

    save:function (){
        let data = {
            email: $("#email").val(),
            password: $("#password").val()
        }
        $.ajax({
            type: "post",
            url: "/user",
            data: JSON.stringify(data), //http body 데이터
            contentType: "application/json; charset=utf-8", //body 데이터 타입
            dataType: "json",
        }).done (function(response){
            alert("회원가입 완료");
            location.href="/main";
        }).fail (function (error){
            alert("회원가입 에러");
        });
    },


    check_email:function(){
        let email = $("#email").val();

        $.ajax({
            type: "post",
            url: "/user/check/"+email,
            dataType : "json",
            contentType : "application/json; charset=utf-8",
        }).done (function (response){
            console.log(response);
            if(response.status == 500){
                $("#val").text("회원가입 가능");
            }else{
                $("#val").text("회원가입 불가능");
            }
        }).fail (function(error){
            alert(JSON.stringify(error));

        });
    }
}
user_func.init();