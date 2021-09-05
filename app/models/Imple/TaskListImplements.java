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
    public List<TaskListViewModel> selectAll(Connection conn){
		List<TaskListViewModel> list = new ArrayList<TaskListViewModel>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery("SELECT * from TaskList");
    		while(rs.next()){
		        Date nowDateTime = new java.sql.Date(Long.valueOf(rs.getString("deadLine")));
				Date nowDateTime2 = new java.sql.Date(Long.valueOf(rs.getString("lastUpdate")));
                list.add(new TaskListViewModel(rs.getInt("accountNo"),rs.getInt("taskNo"),rs.getString("taskName"),rs.getString("taskContents"),nowDateTime,rs.getString("status"),nowDateTime2));
    		}
    		rs.close();
    		stmt.close();
            conn.close();
    	}catch (Exception e){ 
            List<TaskListViewModel> temp = new ArrayList<TaskListViewModel>();
			long miliseconds = System.currentTimeMillis();
			Date nowDateTime = new Date(miliseconds);
			String msg = e.toString();
			temp.add(new TaskListViewModel(9999,9999,"",msg,nowDateTime,"",nowDateTime));
            return temp;
        }
    	return list;
    }

	public List<TaskListViewModel> select(Connection conn,int accountNo,int taskNo){
		List<TaskListViewModel> list = new ArrayList<TaskListViewModel>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery("SELECT * from TaskList where accountNo="+accountNo+" and taskNo="+taskNo);
    		while(rs.next()){
		        Date nowDateTime = new java.sql.Date(Long.valueOf(rs.getString("deadLine")));
				Date nowDateTime2 = new java.sql.Date(Long.valueOf(rs.getString("lastUpdate")));
                list.add(new TaskListViewModel(rs.getInt("accountNo"),rs.getInt("taskNo"),rs.getString("taskName"),rs.getString("taskContents"),nowDateTime,rs.getString("status"),nowDateTime2));
    		}
    		rs.close();
    		stmt.close();
            conn.close();
    	}catch (Exception e){ 
            List<TaskListViewModel> temp = new ArrayList<TaskListViewModel>();
			long miliseconds = System.currentTimeMillis();
			Date nowDateTime = new Date(miliseconds);
			String msg = e.toString();
			temp.add(new TaskListViewModel(9999,9999,"",msg,nowDateTime,"",nowDateTime));
            return temp;
        }
    	return list;
    }

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

			//Date date1 = new java.sql.Date(Long.valueOf(formattedDate));
	       //Date date2 = new java.sql.Date(Long.valueOf(formattedDate2));
         long miliseconds = System.currentTimeMillis();
			Date nowDateTime = new Date(miliseconds);
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

    public Boolean updateTask(Connection conn,TaskListViewModel task){
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
		    return false;
		}
        return true;
    }

	public Boolean deleteTask(Connection conn,int accountNo,int taskNo){
		try{
			//Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement(
				"delete from tasklist where accountNo=? and taskNo=?");
            ps.setInt(1,accountNo);	
			ps.setInt(2,taskNo);
			ps.executeUpdate();

            ps.close();
            conn.close();
		}catch (SQLException e){
		    return false;
		}
        return true;
    }
}