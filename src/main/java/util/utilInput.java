package util;

import java.util.Scanner;

public class utilInput {


    Scanner scanner = new Scanner(System.in);


    public Integer getInt(){
        Integer dataInt = scanner.nextInt();
        return dataInt;
    }
    public String getString(){
        String dataString = scanner.nextLine();
        return dataString;
    }

}
