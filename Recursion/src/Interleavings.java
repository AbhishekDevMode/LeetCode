import java.util.Arrays;
public class Interleavings {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String a = "nkb";
        String b = "gl";
        maker(a, b, sb, 0,0);
    }


    private static void maker(String a,String b,StringBuilder sb,int i,int j){
        if(i==a.length() && j==b.length()){
            System.out.println(sb.toString());

            return;
        }
        if(i<a.length()){
            sb.append(a.charAt(i));
            maker(a,b,sb,i+1,j);
            sb.deleteCharAt(sb.length()-1);
        }
        if(j<b.length()){
            sb.append(b.charAt(j));
            maker(a,b,sb,i,j+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
