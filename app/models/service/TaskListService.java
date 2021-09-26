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
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class TaskListService {
protected TaskListDAO taskListDAO = new TaskListImplements();
private int encodedTimes = 5;
//protected enum screenStatus{CREATE,EDIT,DELETE,}
@Inject Database db;

public List<String> Validation(Connection conn,TaskListViewModel task,String status){
    List<String> errorMsg = new ArrayList<String>();
    //必須チェック処理
    /*if(task.taskNo.length() < 1){
        errorMsg.add("タスクNoを入力してください");
    }*/
    if(task.lastUpdate == null){
        errorMsg.add("期日を入力してください。");
    }

    //タスクNo重複チェック
    List<TaskListDTO> tempList= select(conn,task.accountNo,task.taskNo);
    if(status == app.Enum.screenStatus.CREATE.toString() && tempList.size() > 0){
        errorMsg.add("タスクNoが重複しています。更新してからもう一度登録してください");
    }
    return errorMsg;
}

public List<TaskListDTO> selectAll(Connection conn){
    return taskListDAO.selectAll(conn);
}

public List<TaskListDTO> selectByAccountNo(Connection conn,int accountNo){
    return taskListDAO.selectByAccountNo(conn,accountNo);
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

public String EncodedResult(int taskNo){
		Charset charset = StandardCharsets.UTF_8;
		String encodedResult = String.valueOf(taskNo);
        for(int i = 0;i<encodedTimes;i++){
            encodedResult = Base64.getEncoder().encodeToString(encodedResult.getBytes(charset));
        }
    return encodedResult;
}

public int DencodedResult(String encodedString){
		Charset charset = StandardCharsets.UTF_8;
		
        String result = encodedString;
        for(int i = 0;i<encodedTimes;i++){
            byte[] decoded = Base64.getDecoder().decode(result);
            result = new String(decoded, charset);
        }
    return Integer.valueOf(result);
}

}