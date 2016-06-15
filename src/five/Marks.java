package five;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Marks {

	public static void main(String[] args) {
		Map<String, List<Double>> hm = new TreeMap<String, List<Double>>();
		HashMap meritMap = new HashMap();
		
		try {
			File myFile = new File("marks.txt");
			FileReader fileReader = new FileReader(myFile);
			BufferedReader reader = new BufferedReader(fileReader);
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				String[] splitLine = line.split(" ");
				String name = splitLine[0];
				Double score = Double.parseDouble(splitLine[1]);
				if(hm.containsKey(name)) {
					hm.get(name).add(score);
				} else {
					hm.put(name, new ArrayList<Double>());
					hm.get(name).add(score);
				}
			}
			List<Double> marks = new ArrayList<Double>();
			
			System.out.println("Alpha Order");
			for(Map.Entry<String, List<Double>> entry : hm.entrySet()) {
				String name = entry.getKey();
				marks = entry.getValue();
				double sum = 0;
				for(double i : marks) {
					sum += i;
				}
				double avg = sum/marks.size();
				System.out.println(name + " " + marks.size() + " " + avg );
				meritMap.put(name, avg);
			}
			System.out.println("");
			
			
			System.out.println("Merit Order");
			Map map = sortByValues(meritMap);
			Set mySet = map.entrySet();
			Iterator iterator2 = mySet.iterator();
			int i = 1;
			double sum = 0;
			while(iterator2.hasNext() && (i<mySet.size() + 1)) {
				Map.Entry<String, Double> me2 = (Map.Entry<String, Double>) iterator2.next();
				System.out.println(i + " " + me2.getKey() + " "  + me2.getValue());
				i++;
				sum += me2.getValue();
			}
			double avg = (sum/(i-1));
			DecimalFormat df = new DecimalFormat("#.#");
			System.out.println("Number of students: " + (i-1));
			System.out.println("Average student mark: " + df.format(avg));
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	public static HashMap sortByValues(HashMap map) {
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
	               return ((Comparable) ((Map.Entry) (o1)).getValue())
	                  .compareTo(((Map.Entry) (o2)).getValue());
			}				
		});
		Collections.reverse(list);
		HashMap sortedHashMap = new LinkedHashMap();
		for(Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}
}
