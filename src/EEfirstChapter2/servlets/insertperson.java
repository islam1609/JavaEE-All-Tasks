package EEfirstChapter2.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(value = "/insertperson")
public class insertperson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print("<html>");
        out.print("<head>");
        out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor\" crossorigin=\"anonymous\">");
        out.print("</head>");
        out.print("<body>");
        out.print("<div class='container'>");
        out.print("<form action= '/addperson' method='post'>");
        out.print("fullName: <input type='text' name='person_fullname'><br><br> ");
        out.print("Age: <input type='text' name='person_age'><br><br> ");
        out.print("Gender:  <input type='radio' id='Choice1'\n" +
                "           name='gender' value='Male'>\n" +
                "    <label for='Choice1'>Male</label>\n" +
                "    <input type='radio'  id='Choice2'\n" +
                "           name= 'gender' value='Female'>\n" +
                "    <label for='Choice2'>Female</label><br><br>");
        out.print("<button>Submit</button> ");
        out.print("</form>");
        out.print("</body>");
        out.print("</html>");
    }
}
