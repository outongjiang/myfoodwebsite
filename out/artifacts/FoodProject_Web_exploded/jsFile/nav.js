
$(function(){
    $("li:not('.user')").click(function(){
        $(this).addClass("active").siblings().removeClass("active");
    })
    $(".font").css("font-size","15px");
    $(".font").css("color","black");
    $(".font").css("font-weight","bold");
    $(".user").css("margin-left","1000px");

})
