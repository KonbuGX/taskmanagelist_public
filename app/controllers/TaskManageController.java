package controllers;

import app.*;
import play.mvc.*;
import java.util.*;
import javax.inject.*;
import java.sql.*;
import play.data.*;
import play.db.*;
import models.*;
import org.mindrot.jbcrypt.BCrypt;
import static play.libs.Scala.asScala;
import play.libs.concurrent.HttpExecutionContext;
import java.util.concurrent.CompletionStage;
import java.sql.Date;
import java.time.LocalDateTime;

public class TaskManageController extends Controller {
	private final Form<AccountViewModel> accountform;
	private final FormFactory formFactory;
	public AccountViewModel accountViewModel = new AccountViewModel();
	private AccountService accountService = new AccountService();
	
	@Inject Database db;

    @Inject
    public TaskManageController(FormFactory formFactory){
		this.formFactory = formFactory;
		this.accountform = formFactory.form(AccountViewModel.class);
    }

    //初期表示
    public Result taskManage() {
        return ok(views.html.taskManage.render());
    }

    //ログインボタン押下時
    public Result login() {
        String msg = "";
    	Form<AccountViewModel> formdata = accountform.bindFromRequest();
        return ok(views.html.login.render(msg,formdata));
    }

    //新規作成ボタン押下時
    public Result signup() {
        String msg = "";
    	Form<AccountViewModel> formdata = accountform.bindFromRequest();
        
        return ok(views.html.signup.render(msg,formdata));
    }

    //作成ボタン押下時
    public Result accountCreate() {
    	Form<AccountViewModel> formdata = accountform.bindFromRequest();
        AccountViewModel form = formdata.get();
        Connection conn = db.getConnection();
        List<AccountDTO> tempList =  accountService.selectAll(conn);

        //アカウントNoの付番
        if(tempList.size()>0){
            int tempNo = 0;
            for(int i = 0;i<tempList.size();i++){
                AccountDTO temp = tempList.get(i);
                if(temp.accountNo>tempNo){
                    tempNo = temp.accountNo;
                }
            }
            form.accountNo = tempNo+1;
        }else{
            form.accountNo = 1;
        }

        //日付の取得
        long miliseconds = System.currentTimeMillis();
		Date nowDateTime = new Date(miliseconds);
        form.lastUpdate = nowDateTime;

        //エラーチェック
        Connection conn2 = db.getConnection();
        List<String> errorMsgList = accountService.Validation(conn2,form,app.Enum.screenStatus.SIGNIN.toString());
		if(errorMsgList.size() > 0){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br>";
			for(String tempMsg : errorMsgList){
				msg += "<div class="+"cont"+">"+tempMsg+"</div><br>";
			}
			form.accountNo = 0;
            form.password = "";
            formdata = accountform.fill(form);
			return ok(views.html.signup.render(msg,formdata));
		}

        //パスワードのハッシュ化
        String password = form.password;
        form.password = BCrypt.hashpw(password, BCrypt.gensalt());

        //インサート処理
        Connection conn3 = db.getConnection();
        String errorMsg = accountService.InsertAccount(conn3,form);
		if(errorMsg != null){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br><div class="+"cont"+">"+errorMsg+"</div><br>";
            form.accountNo = 0;
            form.accountName = "";
            form.password = "";
            formdata = accountform.fill(form);
			return ok(views.html.signup.render(msg,formdata));
		}

        session("accountNo",Integer.valueOf(form.accountNo).toString());
        return temporaryRedirect("/index");
    }

    //ログイン処理
    public Result signin() {
        Form<AccountViewModel> formdata = accountform.bindFromRequest();
        AccountViewModel form = formdata.get();
        Connection conn = db.getConnection();
        String status = app.Enum.screenStatus.LOGIN.toString();

        //エラーチェック
		List<String> errorMsgList = accountService.Validation(conn,form,status);
		if(errorMsgList.size() > 0){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br>";
			for(String tempMsg : errorMsgList){
				msg += "<div class="+"cont"+">"+tempMsg+"</div><br>";
			}
            form.password = "";
			return ok(views.html.login.render(msg,formdata));
		}

        //セッション追加
        Connection conn2 = db.getConnection();
        List<AccountDTO> tempList = accountService.selectByName(conn2,form.accountName);
        int accountNo = 0;
        for(AccountDTO temp : tempList){
            accountNo = temp.accountNo;
        }
        session("accountNo",Integer.valueOf(accountNo).toString());
        return temporaryRedirect("/index");
    }

    //サインアウト処理
    public Result signout() {
		session().clear();
        return ok(views.html.taskManage.render());
    }

}