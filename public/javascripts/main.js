$(function () {
    /*パスワード表示・非表示処理*/
    var password = '#password';
    var checkPassword = '#displayPassword';

    $(checkPassword).change(function () {
        if ($(this).prop('checked')) {
            $(password).attr('type', 'text');
        } else {
            $(password).attr('type', 'password');
        }
    });

    /*PCとその他デバイスでのボタン押下時のデザイン処理*/
    var user = navigator.userAgent;
    var dialogOkButton = '.dialogOkButton';
    if(user.indexOf("iPhone") > 0 || user.indexOf("iPad") > 0 || user.indexOf("Android") > 0){
        $('button').bind("touchstart", function () {
			$(this).addClass("hover");
            dialogOkButton.addClass("hover");
		}).bind("touchend", function () {
			$(this).removeClass("hover");
            dialogOkButton.removeClass("hover");
		});
    }else{
        $('button').hover(
			function () {
				$(this).addClass("hover");
                dialogOkButton.addClass("hover");
			},
			function () {
				$(this).removeClass("hover");
                dialogOkButton.removeClass("hover");
			}
		);
    }

});

/*ダイアログ表示・非表示処理*/
function dialogHide() {
    var dialog = document.getElementById("dialog");
    dialog.style.display = "none";
    return;
}
function dialogShow() {
    var dialog = document.getElementById("dialog");
    dialog.style.display = "block";
    return;
}

/*未完了・完了タスク表示切り替え*/
function switchShowList() {
    var show = $('.show');
    var hide = $('.hide');
    
    show.addClass("hide");
    show.removeClass("show");
    hide.addClass("show");
    hide.removeClass("hide");

    return;
}