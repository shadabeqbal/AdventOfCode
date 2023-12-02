import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class one{

    public static int coo(String str, Map<String,Integer> mp, int i){
        int temp = 0;
        if(Character.isDigit(str.charAt(i))){
            temp = str.charAt(i) - '0';
            return temp;
        }

        if(i <= str.length() - 3){
            temp = mp.getOrDefault(str.substring(i, i+3), 0);
            
            if(temp != 0)
                return temp;
        }
        
        if(i <= str.length() - 4){
            temp = mp.getOrDefault(str.substring(i, i+4), 0);
            
            if(temp != 0)
                return temp;
        }
        
        if(i <= str.length() - 5){
            temp = mp.getOrDefault(str.substring(i, i+5), 0);
            
            if(temp != 0)
                return temp;
        }


        return temp;
    }

    public static int foo(String str,Map<String,Integer> mp){
        int x = 0;
        for(int i=0;i<str.length();i++){
            x = coo(str,mp,i);
            if(x != 0)
                return x;
        }

        return x;
    }

    public static int goo(String str,Map<String,Integer> mp){
        int temp = 0;
        for(int i=str.length()-1;i>=0;i--){
            temp = coo(str,mp,i);
            if(temp != 0)
                return temp;
        }

        return temp;
    }

    public static void main(String args[]) throws Exception{
        BufferedInputStream bif = new BufferedInputStream(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(bif);
        int ans = 0;
        Map<String,Integer> mp = new HashMap<>();

        mp.put("one",1);
        mp.put("two",2);
        mp.put("three",3);
        mp.put("four",4);
        mp.put("five",5);
        mp.put("six",6);
        mp.put("seven",7);
        mp.put("eight",8);
        mp.put("nine",9);

        
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            int f = foo(str,mp) * 10;
            int l = goo(str,mp);
            ans += (f + l);
        }

        System.out.println(ans);

    }

}