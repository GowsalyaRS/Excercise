package com.zsgs.fitness77.admin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.zsgs.fitness77.datalayer.FitnessDatabase;
import com.zsgs.fitness77.login.LoginView;
import com.zsgs.fitness77.module.Exercise;
import com.zsgs.fitness77.module.Users;
public class AdminViewModel 
{
    private AdminView adminView;
    private List <Users> users = new ArrayList();
    public AdminViewModel(AdminView adminView) 
    {
        this.adminView = adminView;
    }
    public void validateCheck(String username, String password) throws SQLException  {
        if (username.equals("zsgs"))  {
            if (password.equals("zoho")) 
            {
                LoginView.alert("\tWelcome admin " + username);
                adminView.accessUserDetails(); 
            }
            else 
                LoginView.alert("Invalid Username");
        } 
        else 
            LoginView.alert("Invalid username");
    }
    public void addExercise(Exercise exercise) {
        String query = "INSERT INTO exercise (name, description, equipment_needed) VALUES ('" +
        (exercise.getExe_name()) + "', '" +
        (exercise.getDescription()) + "', " +
        exercise.isEquipment_needed() + ")";
        boolean insertRecord = FitnessDatabase.insertRecord(query);
        if (insertRecord)
            LoginView.alert("Exercise Added Successfully");
        else
            LoginView.alert("Exercise not added Successfully");
    }
    public List<Users> getUser() throws SQLException 
    {
        String query = "select * from users";
        ResultSet rs = FitnessDatabase.executerQueryData(query);  
        while(rs.next())
        {
           int user_id = rs.getInt(1);
           String name = rs.getString(2);
           String email = rs.getString(3);
           String password = rs.getString(4);
           Users user = new Users(name, email, password);
           user.setUser_id(user_id);
           users.add(user);
        }
        return users;
    }
    public boolean isAvailableUser(List<Users> user) 
    {
       if(user.size()>0)
       {
          return true;
       }
       return false;
    }
}
