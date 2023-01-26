package com.example.employee_mangment;

public class Model {
    String name;
    int phone_no;
    String addrees;
    String email;

    public Model(String e_name, int phone_no,String e_addrees,String e_email){

        this.name=e_name;
        this.phone_no=phone_no;
        this.addrees=e_addrees;
        this.email=e_email;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public void setPhone_no(int phone_no){
        this.phone_no=phone_no;
    }
    public int getPhone_no(){
        return phone_no;
    }

    public void setAddrees(String addrees){
        this.addrees=addrees;
    }
    public String getAddrees(){
        return addrees;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
}
