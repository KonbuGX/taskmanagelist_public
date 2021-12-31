package models;

import static play.libs.Scala.asScala;

import app.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Base64;
import java.util.concurrent.CompletionStage;
import javax.inject.*;
import models.*;
import org.mindrot.jbcrypt.BCrypt;
import play.data.*;
import play.db.*;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;

public class TaskListService {

  protected TaskListDAO taskListDAO = new TaskListImplements();
  private final int ENCODEDTIMES = 5;

  //エラーチェック
  public List<String> validation(Connection conn,TaskListViewModel task,String status) {
    List<String> errorMsg = new ArrayList<String>();
    //必須チェック処理
    if (task.getDeadline() == null) {
        errorMsg.add("期日を入力してください。");
    }

    //タスクNo重複チェック
    List<TaskListDTO> tempList = select(conn, task.getAccountNo(), task.getTaskNo());
    if (status == app.Enum.screenStatus.CREATE.toString() && tempList.size() > 0) {
        errorMsg.add("タスクNoが重複しています。更新してからもう一度登録してください");
    }
    return errorMsg;
  }

  //リストを全取得
  public List<TaskListDTO> selectAll(Connection conn) {
    return taskListDAO.selectAll(conn);
  }

  //accountNoで指定しての取得
  public List<TaskListDTO> selectByAccountNo(Connection conn, int accountNo) {
    return taskListDAO.selectByAccountNo(conn, accountNo);
  }

  //accountNo,taskNoで指定しての取得
  public List<TaskListDTO> select(Connection conn, int accountNo, int taskNo) {
    return taskListDAO.select(conn, accountNo, taskNo);
  }

  //インサート処理
  public String insertTask(Connection conn, TaskListViewModel task) {
    return taskListDAO.insertTask(conn, task);
  }

  //アップデート処理
  public String updateTask(Connection conn, TaskListViewModel task) {
    return taskListDAO.updateTask(conn, task);
  }

  //accountNo,taskNoで指定しての削除
  public String deleteTask(Connection conn, int accountNo, int taskNo) {
    return taskListDAO.deleteTask(conn, accountNo, taskNo);
  }

  //accountNoで指定しての削除
  public String deleteTaskByAccountNo(Connection conn, int accountNo) {
    return taskListDAO.deleteTaskByAccountNo(conn, accountNo);
  }

  //完了・未完了リストをセットする処理
  public TaskListViewModel setTaskList(List<TaskListDTO> tempList, TaskListViewModel taskListViewModel){
        taskListViewModel.taskList = new ArrayList<TaskListViewModel>();
        taskListViewModel.incompleteTaskList = new ArrayList<TaskListViewModel>();
		for(TaskListDTO temp : tempList){
            TaskListViewModel task = new TaskListViewModel();
            if(temp.status.equals("完了")){
			    task.setTaskNo(temp.taskNo);
			    task.setTaskName(temp.taskName);
			    task.setTaskContents(temp.taskContents);
			    task.setDeadline(temp.deadLine);
                task.setStatus(temp.status);
			    task.setPriority(temp.priority);
			    task.setLastupdate(temp.lastUpdate);
			    task.setEncodedResult(encodedResult(temp.taskNo));
			    taskListViewModel.taskList.add(task);
            }else{
                task.setTaskNo(temp.taskNo);
			    task.setTaskName(temp.taskName);
			    task.setTaskContents(temp.taskContents);
			    task.setDeadline(temp.deadLine);
			    task.setStatus(temp.status);
                task.setPriority(temp.priority);
			    task.setLastupdate(temp.lastUpdate);
			    task.setEncodedResult(encodedResult(temp.taskNo));
			    taskListViewModel.incompleteTaskList.add(task);
            }
        }
        return taskListViewModel;
    }  

  //編集・削除ボタン押下時の項目をセットする処理
  public Form<TaskListViewModel> setItem(Form<TaskListViewModel> formdata, List<TaskListDTO> form, int accountNo, String screenStatus, Form<TaskListViewModel> personform){
        TaskListViewModel temp = new TaskListViewModel();
		temp.setAccountNo(accountNo);
		for(TaskListDTO tempList : form){
            if(screenStatus.equals("TASKDELETE")){
                temp.setTaskNo(tempList.taskNo);
            }
			temp.setTaskName(tempList.taskName);
			temp.setTaskContents(tempList.taskContents);
			temp.setDeadline(tempList.deadLine);
			temp.setStatus(tempList.status);
            temp.setPriority(tempList.priority);
			formdata = personform.fill(temp);
		}
        return formdata;
   }

  //エンコード処理
  public String encodedResult(int taskNo) {
    Charset charset = StandardCharsets.UTF_8;
    String encodedResult = String.valueOf(taskNo);
    for (int i = 0; i < ENCODEDTIMES; i++) {
        encodedResult = Base64.getEncoder().encodeToString(encodedResult.getBytes(charset));
    }
    return encodedResult;
  }

  //デコード処理
  public int dencodedResult(String encodedString) {
    Charset charset = StandardCharsets.UTF_8;

    String result = encodedString;
    for (int i = 0; i < ENCODEDTIMES; i++) {
      byte[] decoded = Base64.getDecoder().decode(result);
      result = new String(decoded, charset);
    }
    return Integer.valueOf(result);
  }
}
