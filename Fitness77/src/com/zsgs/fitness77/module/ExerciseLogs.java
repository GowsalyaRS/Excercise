package com.zsgs.fitness77.module;
public class ExerciseLogs 
{
    private int log_id;
    private Exercise excercise;
    private Workout workout;
    private byte setOfWork;
    private float weight;
    public ExerciseLogs(Exercise excercise, Workout workout, byte setOfWork, float weight) 
    {
        this.excercise = excercise;
        this.workout = workout;
        this.setOfWork = setOfWork;
        this.weight = weight;
    }
    public int getLog_id() {
        return log_id;
    }
    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }
    public Exercise getExcercise() {
        return excercise;
    }
    public void setExcercise(Exercise excercise) {
        this.excercise = excercise;
    }
    public Workout getWorkout() {
        return workout;
    }
    public void setWorkout(Workout workout) {
        this.workout = workout;
    }
    public byte getSetOfWork() {
        return setOfWork;
    }
    public void setSetOfWork(byte setOfWork) {
        this.setOfWork = setOfWork;
    }
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    } 
    public String toString()
    {
        return "Exercise Name  :  " + excercise.getExe_name() + 
             "\nDescription    :  " + excercise.getDescription()+
             "\nWorkouts       :  " +
             "\nDate           :  " + workout.getDate()+
             "\nDuration       :  " + workout.getDuration()+
             "\nCalories       :  " + workout.getCalorie()+
             "\nCurrent Weight :  " + weight;
    }
}
