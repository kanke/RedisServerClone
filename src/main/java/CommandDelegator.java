import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by kishaku on 14/07/2017.
 */


public class CommandDelegator {

    private static Map<String, String> hashMap = new HashMap();

    public void delegate(String[] splitString) {
        String command = splitString[0];

        if (command.equalsIgnoreCase(Command.GET.toString())) {
            getCommand(splitString);

        } else if (command.equalsIgnoreCase(Command.SET.toString())) {
            setCommand(splitString);

        } else if (command.equalsIgnoreCase(Command.EXPIRE.toString())) {
            expireCommand(splitString);

        } else if (command.equalsIgnoreCase(Command.DEL.toString())) {
            delCommand(splitString);

        } else if (command.equalsIgnoreCase(Command.EXIST.toString())) {
            existCommand(splitString);
        }
    }

    private static void existCommand(String[] splitString) {
        if (splitString.length < 2) {
            System.out.println("ERROR: not enough parameters");
            return;
        }
        String key = splitString[1];
        if (hashMap.containsKey(key)) {
            System.out.println("1 - It exists!");
        } else {
            System.out.println("2 - It doesn't exist!");
        }
    }

    private static void setCommand(String[] splitString) {
        if (splitString.length < 3) {
            System.out.println("ERROR: not enough parameters");
            return;
        }
        String key = splitString[1];
        String newValue = splitString[2];
        hashMap.put(key, newValue);
        System.out.println("OK");
    }

    private static void expireCommand(String[] splitString) {
        if (splitString.length < 3) {
            System.out.println("ERROR: not enough parameters");
            return;
        }
        final String key = splitString[1];
        long timer = Long.parseLong(splitString[2]);
        Timer newTask = new Timer();

        newTask.schedule(new TimerTask() {
            @Override
            public void run() {
                hashMap.remove(key);
            }
        }, timer * 1000);
    }

    private static void delCommand(String[] splitString) {
        if (splitString.length < 2) {
            System.out.println("ERROR: not enough parameters");
            return;
        }
        String key = splitString[1];
        hashMap.remove(key);
        System.out.println("OK");
    }

    private static void getCommand(String[] splitString) {
        if (splitString.length < 2) {
            System.out.println("ERROR: not enough parameters");
            return;
        }
        String key = splitString[1];
        String value = hashMap.get(key);
        System.out.println(value);
    }

}
