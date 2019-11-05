package com.foxminded.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * Count unique characters in the input string and save calculation in form of String.
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class Calculation {

    /**
     * Line separator depends on user's OS.
     */
    private static final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * Cache for saving a state of an object.
     */
    private SimpleCacheManager cache;

    /**
     * Result in form of "StringBuilder".
     */
    private StringBuilder drawnResult = new StringBuilder();

    /**
     * Constructor of the class.
     */
    public Calculation(SimpleCacheManager cache) {
        this.cache = cache;
    }

    /**
     * Returns result of counting.
     *
     * @param input - input form a user - String
     * @return - returns number of unique characters in the input(String) - String
     */
    public String getResult(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Expected String but the input was null...");
        }
        String result;
        input = input.toLowerCase();

        if (cache.get(input) == null) {
            drawnResult.setLength(0);
            drawnResult.append(input).append(LINE_SEPARATOR);
            Map<Character, Integer> mapOfResult = countLetters(input);
            mapOfResult.forEach((key, value) -> drawnResult.append(String.format("\"%s\" - %d%s", key, value, LINE_SEPARATOR)));
            cache.put(input, mapOfResult);
            result = drawnResult.toString();
        } else {
            Map<Character, Integer> mapOfResult = cache.get(input);
            mapOfResult.forEach((key, value) -> drawnResult.append(String.format("\"%s\" - %d%s", key, value, LINE_SEPARATOR)));
            result = drawnResult.toString();
        }
        return result;
    }

    /**
     * Counts unique characters in input String.
     *
     * @param input - input form a user - String
     * @return - return HashMap with the calculation from the input String - Map
     */
    private Map<Character, Integer> countLetters(String input) {
        List<Character> list = convertToList(input);
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : list) {
            map.merge(c, 1, (a, b) -> a + b);
        }
        return map;
    }

    /**
     * Converts a String to List of characters.
     *
     * @param string - a string - String
     * @return - return List of characters - List
     */
    private List<Character> convertToList(String string) {
        return string.chars().mapToObj(b -> (char) b).collect(toList());
    }
}
