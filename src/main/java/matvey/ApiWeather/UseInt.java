package matvey.ApiWeather;

import java.io.IOException;
import java.util.Scanner;

public class UseInt {
    //создаём объект контроллера
    private final Controller controller = new Controller();

    public void runApp() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Здравствуйте! Введите название города на английском языке");
            //вводим название города
            String city = scanner.nextLine();
            //устанавливаем значение города в AppInstance
            setGlobalCity(city);
            System.out.println("Введите ответ: 1 - Получить текущую погоду, " +
                    "2 - Получить погоду на ближайшие 5 дней, "+
                    "выход (exit) - завершить работу");
            String userInput = scanner.nextLine();
            //проверяем выход
            checkIsExit(userInput);
            try {
                //проверяем число
                validateUserInput(userInput);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            try {
                notifyController(userInput);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //проверяем введён ли выход
    private void checkIsExit(String result) {
        if (result.equalsIgnoreCase("выход") || result.equalsIgnoreCase("exit")) {
            System.out.println("Завершаю работу");
            System.exit(0);
        }
    }

    //getter'ы и setter'ы
    private void setGlobalCity(String city) {
        AppInstance.getInstance().setSelectedCity(city);
    }

    private void validateUserInput(String userInput) throws IOException {
        if (userInput == null || userInput.length() != 1) {
            throw new IOException("Incorrect user input: expected one digit as answer, but actually get " + userInput);
        }

        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IOException("Incorrect user input: character is not numeric!");
        }
    }

    private void notifyController(String userInput) throws IOException {
        controller.onUserInput(userInput);
    }
}
