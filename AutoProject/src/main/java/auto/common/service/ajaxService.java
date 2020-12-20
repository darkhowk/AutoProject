package auto.common.service;

import java.util.HashMap;
import java.util.List;

public interface ajaxService {

	List<Object>  getProgramList();

	int setProgramCreatedList(HashMap<String, String> map);

	int setProgramUpdatedList(HashMap<String, String> map);

	int setProgramDeletedList(HashMap<String, String> map);

	List<Object> getSiteList();

	int setSiteCreatedList(HashMap<String, String> map);

	int setSiteUpdatedList(HashMap<String, String> map);

	int setSiteDeletedList(HashMap<String, String> map);
	
	List<Object> getSearchList();
	
	List<Object> getSearchSite();
	
	int tmpSearchResult(HashMap<String, String> param);
	
	int tmpSearchDelete();
	
}
