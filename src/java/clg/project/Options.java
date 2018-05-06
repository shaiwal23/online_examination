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
public class Options {
    private String stmt;
    int q_id,answer_id;

    public Options(String stmt, int q_id, int answer_id) {
        this.stmt = stmt;
        this.q_id = q_id;
        this.answer_id = answer_id;
    }

    public String getStmt() {
        return stmt;
    }

    public int getQ_id() {
        return q_id;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public Options(String stmt, int answer_id) {
        this.stmt = stmt;
        this.answer_id = answer_id;
    }
}
