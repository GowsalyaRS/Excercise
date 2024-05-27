package com.zsgs.fitness77.goal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.zsgs.fitness77.datalayer.FitnessDatabase;
import com.zsgs.fitness77.login.LoginView;
import com.zsgs.fitness77.module.Goal;
import com.zsgs.fitness77.module.GoalType;
import com.zsgs.fitness77.module.Users;
import com.zsgs.fitness77.workout.WorkoutView;
public class GoalViewModel
{
    private static SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd") ;
    private GoalView goalView;
    boolean getGoals = false;
    List <Goal> goalsList = new ArrayList<>();
    public GoalViewModel(GoalView goalView) 
    {
        this.goalView = goalView;
    }
    public GoalViewModel() {
    }
    public void 
    getGoal(Users user) throws SQLException, ParseException 
    {
        if(getGoals==false)
        {
            String query = " select * from users inner join goal on users.user_id = goal.user_id";
            ResultSet rs = FitnessDatabase.executerQueryData(query);
            while(rs.next())
            {
               int user_id =  rs.getInt(1) ;
               String username = rs.getString(2);
               String email = rs.getString(3);
               String password = rs.getString(4);
               int goal_id = rs.getInt(5) ;
               user_id = rs.getInt(6);
               String goalType = rs.getString(7);
               GoalType go = GoalType.valueOf(goalType);
               Date startDate = rs.getDate(8);
               Date endDate = rs.getDate(9); 
               Users users = new Users(username,email,password);
               users.setUser_id(user_id);
               Goal goal = new Goal(users,go,startDate,endDate);
               goal.setGoal_id(goal_id);
               goalsList.add(goal);
            }
            getGoals =true;
        } 
        listGoal(user);
    }
    public void listGoal(Users user) throws ParseException, SQLException 
    {
        System.out.println(user.getUser_id()); //
        boolean flag = false;
        for(int i=0;i<goalsList.size();i++)
        {
            Goal goal = goalsList.get(i);
            if(goal.getUser().getUser_id()==user.getUser_id())
            {
                isCheckDate(goal);
                flag = false;  
                break;
            }
        }
        if(flag)
        LoginView.alert("Your goal not available");
    }
    public void isCheckDate(Goal goal) throws ParseException, SQLException 
    {  
	   Date today = new Date();
	   String k =  s.format(today);
       Date todatDate = s.parse(k);
       Date finalDate = goal.getDerminateDate();
       System.out.println(finalDate.before(todatDate));
       System.out.println(finalDate + " -> " + todatDate);
       if(finalDate.after(todatDate))
       {
           new WorkoutView().addWorkouts(goal);  
       }
       else
       {
          LoginView.alert(" Your time is completed");
       }
    }
    public void validGoalType(int choose, GoalType[] goalType, Users user) throws ParseException 
    {
        if(choose<=goalType.length) 
        {
           goalView.setGoal(choose-1,goalType,user); 
        }
       LoginView.alert("Invalid goal type");
    }
    public void setGoal(Goal goal) 
    {
       String query = "insert into goal(user_id,goal_type,start_date,deadline_date) values(" + goal.getUser().getUser_id() + ", '" + goal.getGoalType() + "', '"+ new java.sql.Date(goal.getJoindate().getTime()) + "', '" + new java.sql.Date(goal.getDerminateDate().getTime()) + "' )";
       boolean row = FitnessDatabase.insertRecord(query);
       if(row)
       LoginView.alert("Goal added successfully....");
       else
       LoginView.alert("Goal not added successfully....");
    }
}
