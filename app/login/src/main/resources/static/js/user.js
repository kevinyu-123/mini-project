let user_func = {
    init:function(){
        $("#btn-save").on("click",()=>{
            this.save();
        });

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





}
user_func.init();