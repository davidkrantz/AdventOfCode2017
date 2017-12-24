import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Pattern;
import java.util.Arrays;

public class Day4 {
	private static int nbrValid = 0;
	private static boolean isValid = true;

	public static void nbrValid(String line) {
		Set s = new HashSet<String>();
		isValid = true;
		Pattern.compile(" ").splitAsStream(line).forEach(word -> {
			char[] chars = word.toCharArray();
        	Arrays.sort(chars);
        	String sorted = new String(chars);
			if (!s.add(sorted)) {
				isValid = false;
			} 
		});
		if (isValid) {
			nbrValid++;
		}
	}

	public static void main(String args[]) throws IOException {
		Files.lines(Paths.get("input.txt"), StandardCharsets.UTF_8).forEach(line -> nbrValid(line));
		System.out.println(nbrValid);
	}
}