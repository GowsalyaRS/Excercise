package com.zsgs.fitness77.admin;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.zsgs.fitness77.module.Exercise;
import com.zsgs.fitness77.module.Users;
import com.zsgs.fitness77.workout.WorkoutViewModel;
public class AdminView 
{
    private AdminViewModel adminViewModel;
    Scanner scan;
    public AdminView()
    {
        this.adminViewModel = new AdminViewModel(this);
        scan = new Scanner(System.in);
    }
    public void init() throws SQLException
    {
        System.out.println("Enter the Username "); 
        String username = scan.nextLine();
        System.out.println("Enter the password");
        String password = scan.nextLine();
        adminViewModel.validateCheck(username,password);
    }
    public void accessUserDetails() throws SQLException 
    {
        while(true)
        {
            System.out.println("=======================================");
            System.out.println("1.Add Exercise  \n2.View Users  \n3.viwe Exercise \n4.Exit");
            System.out.println("=======================================");
            try
            {
                int choose = scan.nextInt();
                switch (choose) 
                {
                   case 1: addExercise();break;
                   case 2: viewUser();break;
                   case 3: viewExcercise();break; 
                   case 4: return;
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
    private void viewExcercise() throws SQLException 
    {
        List<Exercise> exercise = new WorkoutViewModel().getExercise();
        if(exercise.size()<0)
        {
            System.out.println("No Exercise available");
            System.out.println("------------------------------------------------------------------------------");
            return;
        }
        for(int i=0;i<exercise.size();i++)
        {
           System.out.println(exercise.get(i));
        } 
    }
    private void viewUser() throws SQLException 
    {
        List<Users> user = adminViewModel.getUser();
        System.out.println("User id " + "\t" + "Name " + "\t\t" + "Email");
        if(adminViewModel.isAvailableUser(user))
        {
           for(int i=0;i<user.size();i++)
           {
               System.out.println(user.get(i));
           }
        }
        else{
            System.out.println("No Users Available");
        }
    }
    private void addExercise() 
    {
        scan.nextLine();
        System.out.println("Enter the workout name "); 
        String exerciseName = scan.nextLine();
        System.out.println("Enter the description ");
        String description = scan.nextLine();
        System.out.println("Enter the equipment need press \"1\"");
        boolean isEquipment = false;
        int equipmentNumber = scan.nextInt();
        if(equipmentNumber==1)
        {
            isEquipment = true;
        }
        Exercise exercise = new Exercise(exerciseName, description, isEquipment);
        adminViewModel.addExercise(exercise);
    }
}
