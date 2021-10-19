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
	
	//リストを全取得
    public List<AccountDTO> selectAll(Connection conn){
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery("SELECT * from Account");
			
    		while(rs.next()){
				AccountDTO temp = new AccountDTO();
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

	//リストをaccountNameで指定しての取得
	public List<AccountDTO> selectByName(Connection conn,String accountName){
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{
			PreparedStatement ps = conn.prepareStatement("SELECT * from Account where accountName =?");
            ps.setString(1, accountName);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()){
				AccountDTO temp = new AccountDTO();
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

	//インサート処理
	public String insertAccount(Connection conn,AccountViewModel account){
         int accountNo = account.getAccountNo();
         String accountName= account.getAccountName();
         String password= account.getPassword();
         
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
         String formattedDate = simpleDateFormat.format(account.getLastupdate());
         java.sql.Date date = java.sql.Date.valueOf(formattedDate);
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

	//アップデート処理
    public String updateAccount(Connection conn,AccountViewModel account){
        return null;
    }

	//デリート処理
	public String deleteAccount(Connection conn,int accountNo){
		try{
			PreparedStatement ps = conn.prepareStatement("DELETE from Account where accountNo=?");
			ps.setInt(1,accountNo);
            ps.executeUpdate();

            ps.close();
            conn.close();
		}catch (SQLException e){
		    return e.toString();
		}
        return null;
    }
}