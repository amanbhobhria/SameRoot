package com.example.sameroot;

public class Driver {
    String Driver_Name;
    String Driver_Mobile_No;
    String Car_No;
    String Car_Model;
    String Car_Company;
    String Driver_Adhaar_No;
    String Driver_City;

    public void setDriver_Name(String driver_Name) {
        Driver_Name = driver_Name;
    }

    public void setDriver_Mobile_No(String driver_Mobile_No) {
        Driver_Mobile_No = driver_Mobile_No;
    }

    public void setCar_No(String car_No) {
        Car_No = car_No;
    }

    public void setCar_Model(String car_Model) {
        Car_Model = car_Model;
    }

    public void setCar_Company(String car_Company) {
        Car_Company = car_Company;
    }

    public void setDriver_Adhaar_No(String driver_Adhaar_No) {
        Driver_Adhaar_No = driver_Adhaar_No;
    }

    public void setDriver_City(String driver_City) {
        Driver_City = driver_City;
    }

    public Driver() {
    }

    public Driver(String driver_Name, String driver_Mobile_No, String car_No, String car_Model, String car_Company, String driver_Adhaar_No, String driver_City) {
        Driver_Name = driver_Name;
        Driver_Mobile_No = driver_Mobile_No;
        Car_No = car_No;
        Car_Model = car_Model;
        Car_Company = car_Company;
        Driver_Adhaar_No = driver_Adhaar_No;
        Driver_City = driver_City;
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
