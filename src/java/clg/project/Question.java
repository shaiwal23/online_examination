/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clg.project;

/**
 *
 * @author RANJEET
 */
public class Question {
    private String stmt;
    private Options options[];
    int q_id,correct_answer_id;
    public Options[] getOptions() {
        return options;
    }

    public void setOptions(Options[] options) {
        this.options = options;
    }
    

    public int getQ_id() {
        return q_id;
    }

    public void setQ_id(int q_id) {
        this.q_id = q_id;
    }

    public String getStmt() {
        return stmt;
    }

    public void setStmt(String stmt) {
        this.stmt = stmt;
    }

    public int getCorrect_answer_id() {
        return correct_answer_id;
    }

    public void setCorrect_answer_id(int correct_answer_id) {
        this.correct_answer_id = correct_answer_id;
    }

    public Question(int q_id, String stmt,int correct) {
        this.q_id = q_id;
        this.stmt = stmt;
        this.correct_answer_id=correct;
    }
}
