package models;

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

public String Validation(TaskListViewModel task){
    String errorMsg = "";
    /*Connection conn = db.getConnection();
    int accountNo = 999;
    List<TaskListViewModel> tempList= select(conn,accountNo,taskNo);
    if(tempList.count() >= 0){
        errorMsg += errorMsg+"タスクNoが重複しています。";
    }*/
    return errorMsg;
}

public List<TaskListViewModel> selectAll(Connection conn){
    return taskListDAO.selectAll(conn);
}

public List<TaskListViewModel> select(Connection conn,int accountNo,int taskNo){
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