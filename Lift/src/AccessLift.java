import java.util.ArrayList;
import java.util.Scanner;
public class AccessLift 
{
    private ArrayList <User> users= new ArrayList();
    private Lift [] lifts ;
    private static int floor;
    private static Scanner scan = new Scanner(System.in);
    AccessLift(int numberOfLift,int floor)
    {
       this.floor = floor;
       lifts = new Lift[numberOfLift];
       setAccessPoint(lifts);
    }
    public static void setAccessPoint(Lift lifts[])
    {
        for(int i=0;i<lifts.length;i++)
        {
          System.out.println( "lift -> "+ (i+1) +  "\nEnter the lift overall capacity");
          int capacity = scan.nextInt();
          Lift lift = new Lift(capacity);
          lifts[i] = lift;
          System.out.println("Enter the access points count ");
          int accessCount = scan.nextInt();
          System.out.println("Enter the access points");
          for(int j=0;j<accessCount;j++)
          {
            int accessPoint = scan.nextInt();
            if(accessPoint<floor)
            {
                lift.setAccessPoint(accessPoint); 
            }
            else
            {
                j = (j==0)?0:j--;
            }
          }
        }
    }
    public void displayLift()
    {
        System.out.println("Lift " + "\t\tFloor");
        for(int i=0;i<lifts.length;i++)
        {
           Lift lift =  lifts [i];
           System.out.println(lift.getLiftId()  + "\t\t" + lift.getCurrentFloor()); 
        } 
    }
    public void addAccesslift() 
    {
        scan.nextLine();
        System.out.println("Enter the user name"); 
        String name = scan.nextLine();
        User user = new User(name);
        users.add(user);
        System.out.println("provide access in lift Successfully....!");
        System.out.println("Your access Id  : " + user.getUserId()); 
    }
    public void travelLift() 
    {
        System.out.println("Enter the access Id ");
        int accessId = scan.nextInt();
        for(int i=0;i<users.size();i++)
        {
            if(users.get(i).getUserId()==accessId)
            {
                travelLift(users.get(i));
                return;
            }
        }
        System.out.println("oops!...access id is Invalid "); 
    }
    private void travelLift(User user) 
    {
        System.out.println("Your currect floor ");
        int floorNumber = scan.nextInt();
        System.out.println("Enter the direction up ");
        boolean direction = scan.nextBoolean();
        System.out.println("Enter the destination ");
        int destination = scan.nextInt();
        Lift lift = null;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<lifts.length;i++)
        {
           Lift elevator =  lifts[i];
           if(elevator.getAccessPoint().contains(floorNumber) && elevator.getAccessPoint().contains(destination) &&  (elevator.getCurrentCapacity()+1)<elevator.getCapacity() && elevator.isUpDirection()==direction)
           {
               int floor = Math.abs( elevator.getCurrentFloor()-floorNumber);
               System.out.println(floor);
               if(min>floor)
               {
                   lift = elevator;
                   min = floor;
               }
           }
        }
        if(lift==null)
        {
            System.out.println("lift is not available pls wait a minutes....");
            return ;
        }
        System.out.println("Your assigned lift : " + lift.getLiftId());
        displayLift();
        lift.setCapacity(lift.getCapacity()+1);
        lift.setCurrentCapacity(lift.getCurrentCapacity()+1);
        int des =  Math.max (lift.getDestination(),destination);
        lift.setDestination(des);
    }
}
