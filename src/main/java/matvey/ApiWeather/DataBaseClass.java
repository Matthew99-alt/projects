package matvey.ApiWeather;

import java.sql.*;
import java.util.Objects;

//TODO: добавь пож-та команду получения данных из БД, аналогично командам на 1 и 5 дней

public class DataBaseClass {

    // TODO: еще раз повтори! зачем и когда использовать STATIC!
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;


    public void writeItDownAndShow(WeatherResponse weather, String days) {
        try {

            //CRUD - Create/Read/Update/Delete
            // load JDBC driver
            Class.forName("org.sqlite.JDBC");

            //protocol - db type - db location
            connection = DriverManager.getConnection("jdbc:sqlite:weatherDb.db");
            statement = connection.createStatement();

            statement.executeUpdate("DROP TABLE IF EXISTS weather");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS weather (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "text STRING, date Date NOT NULL, min DOUBLE NOT NULL, max DOUBLE NOT NULL);");

            //TODO: вынести работу с preparedStatement и заполнением параметров в отдельный метод
            // переименовать поля, которые не отражают суть, preparedStatement
            if (Objects.equals(days, "5day")) {
                // Демонстрация prepared statement
                preparedStatement = connection.prepareStatement("INSERT INTO weather (text, date, min, max) VALUES (?,?,?,?)");
                for (int i = 1; i < weather.getDailyForecastsLength(); i++) {
                    preparedStatement.setString(1, weather.getHeadlineText());
                    preparedStatement.setString(2, weather.getDailyForecastsDate(i).replace("T", " "));
                    preparedStatement.setDouble(3, weather.getDailyForecastsMin(i));
                    preparedStatement.setDouble(4, weather.getDailyForecastsMax(i));
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM weather");
                // В данном случае result set выгружает всю результирующую выборку
                while (resultSet.next()) {
                    System.out.println(
                            resultSet.getString(1) + " | " +
                                    resultSet.getString("date") + " | " +
                                    resultSet.getDouble("min") + " | " +
                                    resultSet.getDouble("max") + " | "
                    );
                }
            } else {
                //TODO: смотри выше комментарий
                preparedStatement = connection.prepareStatement("INSERT INTO weather (text, date, min, max) VALUES (?,?,?,?)");
                preparedStatement.setString(1, weather.getHeadlineText());
                preparedStatement.setString(2, weather.getDailyForecastsDate(0));
                preparedStatement.setDouble(3, weather.getDailyForecastsMin(0));
                preparedStatement.setDouble(4, weather.getDailyForecastsMax(0));
                preparedStatement.execute();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM weather");
                // В данном случае result set выгружает всю результирующую выборку
                System.out.println(
                        resultSet.getString(1) + " | " +
                                resultSet.getString("date") + " | " +
                                resultSet.getDouble("min") + " | " +
                                resultSet.getDouble("max") + " | "
                );
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            try {
                statement.close();
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

}

