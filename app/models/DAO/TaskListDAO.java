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

public interface TaskListDAO {
	//リストを全取得
	public List<TaskListDTO> selectAll(Connection conn);
	//accountNoで指定しての取得
	public List<TaskListDTO> selectByAccountNo(Connection conn,int accountNo);
	//accountNo,taskNoで指定しての取得
	public List<TaskListDTO> select(Connection conn,int accountNo,int taskNo);
	//インサート処理
	public String insertTask(Connection conn,TaskListViewModel task);
	//アップデート処理
	public String updateTask(Connection conn,TaskListViewModel task);
	//accountNo,taskNoで指定しての削除
	public String deleteTask(Connection conn,int accountNo,int taskNo);
	//accountNoで指定しての削除
	public String deleteTaskByAccountNo(Connection conn,int accountNo);
}