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
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
	private final Form<TaskListViewModel> personform;
	private final FormFactory formFactory;
	private final TaskListRepository taskListRepository;
	public TaskListViewModel taskListViewModel = new TaskListViewModel();
	private TaskListService taskListService = new TaskListService();
	
	@Inject Database db;
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    @Inject
    public HomeController(FormFactory formFactory,TaskListRepository taskListRepository){
		this.formFactory = formFactory;
		this.personform = formFactory.form(TaskListViewModel.class);
		this.taskListRepository = taskListRepository;
    }

    public Result index() {
    	String msg = "<div class="+"cont_title"+">タスク</div><br>";
    	Form<TaskListViewModel> formdata = personform.bindFromRequest();
		TaskListViewModel form = formdata.get();
		Connection conn = db.getConnection();
		/*for(TaskListDTO tempList : taskListService.selectAll(conn)){
			form.taskList.add(tempList);
		}*/
		int accountNo = Integer.parseInt(session("accountNo"));
		
		//todo:エンコード、デコードはserviceに記載
		/*String source = "1";
		Charset charset = StandardCharsets.UTF_8;
		String encodedResult = Base64.getEncoder().encodeToString(source.getBytes(charset));
		String encodedResult2 = Base64.getEncoder().encodeToString(encodedResult.getBytes(charset));
		msg += "<div class="+"cont"+">"+encodedResult2+"</div><br>";
	  	byte[] decoded = Base64.getDecoder().decode(encodedResult2);
        String result = new String(decoded, charset);
		byte[] decoded2 = Base64.getDecoder().decode(result);
        String result2 = new String(decoded2, charset);

		for(TaskListDTO tempList : taskListService.selectByAccountNo(conn,accountNo)){
			form.taskList.add(tempList);
		}*/
		List<TaskListDTO> tempList = taskListService.selectByAccountNo(conn,accountNo);
		List<TaskListViewModel> taskList = new ArrayList<TaskListViewModel>();
		for(TaskListDTO temp : tempList){
			TaskListViewModel task = new TaskListViewModel();
			task.settaskNo(temp.taskNo);
			task.setTaskName(temp.taskName);
			task.setTaskContents(temp.taskContents);
			task.setDeadline(temp.deadLine);
			task.setStatus(temp.status);
			task.setLastupdate(temp.lastUpdate);
			task.setEncodedResult(taskListService.EncodedResult(temp.taskNo));
			taskList.add(task);
		}
        return ok(views.html.index.render(msg,taskList));
    }

    public Result regi() {
		//return redirect(routes.HomeController.index());
        return ok(views.html.regi.render());
    }
    
    public Result add(){
        String msg = "<div class="+"cont"+">タスクを登録して下さい</div><br>";
    	return ok(views.html.add.render(msg,personform));
    }
    
	public Result create(){ 
		int accountNo = Integer.parseInt(session("accountNo"));
		long miliseconds = System.currentTimeMillis();
		Date nowDateTime = new java.sql.Date(miliseconds);
		Form<TaskListViewModel> formdata = personform.bindFromRequest();
		TaskListViewModel form = formdata.get();
		form.setAccountNo(accountNo);
		form.setDeadline(nowDateTime);
		form.setLastupdate(nowDateTime);
		//エラーチェック
		Connection conn = db.getConnection();
		Connection conn2 = db.getConnection();
		List<TaskListDTO> taskList = taskListService.selectByAccountNo(conn2,accountNo);
		int taskNo = 0;
		for(TaskListDTO task : taskList){
			if(taskNo < task.taskNo){
				taskNo = task.taskNo;
			}
		}
		form.settaskNo(taskNo+1);
		List<String> errorMsgList = taskListService.Validation(conn,form,app.Enum.screenStatus.CREATE.toString());
		if(errorMsgList.size() > 0){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br>";
			for(String tempMsg : errorMsgList){
				msg += "<div class="+"cont"+">"+tempMsg+"</div><br>";
			}
			form.lastUpdate = nowDateTime;
			formdata.fill(form);
			return ok(views.html.add.render(msg,formdata));
		}
		Connection conn3 = db.getConnection();
		String errorMsg = taskListService.InsertTask(conn3,form);
		if(errorMsg != null){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br><div class="+"cont"+">"+errorMsg+"</div><br>";
			return ok(views.html.add.render(msg,formdata));
		}
		return redirect(routes.HomeController.index());
	}
	
	public Result edit(String encodedResult){
		Form<TaskListViewModel> formdata = personform.bindFromRequest();
		int accountNo = Integer.parseInt(session("accountNo"));
		Connection conn = db.getConnection();
		int taskNo = taskListService.DencodedResult(encodedResult);
		List<TaskListDTO> form = taskListService.select(conn,accountNo,taskNo);
		TaskListViewModel temp = new TaskListViewModel();
		long miliseconds = System.currentTimeMillis();
		Date nowDateTime = new Date(miliseconds);
		temp.setAccountNo(accountNo);
		for(TaskListDTO tempList : form){
			temp.settaskNo(tempList.taskNo);
			temp.setTaskName(tempList.taskName);
			temp.setTaskContents(tempList.taskContents);
			temp.setDeadline(tempList.deadLine);
			temp.setStatus(tempList.status);
			temp.setLastupdate(nowDateTime);
			formdata = personform.fill(temp);
		}
		String msg = "<div class="+"cont"+">タスクを編集して下さい</div><br>";
		return ok(views.html.edit.render(msg,formdata,encodedResult));
	}
	
	public Result update(String encodedResult){
		int accountNo = Integer.parseInt(session("accountNo"));
		long miliseconds = System.currentTimeMillis();
		Date nowDateTime = new java.sql.Date(miliseconds);
		Form<TaskListViewModel> formdata = formFactory.form(TaskListViewModel.class).bindFromRequest();
		TaskListViewModel form = formdata.get();
		int taskNo = taskListService.DencodedResult(encodedResult);
		form.setAccountNo(accountNo);
		form.settaskNo(taskNo);
		form.setLastupdate(nowDateTime);

		Connection conn = db.getConnection();
		String errorMsg = taskListService.UpdateTask(conn,form);
		if(errorMsg != null){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br><div class="+"cont"+">"+errorMsg+"</div><br>";
			return ok(views.html.edit.render(msg,formdata,encodedResult));
		}
		return redirect(routes.HomeController.index());
	}
	
	public Result delete(String encodedResult){
		Form<TaskListViewModel> formdata = personform.bindFromRequest();
		int accountNo = Integer.parseInt(session("accountNo"));
		Connection conn = db.getConnection();
		int taskNo = taskListService.DencodedResult(encodedResult);
		List<TaskListDTO> form = taskListService.select(conn,accountNo,taskNo);
		TaskListViewModel temp = new TaskListViewModel();
		long miliseconds = System.currentTimeMillis();
		Date nowDateTime = new Date(miliseconds);
		temp.setAccountNo(accountNo);
		for(TaskListDTO tempList : form){
			temp.settaskNo(tempList.taskNo);
			temp.setTaskName(tempList.taskName);
			temp.setTaskContents(tempList.taskContents);
			temp.setDeadline(tempList.deadLine);
			temp.setStatus(tempList.status);
			temp.setLastupdate(nowDateTime);
			formdata = personform.fill(temp);
		}
		String msg = "<div class="+"cont"+">以下のタスクを削除いたしますがよろしいでしょうか。</div><br>";
		return ok(views.html.delete.render(msg,formdata,taskNo,encodedResult));
	}
	
	public Result remove(String encodedResult){
		int accountNo = Integer.parseInt(session("accountNo"));
		Form<TaskListViewModel> formdata = formFactory.form(TaskListViewModel.class).bindFromRequest();
		TaskListViewModel form = formdata.get();
		Connection conn = db.getConnection();
		int taskNo = taskListService.DencodedResult(encodedResult);
		String errorMsg = taskListService.DeleteTask(conn,accountNo,taskNo);
		if(errorMsg != null){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br><div class="+"cont"+">"+errorMsg+"</div><br>";
			return ok(views.html.delete.render(msg,formdata,taskNo,encodedResult));
		}
		return redirect(routes.HomeController.index());
	}
}