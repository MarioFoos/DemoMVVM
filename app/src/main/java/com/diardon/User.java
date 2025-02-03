package com.diardon;

public class User
{
    private String name;
    private int age;

    public User(String nombre, int edad)
    {
        this.name = nombre;
        this.age = edad;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
}
