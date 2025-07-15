import java.util.*;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] scores = new double[n];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
            if (scores[i] == 5.0) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            System.out.println("None");
        } else {
            for (int idx : result) {
                System.out.print(idx + " ");
            }
        }
    }
}