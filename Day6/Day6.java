import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Day6 {

	public static void main(String args[]) throws IOException {
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashSet<String> s = new HashSet<String>();
		Files.lines(Paths.get("input.txt"), StandardCharsets.UTF_8).forEach(line -> Pattern.compile("\t").splitAsStream(line).forEach(cell -> list.add(Integer.parseInt(cell))));
		String stringList = list.toString();
		boolean lookSol1 = true;
		boolean lookSol2 = false;
		s.add(stringList);
		int nbrCycles = 0;
		int nbrCyclesRepeat = 0;
		do {
			int max = Collections.max(list);
			int index = list.indexOf(max);
			list.set(index, 0);
			for (int i = 1; i <= max; i++) {
				System.out.println(list);
				index = (index + 1) % list.size();
				list.set(index, list.get(index) + 1);
			}
			stringList = list.toString();
			if (lookSol1) {
				nbrCycles++;
				if (!s.add(stringList)) {
					s.clear();
					s.add(stringList);
					lookSol1 = false;
					lookSol2 = true;
				}
			} else {
				nbrCyclesRepeat++;
				if (s.contains(stringList)) {
					lookSol2 = false;;
				}
			}
		} while (lookSol1 || lookSol2);
		System.out.println(nbrCycles);
		System.out.println(nbrCyclesRepeat);
	}
}