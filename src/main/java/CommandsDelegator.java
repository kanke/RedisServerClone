import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by kishaku on 14/07/2017.
 */
public class CommandsDelegator {

    private static Map<String, String> hashMap = new HashMap();

    public void delegate(String[] splitString) {
        String command = splitString[0].toUpperCase();

        if (command.equals(Command.GET)) {
            getCommand(splitString);

        } else if (command.equals(Command.SET)) {
            setCommand(splitString);

        } else if (command.equals(Command.EXPIRE)) {
            expireCommand(splitString);

        } else if (command.equals(Command.DEL)) {
            delCommand(splitString);

        } else if (command.equals(Command.EXIST)) {
            existCommand(splitString);
        }
    }

    private static void existCommand(String[] splitString) {
        String key = splitString[1];
        if (hashMap.containsKey(key)) {
            System.out.println("1 - It exists!");
        } else {
            System.out.println("2 - It doesn't exist!");
        }
    }

    private static void setCommand(String[] splitString) {

        String key = splitString[1];
        if (splitString.length < 3) {
            System.out.println("ERROR: not enough parameters");
            return;
        }
        String newValue = splitString[2];
        hashMap.put(key, newValue);
        System.out.println("OK");
    }

    private static void expireCommand(String[] splitString) {
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
        String key = splitString[1];
        hashMap.remove(key);
        System.out.println("OK");
    }

    private static void getCommand(String[] splitString) {

        String key = splitString[1];
        String value = hashMap.get(key);
        System.out.println(value);
    }

}
