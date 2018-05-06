/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clg.project;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Shaiwal Chandra <shaiwal.chandra007@gmail.com>
 */
public class Exam {
    int current_question=0,total_question,duration;

    public void setCurrent_question(int current_question) {
        this.current_question = current_question;
    }

    
    String q_id[];
    ArrayList<Question> list;
    ArrayList<QuizQuestion> quizList=new ArrayList<QuizQuestion>();
    List<Integer> quizSelectionList=new ArrayList<Integer>();
    public Map<Integer,Integer> selections=new LinkedHashMap<Integer,Integer>();

    public Map<Integer, Integer> getSelections() {
        return selections;
    }

    public void setSelections(Map<Integer, Integer> selections) {
        this.selections = selections;
    }
    public List<Integer> getQuizSelectionList() {
        return quizSelectionList;
    }
    
   
    public Exam(int total_question) {
        this.total_question = total_question;
        for(int i=0;i<total_question;i++){
            selections.put(i,-1);
        }
    }

    public Exam() {
    }

   
    public void make_exam(String t_id,int total_q){
        int q_n=0;
        DataAccess da=new DataAccess();
        list=da.fetch_question(t_id,total_q);
        
        for(Question q:list){
            QuizQuestion que=new QuizQuestion();
            que.setStmt(q.getStmt());
            que.setQuestion_no(++q_n);
            que.setCorrect_answer(q.getCorrect_answer_id());
            ArrayList<Options> o=da.fetch_options(q.getQ_id());
            que.setOptions(o);
            quizList.add(que);
        }
    }
    
    public void setQuestion(int i){
        int q_id=list.get(i).getQ_id();
        QuizQuestion que=new QuizQuestion();
        que.setStmt(list.get(i).getStmt());
        que.setQuestion_no(i+1);
        que.setCorrect_answer(list.get(i).getCorrect_answer_id());
        DataAccess da=new DataAccess();
        ArrayList<Options> o=da.fetch_options(q_id);
        que.setOptions(o);
        System.out.println("set Q->"+que.getStmt());
        quizList.add(i,que);
        
    }
     public ArrayList<QuizQuestion> getQuizList() {
        return quizList;
    }
     public int getCurrent_question() {
        return current_question;
    }
     public int getUserSelectionForQuestion(int i){
		Map<Integer,Integer> map=getSelections();
		return (Integer) map.get(i);
	}
     public int calculateResult(Exam exam,int taken){
		int totalCorrect=0;
		Map<Integer,Integer> userSelectionsMap=exam.selections;		
		/*List<Integer> userSelectionsList=new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> entry :userSelectionsMap.entrySet()) {
			userSelectionsList.add(entry.getValue());
		}
		
		quizSelectionList=userSelectionsList;
		*/
            /*    for (int i =exam.quizList.size() - 1; i >=taken; --i)
                    exam.quizList.remove(i);*/
		List<QuizQuestion> questionList=exam.quizList;
		
		List<Integer> correctAnswersList=new ArrayList<Integer>();
                List<Integer> userselectionList=new ArrayList<Integer>();
		for(QuizQuestion question: questionList){
			correctAnswersList.add(question.getCorrect_answer());
                        System.out.println("correct_anser->>"+question.getCorrect_answer());
                        userselectionList.add(question.getUserSelected());
                        System.out.println("selsection_->"+question.getUserSelected());
		}
		
		
		for(int i=0;i<taken;i++){
			
			if(correctAnswersList.get(i).equals(userselectionList.get(i))){
				totalCorrect++;
			}
		}
		
		
		return totalCorrect;
	}
}
