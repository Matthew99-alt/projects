package matvey.exceptions;

public class Main {

    public static void main(String[] args) {

        String[][] num = {{"5", "7", "3"}, {"7", "0", "1", "12", "11"}, {"7", "0", "1", "12"}, {"7", "0", "1", "12"}};
        String[][] num_1 = {{"5", "7", "3", "курица"}, {"7", "0", "1", "12"}, {"7", "0", "1", "12"}, {"7", "0", "1", "12"}};
        String[][] num_2 = {{"5", "7", "3", "11"}, {"7", "0", "1", "12"}, {"7", "0", "1", "12"}, {"7", "0", "1", "12"}};

        Method method = new Method();

        try {
//            method.numbersCount(num);//1 исключение
//            method.numbersCount(num_1);//2 исключение
            method.numbersCount(num_2);//массив без ошибок
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
