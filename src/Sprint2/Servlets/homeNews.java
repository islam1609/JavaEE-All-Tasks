package Sprint2.Servlets;

import Sprint2.DB.DBNews;
import Sprint2.Objects.Languages;
import Sprint2.Objects.News;
import Sprint2.Objects.Publications;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/homeNews")
public class homeNews extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<News> allNews = DBNews.getAllNews();
        ArrayList<Languages> allLang = DBNews.getAllLang();
        ArrayList<Publications> allPublications = DBNews.getAllPublications();
        request.setAttribute("allNews",allNews);
        request.setAttribute("allLang",allLang);
        request.setAttribute("allPublications",allPublications);
        request.getRequestDispatcher("/news.jsp").forward(request,response);
    }
}
