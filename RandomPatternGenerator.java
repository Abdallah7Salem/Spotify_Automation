package SpotifyAutomation;

import java.util.Random;

public class RandomPatternGenerator {

    public static String generateRandomPattern() {
        Random random = new Random();
        StringBuilder pattern = new StringBuilder();

        // Generate the first part [6-10] which must contain both numbers and alphabets
        int lengthFirstPart = random.nextInt(5) + 6; // Random length between 6 and 10
        boolean hasNumber = false;
        boolean hasLetter = false;

        while (pattern.length() < lengthFirstPart || !hasNumber || !hasLetter) {
            if (pattern.length() >= lengthFirstPart) {
                // Reset if we reach the length but don't have both a number and a letter
                pattern.setLength(0);
                hasNumber = false;
                hasLetter = false;
            }

            if (random.nextBoolean()) {
                // Append a random number (0-9)
                pattern.append(random.nextInt(10));
                hasNumber = true;
            } else {
                // Append a random lowercase alphabet (a-z)
                char randomChar = (char) (random.nextInt(26) + 'a');
                pattern.append(randomChar);
                hasLetter = true;
            }
        }

        // Append the fixed domain "@gmail.com"
        pattern.append("@gmail.com");

        return pattern.toString();
    }
}