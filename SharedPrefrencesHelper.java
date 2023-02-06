package com.example.strayers;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefrencesHelper {
    private SharedPreferences sharedPreferences;
    private Context context;
    private String Mail_id = "Mail_id", Name = "Name", Contact = "Contact", City = "City", Password = "Password", role = "Role", image = "image", name1 = "name", info = "info", vaccinated = "vaccinated", adoptStatus = "adoptStatus";
    public SharedPrefrencesHelper(Context context) {
        this.sharedPreferences = context.getSharedPreferences("login_session",
                Context.MODE_PRIVATE);
        this.context = context;
    }
    public String getMail_id() {
        return sharedPreferences.getString(Mail_id, "");
    }
    public String getName() {
        return sharedPreferences.getString(Name, "");
    }
    public String getContact() {
        return sharedPreferences.getString(Contact, "");
    }
    public String getCity() {
        return sharedPreferences.getString(City, "");
    }public String getPassword() {
        return sharedPreferences.getString(Password, "");
    }

    public String getName1() {
        return sharedPreferences.getString(image, "");
    }public String getRole() {
        return sharedPreferences.getString(role, "");
    }public String getImage() {
        return sharedPreferences.getString(image, "");
    }public String getInfo() {
        return sharedPreferences.getString(info, "");
    }public String getVaccinated() {
        return sharedPreferences.getString(vaccinated, "");
    }public String getAdoptStatus() {
        return sharedPreferences.getString(adoptStatus, "");
    }



    public void setMail_id(String Mail_id) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(this.Mail_id, Mail_id);
        edit.commit();
    }
    public void setName(String Name) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(this.Name, Name);
        edit.commit();
    }
    public void setContact(String Contact) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(this.Contact, Contact);
        edit.commit();
    }
    public void setCity(String City) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(this.City, City);
        edit.commit();
    }public void setPassword(String City) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(this.City, City);
        edit.commit();
    }public void setImage(String image) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(this.image, image);
        edit.commit();
    }public void setInfo(String info) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(this.City, City);
        edit.commit();
    }public void setVaccinated(String vaccinated) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(this.vaccinated, vaccinated);
        edit.commit();
    }public void setAdoptStatus(String adoptStatus) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(this.adoptStatus, adoptStatus);
        edit.commit();
    }public void setName1(String name1) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(this.name1, name1);
        edit.commit();
    }public void setRole(String role) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(this.role, role);
        edit.commit();
    }
}
