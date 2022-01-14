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
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class HomeController extends Controller {
	private final Form<TaskListViewModel> personform;
	private final FormFactory formFactory;
	public TaskListViewModel taskListViewModel = new TaskListViewModel();
	private TaskListService taskListService = new TaskListService();
	
	@Inject Database db;

    @Inject
    public HomeController(FormFactory formFactory){
		this.formFactory = formFactory;
		this.personform = formFactory.form(TaskListViewModel.class);
    }

	//初期表示
    public Result index() {
    	String msg = "";
    	Form<TaskListViewModel> formdata = personform.bindFromRequest();
		TaskListViewModel form = formdata.get();

		//リストの取得
		Connection conn = db.getConnection();
        int accountNo = Integer.parseInt(session("accountNo"));
		List<TaskListDTO> tempList = taskListService.selectByAccountNo(conn,accountNo);
		taskListViewModel = taskListService.setTaskList(tempList,taskListViewModel);

        return ok(views.html.index.render(msg,session("accountName"),taskListViewModel.taskList,taskListViewModel.incompleteTaskList));
    }
    
	//新規登録ボタン押下時
    public Result add(){
        String msg = "<div class="+"cont"+">タスクを登録して下さい</div><br>";
    	return ok(views.html.add.render(msg,personform));
    }
    
	//登録ボタン押下時
	public Result create(){ 
		int accountNo = Integer.parseInt(session("accountNo"));
		long miliseconds = System.currentTimeMillis();
		Date nowDateTime = new java.sql.Date(miliseconds);
		Form<TaskListViewModel> formdata = personform.bindFromRequest();
		TaskListViewModel form = formdata.get();

		//登録画面に表示されている項目以外のカラムをセット
		form.setAccountNo(accountNo);
		form.setLastupdate(nowDateTime);
		
		//タスクNoの付番
		Connection conn = db.getConnection();
		List<TaskListDTO> taskList = taskListService.selectByAccountNo(conn,accountNo);
		int taskNo = 0;
		for(TaskListDTO task : taskList){
			if(taskNo < task.taskNo){
				taskNo = task.taskNo;
			}
		}
		form.setTaskNo(taskNo+1);

		//エラーチェック
		Connection conn2 = db.getConnection();
		List<String> errorMsgList = taskListService.validation(conn2,form,app.Enum.screenStatus.CREATE.toString());
		if(errorMsgList.size() > 0){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br>";
			for(String tempMsg : errorMsgList){
				msg += "<div class="+"cont"+">"+tempMsg+"</div><br>";
			}
			form.setLastupdate(nowDateTime);
			formdata.fill(form);
			return ok(views.html.add.render(msg,formdata));
		}

		//インサート処理
		Connection conn3 = db.getConnection();
		String errorMsg = taskListService.insertTask(conn3,form);
		if(errorMsg != null){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br><div class="+"cont"+">"+errorMsg+"</div><br>";
			return ok(views.html.add.render(msg,formdata));
		}
		return redirect(routes.HomeController.index());
	}
	
	//編集ボタン押下時
	public Result edit(String encodedResult){
		Form<TaskListViewModel> formdata = personform.bindFromRequest();
		int accountNo = Integer.parseInt(session("accountNo"));
		//エンコードされたパラメータをデコード
		int taskNo = taskListService.dencodedResult(encodedResult);

		//編集ボタンを押した行のリストを取得し編集画面に表示させる
		Connection conn = db.getConnection();
		List<TaskListDTO> form = taskListService.select(conn,accountNo,taskNo);
        formdata = taskListService.setItem(formdata,form,accountNo,app.Enum.screenStatus.TASKUPDATE.toString(),personform);
		
        String msg = "<div class="+"cont"+">タスクを編集して下さい</div><br>";
		return ok(views.html.edit.render(msg,formdata,encodedResult));
	}
	
	//更新ボタン押下時
	public Result update(String encodedResult){
		int accountNo = Integer.parseInt(session("accountNo"));
		long miliseconds = System.currentTimeMillis();
		Date nowDateTime = new java.sql.Date(miliseconds);
		Form<TaskListViewModel> formdata = formFactory.form(TaskListViewModel.class).bindFromRequest();
		TaskListViewModel form = formdata.get();

		//エンコードされたパラメータをデコード
		int taskNo = taskListService.dencodedResult(encodedResult);

		//画面未表示項目のカラムをセット
		form.setAccountNo(accountNo);
		form.setTaskNo(taskNo);
		form.setLastupdate(nowDateTime);

		//アップデート処理
		Connection conn = db.getConnection();
		String errorMsg = taskListService.updateTask(conn,form);
		if(errorMsg != null){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br><div class="+"cont"+">"+errorMsg+"</div><br>";
			return ok(views.html.edit.render(msg,formdata,encodedResult));
		}
		return redirect(routes.HomeController.index());
	}
	
	//ホーム画面の削除ボタン押下時
	public Result delete(String encodedResult){
		Form<TaskListViewModel> formdata = personform.bindFromRequest();
		int accountNo = Integer.parseInt(session("accountNo"));
		//エンコードされたパラメータをデコード
		int taskNo = taskListService.dencodedResult(encodedResult);

		//削除するタスクを取得し削除画面に表示させる
		Connection conn = db.getConnection();
		List<TaskListDTO> form = taskListService.select(conn,accountNo,taskNo);
        formdata = taskListService.setItem(formdata,form,accountNo,app.Enum.screenStatus.TASKDELETE.toString(),personform);
		
        String msg = "<div class="+"cont"+">以下のタスクを削除いたしますがよろしいでしょうか。</div><br>";
		return ok(views.html.delete.render(msg,formdata,taskNo,encodedResult));
	}
	
	//削除ボタン押下時
	public Result remove(String encodedResult){
		int accountNo = Integer.parseInt(session("accountNo"));
		Form<TaskListViewModel> formdata = formFactory.form(TaskListViewModel.class).bindFromRequest();
		TaskListViewModel form = formdata.get();
		//エンコードされたパラメータをデコード
		int taskNo = taskListService.dencodedResult(encodedResult);
		
		//デリート処理
		Connection conn = db.getConnection();
		String errorMsg = taskListService.deleteTask(conn,accountNo,taskNo);
		if(errorMsg != null){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br><div class="+"cont"+">"+errorMsg+"</div><br>";
			return ok(views.html.delete.render(msg,formdata,taskNo,encodedResult));
		}
		return redirect(routes.HomeController.index());
	}

	//アカウント削除ボタン押下時
	public Result accountDelete(){
		int accountNo = Integer.parseInt(session("accountNo"));
		AccountService accountService = new AccountService();

		//アカウント削除
		Connection conn = db.getConnection();
		String errorMsg = accountService.deleteAccount(conn,accountNo);
		if(errorMsg != null){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br><div class="+"cont"+">"+errorMsg+"</div><br>";
			Connection conn3 = db.getConnection();
			List<TaskListDTO> tempList = taskListService.selectByAccountNo(conn3,accountNo);
		    taskListViewModel = taskListService.setTaskList(tempList,taskListViewModel);

            return ok(views.html.index.render(msg,session("accountName"),taskListViewModel.taskList,taskListViewModel.incompleteTaskList));
		}
		
		//タスク削除
        if(taskListViewModel.taskList.size() > 0 || taskListViewModel.incompleteTaskList.size() > 0){
            Connection conn2 = db.getConnection();
		    errorMsg = taskListService.deleteTaskByAccountNo(conn2,accountNo);
		    if(errorMsg != null){
			    String msg = "<div class="+"cont"+">エラーが発生しました</div><br><div class="+"cont"+">"+errorMsg+"</div><br>";
			    Connection conn3 = db.getConnection();
			    List<TaskListDTO> tempList = taskListService.selectByAccountNo(conn3,accountNo);
		        taskListViewModel = taskListService.setTaskList(tempList,taskListViewModel);

                return ok(views.html.index.render(msg,session("accountName"),taskListViewModel.taskList,taskListViewModel.incompleteTaskList));
		    }
        }
		session().clear();
		return temporaryRedirect("/");
	}
}