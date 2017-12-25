import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.lang.Integer;

public class Day7 {

	public static String findRoot(HashMap<String, ArrayList> map) {
		Set<String> keys = map.keySet();
		ArrayList<String> result = new ArrayList<String>();
		result.addAll(keys);
		for (String key: keys) {
			for (String key1: keys) {
				if (map.get(key1).contains(key)) {
					result.remove(key);
				}	
			}
		}
		return result.get(0);
	}

	public static void main(String args[]) throws IOException {
		HashMap<String, ArrayList> map = new HashMap<String, ArrayList>();
		HashMap<String, Integer> mapWeight = new HashMap<String, Integer>();
		Files.lines(Paths.get("input.txt"), StandardCharsets.UTF_8).forEach(line -> {
			String[] node = line.split(" ");
			String name = node[0];
			String temp = node[1].replace("(", "");
			int weight = Integer.parseInt(temp.replace(")", ""));
			mapWeight.put(name, weight);
			ArrayList<String> childrenList = new ArrayList<String>();
			if (node.length > 2) {
				for (int i = 3; i < node.length; i++) {
					String children = node[i].replace(",", "");
					childrenList.add(children);
				}
			}
			map.put(name, childrenList);
		});
		String root = findRoot(map);
		System.out.println(root);
	}
}