package matvey.ApiWeather;


public class AppInstance {
    //поле выступающее в роли конструктора
    private static AppInstance INSTANCE;
    //поля города и АПИ
    private String selectedCity = null;
    private final String API_KEY = "SWq7PliXGktYGYOht5C9ShKYK7E21v6H";

    //частный конструктор
    private AppInstance(){
    }

    // Непотокобезопасный код для упрощения
    //метод для создания только 1 объекта либо использования уже существующего
    public static AppInstance getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppInstance();
        }
        return INSTANCE;
    }
    //getter'ы и setter'ы
    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }

    public String getApiKey() {
        return this.API_KEY;
    }
}
