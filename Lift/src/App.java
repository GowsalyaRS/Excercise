import java.util.Scanner;

public class App
{
    public static void main(String[] args) 
    {
       Scanner scan = new Scanner(System.in);
       System.out.println("\t....Welcome Zoho Lift Area....");
       System.out.println("Enter the number of lift");
       int numberOfLift = scan.nextInt();
       System.out.println("Enter the  overall floor");
       int floorCount = scan.nextInt();
       AccessLift accessLift = new AccessLift(numberOfLift,floorCount);
       accessLift.displayLift();
       while(true)
       {
           System.out.println("======================================");
           System.out.println("1.add access lift to user \n2.use lift  \n3.cleaning process \n4.Exit");
           System.out.println("======================================");
           System.out.println("Enter the number");
           int choose = scan.nextInt();
           switch(choose)
           {
              case 1: accessLift.addAccesslift();break;
              case 2: accessLift.travelLift();break;
              case 3: accessLift.cleaning();break; 
              case 4: return;
              default : System.out.println(" Oops...! enter the correct option ");
           }
        }
    }
}
