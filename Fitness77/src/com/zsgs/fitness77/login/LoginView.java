package com.zsgs.fitness77.login;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.zsgs.fitness77.module.Users;
public class LoginView 
{
    private LoginViewModel loginModel;
    private static Scanner scan = new Scanner(System.in);
    public LoginView()
    {
      loginModel = new LoginViewModel(this);
    } 
    public void init()  throws SQLException, ParseException
    {
        System.out.println("Enter the username ");
        String username = scan.nextLine();
        System.out.println("Enter the password ");
        String password = scan.nextLine();
        loginModel.validateCheck(username,password);
    }
    public static void alert(String msg)
    {
      System.out.println(msg);
    }
    public void userAccess() throws SQLException, ParseException {
        while(true)
        {
           System.out.println("=======================================");
           System.out.println("1.Signin \n2.SignUp \n3.Exit");
           System.out.println("=======================================");
           try
           {
              int choose = scan.nextInt();
              switch(choose)  
              {
                  case 1: scan.nextLine();signinProcess(); break;
                  case 2: scan.nextLine();init(); break;
                  case 3: return;
                  default:System.out.println("Invalid option...!");
              }
           }
           catch (InputMismatchException e)
           {
              System.out.println("Please Enter the Correct Option...!");
              scan.nextLine();
           }
        }
    }
    private void signinProcess() throws SQLException, ParseException 
    {
        System.out.println("Enter the username  ");
        String name = scan.nextLine();
        System.out.println("Enter the email ");
        String email = scan.nextLine();
        System.out.println("Enter the password ");
        String password = scan.nextLine();
        Users user = new Users(name,email,password);
        loginModel.isValidUser(user);
    }
}
 