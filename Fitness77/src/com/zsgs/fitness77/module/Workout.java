package com.zsgs.fitness77.module;
import java.util.Date;
public class Workout 
{
    private int workout_id;
    private Users user;
    private Date date;
    private  int duration;
    private float calorie;
    public Workout(Users user, Date date, int duration, float calorie) 
    {
        this.user = user;
        this.date = date;
        this.duration = duration;
        this.calorie = calorie;
    }
    public int getWorkout_id() {
        return workout_id;
    }
    public void setWorkout_id(int workout_id) {
        this.workout_id = workout_id;
    }
    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public float getCalorie() {
        return calorie;
    }
    public void setCalorie(float calorie) {
        this.calorie = calorie;
    }
    public String toString()
    {
        return "" + date +"\t\t" + duration + "\t\t" + calorie;
    }
}