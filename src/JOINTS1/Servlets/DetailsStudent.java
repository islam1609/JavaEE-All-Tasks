package JOINTS1.Servlets;

import JOINTS1.DB.DBConnectoR;
import JOINTS1.Objects.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/detailsStudent")
public class DetailsStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Long studentId = null;

        try{
            studentId = Long.parseLong(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        Student student = DBConnectoR.getStudent(studentId);
        if(student!=null){
            req.setAttribute("student",student);
            req.getRequestDispatcher("/detailsStudent.jsp").forward(req,resp);
        }
        req.getRequestDispatcher("/404.jsp");
        }
    }

