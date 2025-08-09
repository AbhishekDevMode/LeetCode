import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Set<List<Integer>> res = new HashSet<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        backtrack(nums, res, list, used);
        List<List<Integer>> res1 = new ArrayList<>(res);

        for (List<Integer> n : res) {
            System.out.println(n);
        }


    }

    private static void backtrack(int[] nums, Set<List<Integer>> res, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));

            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            list.add(nums[i]);
            backtrack(nums, res, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
