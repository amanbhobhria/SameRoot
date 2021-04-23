package com.example.sameroot;

public class model1 {
    String driver_Name,driver_Mobile_No,driver_Adhaar_No,car_No,car_Model,car_Company;
    model1()
    {

    }

    public model1(String driver_Name, String driver_Mobile_No, String driver_Adhaar_No, String car_No, String car_Model, String car_Company) {
        this.driver_Name = driver_Name;
        this.driver_Mobile_No = driver_Mobile_No;
        this.driver_Adhaar_No = driver_Adhaar_No;
        this.car_No = car_No;
        this.car_Model = car_Model;
        this.car_Company = car_Company;
    }

    public String getDriver_Name() {
        return driver_Name;
    }

    public void setDriver_Name(String driver_Name) {
        this.driver_Name = driver_Name;
    }

    public String getDriver_Mobile_No() {
        return driver_Mobile_No;
    }

    public void setDriver_Mobile_No(String driver_Mobile_No) {
        this.driver_Mobile_No = driver_Mobile_No;
    }

    public String getDriver_Adhaar_No() {
        return driver_Adhaar_No;
    }

    public void setDriver_Adhaar_No(String driver_Adhaar_No) {
        this.driver_Adhaar_No = driver_Adhaar_No;
    }

    public String getCar_No() {
        return car_No;
    }

    public void setCar_No(String car_No) {
        this.car_No = car_No;
    }

    public String getCar_Model() {
        return car_Model;
    }

    public void setCar_Model(String car_Model) {
        this.car_Model = car_Model;
    }

    public String getCar_Company() {
        return car_Company;
    }

    public void setCar_Company(String car_Company) {
        this.car_Company = car_Company;
    }
}
