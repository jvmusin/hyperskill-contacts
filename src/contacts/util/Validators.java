package contacts.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Validators {
    public static boolean isNumberValid(String number) {
        String[] parts = number.split("(\\s|-)", -1);
        if (parts.length == 0) return false;
        if (parts[0].startsWith("+")) parts[0] = parts[0].substring(1);
        boolean foundParentheses = false;
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("(") && part.endsWith(")")) {
                if (i > 1 || foundParentheses) return false;
                foundParentheses = true;
                part = part.substring(1, part.length() - 1);
            }
            int len = i == 0 ? 1 : 2;
            if (!part.matches("[a-zA-Z0-9]{" + len + ",}")) return false;
        }
        return true;
    }

    public static Character tryParseGender(String gender) {
        return gender.matches("[MF]") ? gender.charAt(0) : null;
    }

    public static LocalDate tryParseBirthday(String birthday) {
        try {
            return LocalDate.parse(birthday);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
