package com.WebXemPhim.model;

import java.util.ArrayList;
import java.util.List;

public class UserAccount {
	public UserAccount() {
	}
	
	public UserAccount(String user, String pass, List<String> roles) {
		super();
		this.user = user;
		this.pass = pass;
		this.roles=new ArrayList<String>();
		this.roles = roles;
	}
	private int id_Account;
	private String user;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public int getId_Account() {
		return id_Account;
	}
	public void setId_Account(int id_Account) {
		this.id_Account = id_Account;
	}
	private String pass;
	private List<String> roles;

}
