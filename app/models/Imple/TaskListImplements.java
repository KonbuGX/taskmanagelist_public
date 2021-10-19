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

public class TaskListImplements implements TaskListDAO {
    @Inject Database db;

	//リストを全取得
    public List<TaskListDTO> selectAll(Connection conn){
		List<TaskListDTO> list = new ArrayList<TaskListDTO>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery("SELECT * from TaskList");
			
    		while(rs.next()){
				TaskListDTO temp = new TaskListDTO();
				temp.accountNo = rs.getInt("accountNo");
				temp.taskNo = rs.getInt("taskNo");
				temp.taskName = rs.getString("taskName");
				temp.taskContents = rs.getString("taskContents");
				temp.deadLine = rs.getDate("deadLine");
				temp.status = rs.getString("status");
				temp.lastUpdate = rs.getDate("lastUpdate");
				list.add(temp);
    		}
    		rs.close();
    		stmt.close();
            conn.close();
    	}catch (Exception e){ 
            List<TaskListDTO> tempList = new ArrayList<TaskListDTO>();
			TaskListDTO temp = new TaskListDTO();
			long miliseconds = System.currentTimeMillis();
			Date nowDateTime = new Date(miliseconds);
			String msg = e.toString();

			temp.accountNo = 9999;
			temp.taskNo = 9999;
			temp.taskName = "";
			temp.taskContents = msg;
			temp.deadLine = nowDateTime;
			temp.status = "";
			temp.lastUpdate = nowDateTime;
			tempList.add(temp);
            return tempList;
        }
    	return list;
    }

	//accountNoで指定しての取得
    public List<TaskListDTO> selectByAccountNo(Connection conn,int accountNo){
		List<TaskListDTO> list = new ArrayList<TaskListDTO>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{
			PreparedStatement ps = conn.prepareStatement("SELECT * from TaskList where accountNo=? ORDER BY taskNo ASC;");
            ps.setInt(1, accountNo);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()){
				TaskListDTO temp = new TaskListDTO();
				temp.accountNo = rs.getInt("accountNo");
				temp.taskNo = rs.getInt("taskNo");
				temp.taskName = rs.getString("taskName");
				temp.taskContents = rs.getString("taskContents");
				temp.deadLine = rs.getDate("deadLine");
				temp.status = rs.getString("status");
				temp.lastUpdate = rs.getDate("lastUpdate");
				list.add(temp);
    		}
    		rs.close();
    		ps.close();
            conn.close();
    	}catch (Exception e){ 
            List<TaskListDTO> tempList = new ArrayList<TaskListDTO>();
			TaskListDTO temp = new TaskListDTO();
			long miliseconds = System.currentTimeMillis();
			Date nowDateTime = new Date(miliseconds);
			String msg = e.toString();

			temp.accountNo = 9999;
			temp.taskNo = 9999;
			temp.taskName = "";
			temp.taskContents = msg;
			temp.deadLine = nowDateTime;
			temp.status = "";
			temp.lastUpdate = nowDateTime;
			tempList.add(temp);
            return tempList;
        }
    	return list;
    }

	//accountNo,taskNoで指定しての取得
	public List<TaskListDTO> select(Connection conn,int accountNo,int taskNo){
		List<TaskListDTO> list = new ArrayList<TaskListDTO>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{
			PreparedStatement ps = conn.prepareStatement("SELECT * from TaskList where accountNo=? and taskNo=?");
            ps.setInt(1, accountNo);
			ps.setInt(2, taskNo);
    		ResultSet rs = ps.executeQuery();

    		while(rs.next()){
				TaskListDTO temp = new TaskListDTO();
				temp.accountNo = rs.getInt("accountNo");
				temp.taskNo = rs.getInt("taskNo");
				temp.taskName = rs.getString("taskName");
				temp.taskContents = rs.getString("taskContents");
				temp.deadLine = rs.getDate("deadLine");
				temp.status = rs.getString("status");
				temp.lastUpdate = rs.getDate("lastUpdate");
				list.add(temp);
    		}
    		rs.close();
    		ps.close();
            conn.close();
    	}catch (Exception e){ 
            List<TaskListDTO> tempList = new ArrayList<TaskListDTO>();
			TaskListDTO temp = new TaskListDTO();
			long miliseconds = System.currentTimeMillis();
			Date nowDateTime = new Date(miliseconds);
			String msg = e.toString();

			temp.accountNo = 9999;
			temp.taskNo = 9999;
			temp.taskName = "";
			temp.taskContents = msg;
			temp.deadLine = nowDateTime;
			temp.status = "";
			temp.lastUpdate = nowDateTime;
			tempList.add(temp);
            return tempList;
        }
    	return list;
    }

	//インサート処理
	public String insertTask(Connection conn,TaskListViewModel task){
         int accountNo = task.getAccountNo();
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
			PreparedStatement ps = conn.prepareStatement("insert into TaskList(accountNo,taskNo,taskName,taskContents,deadLine,status,lastUpdate) values(?,?,?,?,?,?,?)");
			ps.setInt(1,accountNo);	
			ps.setInt(2,taskNo);
			ps.setString(3,taskName);	
			ps.setString(4,taskContents);
			ps.setDate(5,date1);
            ps.setString(6,status);
			ps.setDate(7,date2);
			ps.executeUpdate();

            ps.close();
            conn.close();
		}catch (SQLException e){
		    return e.toString();
		}
        return null;
    }

	//アップデート処理
    public String updateTask(Connection conn,TaskListViewModel task){
         int accountNo = task.getAccountNo();
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
			PreparedStatement ps = conn.prepareStatement( "update TaskList set taskName=?,taskContents=?,deadLine=?,status=?,lastUpdate=? where accountNo=? and taskNo=?");
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
		}
        return null;
    }

	//accountNo,taskNoで指定しての削除
	public String deleteTask(Connection conn,int accountNo,int taskNo){
		try{
			//Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement(
				"delete from TaskList where accountNo=? and taskNo=?");
            ps.setInt(1,accountNo);	
			ps.setInt(2,taskNo);
			ps.executeUpdate();

            ps.close();
            conn.close();
		}catch (SQLException e){
		    return e.toString();
		}
        return null;
    }

	//accountNoで指定しての削除
	public String deleteTaskByAccountNo(Connection conn,int accountNo){
		try{
			PreparedStatement ps = conn.prepareStatement("DELETE from TaskList where accountNo=?");
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