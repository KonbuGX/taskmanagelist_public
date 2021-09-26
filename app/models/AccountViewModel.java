package models;

import java.util.*;
import play.db.*;
import models.*;

public class AccountViewModel{
    public Integer accountNo;
	public String accountName;
	public String password;
	public Date lastUpdate;

    public AccountViewModel(){
        super();
    }
	public AccountViewModel(int accountNo,String accountName,String password,Date lastUpdate) {
		super();
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.password = password;
		this.lastUpdate = lastUpdate;
	}

    public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	
	public int getAccountNo() {return accountNo;}

    public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public String getAccountName() {return accountName;}

    public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {return password;}

    public void setLastupdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public Date getLastupdate() {return lastUpdate;}
}