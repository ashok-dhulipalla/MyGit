package com.ashok.models;

import java.util.Date;

public class UserTEO
{
    private Integer id;
    private String name;
    private String email;
    private String password;
    private int status;
    private String creation_date;
 
	public String getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
	@Override
	public String toString() {
		return "UserTEO [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", status="
				+ status + ", creation_date=" + creation_date + "]";
	}
	
}
