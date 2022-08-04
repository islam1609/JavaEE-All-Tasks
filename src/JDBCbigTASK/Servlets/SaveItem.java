package JDBCbigTASK.Servlets;

import JDBCbigTASK.DB.DBConnector;
import JDBCbigTASK.Tasks.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/saveItem")
public class SaveItem extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("task_name");
        String desc = req.getParameter("task_description");
        String deadline = req.getParameter("task_deadline");
        String done = req.getParameter("task_done");

        Task task = DBConnector.getTask(id);

        if(task!=null){
            task.setName(name);
            task.setDescription(desc);
            task.setDeadlineDate(deadline);
            task.setDone(done);

            DBConnector.saveTask(task);

            resp.sendRedirect("/details?id="+id);
        }else {
            resp.sendRedirect("/home");
        }

    }
}
