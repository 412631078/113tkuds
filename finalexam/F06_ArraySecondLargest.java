import java.util.*;

public class F06_ArraySecondLargest {
    public static int[] findSecondMax(int[] arr, int l, int r) {
        if (r - l == 1) {
            int max = Math.max(arr[l], arr[r]);
            int sec = Math.min(arr[l], arr[r]);
            return new int[]{max, sec};
        } else if (l == r) {
            return new int[]{arr[l], Integer.MIN_VALUE};
        }
        int mid = (l + r) / 2;
        int[] left = findSecondMax(arr, l, mid);
        int[] right = findSecondMax(arr, mid + 1, r);

        int[] temp = new int[]{left[0], left[1], right[0], right[1]};
        Arrays.sort(temp);
        return new int[]{temp[3], temp[2]};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int[] result = findSecondMax(arr, 0, n - 1);
        System.out.println("SecondMax: " + result[1]);
    }
}

/*
 * Time Complexity: O(n log n)
 * 說明：遞迴分治法，每層合併需排序，總複雜度為 O(n log n)。
 */