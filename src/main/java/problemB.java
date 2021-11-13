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



