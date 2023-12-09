package Day3;



import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GearRatio {
    
    public static boolean checkSymbol(List<String> data, int row, int col) {
        if (col - 1 >= 0 && data.get(row).charAt(col - 1) != '.' && !Character.isDigit(data.get(row).charAt(col - 1)))
            return true;

        if (col + 1 < data.get(row).length() && data.get(row).charAt(col + 1) != '.' && !Character.isDigit(data.get(row).charAt(col + 1)))
            return true;

        if ((row - 1 >= 0 && col - 1 >= 0) && data.get(row - 1).charAt(col - 1) != '.' && !Character.isDigit(data.get(row - 1).charAt(col - 1)))
            return true;

        if ((row - 1 >= 0 && col >= 0) && data.get(row - 1).charAt(col) != '.' && !Character.isDigit(data.get(row - 1).charAt(col)))
            return true;

        if ((row - 1 >= 0 && col + 1 < data.get(row).length()) && data.get(row - 1).charAt(col + 1) != '.' && !Character.isDigit(data.get(row - 1).charAt(col + 1)))
            return true;

        if ((row + 1 < data.size() && col - 1 >= 0) && data.get(row + 1).charAt(col - 1) != '.' && !Character.isDigit(data.get(row + 1).charAt(col - 1)))
            return true;

        if ((row + 1 < data.size() && col >= 0) && data.get(row + 1).charAt(col) != '.' && !Character.isDigit(data.get(row + 1).charAt(col)))
            return true;

        if ((row + 1 < data.size() && col + 1 < data.get(row).length()) && data.get(row + 1).charAt(col + 1) != '.' && !Character.isDigit(data.get(row + 1).charAt(col + 1)))
            return true;

        return false;
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new FileInputStream("Day3/input.txt"));
            List<String> data = new ArrayList<>();
            int ans = 0;

            while (sc.hasNextLine()) {
                data.add(sc.nextLine());
            }

            for (int row = 0; row < data.size(); row++) {
                int num = 0;
                int numberFormed = 0;
                boolean foundSymbol = false;
                for (int col = 0; col < data.get(row).length(); col++) {
                    if (Character.isDigit(data.get(row).charAt(col))) {
                        num = (num * 10) + (data.get(row).charAt(col) - '0');
                        if (!foundSymbol)
                            foundSymbol = checkSymbol(data, row, col);

                        numberFormed = 1;
                    } else {
                        if (foundSymbol && numberFormed == 1)
                            ans += num;

                        numberFormed = 0;
                        num = 0;
                        foundSymbol = false;
                    }
                }

                if (foundSymbol && numberFormed == 1)
                    ans += num;
                
            }

            System.out.println(ans);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
