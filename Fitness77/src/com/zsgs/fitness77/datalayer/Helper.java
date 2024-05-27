package com.zsgs.fitness77.datalayer;

import java.sql.SQLException;

public class Helper 
{
    public void createUsersTable() throws SQLException
    {
        String query = "CREATE TABLE if not exists users ( user_id INT NOT NULL AUTO_INCREMENT,username VARCHAR(200) NOT NULL, email VARCHAR(200) NOT NULL, password VARCHAR(200) NOT NULL, PRIMARY KEY (user_id))";
        FitnessDatabase.insertRecord(query);
    }
    public void createExcerciseTable()throws SQLException
    {
        String query = "CREATE TABLE if not exists exercise (exercise_id INT NOT NULL AUTO_INCREMENT, name VARCHAR(200),description VARCHAR(500),equipment_needed TINYINT(1), PRIMARY KEY (exercise_id))" ;
        FitnessDatabase.insertRecord(query);
    }
    public void createWorkoutsTable()throws SQLException
    {
        String query = "CREATE TABLE if not exists workout (workout_id INT NOT NULL AUTO_INCREMENT,user_id INT, workout_date DATE,duration INT,calorie DECIMAL(10,2),PRIMARY KEY (workout_id),FOREIGN KEY (user_id) REFERENCES users(user_id))";
        FitnessDatabase.insertRecord(query);
    }
    public void createGoalTable()throws SQLException
    {
        String query = "CREATE TABLE if not exists goal (goal_id INT NOT NULL AUTO_INCREMENT,user_id INT,goal_type ENUM('weight_loss','muscle_gain','strength') NOT NULL,start_date DATE NOT NULL,deadline_date DATE,PRIMARY KEY (goal_id),FOREIGN KEY (user_id) REFERENCES users(user_id))";
        FitnessDatabase.insertRecord(query);
    }
    public void  createExerciseLogsTable()throws SQLException
    {
        String query = "CREATE TABLE if not exists log (log_id INT NOT NULL AUTO_INCREMENT,workout_id INT,exercise_id INT,sets TINYINT, weight DECIMAL(10,2),PRIMARY KEY (log_id),FOREIGN KEY (workout_id) REFERENCES workout(workout_id),FOREIGN KEY (exercise_id) REFERENCES exercise(exercise_id))";
        FitnessDatabase.insertRecord(query);
    }
}

