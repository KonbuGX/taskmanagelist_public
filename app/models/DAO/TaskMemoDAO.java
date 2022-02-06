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

public interface TaskMemoDAO {
	//リストを全取得
	public List<TaskMemoDTO> selectAll(Connection conn,int accountNo,int taskNo);
    //accountNoで指定してリストを取得
	public List<TaskMemoDTO> select(Connection conn,int accountNo);
	//インサート処理
	public String insertTaskMemo(Connection conn,TaskMemoViewModel taskMemo);
	//アップデート処理
	public String updateTaskMemo(Connection conn,TaskMemoViewModel taskMemo);
	//accountNo,taskNo,memoNoで指定してメモの削除
	public String deleteTaskMemo(Connection conn,int accountNo,int taskNo,int memoNo);
    //accountNoで指定してメモの削除
	public String deleteTaskMemoByAccountNo(Connection conn,int accountNo);
}