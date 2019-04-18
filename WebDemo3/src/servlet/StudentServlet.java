package servlet;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet",urlPatterns = "/students")
public class StudentServlet extends HttpServlet {

    private static final long serialVersionUID = -2241587881288536870L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.findAll();
        //存入request域
        request.setAttribute("students",students);
        //跳转到jsp页面
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp")
                .forward(request,response);
    }
}
