package contacts.util;

import java.util.Scanner;

public class IO {
    private Scanner in;

    public IO() {
        in = new Scanner(System.in);
    }

    public String read() {
        return in.nextLine();
    }

    public String read(String prompt) {
        System.out.print(prompt + ": ");
        return in.nextLine();
    }

    public int readInt() {
        return Integer.parseInt(read());
    }

    public int readInt(String prompt) {
        return Integer.parseInt(read(prompt));
    }
}
