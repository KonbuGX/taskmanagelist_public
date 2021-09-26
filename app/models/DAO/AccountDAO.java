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

public interface AccountDAO {
	public List<AccountDTO> selectAll(Connection conn);
	public List<AccountDTO> selectByName(Connection conn,String accountName);
	public String insertTask(Connection conn,AccountViewModel task);
	public String updateTask(Connection conn,AccountViewModel task);
	public String deleteTask(Connection conn,int accountNo);
}