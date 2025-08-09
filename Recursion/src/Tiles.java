import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Tiles {
    public static void main(String[] args) {
        String s = "AAB";
        StringBuilder sb = new StringBuilder();
//        List<String> list = new ArrayList<>();
        HashSet<String> list= new HashSet<>();
        totalWords(s,sb,list,0);
        System.out.println(list.size());

        for (String a:list) {
            System.out.println(a);
        }
    }
    private static void totalWords(String s, StringBuilder sb, HashSet<String> list, int i) {
        if (i >= s.length()) {
            list.add(sb.toString());
            return;
        }
        sb.append(s.charAt(i));
        totalWords(s, sb, list, i + 1);
//        sb.deleteCharAt(sb.length() - 1);


    }
}
