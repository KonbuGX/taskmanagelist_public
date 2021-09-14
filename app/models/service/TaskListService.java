package models;

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

public class TaskListService {
protected TaskListDAO taskListDAO = new TaskListImplements();
//protected enum screenStatus{CREATE,EDIT,DELETE,}
@Inject Database db;

public List<String> Validation(Connection conn,TaskListViewModel task,String status){
    List<String> errorMsg = new ArrayList<String>();
    //Connection conn = db.getConnection();
    int accountNo = 999;

    //タスクNo重複チェック
    List<TaskListDTO> tempList= select(conn,accountNo,task.taskNo);
    if(status == app.Enum.screenStatus.CREATE.toString() && tempList.size() > 0){
        errorMsg.add("タスクNoが重複しています。");
    }
    return errorMsg;
}

public List<TaskListDTO> selectAll(Connection conn){
    return taskListDAO.selectAll(conn);
}

public List<TaskListDTO> select(Connection conn,int accountNo,int taskNo){
    return taskListDAO.select(conn,accountNo,taskNo);
}

public String InsertTask(Connection conn,TaskListViewModel task){
    return taskListDAO.insertTask(conn,task);
}

public String UpdateTask(Connection conn,TaskListViewModel task){
    return taskListDAO.updateTask(conn,task);
}

public String DeleteTask(Connection conn,int accountNo,int taskNo){
    return taskListDAO.deleteTask(conn,accountNo,taskNo);
}

}