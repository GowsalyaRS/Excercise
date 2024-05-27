package com.zsgs.fitness77.workout;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.zsgs.fitness77.goal.GoalView;
import com.zsgs.fitness77.module.Exercise;
import com.zsgs.fitness77.module.ExerciseLogs;
import com.zsgs.fitness77.module.Goal;
import com.zsgs.fitness77.module.Users;
import com.zsgs.fitness77.module.Workout;
public class WorkoutView 
{
    private WorkoutViewModel workoutModel;
    SimpleDateFormat fDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    List <Exercise> exercise ;
    boolean isExercise = false;
    static Scanner scan ;
    private GoalView goalView;
    public WorkoutView()
    {
       workoutModel = new WorkoutViewModel(this);
       goalView = new GoalView();
       scan = new Scanner(System.in);
    }
    public void init(Users user) throws SQLException, ParseException 
    {
        while(true) 
        {
            System.out.println("=======================================");
            System.out.println("1.set goal \n2.workouts   \n3.Exit");
            System.out.println("=======================================");
            try
            {
                int choose = scan.nextInt();
                switch (choose) 
                {
                   case 1 : goalView.setGoal(user);break;
                   case 2 : addWorkouts(user);break;
                   case 3: return;
                   default: System.out.println("Please enter the correct option...!");   
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please Enter the Correct Option...!");
                scan.nextLine();
            }
        }
    }
    private void addWorkouts(Users user) throws SQLException, ParseException 
    {
        goalView.getGoal(user) ;
    }
    public void addWorkouts(Goal goal) throws SQLException, ParseException 
    {
        System.out.println("\t\tWelcome today Excercise start !");
        while(true) 
        {
            System.out.println("================================");
            System.out.println("1.Add workouts  \n2.view Workouts history \n3.exit");
            System.out.println("================================");
            int choose = scan.nextInt();
            try
            {
                switch (choose) 
                {
                    case 1 : addLogs(goal.getUser());break;
                    case 2 : viewWorkoutHistory(goal.getUser());break;
                    case 3 : return;
                    default: System.out.println("Enter the correct option!");  
                }
            }
            catch(InputMismatchException e)
            {
               System.out.println("\twrong input!");
               scan.nextLine();
            }
        } 
    }
    private void viewWorkoutHistory(Users user) throws SQLException 
    {
        List <ExerciseLogs> logs = workoutModel.viewWorkoutHistory(user); 
        if(workoutModel.isValidWorkoutHistory(logs))
        {
            for(int i=0;i<logs.size();i++)
            {
                System.out.println(logs.get(i));
            }
        }
        else
          System.out.println("\tYour don't any exercise log");
    }
    public  void addLogs(Users user) throws SQLException, ParseException 
    {
        exercise = workoutModel.getExercise();
        for(int i=0;i<exercise.size();i++)
        {
           System.out.println(i+1 + " -> "+ exercise.get(i));
        }
        System.out.println("Enter the option ");
        int option = scan.nextInt();
        workoutModel.getExercise(option-1,user);
    }
    public void addWorkouts(Exercise exercise, Users user) throws ParseException, SQLException 
    {
        Date date = new Date();
        String today = fDateFormat.format(date);
        Date todays = fDateFormat.parse(today);
        System.out.println("What is your workout time ? (minutes) ");
        int time= scan.nextInt();
        System.out.println("Your calories calulate");
        int calories =(time*2)*2;
        System.out.println("How many sets you try " + exercise.getExe_name() + " this exercise?");
        byte sets = scan.nextByte();
        System.out.println("Enter the current weight ");
        float weight = scan.nextFloat();
        Workout workout = new Workout(user, todays, time, calories);
        ExerciseLogs log = new ExerciseLogs(exercise,workout, sets, weight) ;
        workoutModel.addLog(log,user);
    }
}
