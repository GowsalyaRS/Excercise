import java.util.ArrayList;
public class Lift 
{
    private int liftId;
    private static int count=1;
    private  ArrayList <User> users = new ArrayList() ;
    private int currentFloor;
    private int destination;
    private ArrayList <Integer> accessPoint = new ArrayList <>();
    private boolean upDirection;
    private int capacity;
    private int currentCapacity;
    private boolean cleaning;
    public boolean isCleaning() {
        return cleaning;
    }
    public void setCleaning(boolean cleaning) {
        this.cleaning = cleaning;
    }
    Lift (int capacity)
    {
        liftId = count++;
        this.capacity = capacity;
        accessPoint.add(0);
        upDirection = true;
    }
    public int getLiftId() {
        return liftId;
    }
    public void setLiftId(int liftId) {
        this.liftId = liftId;
    }
    public ArrayList<User> getUser() {
        return users;
    }
    public void setUser(User user) {
        users.add(user);
    }
    public int getCurrentFloor() {
        return currentFloor;
    }
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
    public int getDestination() {
        return destination;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getCurrentCapacity() {
        return currentCapacity;
    }
    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }
    public void setDestination(int destination) {
        this.destination = destination;
    }
    public ArrayList<Integer> getAccessPoint() {
        return accessPoint;
    }
    public void setAccessPoint(int accessPoints) {
        accessPoint.add(accessPoints);
    }
    public boolean isUpDirection() {
        return upDirection;
    }
    public void setUpDirection(boolean upDirection) {
        this.upDirection = upDirection;
    }
}
