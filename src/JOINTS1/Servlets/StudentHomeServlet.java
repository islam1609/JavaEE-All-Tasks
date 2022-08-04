package JOINTS1.Servlets;

import JOINTS1.DB.DBConnectoR;
import JOINTS1.Objects.Student;
import Sprint1.db.DBconnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/homeStudent")
public class StudentHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> allStudents = DBConnectoR.getAllStudent();
        request.setAttribute("allStudents",allStudents);
        request.getRequestDispatcher("/homeStudent.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
