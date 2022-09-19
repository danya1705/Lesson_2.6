import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>(List.of(1, 1, 8, 3, 4, 4, 5, 5, 6, 7));

        printUneven(nums);
        printEvenSortedNoRepeats(nums);

        String str = "Humpty Dumpty sat on a wall, Humpty Dumpty had a great fall";
        List<String> words = new ArrayList<>(List.of(str.split("[ ,.!?]+")));

        printUniqueWords(words);
        printDoublesCount(words);
    }

    private static void printUneven(List<Integer> nums) {
        for (Integer num : nums) {
            if (num % 2 == 1) {
                System.out.printf(num + " ");
            }
        }
        System.out.println();
    }

    private static void printEvenSortedNoRepeats(List<Integer> nums) {
        Collections.sort(nums);
        Set<Integer> checkDoubles = new HashSet<>();
        for (Integer num : nums) {
            if (num % 2 == 0 && checkDoubles.add(num)) {
                System.out.printf(num + " ");
            }
        }
        System.out.println();
    }

    private static void printUniqueWords(List<String> words) {
        Set<String> checkDoubles = new HashSet<>();
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            if (checkDoubles.add(word)) {
                uniqueWords.add(word);
            } else uniqueWords.remove(word);
        }
        System.out.println(uniqueWords);
    }

    private static void printDoublesCount(List<String> words) {
        Map<String, Integer> mappedWords = new HashMap<>();
        for (String word : words) {
            if (mappedWords.containsKey(word)) {
                mappedWords.put(word, mappedWords.get(word) + 1);
            } else {
                mappedWords.put(word, 1);
            }
        }
        for (Integer value : mappedWords.values()) {
            if (value > 1) System.out.printf(value + " ");
        }
    }
}