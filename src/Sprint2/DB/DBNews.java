package Sprint2.DB;

import JOINTS1.Objects.City;
import JOINTS1.Objects.Student;
import Sprint2.Objects.Languages;
import Sprint2.Objects.News;
import Sprint2.Objects.Publications;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class DBNews {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/EE1", "postgres", "jeffkalash");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Languages> getAllLang() {
        ArrayList<Languages> allLang = new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement(
                    "SELECT * FROM languages");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Languages language = new Languages();
                language.setId(resultSet.getLong("id"));
                language.setName(resultSet.getString("name"));
                language.setCode(resultSet.getString("code"));

                allLang.add(language);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return allLang;
    }

    public static ArrayList<Publications> getAllPublications() {
        ArrayList<Publications> allPub = new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement(
                    "SELECT * FROM publications");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Publications publication = new Publications();

                publication.setId(resultSet.getLong("id"));
                publication.setName(resultSet.getString("name"));
                publication.setDescription(resultSet.getString("description"));
                publication.setRating(resultSet.getDouble("rating"));

                allPub.add(publication);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return allPub;
    }

    public static ArrayList<News> getAllNews(){
        ArrayList<News> allNews = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT nw.id, nw.title, nw.short_content, nw.content, nw.date, nw.picture_url, pb.id AS publicId ," +
                            " pb.name AS publicName,pb.description ,pb.rating, lg.id as langId , lg.name AS langName, lg.code " +
                            "FROM news nw " +
                            "inner join publications pb on pb.id = nw.publication_id "+
                            "inner join languages lg on lg.id = nw.languages_id");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String short_content = resultSet.getString("short_content");
                String content = resultSet.getString("content");
                String date = resultSet.getString("content");
                String picture_url = resultSet.getString("picture_url");

                Publications publication = new Publications();
                publication.setId(resultSet.getLong("publicId"));
                publication.setName(resultSet.getString("publicName"));
                publication.setDescription(resultSet.getString("description"));
                publication.setRating(resultSet.getDouble("rating"));

                Languages language = new Languages();
                language.setId(resultSet.getLong("langId"));
                language.setName(resultSet.getString("langName"));
                language.setCode(resultSet.getString("code"));

                News news = new News();
                news.setId(id);
                news.setTitle(title);
                news.setShort_content(title);
                news.setContent(content);
                news.setDate(date);
                news.setPicture_url(picture_url);
                news.setPublications(publication);
                news.setLanguages(language);

                allNews.add(news);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return allNews;
    }
}