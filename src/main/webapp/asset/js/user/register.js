/**
 * Created by pen on 17-7-30.
 */

$(document).ready(function() {
    $('#register_form').ajaxForm({
        type: 'post',
        url: '/penblog/user/register',
        success: function (data) {
            if (data.result == false) {
                $('#error').text(data.message);
            } else if (data.result == true) {
                location.href = '/penblog/user/list';
            }
        }
    });
});