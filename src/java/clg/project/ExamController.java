/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clg.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shaiwal Chandra <shaiwal.chandra007@gmail.com>
 */
@WebServlet(name = "ExamController", urlPatterns = {"/ExamController"})
public class ExamController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean finish=false;
        try (PrintWriter out = response.getWriter()) {
            HttpSession session=request.getSession();
            try{
                if(session.getAttribute("currentExam")==null){
                    String exam_name=(String)session.getAttribute("exam");
                    request.getSession().setAttribute("examDuration",20);
                    request.getSession().setAttribute("total_question",10);
                    request.getSession().setAttribute("min",20);
                    request.getSession().setAttribute("sec",0);
                    Exam exam=new Exam((int)request.getSession().getAttribute("examDuration"));
                    exam.make_exam(exam_name,(Integer)request.getSession().getAttribute("total_question"));
                    request.getSession().setAttribute("currentExam",exam);
                    Calendar cal = Calendar.getInstance();
                    java.sql.Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
                  //  Date started = new java.sql.Date(calendar.getTime().getTime());
                    System.out.println("date->"+timestamp);
                  /*  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a");
                    Date date = new Date();
                    String started=dateFormat.format(date);*/
                    session.setAttribute("started",timestamp);
                }
            }catch(Exception e){e.printStackTrace();}
            Exam exam=(Exam)session.getAttribute("currentExam");
            
            String action=request.getParameter("action");
			
			System.out.println("Value of Action "+action+"   "+request.getParameter("minute"));
			int minute=-1;
			int second=-1;
			if(request.getParameter("minute")!=null)
			{			
			minute=Integer.parseInt(request.getParameter("minute"));
			second=Integer.parseInt(request.getParameter("second"));
			request.getSession().setAttribute("min",request.getParameter("minute") );
			request.getSession().setAttribute("sec",request.getParameter("second") );
			}
			if("Submit".equals(action)){
			String radio=request.getParameter("answer");
			int selectedRadio=-1;
			exam.selections.put(exam.current_question, selectedRadio);
                        if(radio!=null){
                            int p=Integer.parseInt(radio);
                            exam.selections.put(exam.current_question,p);
                            exam.quizList.get(exam.current_question).setUserSelected(p);
                          //  System.out.println("q_no->"+exam.current_question+"answer->"+p);
                            if(exam.current_question<(Integer)request.getSession().getAttribute("total_question")-1){
                                
                            exam.current_question++;
                            QuizQuestion q=exam.quizList.get(exam.current_question);
                            session.setAttribute("que",q);
                            }
                            else{
                           //     System.out.println("correct");
                                finish=true;
				int result=exam.calculateResult(exam,exam.quizList.size());
                                DataAccess da=new DataAccess();
                                User u=(User)session.getAttribute("user");
                                Timestamp d=(Timestamp)session.getAttribute("started");
                                int u_id=u.getUser_id();
                                int a=da.marks_entry(u_id,(String)session.getAttribute("exam"),(int)request.getSession().getAttribute("examDuration"),(Integer)request.getSession().getAttribute("total_question"), result,d);
				request.setAttribute("result",result);
				request.getRequestDispatcher("ReviewController").forward(request,response);
                            }
                        }
                        }
			if("Next".equals(action)){
                               
				exam.current_question++;
			//	exam.setQuestion(exam.current_question);
                               // System.out.println("q_no->"+exam.current_question);
                                QuizQuestion q=exam.quizList.get(exam.current_question);
                             //   System.out.println("ques->>"+q.getStmt());
			  	session.setAttribute("que",q);
			}
			else if("Previous".equals(action))
			{   System.out.println("You clicked Previous Button");
				exam.current_question--;
			//	exam.setQuestion(exam.current_question);
                                QuizQuestion q=exam.quizList.get(exam.current_question);	
				session.setAttribute("que",q);
				
			}
			else if("Finish Exam".equals(action)||( minute==0 && second==0))
			{   finish=true;
				int result=exam.calculateResult(exam,exam.quizList.size());
                                DataAccess da=new DataAccess();
                                User u=(User)session.getAttribute("user");
                                Timestamp d=(Timestamp)session.getAttribute("started");
                                int u_id=u.getUser_id();
                                int a=da.marks_entry(u_id,(String)session.getAttribute("exam"),(int)request.getSession().getAttribute("examDuration"),(Integer)request.getSession().getAttribute("total_question"), result,d);
				request.setAttribute("result",result);
				request.getRequestDispatcher("ReviewController").forward(request,response);
				
			} 
                        else{
                            String q=request.getParameter("q_no");
                            if(q!=null){
                            int q_no=Integer.parseInt(q)-1;
                            System.out.println("question no"+q_no);
                            exam.setCurrent_question(q_no);
                            QuizQuestion qq=exam.quizList.get(exam.current_question);	
                            session.setAttribute("que",qq);
                            }  
                        }
                        if(exam.current_question==0){
                    //    exam.setQuestion(exam.getCurrent_question());
                        QuizQuestion question=exam.quizList.get(exam.current_question);
                        session.setAttribute("que",question);
                    //    System.out.println("here");
                        }
                        if(finish==false){
                            request.getRequestDispatcher("exampage.jsp").forward(request, response);
                        }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
