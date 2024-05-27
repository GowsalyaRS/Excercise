package com.zsgs.fitness77.workout;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.zsgs.fitness77.datalayer.FitnessDatabase;
import com.zsgs.fitness77.login.LoginView;
import com.zsgs.fitness77.module.Exercise;
import com.zsgs.fitness77.module.ExerciseLogs;
import com.zsgs.fitness77.module.Users;
import com.zsgs.fitness77.module.Workout;
public class WorkoutViewModel 
{
    private static SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd") ;
    private WorkoutView workoutView;
    List <Exercise> exeList = new ArrayList<>();
    boolean isExercise = false;
    public WorkoutViewModel(WorkoutView workoutView) 
    {
        this.workoutView = workoutView;
    }
    public WorkoutViewModel()
    {
    }
    public List<Exercise> getExercise() throws SQLException 
    {
        if(isExercise==false)
        {
           String query = "select * from exercise";
           ResultSet rs = FitnessDatabase.executerQueryData(query);
           while(rs.next())
           {
               int exe_id = rs.getInt(1);
               String exe_name = rs.getString(2) ;
               String des = rs.getString(3);
               boolean flag = rs.getBoolean(4);
               Exercise exe = new Exercise(exe_name, des, flag);
               exe.setExe_id(exe_id);
               exeList.add(exe);
           }
           isExercise = true;
        }
        return exeList;  
    }
    public void getExercise(int option, Users user) throws ParseException, SQLException {
        if(exeList.size()>=option)
          workoutView.addWorkouts(exeList.get(option),user);
        else
        LoginView.alert("Your wrong exercise choose");
    }
    public void addLog(ExerciseLogs log, Users user) throws SQLException 
    {
        boolean insertRow = false;
        Workout workout = log.getWorkout();
        int exe_id = log.getExcercise().getExe_id();
        String query = "insert into workout(user_id,workout_date,duration,calorie) values (" + user.getUser_id()+ ", '"+ new java.sql.Date(workout.getDate().getTime()) + "', "+ workout.getDuration()+ ", " + workout.getCalorie() + ")"; 
        insertRow =  FitnessDatabase.insertRecord(query);
        String qr = "SELECT workout_id FROM workout WHERE user_id = " + user.getUser_id() + " AND workout_date = '" + new java.sql.Date (workout.getDate().getTime()) + "'";
        ResultSet rs = FitnessDatabase.executerQueryData(qr);
        int row =0;
        while(rs.next())
        {
          row = rs.getInt(1);
        }
        workout.setWorkout_id(row);
        String quer = "insert into log(workout_id,exercise_id,sets,weight) values (" + workout.getWorkout_id() + ", " + exe_id + ", " + log.getSetOfWork() + ", " + log.getWeight() + ")";
        insertRow =  FitnessDatabase.insertRecord(quer);
        if(insertRow)
          LoginView.alert("Exercise Logs Added Successfully....");
        else
          LoginView.alert ("Exercise Logs not Added");
    }
    public List<ExerciseLogs> viewWorkoutHistory(Users user) throws SQLException 
    {
       String query = "select w.*,e.*,l.*  from workout w inner join log l on w.workout_id = l.workout_id inner join exercise e on l.exercise_id=e.exercise_id where w.user_id  = "  + user.getUser_id(); 
       ResultSet rs = FitnessDatabase.executerQueryData(query);
       List <ExerciseLogs> logs = new ArrayList();
       while(rs.next()) 
       {
           Date day = rs.getDate(3);
           int duration = rs.getInt(4);
           float calorie = rs.getFloat(5);
           Workout workout = new Workout(user, day, duration, calorie);
           String exe_name = rs.getString(7);
           String des = rs.getString(8);
           boolean equipment_needed = rs.getBoolean(9);
           Exercise ex = new Exercise(exe_name, des, equipment_needed);
           byte set = rs.getByte(13);
           float weight = rs.getFloat(14);
           ExerciseLogs log = new ExerciseLogs(ex, workout, set, weight);
           logs.add(log);
        }
        return logs;
    }
    public boolean isValidWorkoutHistory(List<ExerciseLogs> logs) 
    {
        if(logs.size()>0)
        {
            return true;
        }
        return false;
    }
}
