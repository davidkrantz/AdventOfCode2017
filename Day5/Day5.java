import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class Day5 {

	public static void main(String args[]) throws IOException {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Files.lines(Paths.get("input.txt"), StandardCharsets.UTF_8).forEach(line -> list.add(Integer.parseInt(line)));
		int index = 0;
		int nbrSteps = 0;
		while (index < list.size()) {
			if (list.get(index) >= 3) {
				list.set(index, list.get(index) - 1);
				index += list.get(index) + 1;
			} else {
				list.set(index, list.get(index) + 1);
				index += list.get(index) - 1;
			}
			nbrSteps++;
		}
		System.out.println(nbrSteps);
	}
}