package solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcceptableNumber {
    private List<String> numbers = new ArrayList<String>();
    private final String numbersRegex = "^\\(\\d{3}\\)\\s\\d{3}-\\d{4}$|^\\d{3}-\\d{3}-\\d{4}$";
    private Pattern pattern = Pattern.compile(numbersRegex);

    public List<String> getNumbers() {
        return numbers;
    }

    public void numbersReader(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    numbers.add(matcher.group());
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("A file with this name does not exist in the path " + filePath);
        }
    }
}
