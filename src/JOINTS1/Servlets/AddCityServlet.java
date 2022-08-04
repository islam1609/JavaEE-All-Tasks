package JOINTS1.Servlets;

import JOINTS1.DB.DBConnectoR;
import JOINTS1.Objects.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addCity")
public class AddCityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/addCity.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("city_name");
        String code =request.getParameter("city_code");


        try {

            City city = new City();
            city.setName(name);
            city.setCode(code);

            DBConnectoR.addCity(city);
            response.sendRedirect("/homeStudent");
        }catch (Exception e){
            e.printStackTrace();
        }
        }
}
