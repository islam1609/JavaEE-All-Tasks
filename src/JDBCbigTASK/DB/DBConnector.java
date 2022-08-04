package JDBCbigTASK.DB;

import JDBCbigTASK.Tasks.Task;

import java.sql.*;
import java.util.ArrayList;

public class DBConnector {
    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/EE1","postgres","jeffkalash");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Task> getAllTasks(){
        ArrayList<Task> allTasks = new ArrayList<Task>();
    try{
        PreparedStatement statement = connection.prepareStatement
                ("SELECT * FROM t_tasks");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            Long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String desc = resultSet.getString("description");
            String deadline = resultSet.getString("deadline");
            String done = resultSet.getString("done");

            Task task = new Task();
            task.setId(id);
            task.setName(name);
            task.setDescription(desc);
            task.setDeadlineDate(deadline);
            task.setDone(done);

            allTasks.add(task);

        }
        statement.close();

    }catch (Exception e){
        e.printStackTrace();
        }
            return allTasks;
    }

    public static void addTask (Task task){
        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "INSERT INTO t_tasks (name, description, deadline, done) " +
                    "VALUES (?,?,?,?)");
            statement.setString(1,task.getName());
            statement.setString(2,task.getDescription());
            statement.setDate(3, Date.valueOf(task.getDeadlineDate()));
            statement.setString(4,task.getDone());

            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Task getTask(Long id){

        Task task = null;

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM t_tasks WHERE id = ?");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                String name = resultSet.getString("name");
                String desc = resultSet.getString("description");
                String deadline = resultSet.getString("deadline");
                String done = resultSet.getString("done");

               task = new Task();
               task.setId(id);
               task.setName(name);
               task.setDescription(desc);
               task.setDeadlineDate(deadline);
               task.setDone(done);

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return task;
    }

    public static void saveTask(Task task){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE  t_tasks  set name =?, description=?, deadline=?,done=?" +
                    "where id=?");

            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setDate(3, Date.valueOf(task.getDeadlineDate()));
            statement.setString(4, task.getDone());
            statement.setLong(5, task.getId());

            statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void deleteTask (Task task){
        try{

            PreparedStatement statement = connection.prepareStatement
                    ( "DELETE from t_tasks  WHERE id=?");

            statement.setLong(1, task.getId());

            statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
