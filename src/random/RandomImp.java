package random;

import java.util.Collections;
import java.util.List;

public class RandomImp implements Random{
	
	@Override
	public List<String> SortTeam(List<String> list) {
		Collections.shuffle(list);
		return list;
	}

	@Override
	public String SelectMap(List<String> list) {
		int length = list.size();
		int number =(int)(Math.random()*length);
		return list.get(number);
	}

}
