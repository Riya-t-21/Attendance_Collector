package com.example.attendance_collector;

public class student_list
{
  public String name,lastname,age,mobile,email,date;
    public  student_list()
    {

    }
    public student_list(String name,String lastname,String age,String mobile,String email,String date)
    {
        this.name=name;
        this.lastname=lastname;
        this.age=age;
        this.mobile=mobile;
        this.email=email;
        this.date=date;

    }
    // get methods to set data
    public String getName()
    {
        return name;
    }

    public String getLastname()
    {
        return lastname;
    }
    public String getAge()
    {
        return age;
    }
    public String getMobile()
    {
        return mobile;
    }
    public String getEmail()
    {
        return email;
    }
    public String getDate()
    {
        return date;
    }
//____________set methods to get data_______________-

    public void setName(String name)
    {
        this.name=name;
    }
    public void setLastname(String lastname)
    {
        this.lastname=lastname;
    }
    public void setAge(String age)
    {
        this.age=age;
    }
    public void setMobile(String mobile)
    {
        this.mobile=mobile;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public void setDate(String date)
    {
        this.date=date;
    }
}
