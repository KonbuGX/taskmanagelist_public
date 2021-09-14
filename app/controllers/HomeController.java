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
		for(TaskListDTO tempList : taskListService.selectAll(conn)){
			form.taskList.add(tempList);
		}
		//String password = "args[0]";
        //String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(8));
    	
        return ok(views.html.index.render(msg,form.taskList));
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
		int accountNo = 999;
		long miliseconds = System.currentTimeMillis();
		Date nowDateTime = new java.sql.Date(miliseconds);
		Form<TaskListViewModel> formdata = personform.bindFromRequest();
		TaskListViewModel form = formdata.get();
		form.setAccountNo(accountNo);
		form.setLastupdate(nowDateTime);
		//エラーチェック
		Connection conn = db.getConnection();
		List<String> errorMsgList = taskListService.Validation(conn,form,app.Enum.screenStatus.CREATE.toString());
		if(errorMsgList.size() > 0){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br>";
			for(String tempMsg : errorMsgList){
				msg += "<div class="+"cont"+">"+tempMsg+"</div><br>";
			}
			return ok(views.html.add.render(msg,formdata));
		}

		Connection conn2 = db.getConnection();
		String errorMsg = taskListService.InsertTask(conn2,form);
		if(errorMsg != null){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br><div class="+"cont"+">"+errorMsg+"</div><br>";
			return ok(views.html.add.render(msg,formdata));
		}
		return redirect(routes.HomeController.index());
	}
	
	public Result edit(int taskNo){
		Form<TaskListViewModel> formdata = personform.bindFromRequest();
		int accountNo = 999;
		Connection conn = db.getConnection();
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
		return ok(views.html.edit.render(msg,formdata,taskNo));
	}
	
	public Result update(int taskNo){
		int accountNo = 999;
		long miliseconds = System.currentTimeMillis();
		Date nowDateTime = new java.sql.Date(miliseconds);
		Form<TaskListViewModel> formdata = formFactory.form(TaskListViewModel.class).bindFromRequest();
		TaskListViewModel form = formdata.get();
		form.setAccountNo(accountNo);
		form.settaskNo(taskNo);
		form.setLastupdate(nowDateTime);

		Connection conn = db.getConnection();
		String errorMsg = taskListService.UpdateTask(conn,form);
		if(errorMsg != null){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br><div class="+"cont"+">"+errorMsg+"</div><br>";
			return ok(views.html.edit.render(msg,formdata,taskNo));
		}
		return redirect(routes.HomeController.index());
	}
	
	public Result delete(int taskNo){
		Form<TaskListViewModel> formdata = personform.bindFromRequest();
		int accountNo = 999;
		Connection conn = db.getConnection();
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
		return ok(views.html.delete.render(msg,formdata,taskNo));
	}
	
	public Result remove(int taskNo){
		int accountNo = 999;
		Form<TaskListViewModel> formdata = formFactory.form(TaskListViewModel.class).bindFromRequest();
		TaskListViewModel form = formdata.get();
		Connection conn = db.getConnection();

		String errorMsg = taskListService.DeleteTask(conn,accountNo,taskNo);
		if(errorMsg != null){
			String msg = "<div class="+"cont"+">エラーが発生しました</div><br><div class="+"cont"+">"+errorMsg+"</div><br>";
			return ok(views.html.delete.render(msg,formdata,taskNo));
		}
		return redirect(routes.HomeController.index());
	}
	
}
