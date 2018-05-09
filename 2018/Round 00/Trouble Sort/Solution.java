import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            in.nextInt();
            in.nextLine();

            String m = in.nextLine();
            List<Integer> arr = Arrays.asList(m.split(" ")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

            System.out.println("Case #" + i + ": " + solve(arr));
        }
    }

    private static String solve(List<Integer> arr) {
        List<Integer> sortedArr = arr.stream().sorted().collect(Collectors.toList());
        List<Integer> troubledArr = troubleSort(arr);

        for (int idx = 0; idx < sortedArr.size(); idx++) {
            if (!sortedArr.get(idx).equals(troubledArr.get(idx))) {
                return Integer.toString(idx);
            }
        }

        return "OK";
    }

    private static List<Integer> troubleSort(List<Integer> arr) {
        boolean done = false;
        while (!done) {
            done = true;
            for (int idx = 0; idx < arr.size()-2; idx++) {
                if (Integer.compare(arr.get(idx), arr.get(idx+2)) > 0) {
                    done = false;
                    Collections.swap(arr, idx, idx+2);
                }
            }
        }
        return arr;
    }
}