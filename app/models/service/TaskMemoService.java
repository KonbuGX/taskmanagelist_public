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

public class TaskMemoService {

  protected TaskMemoDAO taskMemoDAO = new TaskMemoImplements();
  private final int ENCODEDTIMES = 5;

  //エラーチェック
  public List<String> validation(TaskMemoViewModel taskMemo,String status) {
    List<String> errorMsg = new ArrayList<String>();
    //必須チェック処理
    if (status == app.Enum.screenStatus.TASKMEMOINSERT.toString() && taskMemo.getMemoContents() == "") {
        errorMsg.add("メモの入力欄が未入力です。");
    }
    if(status == app.Enum.screenStatus.TASKMEMOUPDATE.toString() && taskMemo.getDialogMemoContents() == ""){
        errorMsg.add("ダイアログのメモの入力欄が未入力です。");
    }

    return errorMsg;
  }

  //メモのリストを全取得
  public List<TaskMemoDTO> selectAll(Connection conn,int accountNo,int taskNo) {
    return taskMemoDAO.selectAll(conn,accountNo,taskNo);
  }

  //accountNoで指定してリストを取得
  public List<TaskMemoDTO> select(Connection conn,int accountNo) {
    return taskMemoDAO.select(conn,accountNo);
  }

  //メモのインサート処理
  public String insertTaskMemo(Connection conn, TaskMemoViewModel taskMemo) {
    return taskMemoDAO.insertTaskMemo(conn, taskMemo);
  }

  //アップデート処理
  public String updateTaskMemo(Connection conn, TaskMemoViewModel taskMemo) {
    return taskMemoDAO.updateTaskMemo(conn, taskMemo);
  }

  //accountNo,taskNo,memoNoで指定してメモの削除
  public String deleteTaskMemo(Connection conn, int accountNo, int taskNo,int memoNo) {
    return taskMemoDAO.deleteTaskMemo(conn, accountNo, taskNo, memoNo);
  }

  //accountNoで指定してメモの削除
  public String deleteTaskMemoByAccountNo(Connection conn, int accountNo) {
    return taskMemoDAO.deleteTaskMemoByAccountNo(conn, accountNo);
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
