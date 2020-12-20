package auto.common.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auto.common.dao.utilDao;
import auto.common.service.utilService;

@Service
public class utilServiceImpl implements utilService{

	@Autowired
	private utilDao utilDao;

	@Override
	public List<HashMap<String, String>> getSite(HashMap<String, String> param) {
		return utilDao.getSite(param);
	}

	@Override
	public List<HashMap<String, String>> getSites() {
		return utilDao.getSites();
	}

}
