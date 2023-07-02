package Algorithms.Strings;

import java.util.Set;

public class StringSegmentation {
    public static boolean canSegmentString(String inputString, Set<String> dictionary) {
        for (int i = 1; i < inputString.length(); ++i) {
            String first = inputString.substring(0, i);

            if (dictionary.contains(first)) {
                String second = inputString.substring(i);
                if (inputString.isEmpty()) {
                    return true;
                }

                if (dictionary.contains(second)) {
                    return true;
                }

                if (canSegmentString(second, dictionary)) {
                    return true;
                }

            }
        }
        return false;
    }
}
