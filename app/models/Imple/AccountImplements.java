package models;

import java.util.*;
import java.util.List;
import play.mvc.*;
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
import java.text.SimpleDateFormat;

public class AccountImplements implements AccountDAO {
    @Inject Database db;

    public List<AccountDTO> selectAll(Connection conn){
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery("SELECT * from Account");
			
    		while(rs.next()){
				AccountDTO temp = new AccountDTO();
				//ローカルではSQLiteのためコメントアウト。近々postgresqlに変更予定。
				//Date nowDateTime2 = new java.sql.Date(Long.valueOf(rs.getString("lastUpdate")));
				temp.accountNo = rs.getInt("accountNo");
				temp.accountName = rs.getString("accountName");
				temp.password = rs.getString("password");
				temp.lastUpdate = rs.getDate("lastUpdate");
				list.add(temp);
    		}
    		rs.close();
    		stmt.close();
            conn.close();
    	}catch (Exception e){ 
            List<AccountDTO> tempList = new ArrayList<AccountDTO>();
			AccountDTO temp = new AccountDTO();
			long miliseconds = System.currentTimeMillis();
			Date nowDateTime = new Date(miliseconds);
			String msg = e.toString();

			temp.accountNo = 9999;
			temp.accountName = msg;
			temp.password = "";
			temp.lastUpdate = nowDateTime;
			tempList.add(temp);
            return tempList;
        }
    	return list;
    }

	public List<AccountDTO> selectByName(Connection conn,String accountName){
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{
			PreparedStatement ps = conn.prepareStatement("SELECT * from Account where accountName =?");
            ps.setString(1, accountName);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()){
				AccountDTO temp = new AccountDTO();
				//ローカルではSQLiteのためコメントアウト。近々postgresqlに変更予定。
				//Date nowDateTime2 = new java.sql.Date(Long.valueOf(rs.getString("lastUpdate")));
				temp.accountNo = rs.getInt("accountNo");
				temp.accountName = rs.getString("accountName");
				temp.password = rs.getString("password");
				temp.lastUpdate = rs.getDate("lastUpdate");
				list.add(temp);
    		}
    		rs.close();
    		ps.close();
            conn.close();
    	}catch (Exception e){ 
            List<AccountDTO> tempList = new ArrayList<AccountDTO>();
			AccountDTO temp = new AccountDTO();
			long miliseconds = System.currentTimeMillis();
			Date nowDateTime = new Date(miliseconds);
			String msg = e.toString();

			temp.accountNo = 9999;
			temp.accountName = msg;
			temp.password = "";
			temp.lastUpdate = nowDateTime;
			tempList.add(temp);
            return tempList;
        }
    	return list;
    }

	public String insertTask(Connection conn,AccountViewModel task){
         int accountNo = task.getAccountNo();
         String accountName= task.getAccountName();
         String password= task.getPassword();
         
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 
         String formattedDate = simpleDateFormat.format(task.getLastupdate());
         java.sql.Date date = java.sql.Date.valueOf(formattedDate);

			//Date date1 = new java.sql.Date(Long.valueOf(formattedDate));
	       //Date date2 = new java.sql.Date(Long.valueOf(formattedDate2));
         long miliseconds = System.currentTimeMillis();
			Date nowDateTime = new Date(miliseconds);
		try{
			PreparedStatement ps = conn.prepareStatement("insert into Account(accountNo,accountName,password,lastUpdate) values(?,?,?,?)");
			ps.setInt(1,accountNo);	
			ps.setString(2,accountName);	
			ps.setString(3,password);
			ps.setDate(4,date);
			ps.executeUpdate();

            ps.close();
            conn.close();
		}catch (SQLException e){
		    return e.toString();
		}
        return null;
    }

    public String updateTask(Connection conn,AccountViewModel task){
         /*int accountNo = task.getAccountNo();
         int taskNo= task.getTaskNo();
         String taskName= task.getTaskName();
	     String taskContents= task.getTaskContents();
         String status= task.getStatus();
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

         String formattedDate = simpleDateFormat.format(task.getDeadline());
         String formattedDate2 = simpleDateFormat.format(task.getLastupdate());
         java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);
         java.sql.Date date2 = java.sql.Date.valueOf(formattedDate2);
		 try{
			PreparedStatement ps = conn.prepareStatement( "update tasklist set taskName=?,taskContents=?,deadLine=?,status=?,lastUpdate=? where accountNo=? and taskNo=?");
			ps.setString(1,taskName);	
			ps.setString(2,taskContents);
			ps.setDate(3,date1);
            ps.setString(4,status);
			ps.setDate(5,date2);
            ps.setInt(6,accountNo);	
			ps.setInt(7,taskNo);
			ps.executeUpdate();

            ps.close();
            conn.close();
		}catch (SQLException e){
		    return e.toString();
		}*/
        return null;
    }

	public String deleteTask(Connection conn,int accountNo){
		/*try{
			//Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement(
				"delete from Account where accountNo=? and taskNo=?");
            ps.setInt(1,accountNo);	
			ps.executeUpdate();

            ps.close();
            conn.close();
		}catch (SQLException e){
		    return e.toString();
		}*/
        return null;
    }
}