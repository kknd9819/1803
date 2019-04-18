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

@WebServlet(urlPatterns = "/edit")
public class StudentEditServlet extends HttpServlet {
    private static final long serialVersionUID = 6522542161452767797L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("userId");
        StudentDao studentDao = new StudentDaoImpl();
        Student student = studentDao.findById(Integer.parseInt(userId));
        request.setAttribute("student",student);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/edit.jsp")
               .forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String studentName = request.getParameter("studentName");
        String age = request.getParameter("age");
        String telphone = request.getParameter("telphone");

        //从数据库根据id查
        StudentDao studentDao = new StudentDaoImpl();
        Student student = studentDao.findById(Integer.parseInt(id));
        student.setStudentName(studentName);
        student.setTelphone(telphone);
        student.setAge(Integer.parseInt(age));

        //调用更新语句保存进入数据库
        studentDao.update(student);

        //重定向回到列表页面
        response.sendRedirect(request.getContextPath()+"/students");
    }
}
