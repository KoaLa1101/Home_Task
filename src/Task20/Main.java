package Task20;

import java.util.Scanner;

public class Main {
    static Download dt;

    public static void command(String com) {
        String[] param = com.split(" ", 2);

        if (param.length > 1) {
            if (param[0].toLowerCase().equals("download")) {
                if (dt == null || dt.getState().equals(Thread.State.TERMINATED)) {
                    dt = new Download(param[1].trim());
                    dt.start();
                }
            }
        } else if (param.length > 0) {
            if (param[0].toLowerCase().equals("status")) {
                if (dt == null) System.out.println("Now nothing is downloading");
                else dt.partOfDownloading();
            }
            if (param[0].toLowerCase().equals("stop")) {
                if (dt != null) {
                    dt.interrupt();
                    System.out.println("Download stopped");
                } else System.out.println("You cannot stop what is not");
            }
            if(param[0].toLowerCase().equals("quit")){
                return;
            }

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;
        while(true){
            str = in.nextLine();
            command(str);
        }

    }
}
