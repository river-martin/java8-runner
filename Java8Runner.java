import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Java8Runner {
  public static void main(String[] args) {
    if (args.length != 2) {
      System.err.println("Usage: Java8Runner <pattern> <input_file_name>");
      System.exit(1);
    }
    File file = new File(args[1]);
    String input = null;
    try {
      input = new String(Files.readAllBytes(file.toPath()));
    } catch (IOException e) {
      System.err.println("Error reading file: " + args[1]);
      System.exit(1);
    }
    Matcher matcher = Pattern.compile(args[0]).matcher(input);
    if (matcher.find()) {
      System.out.println("[match_1]\n");
      MatchResult result = matcher.toMatchResult();
      for (int i = 0; i <= result.groupCount(); i++) {
        System.out.printf("[match_1.group_%d]\n", i);
        String group = result.group(i);
        if (group == null) {
          System.out.println("# not captured");
          continue;
        } else {
          System.out.printf("span = [%d, %d]\n", result.start(i), result.end(i));
          System.out.printf("str = '''%s'''\n\n", result.group(i));
        }
      }
    } else {
      System.out.println("# no match");
    }

  }
}