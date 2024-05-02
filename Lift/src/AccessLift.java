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
        System.out.println("Enter the direction up (true /false)");
        boolean direction = scan.nextBoolean();
        System.out.println("Enter the destination ");
        int destination = scan.nextInt();
        Lift lift = null;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<lifts.length;i++)
        {
           Lift elevator =  lifts[i];
           if(elevator.isCleaning())
           {
              continue;
           }
           if(elevator.getAccessPoint().contains(floorNumber) && elevator.getAccessPoint().contains(destination) &&  (elevator.getCurrentCapacity()+1)<elevator.getCapacity()  )
           {
              if(direction || !direction)
              {
                int floor = Math.abs( elevator.getCurrentFloor()-floorNumber);
                if(min>floor)
                {
                   lift = elevator;
                   min = floor;
                }
              }
           }
        }
        if(lift==null)
        {
            for(int i=0;i<lifts.length;i++)
            {
                Lift liftss = lifts[i];
                if(liftss.isCleaning())
                {
                    continue;
                }
                if(liftss.getAccessPoint().contains(floorNumber))
                {
                    int floor = Math.abs(liftss.getCurrentFloor()-floorNumber);
                    if(min>floor)
                    {
                      lift = liftss;
                       min = floor;
                    }
                }
            } 
            System.out.println("Your assigned lift : " + lift.getLiftId()); 
            lift.setDestination(destination);
            lift.setCurrentFloor(destination);
            displayLift();
            return;
        }
        System.out.println("Your assigned lift : " + lift.getLiftId());
        int des =0;
        if(direction)
        {
          lift.setCurrentCapacity(lift.getCurrentCapacity()+1);
          des =  Math.max (lift.getDestination(),destination); 
        }
        else 
        {
           des =Math.min(destination,lift.getDestination());
        }
        lift.setDestination(des);
        lift.setCurrentFloor(des);
        displayLift();
    }
    public void cleaning()
    {
        while(true) 
        {
            System.out.println("1.start cleaning  \n2.Finished cleaning  \n.exit");
            int choose = scan.nextInt();
            switch (choose) 
            {
                case 1:stratCleaning();break;
                case 2:finishedCleaning();break;
                case 3:return;
                default : System.out.println(" oops..! enter the correct option ");   
            }
        }
    }
    public  void finishedCleaning() 
    {
        System.out.println("Enter the lift number"); 
        int liftNumber = scan.nextInt();
        if(liftNumber <=liftNumber)
        {
           lifts [liftNumber-1].setCleaning(false);
           System.out.println("Finished cleaning lift");
        }
        else{
            System.out.println("This is lift invalid");
        }
    }
    public void stratCleaning() 
    {
        System.out.println("Enter the cleaning left number ");
        int liftNumber = scan.nextInt();
        if(liftNumber<=lifts.length )
        {
            lifts [liftNumber-1].setCleaning(true);
            System.out.println("Cleaning  lift  added successfully");
        }
        else
        {
            System.out.println("This is lift invalid");
        }
    }

}
