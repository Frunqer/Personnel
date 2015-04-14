package com.personnel.bean.user;

import org.hibernate.validator.constraints.Email;

/**
 * 薪酬类
 * @author zhouzhenjiang
 *
 */
public class Salary {
    private int sid;
    private String email;
    private double basic_salary;
    private double season_salary;
    private double year_salary;
    private int salary_month;
    private double welfare;
    
    public Salary() {
        super();
        // TODO Auto-generated constructor stub
    }
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getBasic_salary() {
        return basic_salary;
    }
    public void setBasic_salary(double basic_salary) {
        this.basic_salary = basic_salary;
    }
    public double getSeason_salary() {
        return season_salary;
    }
    public void setSeason_salary(double season_salary) {
        this.season_salary = season_salary;
    }
    public double getYear_salary() {
        return year_salary;
    }
    public void setYear_salary(double year_salary) {
        this.year_salary = year_salary;
    }
    public int getSalary_month() {
        return salary_month;
    }
    public void setSalary_month(int salary_month) {
        this.salary_month = salary_month;
    }
    public double getWelfare() {
        return welfare;
    }
    public void setWelfare(double welfare) {
        this.welfare = welfare;
    }
    

}
