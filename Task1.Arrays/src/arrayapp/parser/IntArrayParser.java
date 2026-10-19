package arrayapp.parser;
import arrayapp.entity.IntArrayEntity;
import arrayapp.exception.ArrayDataException;
import arrayapp.validation.IntArrayLineValidator;
import java.util.ArrayList;
import java.util.List;

public class IntArrayParser {

    private static final String SEPARATOR_REGEX = "[,;\\-\\s]+";

    private final IntArrayLineValidator validator = new IntArrayLineValidator();

    public IntArrayEntity parse(String line) throws ArrayDataException {
        if (!validator.isValid(line)) {
            String message = "Invalid array line: " + line;
            throw new ArrayDataException(message);
        }

        String[] rawValues = line.trim().split(SEPARATOR_REGEX);
        int[] values = convertToValues(rawValues);

        IntArrayEntity.IntArrayBuilder builder = new IntArrayEntity.IntArrayBuilder();
        return builder.values(values).build();
    }

    public List<IntArrayEntity> parseAll(List<String> lines) throws ArrayDataException {
        List<IntArrayEntity> entities = new ArrayList<>();

        for (String line : lines) {
            String trimmedLine = line.trim();

            if (trimmedLine.isEmpty()) {
                continue;
            }

            IntArrayEntity entity = parse(trimmedLine);
            entities.add(entity);
        }

        return entities;
    }

    private int[] convertToValues(String[] rawValues) throws ArrayDataException {
        int[] values = new int[rawValues.length];

        for (int index = 0; index < rawValues.length; index++) {
            try {
                values[index] = Integer.parseInt(rawValues[index].trim());
            } catch (NumberFormatException exception) {
                String message = "Invalid number: " + rawValues[index];
                throw new ArrayDataException(message, exception);
            }
        }

        return values;
    }
}