package JDBCbigTASK.Servlets;

import JDBCbigTASK.DB.DBConnector;
import JDBCbigTASK.Tasks.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addTask")
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name= req.getParameter("task_name");
        String desc =req.getParameter("task_description");
        String deadline=req.getParameter("task_deadline");
        String done=req.getParameter("task_done");

        Task task= new Task();
        task.setName(name);
        task.setDescription(desc);
        task.setDeadlineDate(deadline);
        task.setDone(done);

        DBConnector.addTask(task);

        resp.sendRedirect("/home");
    }
}
