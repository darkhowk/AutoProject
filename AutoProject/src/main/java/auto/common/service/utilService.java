package auto.common.service;

import java.util.HashMap;
import java.util.List;

public interface utilService {
	List<HashMap<String, String>> getSite(HashMap<String, String> param);

	List<HashMap<String, String>> getSites();
	
}
