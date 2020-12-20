package auto.common.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class logUtil {

	public static void HashMapLog(Map map) {
		Set set = map.keySet();
		Iterator iter = set.iterator();

		while (iter.hasNext()) {
			String key = iter.next().toString();
			String value = map.get(key).toString();
			System.out.println("key :: " + key + " || value :: " + value);
		}

	}

}
