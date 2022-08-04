package EEfirstChapter3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = "/addFootballer")
public class AddFootballerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("player_name");
        String surname = req.getParameter("player_surname");
        String club = req.getParameter("player_club");
        String salary  = req.getParameter("player_salary");
        String transferPrice = req.getParameter("player_price");

        Player player =new Player();
        player.setName(name);
        player.setSurname(surname);
        player.setClub(club);
        player.setSalary(Integer.parseInt(salary));
        player.setTransferPrice(Integer.parseInt(transferPrice));
        FManager.addPlayer(player);

        resp.sendRedirect("/FootballersList");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
