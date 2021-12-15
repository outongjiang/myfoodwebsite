$(function() {
    var init_input = $("td>input[type='text']");
    init_input.attr("readOnly", true);
    init_input.attr("disabled", true);
    init_input.addClass("foodProperties_border");
})

function f(id1) {
    var id = "#" + id1;
    if ($(id).html() == "编辑") {
        var input = $(id).parent().parent().children("td").children("input[type='text']");
        input.attr("readOnly", false);
        input.attr("disabled", false);
        input.removeClass("foodProperties_border");
        input.focus();
        $(id).html("完成");
    } else {
        var input = $(id).parent().parent().children("td").children("input[type='text']");
        input.attr("readOnly", true);
        input.attr("disabled", true);
        input.addClass("foodProperties_border");
        // input.focus();
        $(id).html("编辑");
    }
    location.assign("updateFoodServlet?foodid="+id1);
}