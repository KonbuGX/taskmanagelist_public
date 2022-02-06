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

public class TaskMemoViewModel extends Model{

    public Integer accountNo;
	public Integer taskNo;
    public Integer memoNo;
	public String memoContents;
    public Date lastUpdate;
    public String encodedResult;
    public List<TaskMemoDTO> taskMemoList;
    public String taskName;
	public String taskContents;
    public String dialogMemoContents;

   public TaskMemoViewModel(){
        super();
        this.taskMemoList = new ArrayList<TaskMemoDTO>();
    }
	public TaskMemoViewModel(int accountNo,int taskNo,int memoNo,String memoContents,Date lastUpdate) {
		super();
		this.accountNo = accountNo;
		this.taskNo = taskNo;
        this.memoNo = memoNo;
        this.memoContents = memoContents;
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
	
    public void setMemoNo(int memoNo) {
		this.memoNo = memoNo;
	}
	
	public int getMemoNo() {return memoNo;}
	
	public void setMemoContents(String memoContents) {
		this.memoContents = memoContents;
	}
	
	public String getMemoContents() {return memoContents;}

    public void setLastupdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public Date getLastupdate() {return lastUpdate;}

	public void setEncodedResult(String encodedResult) {
		this.encodedResult = encodedResult;
	}

    public String getEncodedResult() {return encodedResult;}
	
    public void setDialogMemoContents(String dialogMemoContents) {
		this.dialogMemoContents = dialogMemoContents;
	}

    public String getDialogMemoContents() {return dialogMemoContents;}

	@Override
	public String toString(){
		return accountNo+":"+taskNo+":"+memoNo+":"+memoContents+":"+lastUpdate;
	}

}