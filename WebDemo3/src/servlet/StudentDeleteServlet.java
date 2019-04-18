package servlet;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class StudentDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = -5652095640904493493L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("ids");

        //执行数据库删除
        StudentDao studentDao = new StudentDaoImpl();

        for(String id : ids){
            studentDao.deleteById(Integer.parseInt(id));
        }

    }
}
