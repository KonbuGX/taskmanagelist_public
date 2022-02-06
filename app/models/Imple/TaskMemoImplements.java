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

public class TaskMemoImplements implements TaskMemoDAO {

	//メモのリストを全取得
    public List<TaskMemoDTO> selectAll(Connection conn,int accountNo,int taskNo){
		List<TaskMemoDTO> list = new ArrayList<TaskMemoDTO>();
        try{
    		PreparedStatement ps = conn.prepareStatement("SELECT * from TaskMemo where accountNo=? AND taskNo=? ORDER BY memoNo ASC;");
            ps.setInt(1, accountNo);
            ps.setInt(2, taskNo);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()){
				TaskMemoDTO temp = new TaskMemoDTO();
				temp.accountNo = rs.getInt("accountNo");
				temp.taskNo = rs.getInt("taskNo");
				temp.memoNo = rs.getInt("memoNo");
				temp.memoContents = rs.getString("memoContents");
				temp.lastUpdate = rs.getDate("lastUpdate");
				list.add(temp);
    		}
    		rs.close();
    		ps.close();
            conn.close();
    	}catch (Exception e){ 
            List<TaskMemoDTO> tempList = new ArrayList<TaskMemoDTO>();
			TaskMemoDTO temp = new TaskMemoDTO();
			long miliseconds = System.currentTimeMillis();
			Date nowDateTime = new Date(miliseconds);
			String msg = e.toString();

			temp.accountNo = 9999;
			temp.taskNo = 9999;
			temp.memoNo = 9999;
			temp.memoContents = msg;
			temp.lastUpdate = nowDateTime;
			tempList.add(temp);
            return tempList;
        }
    	return list;
    }

    //accountNoで指定してリストを取得
    public List<TaskMemoDTO> select(Connection conn,int accountNo){
		List<TaskMemoDTO> list = new ArrayList<TaskMemoDTO>();
        try{
    		PreparedStatement ps = conn.prepareStatement("SELECT * from TaskMemo where accountNo=?;");
            ps.setInt(1, accountNo);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()){
				TaskMemoDTO temp = new TaskMemoDTO();
				temp.accountNo = rs.getInt("accountNo");
				temp.taskNo = rs.getInt("taskNo");
				temp.memoNo = rs.getInt("memoNo");
				temp.memoContents = rs.getString("memoContents");
				temp.lastUpdate = rs.getDate("lastUpdate");
				list.add(temp);
    		}
    		rs.close();
    		ps.close();
            conn.close();
    	}catch (Exception e){ 
            List<TaskMemoDTO> tempList = new ArrayList<TaskMemoDTO>();
			TaskMemoDTO temp = new TaskMemoDTO();
			long miliseconds = System.currentTimeMillis();
			Date nowDateTime = new Date(miliseconds);
			String msg = e.toString();

			temp.accountNo = 9999;
			temp.taskNo = 9999;
			temp.memoNo = 9999;
			temp.memoContents = msg;
			temp.lastUpdate = nowDateTime;
			tempList.add(temp);
            return tempList;
        }
    	return list;
    }

	//メモのインサート処理
	public String insertTaskMemo(Connection conn,TaskMemoViewModel taskMemo){
         int accountNo = taskMemo.getAccountNo();
         int taskNo = taskMemo.getTaskNo();
         int memoNo = taskMemo.getMemoNo();
	     String memoContents = taskMemo.getMemoContents();
         
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
         String formattedDate = simpleDateFormat.format(taskMemo.getLastupdate());
         java.sql.Date lastUpdate = java.sql.Date.valueOf(formattedDate);
		try{
			PreparedStatement ps = conn.prepareStatement("insert into TaskMemo(accountNo,taskNo,memoNo,memoContents,lastUpdate) values(?,?,?,?,?)");
			ps.setInt(1,accountNo);	
			ps.setInt(2,taskNo);
			ps.setInt(3,memoNo);	
			ps.setString(4,memoContents);
			ps.setDate(5,lastUpdate);
			ps.executeUpdate();

            ps.close();
            conn.close();
		}catch (SQLException e){
		    return e.toString();
		}
        return null;
    }

    //アップデート処理
    public String updateTaskMemo(Connection conn,TaskMemoViewModel taskMemo){
         int accountNo = taskMemo.getAccountNo();
         int taskNo = taskMemo.getTaskNo();
         int memoNo = taskMemo.getMemoNo();
	     String memoContents = taskMemo.getMemoContents();
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

         String formattedDate = simpleDateFormat.format(taskMemo.getLastupdate());
         java.sql.Date lastUpdate = java.sql.Date.valueOf(formattedDate);
		 try{
			PreparedStatement ps = conn.prepareStatement( "update TaskMemo set memoContents=?,lastUpdate=? where accountNo=? and taskNo=? and memoNo=?");
			ps.setString(1,memoContents);
            ps.setDate(2,lastUpdate);
            ps.setInt(3,accountNo);
            ps.setInt(4,taskNo);
            ps.setInt(5,memoNo);
			ps.executeUpdate();

            ps.close();
            conn.close();
		}catch (SQLException e){
		    return e.toString();
		}
        return null;
    }

    //accountNo,taskNo,memoNoで指定してメモの削除
	public String deleteTaskMemo(Connection conn,int accountNo,int taskNo,int memoNo){
		try{
			PreparedStatement ps = conn.prepareStatement(
				"delete from TaskMemo where accountNo=? and taskNo=? and memoNo=?");
            ps.setInt(1,accountNo);	
			ps.setInt(2,taskNo);
            ps.setInt(3,memoNo);
			ps.executeUpdate();

            ps.close();
            conn.close();
		}catch (SQLException e){
		    return e.toString();
		}
        return null;
    }

    //accountNoで指定してメモの削除
	public String deleteTaskMemoByAccountNo(Connection conn,int accountNo){
		try{
			PreparedStatement ps = conn.prepareStatement(
				"delete from TaskMemo where accountNo=?");
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