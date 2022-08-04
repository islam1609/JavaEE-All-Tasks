package Sprint1.db;

import Sprint1.item.Item;
import Sprint1.item.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBconnector {
    private static Connection connection;
    static{
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/EE1","postgres","jeffkalash");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Item> getAllItems(){
        ArrayList<Item> allItems= new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT * FROm t_items");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");

                Item item = new Item();
                item.setId(id);
                item.setName(name);
                item.setDescription(description);
                item.setPrice(price);

                allItems.add(item);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return allItems;
    }
    public static ArrayList<User> getAllUsers(){
        ArrayList<User> allUsers = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT * From users");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                User user = new User();
                user.setEmail(email);

                user.setPassword(password);

                allUsers.add(user);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return allUsers;
    }
}
