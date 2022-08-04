package JOINTS1.Servlets;

import JDBCbigTASK.DB.DBConnector;
import JDBCbigTASK.Tasks.Task;
import JOINTS1.DB.DBConnectoR;
import JOINTS1.Objects.City;
import JOINTS1.Objects.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<City> allCities = DBConnectoR.getAllCities();
       /* for(City ct : allCities) {
            System.out.println(ct.getName());
        } */
        request.setAttribute("cities",allCities);
        request.getRequestDispatcher("/addStudent.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("student_name");
        String surname =request.getParameter("student_surname");
        String birthdate=request.getParameter("student_birthdate");
        Long city_id=Long.parseLong(request.getParameter("student_city_id"));


        System.out.println(name+" "+surname+" "+birthdate+" "+city_id);


        City city = DBConnectoR.getCity(city_id);

        System.out.println(name+" "+surname+" "+birthdate+" "+city_id);


        if(city!=null) {
            System.out.println(city.getId()+city.getName());
            Student student = new Student();
            student.setName(name);
            student.setSurname(surname);
            student.setBirthdate(birthdate);
            student.setCity(city);

            DBConnectoR.addStudent(student);
        }
        response.sendRedirect("/homeStudent");
    }
}
