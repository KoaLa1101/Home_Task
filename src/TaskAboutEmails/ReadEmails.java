package TaskAboutEmails;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadEmails {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(Pattern.matches("^(([a-zA-Zà-ÿÀ-ß]+)|([a-zA-Zà-ÿÀ-ß]+[a-zA-Zà-ÿÀ-ß]+)|([a-zA-Zà-ÿÀ-ß]+[0-9]+)|" + "([0-9]+[a-zA-Zà-ÿÀ-ß]+)|([a-zA-Z0-9à-ÿÀ-ß][à-ÿÀ-ßa-zA-Z0-9-_]{1,101}[à-ÿÀ-ßa-zA-Z0-9]))\\.([à-ÿÀ-ßa-zA-Z]{2,6}|" + "[à-ÿÀ-ßa-zA-Z0-9-]{2,31}\\.[à-ÿÀ-ßa-zA-Z]{2,3})$", in.next()));
        // For domain recognition


        String str = in.next();
        Pattern emailEnd = Pattern.compile("(?:@)((?:[a-z0-9](?:[a-z0-9-]*[a-z0-9]?)\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        // I couldn't write my lambda-expression for this, so I used this
        Matcher matcher = emailEnd.matcher(str);
        if (matcher.find()) {
            String gg = matcher.group();
            String[] ggSplit = gg.split("\\.");
            System.out.println(ggSplit[0].substring(1) + " - " + ggSplit[ggSplit.length - 1]);
        }
        // The task of the upper and lower...
    }
}
