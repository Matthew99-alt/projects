package matvey.ApiWeather;

import java.sql.*;
import java.util.Objects;

public class WeatherData {

    private Connection connection;
    private Statement table;
    private PreparedStatement query;


    public void writeItDownAndShow(WeatherResponse weather, String days) {

        try {

            //CRUD - Create/Read/Update/Delete
            // load JDBC driver
            Class.forName("org.sqlite.JDBC");

            //protocol - db type - db location
            connection = DriverManager.getConnection("jdbc:sqlite:weatherDb.db");
            table = connection.createStatement();

            table.executeUpdate("DROP TABLE IF EXISTS weather");

            table.executeUpdate("CREATE TABLE IF NOT EXISTS weather (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "text STRING, date Date NOT NULL, min DOUBLE NOT NULL, max DOUBLE NOT NULL);");

            query = connection.prepareStatement("INSERT INTO weather (text, date, min, max) VALUES (?,?,?,?)");

            if (Objects.equals(days, "5day")) {
                // Демонстрация prepared statement
                for (int i = 0; i < weather.getDailyForecastsLength(); i++) {
                    fillTheDataBase(i, weather);
                }
            } else {
                fillTheDataBase(0, weather);
            }
            query.executeBatch();

            ResultSet resultSet = table.executeQuery("SELECT * FROM weather");
            while (resultSet.next()) {
                showTheDataBase(resultSet);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                table.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }

    }

    private void fillTheDataBase(int i, WeatherResponse weather) throws SQLException {
        query.setString(1, weather.getHeadlineText());
        query.setString(2, weather.getDailyForecastsDate(i).replace("T", " "));
        query.setDouble(3, weather.getDailyForecastsMin(i));
        query.setDouble(4, weather.getDailyForecastsMax(i));
        query.addBatch();
    }

    private void showTheDataBase(ResultSet resultSet) throws SQLException {
        System.out.println(
                resultSet.getString(1) + " | " +
                        resultSet.getString("date") + " | " +
                        resultSet.getDouble("min") + " | " +
                        resultSet.getDouble("max") + " | "
        );
    }
}