package SpotifyAutomation;

import java.util.Random;

public class SecureRandomPatternGenerator {

    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;:,.<>?";

    public static String generateSecureRandomPattern() {
        Random random = new Random();
        StringBuilder pattern = new StringBuilder();

        // Ensure at least 1 letter
        pattern.append(getRandomChar(LETTERS, random));

        // Ensure at least 1 number or special character
        String numbersAndSpecialChars = NUMBERS + SPECIAL_CHARS;
        pattern.append(getRandomChar(numbersAndSpecialChars, random));

        // Fill the remaining characters to meet the minimum length of 10
        int remainingLength = 8; // 10 total - 2 already added
        String allChars = LETTERS + NUMBERS + SPECIAL_CHARS;
        for (int i = 0; i < remainingLength; i++) {
            pattern.append(getRandomChar(allChars, random));
        }

        // Shuffle the pattern to ensure randomness
        return shuffleString(pattern.toString(), random);
    }

    private static char getRandomChar(String charSet, Random random) {
        int randomIndex = random.nextInt(charSet.length());
        return charSet.charAt(randomIndex);
    }

    private static String shuffleString(String input, Random random) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
}
