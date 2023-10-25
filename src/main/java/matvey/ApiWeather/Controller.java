package matvey.ApiWeather;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import matvey.ApiWeather.enums.Functionality;
import matvey.ApiWeather.enums.Periods;

public class Controller {
    //объект класса apiWeather
    ApiWeather apiWeather = new ApiWeather();
    //маппа вариантов
    Map<Integer, Functionality> variantResult = new HashMap<>();
    //???
    public Controller() {
        variantResult.put(1, Functionality.GET_CURRENT_WEATHER);
        variantResult.put(2, Functionality.GET_WEATHER_IN_NEXT_5_DAYS);
    }

    //метод для проверки числа
    public void onUserInput(String input) throws IOException {
        //ползователь вводит число
        int command = Integer.parseInt(input);
        //проверяем на наличие введённого номера
        if (!variantResult.containsKey(command)) {
            throw new IOException("There is no command for command-key " + command);
        }
        //выбираем данные в соответствии с номером если правильный
        switch (variantResult.get(command)) {
            case GET_CURRENT_WEATHER:
                getCurrentWeather();
                break;
            case GET_WEATHER_IN_NEXT_5_DAYS:
                getWeatherIn5Days();
                break;
        }
    }
    //getter'ы и setter'ы
    public void getCurrentWeather() throws IOException {
        apiWeather.getWeather(Periods.NOW);
    }
    public void getWeatherIn5Days() throws IOException {
        apiWeather.getWeather(Periods.FIVE_DAYS);
    }
}
