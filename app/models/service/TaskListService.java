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
  private int encodedTimes = 5;

  //エラーチェック
  public List<String> Validation(Connection conn,TaskListViewModel task,String status) {
    List<String> errorMsg = new ArrayList<String>();
    //必須チェック処理
    if (task.lastUpdate == null) {
      errorMsg.add("期日を入力してください。");
    }

    //タスクNo重複チェック
    List<TaskListDTO> tempList = select(conn, task.accountNo, task.taskNo);
    if (
      status == app.Enum.screenStatus.CREATE.toString() && tempList.size() > 0
    ) {
      errorMsg.add(
        "タスクNoが重複しています。更新してからもう一度登録してください"
      );
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
  public String InsertTask(Connection conn, TaskListViewModel task) {
    return taskListDAO.insertTask(conn, task);
  }

  //アップデート処理
  public String UpdateTask(Connection conn, TaskListViewModel task) {
    return taskListDAO.updateTask(conn, task);
  }

  //accountNo,taskNoで指定しての削除
  public String DeleteTask(Connection conn, int accountNo, int taskNo) {
    return taskListDAO.deleteTask(conn, accountNo, taskNo);
  }

  //accountNoで指定しての削除
  public String DeleteTaskByAccountNo(Connection conn, int accountNo) {
    return taskListDAO.deleteTaskByAccountNo(conn, accountNo);
  }

  //エンコード処理
  public String EncodedResult(int taskNo) {
    Charset charset = StandardCharsets.UTF_8;
    String encodedResult = String.valueOf(taskNo);
    for (int i = 0; i < encodedTimes; i++) {
      encodedResult =
        Base64.getEncoder().encodeToString(encodedResult.getBytes(charset));
    }
    return encodedResult;
  }

  //デコード処理
  public int DencodedResult(String encodedString) {
    Charset charset = StandardCharsets.UTF_8;

    String result = encodedString;
    for (int i = 0; i < encodedTimes; i++) {
      byte[] decoded = Base64.getDecoder().decode(result);
      result = new String(decoded, charset);
    }
    return Integer.valueOf(result);
  }
}
