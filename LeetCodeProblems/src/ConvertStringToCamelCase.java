import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConvertStringToCamelCase {
    static String toCamelCase(String s) {
        String[] words = s.split("[-_\\s]+"); // Split by hyphens, underscores, or spaces
        StringBuilder camelCaseString = new StringBuilder(words[0].toLowerCase());

        for (int i = 1; i < words.length; i++) {
            camelCaseString.append(Character.toUpperCase(words[i].charAt(0)));
            camelCaseString.append(words[i].substring(1).toLowerCase());
        }

        return camelCaseString.toString();
    }
    @Test
    public void testSomeUnderscoreLowerStart() {
        String input = "mountain-Green-Ninja-left-desert-Black-Street-desert-Square-Ninja";
        System.out.println("input: "+input);
        assertEquals("mountainGreenNinjaLeftDesertBlackStreetDesertSquareNinja", ConvertStringToCamelCase.toCamelCase(input));
    }
}
