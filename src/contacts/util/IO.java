package contacts.util;

import java.util.Scanner;

public class IO {
    private final Scanner in;

    public IO() {
        in = new Scanner(System.in);
    }

    public String read(String prompt) {
        System.out.print(prompt + ": ");
        return in.nextLine();
    }
}
