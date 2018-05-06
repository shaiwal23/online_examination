package clg.project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Marks {
    private int exam_id,user_id,exam_duration,total_marks,marks_obtained;
    private String exam_time;

    public Marks(int exam_id, int exam_duration, int total_marks, int marks_obtained, String exam_time) {
        this.exam_id = exam_id;
        this.exam_duration = exam_duration;
        this.total_marks = total_marks;
        this.marks_obtained = marks_obtained;
        this.exam_time = exam_time;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getExam_duration() {
        return exam_duration;
    }

    public void setExam_duration(int exam_duration) {
        this.exam_duration = exam_duration;
    }

    public int getTotal_marks() {
        return total_marks;
    }

    public void setTotal_marks(int total_marks) {
        this.total_marks = total_marks;
    }

    public int getMarks_obtained() {
        return marks_obtained;
    }

    public void setMarks_obtained(int marks_obtained) {
        this.marks_obtained = marks_obtained;
    }

    public String getExam_time() {
        return exam_time;
    }

    public void setExam_time(String exam_time) {
        this.exam_time = exam_time;
    }
}
