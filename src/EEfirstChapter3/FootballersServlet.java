package EEfirstChapter3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
@WebServlet(value ="/FootballersList")
public class FootballersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ArrayList<Player> allPlayers = FManager.getAllPlayers();
        out.print("<html>");
        out.print("<head>");
        out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor\" crossorigin=\"anonymous\">");
        out.print("</head>");
        out.print("<body>");
        out.print("<div class='container'>");
        out.print("<form action= '/addFootballer' method='post'>");
        out.print("NAME: <input type='text' name='player_name'> ");
        out.print("Surname: <input type='text' name='player_surname'> ");
        out.print("Club: <select name='player_club'>\n" +
                "  <option>Real Madrid</option>\n" +
                "  <option>Barcelona</option>\n" +
                "  <option>Manchester United</option>\n" +
                "  <option>Manchester city</option>\n" +
                "</select > ");
        out.print("Salary: <input type='text' name='player_salary'> ");
        out.print("Transfer price: <input type='text' name='player_price'> ");
        out.print("<button>Add Footballer</button> ");
        out.print("</form><br><br><br>");
        for(Player pl  : allPlayers){
            out.print("<h3 class='text-success'>"+pl.getName()+" "+pl.getSurname()+"</h3>");
            out.print("<p class='text-success'>"+"Club: "+pl.getClub()+"</p>");
            out.print("<p class='text-danger'>"+"Salary: "+pl.getSalary()+"</p>");
            out.print("<p class='text-danger'>"+"Transfer Price: "+pl.getTransferPrice()+"</p>");
        }
        out.print("</body>");
        out.print("</body>");
        out.print("</html>");
    }

}

