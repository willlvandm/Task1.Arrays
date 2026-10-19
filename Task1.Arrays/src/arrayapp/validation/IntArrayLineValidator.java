package arrayapp.validation;

import java.util.regex.Pattern;

public class IntArrayLineValidator {

    private static final Pattern VALID_LINE_PATTERN =
            Pattern.compile("^-?\\d+(\\s*[,;\\-]\\s*-?\\d+)*\\s*$");

    public boolean isValid(String line) {
        if (line == null) {
            return false;
        }

        String trimmedLine = line.trim();

        if (trimmedLine.isEmpty()) {
            return false;
        }

        return VALID_LINE_PATTERN.matcher(trimmedLine).matches();
    }
}