package JDBCbigTASK.Servlets;

import JDBCbigTASK.DB.DBConnector;
import JDBCbigTASK.Tasks.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deleteItem")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));


        Task task = DBConnector.getTask(id);

        if(task!=null){

            DBConnector.deleteTask(task);

            resp.sendRedirect("/home");
        }else {
            resp.sendRedirect("/home");
        }

    }
}
