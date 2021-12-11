$(function () {
    var i=1;
    var animate;
    $("#checkCodeid").click(function () {
        var d=new Date();
        $(this).src="/CheckCode?"+d.getSeconds();
    });
    animate=setInterval(function(){
        if(i%2==0){
            $(".flush").css("font-size","30px");
        }else{
            $(".flush").css("font-size","20px");
        }
        i++;
    },300);
    $(".flush").mouseleave(function(){
         animate=setInterval(function(){
            if(i%2==0){
                $(".flush").css("font-size","30px");
            }else{
                $(".flush").css("font-size","20px");
            }
            i++;
        },300);
    })
    $(".flush").mousemove(function(){clearInterval(animate)})
    $(".q").css("text-shadow","none");
    $(".q").css("color","black");
    $(".btnResponse>input").hover(function () {
        $(this).addClass("btnShadow");
    },function () {
        $(this).removeClass("btnShadow");
    })
})
