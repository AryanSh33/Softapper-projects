import java.util.*;

public class Hash {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);

        for(int i=0;i<5;i++){
            map.put(i,i+1);
        }
    }
}
