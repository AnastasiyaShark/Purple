//An anagram is a reordering of the letters in a word of phrase. For example, you can rearrange the letters of terraced to get the word retraced. Rearranging them some more will give you the word cratered. You can even make dactrere and redatrec, which are both anagrams of terraced even if they are not legitimate English words.
//
//Input
//Input contains up to  words, one per line. Each word consists of upper- and lower-case letters (a–z) and may have as many as  characters. Input ends at end of file.
//
//Output
//For every input word, output the total number of unique anagrams that can be made from it. For the purpose of this problem, upper- and lower-case letters are considered distinct.
//
//Sample Input 1	Sample Output 1
//at
//ordeals
//abcdefghijklmnopqrstuvwxyz
//abcdefghijklmabcdefghijklm
//abcdABCDabcd
//2
//5040
//403291461126605635584000000
//49229914688306352000000
//29937600


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class problemB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            BigDecimal denominator = new BigDecimal(1);

            int wordLength = word.length();
            if (wordLength == 0) {
                System.out.println(0);
                continue;
            }
            List<Character> charters = new ArrayList<>();
            for (int i = 0; i < wordLength; i++) {
                charters.add(word.charAt(i));
            }
            //map with charters and counts
            Map<Character, Integer> map = charters.stream()
                    .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
            //map with counts and counts
            Map<Integer, Integer> repetitionsPerGroup = map.values().stream()
                    .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));

            for (Integer key : repetitionsPerGroup.keySet()) {
                Integer value = repetitionsPerGroup.get(key);
                denominator = denominator.multiply((countDenominator(key, value)));
            }

            System.out.println(factorialUsingStreams(wordLength).divide(denominator, RoundingMode.CEILING));
        }
        scanner.close();
    }

    //get denominator
    public static BigDecimal countDenominator(int numberOfElementsInGroup, int numberOfGroups) {
        return BigDecimal.valueOf(Math.pow(numberOfElementsInGroup, numberOfGroups));
    }

    //consider factorial
    public static BigDecimal factorialUsingStreams(int n) {
        BigDecimal idx = new BigDecimal(1);
        for (int i = 1; i <= n; i++) {
            idx = idx.multiply(BigDecimal.valueOf(i));
        }
        return idx;
    }

}


//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//public class problemB {
//
//
//    public static void main(String[] args) {
//
//
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            String word = scanner.nextLine();
//            BigInteger denominator = new BigInteger("1");
//
//            int wordLength = word.length();
//            if (wordLength == 0) {
//                System.out.println(0);
//                continue;
//            }
//            List<Character> charters = new ArrayList<>();
//            for (int i = 0; i < wordLength; i++) {
//                charters.add(word.charAt(i));
//            }
//            //map with charters and counts
//            Map<Character, Integer> map = charters.stream()
//                    .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
//            //map with counts and counts
//            Map<Integer, Integer> repetitionsPerGroup = map.values().stream()
//                    .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
//
//            for (Integer key : repetitionsPerGroup.keySet()) {
//                Integer value = repetitionsPerGroup.get(key);
//                denominator = denominator.multiply(BigInteger.valueOf(countDenominator(key, value)));
//            }
//
//            System.out.println(factorialUsingStreams(wordLength).divide(denominator).doubleValue());
//        }
//        scanner.close();
//    }
//
//    //get denominator
//    public static int countDenominator(int numberOfElementsInGroup, int numberOfGroups) {
//        System.out.println((int) Math.pow(numberOfElementsInGroup, numberOfGroups));
//        return (int) Math.pow(numberOfElementsInGroup, numberOfGroups);
//
//    }
//
//    //consider factorial
//    public static BigInteger factorialUsingStreams(int n) {
//        BigInteger idx = new BigInteger("1");
//        for (int i = 1; i <= n; i++) {
//            idx = idx.multiply(BigInteger.valueOf(i));
//        }
//        return idx;
//
//    }
//
//}


//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//public class problemB {
//
//
//    public static void main(String[] args) {
//
//
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            String word = scanner.nextLine();
//            int wordLength = word.length();
//            if (wordLength == 0){
//                System.out.println(wordLength);
//                continue;
//            }
//
//            BigDecimal denominator = new BigDecimal(1);
//
//            List<String> charters = Arrays.asList(word.split(""));
//            //map with charters and counts
//            Map<String, Integer> map = charters.stream()
//                    .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
//            //map with counts and counts
//            Map<Integer, Integer> repetitionsPerGroup = map.values().stream()
//                    .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
//
//            for (Integer key : repetitionsPerGroup.keySet()) {
//                Integer value = repetitionsPerGroup.get(key);
//                denominator = denominator.multiply((countDenominator(key, value)));
//            }
//
//            System.out.println(factorialUsingStreams(wordLength).divide(denominator, RoundingMode.CEILING));
//        }
//        scanner.close();
//    }
//
//    //get denominator
//    public static BigDecimal countDenominator(int numberOfElementsInGroup, int numberOfGroups) {
//        return BigDecimal.valueOf(Math.pow(numberOfElementsInGroup, numberOfGroups)) ;
//
//    }
//
//    //consider factorial
//    public static BigDecimal factorialUsingStreams(int n) {
//        BigDecimal idx = new BigDecimal(1);
//        for (int i = 1; i <= n; i++) {
//            idx = idx.multiply(BigDecimal.valueOf(i));
//        }
//        return idx;
//
//    }
//
//
//}



