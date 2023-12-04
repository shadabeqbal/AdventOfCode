package Day2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;

public class cube2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedInputStream(new FileInputStream("Day2/input.txt")));
    
        int ans = 0;
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            String games = str.substring(str.indexOf(':')+2);
            String[] sets = games.split(";");
            
            int t_blue = 0;
            int t_red = 0;
            int t_green = 0;

            for(String each : sets){
                
                String[] rounds = each.split(",");

                for(String r : rounds){
                    String[] values = r.trim().split(" ");
                    
                    String color = values[1];
                    int points = Integer.parseInt(values[0]);

                    if(color.equals("blue"))
                        t_blue = Math.max(t_blue,points);
                    else if(color.equals("red"))
                        t_red = Math.max(t_red,points);
                    else if(color.equals("green"))
                        t_green = Math.max(t_green,points);
                        
                }
            }

            ans += (t_blue * t_red * t_green);
        }

        System.out.println(ans);
    }
}
