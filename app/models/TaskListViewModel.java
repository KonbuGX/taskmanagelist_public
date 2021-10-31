package models;

import java.util.*;
import play.db.*;
import models.*;
import java.sql.ResultSet;
import javax.persistence.*;
import io.ebean.Model;
import io.ebean.Finder;
import io.ebean.*;
import play.db.ebean.*;

public class TaskListViewModel extends Model{

    public Integer accountNo;
	public Integer taskNo;
    public String taskName;
	public String taskContents;
	public Date deadLine;
	public String status;
    public Date lastUpdate;
	public List<TaskListViewModel> taskList;
    public String encodedResult;

   public TaskListViewModel(){
        super();
		this.taskList = new ArrayList<TaskListViewModel>();
    }
	public TaskListViewModel(int accountNo,int taskNo,String taskName,String taskContents,Date deadLine,String status,Date lastUpdate) {
		super();
		this.accountNo = accountNo;
		this.taskNo = taskNo;
		this.taskName = taskName;
		this.taskContents = taskContents;
		this.deadLine = deadLine;
		this.status = status;
		this.lastUpdate = lastUpdate;
	}
	
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	
	public int getAccountNo() {return accountNo;}
	
	public void setTaskNo(int taskNo) {
		this.taskNo = taskNo;
	}
	
	public int getTaskNo() {
		return taskNo;
	}
	
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public String getTaskName() {return taskName;}
	
	public void setTaskContents(String taskContents) {
		this.taskContents = taskContents;
	}
	
	public String getTaskContents() {return taskContents;}

    public void setDeadline(Date deadLine) {
		this.deadLine = deadLine;
	}
	
	public Date getDeadline() {return deadLine;}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {return status;}

    public void setLastupdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public Date getLastupdate() {return lastUpdate;}

	public void setEncodedResult(String encodedResult) {
		this.encodedResult = encodedResult;
	}
	
	public String getEncodedResult() {return encodedResult;}

	@Override
	public String toString(){
		return accountNo+":"+taskNo+":"+taskName+":"+taskContents+":"+deadLine+":"+status+":"+lastUpdate;
	}

}