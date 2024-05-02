public class User 
{
    private int userId;
    private static int count =1101;
    private String name;
    private int distination =-1;
    User (String name)
    {
        userId = count++;
        this.name = name;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDistination() {
        return distination;
    }
    public void setDistination(int distination) {
        this.distination = distination;
    }
    
}
