package arrayapp;

import arrayapp.comparator.ArrayComparators;
import arrayapp.entity.IntArrayEntity;
import arrayapp.entity.IntArrayBuilder;
import arrayapp.exception.ArrayDataException;
import arrayapp.parser.IntArrayParser;
import arrayapp.reader.TextFileReader;
import arrayapp.repository.IntArrayRepository;
import arrayapp.service.ArrayCalculationService;
import arrayapp.service.ArraySearchService;
import arrayapp.service.IntArrayCalculationService;
import arrayapp.service.IntArraySearchService;
import arrayapp.specification.IdSpecification;
import arrayapp.specification.NameSpecification;
import arrayapp.specification.StatisticSpecification;
import arrayapp.specification.StatisticType;
import arrayapp.warehouse.Warehouse;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApplicationRunner {

    private static final Logger LOGGER = LogManager.getLogger(ApplicationRunner.class);
    private static final String DATA_FILE_PATH = "data/arrays.txt";

    public static void main(String[] args) {
        runFirstPart();
        runSecondPart();
    }

    private static void runFirstPart() {
        TextFileReader fileReader = new TextFileReader();
        IntArrayParser parser = new IntArrayParser();
        ArraySearchService searchService = new IntArraySearchService();
        ArrayCalculationService calculationService = new IntArrayCalculationService();

        try {
            List<String> lines = fileReader.readLines(DATA_FILE_PATH);
            List<IntArrayEntity> arrays = parser.parseAll(lines);

            for (IntArrayEntity array : arrays) {
                Integer minimum = searchService.findMin(array).orElse(0);
                Integer maximum = searchService.findMax(array).orElse(0);
                Long sum = calculationService.calculateSum(array).orElse(0L);
                Double average = calculationService.calculateAverage(array).orElse(0.0);

                LOGGER.info("Part I. Array: {}", array.getValues());
                LOGGER.info("Part I. min={}, max={}, sum={}, average={}",
                        minimum, maximum, sum, average);
            }
        } catch (ArrayDataException exception) {
            LOGGER.error("Part I failed while processing array data", exception);
        }
    }

    private static void runSecondPart() {
        IntArrayRepository repository = IntArrayRepository.getInstance();

        IntArrayEntity firstArray = new IntArrayBuilder()
                .id(1)
                .name("first")
                .values(new int[]{5, 2, 8})
                .build();

        IntArrayEntity secondArray = new IntArrayBuilder()
                .id(2)
                .name("second")
                .values(new int[]{10, 20, 30})
                .build();

        IntArrayEntity thirdArray = new IntArrayBuilder()
                .id(3)
                .name("third")
                .values(new int[]{1, 1, 1})
                .build();

        repository.add(firstArray);
        repository.add(secondArray);
        repository.add(thirdArray);

        LOGGER.info("Part II. Initial statistics: {}",
                Warehouse.getInstance().getStatistics(1));

        firstArray.setValue(0, 100);

        LOGGER.info("Part II. Recalculated statistics: {}",
                Warehouse.getInstance().getStatistics(1));

        List<IntArrayEntity> arraysWithSumAboveTen = repository.find(
                new StatisticSpecification(StatisticType.SUM, ">", 10)
        );

        LOGGER.info("Part II. Arrays with sum > 10: {}", arraysWithSumAboveTen);

        List<IntArrayEntity> arrayByName = repository.find(
                new NameSpecification("second")
        );

        LOGGER.info("Part II. Array found by name: {}", arrayByName);

        List<IntArrayEntity> arrayById = repository.find(new IdSpecification(3));

        LOGGER.info("Part II. Array found by id: {}", arrayById);

        repository.sort(ArrayComparators.BY_FIRST_ELEMENT);

        LOGGER.info("Part II. Arrays sorted by first element: {}", repository.getAll());

        repository.remove(2);

        LOGGER.info("Part II. Arrays after removal: {}", repository.getAll());
    }
}
