package com.zsgs.fitness77.module;
import java.util.Date;
public class Goal 
{
    private int goal_id;
    private Users user;
    private GoalType goalType;
    private  Date joindate;
    private Date derminateDate;  
    public Goal(Users user, GoalType goalType, Date joindate, Date derminateDate) 
    {
        this.user =user;
        this.goalType = goalType;
        this.joindate = joindate;
        this.derminateDate = derminateDate;
    }
    public int getGoal_id() {
        return goal_id;
    }
    public void setGoal_id(int goal_id) {
        this.goal_id = goal_id;
    }
    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }
    public GoalType getGoalType() {
        return goalType;
    }
    public void setGoalType(GoalType goalType) {
        this.goalType = goalType;
    }
    public Date getJoindate() {
        return joindate;
    }
    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }
    public Date getDerminateDate() {
        return derminateDate;
    }
    public void setDerminateDate(Date derminateDate) {
        this.derminateDate = derminateDate;
    } 
}
