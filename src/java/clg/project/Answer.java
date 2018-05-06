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
public class Answer {
    String answer_id,q_id,stmt;

    public String getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(String answer_id) {
        this.answer_id = answer_id;
    }

    public String getQ_id() {
        return q_id;
    }

    public void setQ_id(String q_id) {
        this.q_id = q_id;
    }

    public String getStmt() {
        return stmt;
    }

    public void setStmt(String stmt) {
        this.stmt = stmt;
    }

    public Answer(String answer_id, String q_id, String stmt) {
        this.answer_id = answer_id;
        this.q_id = q_id;
        this.stmt = stmt;
    }
}
