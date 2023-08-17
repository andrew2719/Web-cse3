import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class CreateDB {
    
    public static void main(String[] args) throws Exception {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/";

            String databaseName = "my_db";
            String userName = "root";
            String password = "Pab2719100coc7!";
    
            Connection connection = DriverManager.getConnection(url,userName, password);
    
            // String sql = "CREATE DATABASE " + databaseName;
    
            // Statement statement = connection.createStatement();
            // statement.executeUpdate(sql);
            // statement.close();
            // JOptionPane.showMessageDialog(null, databaseName + " Database has been created successfully", "System Message", JOptionPane.INFORMATION_MESSAGE);

            // create table
            String sql = "CREATE TABLE " + databaseName + ".student ("
            + "id INT NOT NULL AUTO_INCREMENT,"
            + "name VARCHAR(45) NOT NULL,"
            + "age INT NOT NULL,"
            + "PRIMARY KEY (id))";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();

            // insert data
            sql = "INSERT INTO " + databaseName + ".student (name, age) VALUES ('John', 20)";
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();

            // retrive data by id
            sql = "SELECT * FROM " + databaseName + ".student WHERE id = 1";
            statement = connection.createStatement();
            statement.executeQuery(sql);
            statement.close();

            // input data
            String name = JOptionPane.showInputDialog(null, "Enter name", "Input", JOptionPane.QUESTION_MESSAGE);
            String age = JOptionPane.showInputDialog(null, "Enter age", "Input", JOptionPane.QUESTION_MESSAGE);
            
            // insert using prepared statement
            sql = "INSERT INTO " + databaseName + ".student (name, age) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // insert name aage
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, Integer.parseInt(age));

            preparedStatement.executeUpdate();
            preparedStatement.close();

            // just using execute
            sql = "INSERT INTO " + databaseName + ".student (name, age) VALUES ('" + name + "', " + age + ")";
            statement = connection.createStatement();
            statement.execute(sql);
            statement.close();

            // display data
            sql = "SELECT * FROM " + databaseName + ".student";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " + resultSet.getInt("age"));
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}