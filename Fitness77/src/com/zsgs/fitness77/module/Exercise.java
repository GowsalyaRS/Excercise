package com.zsgs.fitness77.module;

public class Exercise 
{
    private int exe_id;
    private String exe_name;
    private String description;
    private boolean equipment_needed;
    public Exercise(String exerciseName, String description, boolean equipment_needed) 
    {
        this.exe_name = exerciseName;
        this.description = description;
        this.equipment_needed = equipment_needed;
    }
    public int getExe_id() {
        return exe_id;
    }
    public void setExe_id(int exe_id) {
        this.exe_id = exe_id;
    }
    public String getExe_name() 
    {
        return exe_name;
    }
    public void setExe_name(String exe_name) 
    {
        this.exe_name = exe_name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }
    public boolean isEquipment_needed() 
    {
        return equipment_needed;
    }
    public void setEquipment_needed(boolean equipment_needed) 
    {
        this.equipment_needed = equipment_needed;
    }
    public String toString()
    {
       return "Exe_ id          : " + exe_id + 
            "\nExe Name         : " + exe_name+
            "\nDescription      : " + description+
            "\nEquipment needed : " + equipment_needed;
    }
}
