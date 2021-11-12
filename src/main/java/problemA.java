import java.util.Scanner;
//Some numbers are just, well, odd. For example, the number  is odd, because it is not a multiple of two. Numbers that are a multiple of two are not odd, they are even. More precisely, if a number  can be expressed as  for some integer , then  is even. For example,  is even.
//
//Some people get confused about whether numbers are odd or even. To see a common example, do an internet search for the query “is zero even or odd?” (Don’t search for this now! You have a problem to solve!)
//
//Write a program to help these confused people.
//
//Input
//Input begins with an integer  on a line by itself, indicating the number of test cases that follow. Each of the following  lines contain a test case consisting of a single integer .
//
//Output
//For each , print either ‘ is odd’ or ‘ is even’ depending on whether  is odd or even.
public class problemA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases;
        int number;

        numberOfTestCases = scanner.nextInt();

        for (int i = 0; i < numberOfTestCases; i++) {
            number = scanner.nextInt();
            System.out.printf("%d %s%n", number, (number & 1) == 0 ? "is even" : "is odd");

        }
    }
}
