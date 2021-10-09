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
	//リストを全取得
	public List<AccountDTO> selectAll(Connection conn);
	//リストをaccountNameで指定しての取得
	public List<AccountDTO> selectByName(Connection conn,String accountName);
	//インサート処理
	public String insertAccount(Connection conn,AccountViewModel account);
	//アップデート処理
	public String updateAccount(Connection conn,AccountViewModel account);
	//デリート処理
	public String deleteAccount(Connection conn,int accountNo);
}