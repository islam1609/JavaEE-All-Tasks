package EEfirstChapter2.servlets;

import EEfirstChapter2.Person.person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addperson")

public class addperson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("person_fullname");
        String age = req.getParameter("person_age");
        String gender = req.getParameter("gender");

        person Person = new person();
        Person.setFullName(fullname);
        Person.setAge(Integer.parseInt(age));
        Person.setGender(gender);

        if (Person.gender.equals("Male") && Person.age >= 18) {
            System.out.println("Hello Dear Mister " + fullname);
        } else if (Person.gender.equals("Male") && Person.age < 18) {
            System.out.println("Hello Dude " + fullname);
        } else if (Person.gender.equals("Female") && Person.age >= 18) {
            System.out.println("Hello Dear Miss " + fullname);
        } else if (Person.gender.equals("Female") && Person.age < 18) {
            System.out.println("Hello Dude " + fullname);
        }
            resp.sendRedirect("/insertperson");

    }
}
