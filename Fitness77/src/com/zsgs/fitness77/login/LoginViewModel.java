package com.zsgs.fitness77.login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.zsgs.fitness77.datalayer.FitnessDatabase;
import com.zsgs.fitness77.module.Users;
import com.zsgs.fitness77.workout.WorkoutView;
public class LoginViewModel
{
    private LoginView loginView;
    ArrayList <Users> users;
    boolean isCheckUser ;
    public LoginViewModel(LoginView loginView) 
    {
        this.loginView = loginView; 
        users= new ArrayList<>();
    }
    public void validateCheck(String username, String password) throws SQLException, ParseException 
    {
        if(isCheckUser==false)
        {
            String query = "select * from users";
            ResultSet rs =FitnessDatabase.executerQueryData(query);
            while(rs.next())
            {
                int user_id = rs.getInt(1);
                String user = rs.getString(2);
                String email = rs.getString(3);
                String passwords = rs.getString(4);
                Users us = new Users(user,email,passwords);
                us.setUser_id(user_id);
                users.add(us);
            }
            isCheckUser = true;
        }

            Users user = validUser(username,password);
            if(user==null)
            {
                loginView.alert("Invalid User!");
                return;
            }
            loginView.alert("\tWELCOME " + user.getUsername());
            new WorkoutView().init(user);  
    }
    public Users validUser(String username, String password) 
    {
        Users user =null;
        for(int i=0;i<users.size();i++)
        {
            user = users.get(i);
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
            {
               return user;
            }
        }
        return null;
    }
    public void isValidUser(Users user) throws SQLException, ParseException 
    {
        if(!isValidUser(user.getUsername(),user.getEmail()))
           return;    
        if(isCheckUser==false)
        {
            validateCheck(user.getUsername(),user.getPassword());
        }
        for(int i=0;i<users.size();i++)
        {
            if(!users.get(i).getUsername().equals(user.getUsername()))
            {
                if(users.get(i).getEmail().equals(user.getEmail()))
                {
                   LoginView.alert("Already use this email!");
                   return;
                }
            }
            else{
                LoginView.alert("Already use this username! ");
                return;
            }
        }
        addUser(user);
        users.add(user); 
        new WorkoutView().init(user); 
    }
    private void addUser(Users user) 
    {
        String query = "insert into users(username,email,password) values ('" + user.getUsername()+ "', '" + user.getEmail() + "', '" + user.getPassword()+ "')" ; 
        if(FitnessDatabase.insertRecord(query))
           LoginView.alert("User added Successfully ");
        else
           LoginView.alert("User not added Successfully ");
    }
    private boolean isValidUser(String username, String email) 
    {
        if(username.length()<3 || username.length()>50)
        {
            LoginView.alert("User name is Invalid");
            return false;
        }
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches())
        {
            LoginView.alert("User email is Invalid");
            return false;
        }
        return true;
    }
}
