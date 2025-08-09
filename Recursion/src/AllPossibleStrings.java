import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class AllPossibleStrings {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        StringBuilder sb1 = new StringBuilder();
        int n = 4;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        boolean[] visited = new boolean[n];
        permutations(sb.toString(), res, sb1, visited);
        Collections.sort(res);
//        System.out.println(res.get(5));
        for(String s:res){
            System.out.println(s);
        }

    }

    private static void permutations(String s, List<String> res, StringBuilder sb, boolean[] visited) {
        if (sb.length() == s.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            sb.append(s.charAt(i));
            permutations(s, res, sb, visited);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
}
