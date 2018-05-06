/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clg.project;

import java.util.ArrayList;

/**
 *
 * @author Shaiwal Chandra <shaiwal.chandra007@gmail.com>
 */
public class QuizQuestion {
    int question_no,correct_answer;
    String stmt;
    ArrayList<Options> options;
    int userSelected=-1;

    public int getUserSelected() {
        return userSelected;
    }

    public void setUserSelected(int userSelected) {
        this.userSelected = userSelected;
    }

    public ArrayList<Options> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Options> options) {
        this.options = options;
    }
    public int getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(int correct_answer) {
        this.correct_answer = correct_answer;
    }
    

    public int getQuestion_no() {
        return question_no;
    }

    public void setQuestion_no(int question_no) {
        this.question_no = question_no;
    }

    public String getStmt() {
        return stmt;
    }

    public void setStmt(String stmt) {
        this.stmt = stmt;
    }
    public String toString(){
		String str= question_no+"."+getStmt();
		for(Options op:getOptions()){
                        String option=op.getAnswer_id()+" ."+op.getStmt();
			str=str+option+"  ";
		}
		str=str+"\n Correct Answer : "+getCorrect_answer();
		return str;
	}
    
}
