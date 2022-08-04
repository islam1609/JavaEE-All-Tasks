package Sprint1.Servlets;

import JDBCbigTASK.DB.DBConnector;
import Sprint1.db.DBconnector;
import Sprint1.item.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value ="/homeStore")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Item> allItems = DBconnector.getAllItems();
        request.setAttribute("items",allItems);
        request.getRequestDispatcher("/homeStore.jsp").forward(request,response);
    }
}
