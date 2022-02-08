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
    var dialog = document.getElementById("dialog");
        if(user.indexOf("iPhone") > 0 || user.indexOf("iPad") > 0 || user.indexOf("Android") > 0){
            $('button').bind("touchstart", function () {
                $(this).addClass("hover");
            }).bind("touchend", function () {
                $(this).removeClass("hover");
            });

            //アカウント削除ボタン押下時時のダイアログが表示されている時のみ
            if(dialog != null && dialog.style.display != "none"){
                $('.dialogOkButton').bind("touchstart", function () {
                    $(this).addClass("hover");
                }).bind("touchend", function () {
                    $(this).removeClass("hover");
                });
            }
        }else{
            $('button').hover(
                function () {
                    $(this).addClass("hover");
                },
                function () {
                    $(this).removeClass("hover");
                }
            );

            //アカウント削除ボタン押下時時のダイアログが表示されている時のみ
            if(dialog != null && dialog.style.display != "none"){
                $('.dialogOkButton').hover(
                    function () {
                        $(this).addClass("hover");
                    },
                    function () {
                        $(this).removeClass("hover");
                    }
                );
            }
        }

    //期日によるタスク行の背景色変更
    //ホーム画面のタスクリストのみ処理を実行
    let taskTable = document.getElementById("taskTable");
    if(taskTable != null && taskTable.rows[0].cells.length > 4){
        var tempDate = new Date();
        var today = Date.parse(tempDate.getFullYear()+"-"+(tempDate.getMonth()+1)+"-"+tempDate.getDate());
        for(let row of taskTable.rows){
            //ヘッダーは処理の対象外
            if(taskTable.rows[0] == row){
                continue;
            }

            var status = row.cells[4].innerText;
            var deadline = Date.parse(row.cells[3].innerText);
            if(status != "完了" && deadline < today){
                for(let cell of row.cells){
                    cell.style.backgroundColor = "rgb(255, 130, 130)";
                }
            }else if(status == "完了"){
                for(let cell of row.cells){
                    cell.style.backgroundColor = "rgb(204, 204, 204)";
                }
            }
        }
    }
    
});

//ハンバーガーメニューの表示非表示の処理
function hamburgerMenuShow(){
    if ($('.nav-btn').hasClass('open')) {
        $('.nav-btn').removeClass('open');
        $('#navi').removeClass('open-menu');
    } else {
        $('.nav-btn').addClass('open');
        $('#navi').addClass('open-menu');
    }
}

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

//メモ画面の編集、削除ボタン押下時のダイアログ表示処理
function taskMemoDialogShow(id,memoNo,status) {
    let msg = $('a#'+id).parent('.memoTableBtn').prev('td.memoTableTd').text();
    if(status == "編集"){
        var dialog = document.getElementById("updateMemoDialog");
        dialog.style.display = "block";
        document.getElementById("dialogMemoContents").value = msg;
        document.getElementById("memoNo").value = Number(memoNo);
    }else{
        var dialog = document.getElementById("deleteMemoDialog");
        dialog.style.display = "block";
        document.getElementById("deleteMemoContentsMsg").innerText = msg;
        document.getElementById("deleteMemoBtn").setAttribute('onclick',"location.href='/deleteTaskMemo/"+Number(memoNo)+"'");
    }
    return;
}

//メモ画面のダイアログ非表示表示処理
function taskMemoDialogHide(status) {
    if(status == "編集"){
        var dialog = document.getElementById("updateMemoDialog");
        dialog.style.display = "none";
    }else{
        var dialog = document.getElementById("deleteMemoDialog");
        dialog.style.display = "none";
    }
    
    return;
}