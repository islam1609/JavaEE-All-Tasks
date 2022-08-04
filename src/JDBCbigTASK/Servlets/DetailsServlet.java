package JDBCbigTASK.Servlets;

import JDBCbigTASK.DB.DBConnector;
import JDBCbigTASK.Tasks.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Long TaskId= null;
        try {
            TaskId= Long.parseLong(id);
        }catch (Exception e){
        }
        Task task = DBConnector.getTask(TaskId);
        if(task!=null){
            req.setAttribute("task",task);
            req.getRequestDispatcher("/details.jsp").forward(req,resp);
        }
        req.getRequestDispatcher("/404.jsp");
    }
}
