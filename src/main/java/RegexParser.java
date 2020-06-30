import java.util.HashMap;
import java.util.HashSet;

public class RegexParser {

    public static void main(String[] args) {
        RegexParser rg = new RegexParser();
        //System.out.println(rg.isMatch("bbbba", ".*a*a"));
        //System.out.println(rg.isMatch("ab", ".*c"));
        //System.out.println(rg.isMatch("a", "ab*"));
        System.out.println(rg.isMatch("", "c*c*"));
    }

    HashMap<String,Boolean> hash = new HashMap<>();
    public boolean isMatch(String s, String p) {
        return isMatchRec(s, p,0,0);
    }

    private boolean isMatchRec(String s, String p,int i, int j) {
        String index = i + "." + j;
        if (hash.containsKey(index))
            return hash.get(index);
        boolean aboutToMask = j+1 < p.length() && p.charAt(j+1) == '*';
        boolean maskAny = p.substring(j).startsWith(".*");
        boolean res = false;

        if (i == s.length()) {
            res =  j == p.length() || (aboutToMask && isMatchRec(s,p,i,j+2));
            hash.put(index,res);
            return res;
        }
        if (j >= p.length()){
            hash.put(index,false);
            return false;
        }

        boolean b = s.charAt(i) == p.charAt(j);
        if (maskAny || (aboutToMask &&b)) {
            res =   isMatchRec(s, p,i,j+2) || isMatchRec(s,p,i+1,j+2) || isMatchRec(s,p,i+1,j);
            hash.put(index,res);
            return res;
        }

        if (p.charAt(j)== '.') {
            res = isMatchRec(s, p, i + 1, j + 1);
            hash.put(index, res);
            return res;
        }

        if (b)
            res = isMatchRec(s,p,i+1,j+1); //equal + no-mask
        else if (aboutToMask) //zero match
             res =   isMatchRec(s,p,i,j+2); //treat * as zero

        hash.put(index,res);
        return res;

    }


}





