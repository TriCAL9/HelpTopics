package cube.mtga.scripts;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CubeCardList {
    public static void main(String[] args) throws IOException {
        final Scanner in = new Scanner(Path.of(System.getProperty("user.dir") + "\\message.txt")
            , StandardCharsets.UTF_8);
        Pattern p = Pattern.compile("(?:^)[aA-Zz]|(?<=[.!?]\\s)\\b[a-z]");
        while(in.hasNextLine())
            System.out.println(in.next(p));

    }
}
