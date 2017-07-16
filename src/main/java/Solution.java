/**
 * Created by kishaku on 12/07/2017.
 */

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {

        Injector injector = Guice.createInjector();
        CommandDelegator commandDelegator = injector.getInstance(CommandDelegator.class);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitString = line.split("\\s+");
            commandDelegator.delegate(splitString);
        }
    }

}