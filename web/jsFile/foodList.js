$(function() {

    var init_input = $("td>input[type='text']");
    init_input.attr("readOnly", true);
    init_input.attr("disabled", true);
    init_input.addClass("foodProperties_border");
    $("#firstcheckbox").click(function() {
        var checkboxs = $("input[type='checkbox']").not("#firstcheckbox");
        if ($(this).prop("checked") == true) {
            for (var i = 0; i < checkboxs.length; i++) {
                if ($(checkboxs[i]).prop("checked") == false) {
                    $(checkboxs[i]).prop("checked", true);
                }
            }
        } else {

            for (var i = 0; i < checkboxs.length; i++) {
                if ($(checkboxs[i]).prop("checked") == true) {
                    $(checkboxs[i]).prop("checked", false);
                }
            }

        }

    });


})

function del(id1) {
    if(confirm("您确定要删除该选项?")){

        self.location.href ="/vd/DeleteFoodServlet?id="+id1;
    }
}
function edit(id1) {
    var id = "#" + id1;
    if($(id).html() == "编辑"){
        var input = !$(id).parent().parent().children("td").children("input[type='text']").not("#bkbj").not(".bkbj");
        input.attr("readOnly", false);
        input.attr("disabled", false);
        input.removeClass("foodProperties_border");
        input.focus();
        $(id).html("完成");
    }else{
        var input =$(id).parent().parent().children("td").children("input[type='text']");
        input.prop("readOnly", true);
        input.prop("disabled", true);
        input.addClass("foodProperties_border");
        // input.focus();
        $(id).html("编辑");
        self.location.href ="/vd/UpdateFoodServlet?id="+id1+"&name="+input.eq(1).val()+"&price="+input.eq(2).val()+"&num="+input.eq(3).val();
    }
}
function dels() {
    if(confirm("您确定要删除选中的选项吗?")) {
        $("#dels").submit();
    }
}
