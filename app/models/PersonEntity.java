package models;

import java.util.*;


public class PersonEntity {
	
	protected Integer id;
	public String name;
	public String mail;
	public String tel;
	
	public PersonEntity() {
		super();
	}
	
	public PersonEntity(int id,String name,String mail,String tel) {
		super();
		this.id = id;
	}
	
	public Integer getId() {return id;}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getMail() {return mail;}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getTel() {return tel;}
	
	@Override
	public String toString() {
		return id+":"+name+"["+mail+","+","+tel+"]";
	}
	
}