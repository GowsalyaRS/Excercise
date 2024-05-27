package com.zsgs.fitness77.goal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.zsgs.fitness77.module.Goal;
import com.zsgs.fitness77.module.GoalType;
import com.zsgs.fitness77.module.Users;
import java.util.Date;
public class GoalView 
{
    private GoalViewModel goalModel;
    static Scanner scan = new Scanner(System.in);
    public GoalView()
    {
        goalModel = new GoalViewModel(this);
    }
    public void getGoal(Users user) throws SQLException, ParseException 
    {
      goalModel.getGoal(user);
    }
    public void setGoal(Users user) throws ParseException 
    {
        GoalType [] goalType =  GoalType.values(); 
        for(int i=0;i<goalType.length;i++)
        {
            System.out.println((i+1) + " => " + goalType[i]);
        }
        System.out.println("Enter the goal type number ");
        int choose = scan.nextInt();
        goalModel.validGoalType(choose,goalType,user); 
    }
    public void setGoal(int choose, GoalType[] goalTypes, Users user) throws ParseException 
    {
        GoalType goalType =  goalTypes[choose];
        SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd"); 
        scan.nextLine();
        System.out.println("Enter the start  date exercise "); 
        String date = scan.nextLine();
        Date startDate = null;
        try
        {
          startDate =fdate.parse(date);
        }
        catch(ParseException e)
        {
           System.out.println("This is not valid  date");
           return;
        }
        System.out.println("Enter the  end date exercise "); 
        String endDate = scan.nextLine();
        Date endDates = null;
        try
        {
          endDates=fdate.parse(endDate);
        }
        catch(ParseException e)
        {
           System.out.println("This is not valid  date");
           return;
        }
        Goal goal = new Goal(user, goalType, startDate, endDates);
        goalModel.setGoal(goal);
    }   
}
