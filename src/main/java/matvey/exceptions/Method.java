package matvey.exceptions;

public class Method {

    //метод для работы с массивами
    public void numbersCount(String[][] numbers) throws MyArraySizeException, MyArrayDataException {

        //переменна для суммирования элементов массива
        int result = 0;

        //проверяем количество строк(сколько массивов в массиве массивов)
        //если их 4
        if (numbers.length == 4) {
            for (int i = 0; i < numbers.length; i++) {
                //проверяем количество столбцов(в массивах 4 элемента или нет)
                if (numbers[i].length != 4) {
                    throw new MyArraySizeException("Размер массива не соответствует размеру 4Х4");
                }
            }
        } else {
            throw new MyArraySizeException("Размер массива не соответствует размеру 4Х4");
        }

        //в случае если размер верный запускаем два
        //цикла на преобразование String'овых данных в int
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                try {
                    //преобразовываем строку в число и складываем с уже получившимся числом
                    result = result + Integer.parseInt(numbers[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Массив содержит данные не соответствующие " +
                            "типу int строка " + i + " столбец " + j);
                }
            }
        }

        //выводим результат в случае успешной работы цикла
        System.out.println(result);
    }
}
