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
	public List<TaskListViewModel> selectAll(Connection conn);
	public List<TaskListViewModel> select(Connection conn,int accountNo,int taskNo);
	public String insertTask(Connection conn,TaskListViewModel task);
	public Boolean updateTask(Connection conn,TaskListViewModel task);
	public Boolean deleteTask(Connection conn,int accountNo,int taskNo);
}