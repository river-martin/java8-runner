import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Java8Runner {

  /**
   * Read a file and return its content as a string.
   * 
   * @param path The path to the file.
   * @return The content of the file.
   */
  private static String readFile(String path) {
    File file = new File(path);
    String input = null;
    try {
      input = new String(Files.readAllBytes(file.toPath()));
    } catch (IOException e) {
      System.err.println("Error reading file: " + path);
      System.exit(1);
    }
    return input;
  }

  public static void main(String[] args) {
    if (args.length != 2) {
      System.err.println("Usage: Java8Runner <regex_file_path> <input_file_path>");
      System.exit(1);
    }
    String regex = readFile(args[0]);
    String input = readFile(args[1]);
    Matcher matcher = Pattern.compile(regex).matcher(input);
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