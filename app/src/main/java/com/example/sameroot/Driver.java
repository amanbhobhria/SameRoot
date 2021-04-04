package com.example.sameroot;

public class Driver {
    String Driver_Name;
    String Driver_Mobile_No;
    String Car_No;
    String Car_Model;
    String Car_Company;
    String Driver_Adhaar_No;
    String Driver_City;


    public Driver(String ddname, String Driver_Name, String Driver_Mobile_No, String Car_No, String Car_Model, String Car_Company, String Driver_Adhaar_No, String Driver_City){
        this.Driver_Name = Driver_Name;
        this.Driver_Mobile_No = Driver_Mobile_No;
        this.Car_No = Car_No;
        this.Car_Model = Car_Model;
        this.Car_Company = Car_Company;
        this.Driver_Adhaar_No = Driver_Adhaar_No;
        this.Driver_City = Driver_City;
    }

    public String getDriver_Name() {
        return Driver_Name;
    }

    public String getDriver_Mobile_No() {
        return Driver_Mobile_No;
    }

    public String getCar_No() {
        return Car_No;
    }

    public String getCar_Model() {
        return Car_Model;
    }

    public String getCar_Company() {
        return Car_Company;
    }

    public String getDriver_Adhaar_No() {
        return Driver_Adhaar_No;
    }

    public String getDriver_City() {
        return Driver_City;
    }
}
