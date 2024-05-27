package com.zsgs.fitness77.module;
public class Users
{
   private int user_id;  
   private String username;
   private String email;
   private String password;
    public Users(String username, String email, String password) 
    {
      this.username = username;
      this.email = email;
      this.password = password;
    }
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }
    public String getEmail() 
    {
        return email;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }
    public String getPassword() 
    {
        return password;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String toString()
    {
        return ""+ user_id + "\t\t" + username + "\t\t" + email ;
    }
}