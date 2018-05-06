/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clg.project;

/**
 *
 * @author Shaiwal Chandra
 */
public class Course {
    private String c_name,t_id,c_id,t_name;

    public Course(String t_id, String t_name) {
        this.t_id = t_id;
        this.t_name = t_name;
    }

    public String getT_id() {
        return t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public Course( String c_id,String c_name, String t_id, String t_name) {
        this.c_name = c_name;
        this.t_id = t_id;
        this.c_id = c_id;
        this.t_name = t_name;
    }

    

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }


    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

   
}
