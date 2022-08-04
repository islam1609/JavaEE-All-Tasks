/*package JDBCbigTASK.Servlets;

import JDBCbigTASK.DB.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = "/delete")
public class deleteWithoutDB extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("task_id");
        Long TaskId = null;
        try {
            TaskId=Long.parseLong(id);
        }catch (Exception e){
        }
        DBManager.deleteTask(TaskId);
        resp.sendRedirect("/home");
    }
} */