package JOINTS1.DB;

import JDBCbigTASK.Tasks.Task;
import JOINTS1.Objects.City;
import JOINTS1.Objects.Student;

import java.sql.*;
import java.util.ArrayList;

public class DBConnectoR {
    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/EE1","postgres","jeffkalash");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static ArrayList<Student> getAllStudent(){
        ArrayList<Student> students = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT st.id, st.name, st.surname, st.birthdate, c.name AS cityName, c.code " +
                            "FROM students st " +
                            "inner join cities c on c.city_id = st.city_id ");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String birthdate = resultSet.getString("birthdate");

                City ct = new City();
                ct.setId(resultSet.getLong("id"));
                ct.setName(resultSet.getString("cityname"));
                ct.setCode(resultSet.getString("code"));

                Student stn = new Student();
                stn.setId(id);
                stn.setName(name);
                stn.setSurname(surname);
                stn.setBirthdate(birthdate);
                stn.setCity(ct);

                students.add(stn);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }



    public static ArrayList<City> getAllCities(){

        ArrayList<City> cities = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM cities ORDER BY name ASC");

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){

                City ct = new City();
                ct.setId(resultSet.getLong("city_id"));
                ct.setName(resultSet.getString("name"));
                ct.setCode(resultSet.getString("code"));

                cities.add(ct);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return cities;
    }

        public static City getCity(Long id){

            City city = null;

            try{

                PreparedStatement statement = connection.prepareStatement("" +
                        "SELECT * FROM cities WHERE city_id = ?");
                statement.setLong(1, id);
                ResultSet resultSet = statement.executeQuery();

                if(resultSet.next()){
                    city = new City();
                    city.setId(resultSet.getLong("city_id"));
                    city.setName(resultSet.getString("name"));
                    city.setCode(resultSet.getString("code"));
                }

                statement.close();

            }catch (Exception e){
                e.printStackTrace();
            }

            return city;
        }



    public static void addStudent (Student student){
        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "INSERT INTO students (name, surname, birthdate, city_id) " +
                    "VALUES (?,?,?,?)");
            statement.setString(1,student.getName());
            statement.setString(2,student.getSurname());
            statement.setDate(3, Date.valueOf(student.getBirthdate()));
            statement.setLong(4,student.getCity().getId());

            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addCity (City city){
        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "INSERT INTO cities (name , code) " +
                    "VALUES (?,?)");
            statement.setString(1,city.getName());
            statement.setString(2,city.getCode());

            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static Student getStudent(Long id){

        Student student = null;

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    ("SELECT st.id, st.name, st.surname, st.birthdate, c.name AS cityName, c.code " +
                            "FROM students st " +
                            "inner join cities c on c.city_id = st.city_id  " +
                    "WHERE st.id = ?"));

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String birthdate = resultSet.getString("birthdate");

                City ct = new City();
                ct.setId(resultSet.getLong("id"));
                ct.setName(resultSet.getString("cityName"));
                ct.setCode(resultSet.getString("code"));

                student = new Student();
                student.setId(id);
                student.setName(name);
                student.setSurname(surname);
                student.setBirthdate(birthdate);
                student.setCity(ct);

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return student;
    }


}
