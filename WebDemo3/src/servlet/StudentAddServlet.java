package servlet;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add")
public class StudentAddServlet extends HttpServlet {

    private static final long serialVersionUID = 7953000327706030882L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/add.jsp")
                .forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //需要对post请求里面的中文数据进行utf-8编码，防止乱码
        request.setCharacterEncoding("utf-8");
        String studentName = request.getParameter("studentName");
        String age = request.getParameter("age");
        String telphone = request.getParameter("telphone");

        Student student = new Student();
        student.setStudentName(studentName);
        student.setAge(Integer.parseInt(age));
        student.setTelphone(telphone);

        //存入数据库
        StudentDao studentDao = new StudentDaoImpl();
        int count = studentDao.save(student);
        //重定向到列表页
        response.sendRedirect(request.getContextPath()+"/students");
    }
}
