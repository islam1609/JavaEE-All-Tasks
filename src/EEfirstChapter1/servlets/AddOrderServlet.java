package EEfirstChapter1.servlets;

import EEfirstChapter1.order.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addOrder")
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{


        String name = req.getParameter("order_name");
        String surname = req.getParameter("order_surname");
        String food = req.getParameter("order_food");

        Order order =new Order();
        order.setName(name);
        order.setSurname(surname);
        order.setFood((food));


        System.out.println(name+" "+surname+" "+food);

        resp.sendRedirect("/toOrder");
    }
}
