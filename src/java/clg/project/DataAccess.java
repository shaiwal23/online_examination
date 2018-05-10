
package clg.project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shaiwal Chandra
 */
public class DataAccess {
    Connection con;
    PreparedStatement ps_marks_update,ps_c_list,ps_ques,ps_t_id,ps_c_entry,ps_topics,ps_course,ps_register,ps_check_u,ps_options,ps_m_entry,ps_marks;
    
    String t_list="select t_id,t_name from course where c_id=?";
    String c_list="select c_id,c_name,t_id,t_name from course";
    String c_drop="select distinct c_name from course";
    String ques="select q_id,stmt,answer_id from question where t_id=? order by rand() limit ?";
    String c_entry="insert into course (c_id,c_name,t_id,t_name) values (?,?,?,?)";
    String register="insert into user (email,f_name,l_name,passwd,type) values (?,?,?,?,?)";
    String check_u="select user_id,f_name,l_name,type from user where email=? and passwd=?";
    String options="select answer_id,stmt from answer where q_id=?";
    String m_entry="insert into exams (user_id,exam_duration,total_marks,marks_obtained,exam_time,t_id) values (?,?,?,?,?,?)";
    String m_update="update exams set correct=?,wrong=?,unanswered=? where exam_time=?";
    String m_obtained="select exam_id,exam_time,exam_duration,total_marks,marks_obtained,correct,wrong,unanswered from exams where user_id=?";
    
    
    public DataAccess(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/oe?zeroDateTimeBehavior=convertToNull";
            String user="root";
            String pass="";
            con=DriverManager.getConnection(url,user,pass);
            ps_c_list=con.prepareStatement(c_list);
            ps_ques=con.prepareStatement(ques);
            ps_c_entry=con.prepareStatement(c_entry);
            ps_course=con.prepareStatement(c_drop);
            ps_register=con.prepareStatement(register);
            ps_check_u=con.prepareStatement(check_u);
            ps_options=con.prepareStatement(options);
            ps_m_entry=con.prepareStatement(m_entry);
            ps_marks=con.prepareStatement(m_obtained);
            ps_marks_update=con.prepareStatement(m_update);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    ArrayList<Marks> marks_fetch(int user_id){
        ArrayList<Marks> list=null;
        try {
            ps_marks.setInt(1, user_id);
            ResultSet rs=ps_marks.executeQuery();
            while(rs.next()){
                Marks m=new Marks(rs.getInt(1),rs.getInt(3), rs.getInt(4),rs.getInt(5),rs.getString(2),rs.getInt(6),rs.getInt(7),rs.getInt(8));
                if(list==null)
                    list=new ArrayList<>();
                list.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
      return list;  
    }
    int marks_entry(int user_id,String t_id,int exam_duration,int total_marks,int marks_obtained,Timestamp d){
        int res=-1;
        try {
            ps_m_entry.setInt(1, user_id);
            ps_m_entry.setTimestamp(5, d);
            ps_m_entry.setInt(2, exam_duration);
            ps_m_entry.setInt(3, total_marks);
            ps_m_entry.setInt(4, marks_obtained);
            ps_m_entry.setString(6, t_id);
            int a=ps_m_entry.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;        
        
    }
    public ArrayList<String> course_fetch(){
        ArrayList<String> list=null;
        try {
            ResultSet rs=ps_course.executeQuery();
            while(rs.next()){
                if(list==null)
                    list=new ArrayList<>();
                list.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<Course> topic_fetch(String c_id){
        ArrayList<Course> list=null;
        try {
            
            ps_c_list.setString(1, c_id);
            ResultSet rs=ps_c_list.executeQuery();
            while(rs.next()){
                if(list==null)
                    list=new ArrayList<>();
                Course c=new Course(rs.getString(1),rs.getString(2));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public int Course_entry(String c_name,String c_id,String t_id,String t_name){
        try {
            ps_c_entry.setString(1, c_id);
            ps_c_entry.setString(2, c_name);
            ps_c_entry.setString(3, t_id);
            ps_c_entry.setString(4, t_name);
            int a=ps_c_entry.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
    public ArrayList<Course> clist(){
        
        ArrayList<Course> list=null;
        
        ResultSet rs;
        try {
            rs = ps_c_list.executeQuery();
            while(rs.next()){
            if(list==null)
                list=new ArrayList<>();
            Course a=new Course(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
            list.add(a);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
   public ArrayList<Question> fetch_question(String t_id,int total_q){
        ArrayList<Question> list=null;
        try {
            ps_ques.setString(1,t_id);
            ps_ques.setInt(2, total_q);
            ResultSet rs=ps_ques.executeQuery();
            while(rs.next()){
                if(list==null)
                    list=new ArrayList<>();
                Question q=new Question(rs.getInt(1),rs.getString(2),rs.getInt(3));
                list.add(q);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
   int user_register(String email,String f_name,String l_name,String passwd,String type){
       int res=0; 
       try {
            ps_register.setString(1,email);
            ps_register.setString(2,f_name);
            ps_register.setString(3,l_name);
            ps_register.setString(4,passwd);
            ps_register.setString(5,type);
            res=ps_register.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
       return res;
   }
   public User user_login(String email,String passwd){
        try {
            ps_check_u.setString(1,email);
            ps_check_u.setString(2,passwd);
            ResultSet rs=ps_check_u.executeQuery();
            if(rs.next()){
                User u=new User(rs.getInt(1),email,rs.getString(2),rs.getString(3),rs.getString(4));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
   }
   public ArrayList<Options> fetch_options(int q_id){
       ArrayList<Options> op=null;
        try {
            ps_options.setInt(1, q_id);
            ResultSet rs=ps_options.executeQuery();
            while(rs.next()){
                if(op==null)
                    op=new ArrayList<>();
                Options o=new Options(rs.getString(2),rs.getInt(1));
                op.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
      return op;
   }
   public int updateMarks(Timestamp t,int correct,int wrong,int unattempted){
       int a=-1; 
       try {
            ps_marks_update.setInt(1,correct);
            ps_marks_update.setInt(2, wrong);
            ps_marks_update.setInt(3, unattempted);
            ps_marks_update.setTimestamp(4, t);
            a=ps_marks_update.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
       return a;
}
}