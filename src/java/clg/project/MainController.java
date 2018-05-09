/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clg.project;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RANJEET
 */
@WebServlet(name = "MainController", urlPatterns = { "/login", "/register", "/takeExam", "/logout" })
public class MainController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String applicationContextPath=request.getContextPath();
            if(request.getRequestURI().equals(applicationContextPath+"/takeExam")){
                request.getSession().setAttribute("currentExam", null);
                request.getSession().setAttribute("examDuration",null);
                request.getSession().setAttribute("min",null);
                request.getSession().setAttribute("sec",null);
                request.getSession().setAttribute("total_question",null);
			String exam = request.getParameter("topic");
			request.getSession().setAttribute("exam", exam);
                //	System.out.println(request.getSession().getAttribute("user"));
			if (request.getSession().getAttribute("user") == null) {
                                
				request.getRequestDispatcher("login.jsp").forward(request,
						response);

			} else {
                                
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("quizDetails.jsp");
				dispatcher.forward(request, response);
			}
            }
            else if(request.getRequestURI().equals(applicationContextPath+"/logout")){
                Cookie[] cookies=null;
                cookies=request.getCookies();
                for(int i=0;i<cookies.length;i++){
                    System.out.println(cookies[i].getValue());
                    if(cookies[i].getName().equals("email")){
                        cookies[i].setMaxAge(0);
                        cookies[i].setValue("");
                        
                    }
                        
                    if(cookies[i].getName().equals("pass")){
                        cookies[i].setMaxAge(0);
                        cookies[i].setValue("");
                    }
                }
                request.getSession().invalidate();
                response.sendRedirect("firstpage.jsp");
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
