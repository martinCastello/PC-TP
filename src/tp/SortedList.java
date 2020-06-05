package tp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortedList {
	
	private List<Integer> result = new ArrayList<Integer>();

	public synchronized void insert(Integer num) {
		result.add(num);
	}
	
	public List<Integer> getResult(){
		return result.stream().sorted().collect(Collectors.toList());
	}
}
