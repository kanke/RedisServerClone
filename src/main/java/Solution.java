/**
 * Created by kishaku on 12/07/2017.
 */

import java.util.*;

public class Solution {

    private static CommandDelegator commandDelegator = new CommandDelegator();

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitString = line.split("\\s+");
            commandDelegator.delegate(splitString);
        }
    }

}