/**
 * Created by pen on 17-7-11.
 */

$(document).ready(function() {
    $("form").ajaxForm({
        type: 'post',
        url: '/penblog/user/profile',
        success: function (data) {
            if (data.result == true) {
                location.href = '/penblog/user/profile?id=' + data.id;
            }
        }
    });
});

function sayHello() {
    var text=""; day = new Date( ); time = day.getHours( );
    if (( time>=0) && (time < 6 ))
        text="凌晨了，";
    if (( time >= 7 ) && (time < 12))
        text="上午好，";
    if (( time >= 12) && (time < 18))
        text="下午好，";
    if ((time >= 18) && (time < 24))
        text="晚上好，";

    return text
}
