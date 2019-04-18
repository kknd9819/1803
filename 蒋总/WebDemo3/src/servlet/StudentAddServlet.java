package servlet;


import dao.StudentDao;
import dao.StudentDaoImpl;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentAddServlet",urlPatterns ="/add")
public class StudentAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext ().getRequestDispatcher ( "/WEB-INF/jsp/add.jsp" )
                .forward ( request,response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding ( "utf-8" );

        String student_name = request.getParameter ( "student_name" );
        String age = request.getParameter ( "age" );
        String sex = request.getParameter ( "sex" );
        String tlephone = request.getParameter ( "tlephone" );

        //存入数据库
        StudentDao studentDao = new StudentDaoImpl ();
        Student student = new Student ();
        student.setStudent_name ( student_name );
        student.setAge ( Integer.parseInt ( age ) );
        student.setSex ( sex );
        student.setTlephone ( tlephone );
        int count = studentDao.save ( student );

        //重定向到列表页
        response.sendRedirect ( request.getContextPath ()+"/students");

    }
}
