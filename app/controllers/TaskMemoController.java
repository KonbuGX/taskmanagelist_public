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
import java.util.stream.IntStream;

public class TaskMemoController extends Controller {
	private final Form<TaskMemoViewModel> taskMemoForm;
	private final FormFactory formFactory;
	public TaskMemoViewModel taskMemoViewModel = new TaskMemoViewModel();
	private TaskMemoService taskMemoService = new TaskMemoService();
    private int taskNo;
    private String ENCODEDRESULT;
    private String TASKNAME;
    private String TASKCONTENTS;
	
	@Inject Database db;

    @Inject
    public TaskMemoController(FormFactory formFactory){
		this.formFactory = formFactory;
		this.taskMemoForm = formFactory.form(TaskMemoViewModel.class);
    }

	//初期表示
    public Result taskMemo(String encodedResult) {
    	String msg = "";
    	Form<TaskMemoViewModel> formdata = taskMemoForm.bindFromRequest();
		TaskMemoViewModel form = formdata.get();

        taskNo = taskMemoService.dencodedResult(encodedResult);
        ENCODEDRESULT = encodedResult;
        
		//リストの取得
		Connection conn = db.getConnection();
        int accountNo = Integer.parseInt(session("accountNo"));
		taskMemoViewModel.taskMemoList = taskMemoService.selectAll(conn,accountNo,taskNo);

        //タスク名、タスコンテンツの取得
        TaskListService taskListService = new TaskListService();
        Connection conn2 = db.getConnection();
        List<TaskListDTO> taskList = taskListService.select(conn2,accountNo,taskNo);
        TASKNAME = taskList.get(0).taskName;
        TASKCONTENTS = taskList.get(0).taskContents;

        return ok(views.html.taskMemo.render(msg,session("accountName"),TASKNAME,TASKCONTENTS,taskMemoForm,taskMemoViewModel.taskMemoList));
    }

	//登録ボタン押下時
    public Result createTaskMemo(){
        int accountNo = Integer.parseInt(session("accountNo"));
		long miliseconds = System.currentTimeMillis();
		Date nowDateTime = new java.sql.Date(miliseconds);
		Form<TaskMemoViewModel> formdata = taskMemoForm.bindFromRequest();
		TaskMemoViewModel form = formdata.get();

		//登録画面に表示されている項目以外のカラムをセット
		form.setAccountNo(accountNo);
        form.setTaskNo(taskNo);
		form.setLastupdate(nowDateTime);
		
		//メモNoの付番
		Connection conn = db.getConnection();
		List<TaskMemoDTO> memoList = taskMemoService.selectAll(conn,accountNo,taskNo);
        if(memoList.size() > 0){
            int memoNo = memoList.stream().mapToInt(num -> num.memoNo).max().getAsInt();
            form.setMemoNo(memoNo+1);
        }else{
            int memoNo = 1;
            form.setMemoNo(memoNo);
        }
        
		//エラーチェック
        String status = app.Enum.screenStatus.TASKMEMOINSERT.toString();
		List<String> errorMsgList = taskMemoService.validation(form,status);
		if(errorMsgList.size() > 0){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br>";
			for(String tempMsg : errorMsgList){
				msg += "<div class="+"cont"+">"+tempMsg+"</div><br>";
			}
			formdata.fill(form);
			return ok(views.html.taskMemo.render(msg,session("accountName"),TASKNAME,TASKCONTENTS,formdata,taskMemoViewModel.taskMemoList));
		}

		//インサート処理
		Connection conn2 = db.getConnection();
		String errorMsg = taskMemoService.insertTaskMemo(conn2,form);
		if(errorMsg != null){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br><div class="+"cont"+">"+errorMsg+"</div><br>";
			return ok(views.html.taskMemo.render(msg,session("accountName"),TASKNAME,TASKCONTENTS,formdata,taskMemoViewModel.taskMemoList));
		}
		return redirect(routes.TaskMemoController.taskMemo(ENCODEDRESULT));
    }

    //ダイアログの更新ボタン押下時
	public Result updateTaskMemo(){
		int accountNo = Integer.parseInt(session("accountNo"));
		long miliseconds = System.currentTimeMillis();
		Date nowDateTime = new java.sql.Date(miliseconds);
		Form<TaskMemoViewModel> formdata = formFactory.form(TaskMemoViewModel.class).bindFromRequest();
		TaskMemoViewModel form = formdata.get();

        //エラーチェック
        String status = app.Enum.screenStatus.TASKMEMOUPDATE.toString();
		List<String> errorMsgList = taskMemoService.validation(form,status);
		if(errorMsgList.size() > 0){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br>";
			for(String tempMsg : errorMsgList){
				msg += "<div class="+"cont"+">"+tempMsg+"</div><br>";
			}
			formdata.fill(form);
			return ok(views.html.taskMemo.render(msg,session("accountName"),TASKNAME,TASKCONTENTS,formdata,taskMemoViewModel.taskMemoList));
		}

		//画面未表示項目のカラムをセット
		form.setAccountNo(accountNo);
		form.setTaskNo(taskNo);
		form.setLastupdate(nowDateTime);
        form.setMemoContents(form.getDialogMemoContents());

		//アップデート処理
		Connection conn = db.getConnection();
		String errorMsg = taskMemoService.updateTaskMemo(conn,form);
		if(errorMsg != null){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br><div class="+"cont"+">"+errorMsg+"</div><br>";
			return ok(views.html.taskMemo.render(msg,session("accountName"),TASKNAME,TASKCONTENTS,formdata,taskMemoViewModel.taskMemoList));
		}

		return redirect(routes.TaskMemoController.taskMemo(ENCODEDRESULT));
	}

    //ダイアログの削除ボタン押下時
	public Result deleteTaskMemo(int memoNo){
		int accountNo = Integer.parseInt(session("accountNo"));
		Form<TaskMemoViewModel> formdata = formFactory.form(TaskMemoViewModel.class).bindFromRequest();
		TaskMemoViewModel form = formdata.get();
		
		//デリート処理
		Connection conn = db.getConnection();
		String errorMsg = taskMemoService.deleteTaskMemo(conn,accountNo,taskNo,memoNo);
		if(errorMsg != null){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br><div class="+"cont"+">"+errorMsg+"</div><br>";
			return ok(views.html.taskMemo.render(msg,session("accountName"),TASKNAME,TASKCONTENTS,formdata,taskMemoViewModel.taskMemoList));
		}
		return redirect(routes.TaskMemoController.taskMemo(ENCODEDRESULT));
	}
}