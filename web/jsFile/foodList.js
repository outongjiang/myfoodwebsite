$(function() {
    var init_input = $("td>input[type='text']");
    init_input.attr("readOnly", true);
    init_input.attr("disabled", true);
    init_input.addClass("foodProperties_border");
    var flag = 0;
    $("#update").click(function() {
        var input = $(this).parent().parent().children("td").children("input[type='text']");
        if (flag == 0) {
            input.attr("readOnly", false);
            input.attr("disabled", false);
            init_input.removeClass("foodProperties_border");
            input.focus();
            $(this).html("完成");
            flag = 1;
        } else {
            input.attr("readOnly", true);
            input.attr("disabled", true);
            $(this).html("编辑");
            init_input.addClass("foodProperties_border");
            flag = 0;
        }

    })

})