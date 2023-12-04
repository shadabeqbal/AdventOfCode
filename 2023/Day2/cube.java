package Day2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class cube {
   
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new BufferedInputStream(new FileInputStream("Day2/input.txt")));
        //12 red cubes, 13 green cubes, and 14 blue cubes
        int red = 12;
        int green = 13;
        int blue = 14;
        int ans = 0;
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            String key = str.substring(5,str.indexOf(':'));
            String games = str.substring(str.indexOf(':')+2);
            String[] sets = games.split(";");
            
            int t_blue = 0;
            int t_red = 0;
            int t_green = 0;
            boolean game_not_possible = false;
            for(String each : sets){
                
                if(t_blue > blue || t_red > red || t_green > green)
                    break;
                
                String[] rounds = each.split(",");

                for(String r : rounds){
                    String[] values = r.trim().split(" ");
                    
                    String color = values[1];
                    int points = Integer.parseInt(values[0]);
                    
                    if(color.equals("blue"))
                        t_blue = points;
                    else if(color.equals("red"))
                        t_red = points;
                    else if(color.equals("green"))
                        t_green = points;

                    if(t_blue > blue || t_red > red || t_green > green){
                        game_not_possible = true;
                        break;
                    }
                    
                }

                if(game_not_possible == true)
                    break;
            }

            if(t_red <= red && t_blue <= blue && t_green <= green)
                ans += Integer.parseInt(key);
        }

        System.out.println(ans);

    }

}
