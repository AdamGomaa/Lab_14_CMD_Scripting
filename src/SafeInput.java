import java.util.Scanner;

public class SafeInput {

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.println("\n" + prompt + ":");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        do {
            System.out.print("\n" + prompt + ":");
            if (pipe.hasNextInt()) {
                int toReturn = pipe.nextInt();
                if (pipe.hasNextLine())
                    pipe.nextLine();
                return toReturn;
            }
        } while (true);
    }

    public static double getDouble(Scanner pipe, String prompt) {
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                double toReturn = pipe.nextDouble();
                if (pipe.hasNextLine())
                    pipe.nextLine();
                return toReturn;
            }
        } while (true);
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        do {
            System.out.print("\n" + prompt + ":");
            if (pipe.hasNextInt()) {
                int toReturn = pipe.nextInt();
                if (pipe.hasNextLine())
                    pipe.nextLine();
                if (toReturn >= low && toReturn <= high)
                    return toReturn;
            }
        } while (true);
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "] " + ": ");
            if (pipe.hasNextDouble()) {
                double toReturn = pipe.nextDouble();
                if (pipe.hasNextLine())
                    pipe.nextLine();
                if (toReturn >= low && toReturn <= high)
                    return toReturn;
            }
        } while (true);
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String reString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextLine())
                reString = pipe.nextLine();
        } while (reString == null || (reString.trim().length() == 1
                && !(reString.trim().equalsIgnoreCase("y") || reString.trim().equalsIgnoreCase("n"))));
        if (reString.trim().equalsIgnoreCase("y"))
            return true;
        else
            return false;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regExPattern)
    {
        String value = "";
        boolean gotAValue = false;
        do {
            System.out.print(prompt + ": ");
            value = pipe.nextLine();
            if(value.matches(regExPattern))
            {
                gotAValue = true;
            }
            else
            {
                System.out.println("\nInvalid input: " + value);
            }
        }while(!gotAValue);

        return value;
    }


    public static void prettyHeader(String msg) {
        int starCounter = 60;
        int msgPadding = (starCounter - msg.length() - 5) / 2;
        String stars = "*".repeat(starCounter);
        String paddedMessage = "*".repeat(3) + " ".repeat(msgPadding) + msg + " ".repeat(msgPadding) + "*".repeat(3);

        System.out.println(stars);
        System.out.println(paddedMessage);
        System.out.println(stars);


    }
}