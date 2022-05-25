import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter {
    private int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> filterList = new ArrayList<>();
        logger.log("Запускаем фильтрацию");

        for (Integer num : source) {
            if (num > threshold) {
                filterList.add(num);
                logger.log("Элемент \"" + num + "\" проходит ");
            } else
                logger.log("Элемент \"" + num + "\" не проходит ");
        }
        return filterList;

    }
}
