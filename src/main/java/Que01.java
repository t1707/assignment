import java.util.*;

public class Que01 {

    public static boolean checkPalin(String str){
        int i=0, j=str.length()-1;
        while(i<j){
            if(!Character.isLetterOrDigit(str.charAt(i))) i++;
            else if(!Character.isLetterOrDigit(str.charAt(j))) j--;
            else if(Character.toLowerCase(str.charAt(i++))!=Character.toLowerCase(str.charAt(j--))) {
                return false;
            }
        }
        return true;
    }
}
