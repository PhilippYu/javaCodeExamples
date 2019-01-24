import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

import com.mysql.jdbc.Driver;

public class Runner {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/jdbcdb";
        String username = "root";
        String password = "";
        String className = "com.mysql.jdbc.Driver";
        ArrayList<Segment> lenNums = new ArrayList<>();

        try{
            Class.forName(className);
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;

            try{
                connection = DriverManager.getConnection(url,username,password);
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT ABS(FLOOR(x2-x1)) AS len,COUNT(*) AS num FROM coordinates GROUP BY len ORDER BY len ASC");

                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("len")+";"+resultSet.getInt("num"));
                    Segment segment = new Segment(resultSet.getInt("len"), resultSet.getInt("num"));
                    lenNums.add(segment);
                }

                Statement statement1 = connection.createStatement();
                statement1.executeUpdate("DELETE FROM frequencies");

                PreparedStatement preparedStatement = null;
                preparedStatement = connection.prepareStatement("INSERT INTO frequencies VALUES (?,?)");

                for (Segment segment : lenNums){
                    preparedStatement.setInt(1,segment.getLen());
                    preparedStatement.setInt(2,segment.getNum());
                    preparedStatement.executeUpdate();
                }

                ResultSet resultSet1 = null;
                Statement statement2 = null;
                statement2 = connection.createStatement();
                resultSet1 = statement2.executeQuery("SELECT len,num FROM frequencies WHERE len>num");

                System.out.println("\n");
                while(resultSet1.next()){
                    System.out.println(resultSet1.getInt("len")+";"+resultSet1.getInt("num"));
                }

            } finally {
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
