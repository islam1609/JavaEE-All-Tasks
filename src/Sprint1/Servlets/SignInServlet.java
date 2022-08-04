package Sprint1.Servlets;

import Sprint1.db.DBconnector;
import Sprint1.item.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("modal", "false");
        request.getRequestDispatcher("/signIn.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("login_email");
        String password = req.getParameter("login_password");
        req.setAttribute("alert_visible", "false");
        ArrayList<User> allUsers = DBconnector.getAllUsers();
        if(allUsers!=null) {
            for (User us : allUsers) {
                if (us.getEmail().equals(email) && us.getPassword().equals(password))
                    req.getRequestDispatcher("/userPage.jsp").forward(req,resp);
            }
        }
        req.setAttribute("modal","true");
        req.getRequestDispatcher("/signIn.jsp").forward(req, resp);
    }
}
