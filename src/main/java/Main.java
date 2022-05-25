import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        try (InputStream is = System.in; Scanner console = new Scanner(is)) {
            logger.log("Запускаем программу");
            logger.log("Просим пользователя ввести входные данные для списка");
            System.out.println("Введите размер списка: ");
            int arrSize = console.nextInt();
            if (arrSize == 0) {
                throw new IllegalArgumentException("Ошибка! Список не может быть пустым");
            }
            System.out.println("Введите верхнюю границу для значений: ");
            int arrHeight = console.nextInt();

            logger.log("Создаем и наполняем список");
            List<Integer> list = new Random()
                    .ints(arrSize, 0, arrHeight)
                    .boxed()
                    .collect(Collectors.toList());
            System.out.print("Вот случайный список: ");
            list.forEach(v -> System.out.print(v + " "));
            System.out.println();

            logger.log("Просим пользователя ввести входные данные для фильтрации");
            System.out.println("Введите порог для фильтрации: ");
            int threshold = console.nextInt();
            Filter filter = new Filter(threshold);
            List<Integer> filteredList = filter.filterOut(list);

            logger.log("Прошло в фильтр " + filteredList.size() + " элементов из " + arrSize);
            logger.log("Выводим результат на экран");
            System.out.print("Отфильтрованный список: ");
            filteredList.forEach(v -> System.out.print(v + " "));
            System.out.println();

            logger.log("Завершаем программу");

        } catch (Exception e) {
            if (e instanceof InputMismatchException) {
                logger.log("Ошибка! Некорректный ввод");
                e.printStackTrace();
            } else if (e instanceof IllegalArgumentException) {
                logger.log("Ошибка! Вводимое значение должно быть больше 0");
                e.printStackTrace();
            }
        }
    }
}
