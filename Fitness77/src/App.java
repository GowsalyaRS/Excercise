import java.util.InputMismatchException;
import java.util.Scanner;

import com.zsgs.fitness77.admin.AdminView;
import com.zsgs.fitness77.datalayer.Helper;
import com.zsgs.fitness77.login.LoginView;
public class App 
{
    static
    {
        Helper helper = new Helper();
        try 
        {
            helper.createUsersTable();
            helper.createExcerciseTable();
            helper.createGoalTable();
            helper.createExerciseLogsTable();
            helper.createWorkoutsTable();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception 
    {
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            System.out.println("=======================================");
            System.out.println("1.Admin \n2.User \n3.Exit");
            System.out.println("=======================================");
            try
            {
                int choose = scan.nextInt();
                switch (choose) 
                {
                   case 1:new AdminView().init();break;
                   case 2: new LoginView().userAccess();break;
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
}
