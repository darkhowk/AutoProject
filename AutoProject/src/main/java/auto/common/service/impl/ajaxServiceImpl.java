package auto.common.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auto.common.dao.ajaxDao;
import auto.common.service.ajaxService;

@Service
public class ajaxServiceImpl implements ajaxService{

	@Autowired
	private ajaxDao AjaxDao;
	
	@Override
	public List<Object> getProgramList() {
		return AjaxDao.getProgramList();
	}

	@Override
	public int setProgramCreatedList(HashMap<String, String> map) {
		return AjaxDao.setProgramCreatedList(map);
	}

	@Override
	public int setProgramUpdatedList(HashMap<String, String> map) {
		return AjaxDao.setProgramUpdatedList(map);
	}

	@Override
	public int setProgramDeletedList(HashMap<String, String> map) {
		return AjaxDao.setProgramDeletedList(map);
	}

	@Override
	public List<Object> getSiteList() {
		return AjaxDao.getSiteList();
	}

	@Override
	public int setSiteCreatedList(HashMap<String, String> map) {
		return AjaxDao.setSiteCreatedList(map);
	}

	@Override
	public int setSiteUpdatedList(HashMap<String, String> map) {
		return AjaxDao.setSiteUpdatedList(map);
	}

	@Override
	public int setSiteDeletedList(HashMap<String, String> map) {
		return AjaxDao.setSiteDeletedList(map);
	}

	@Override
	public List<Object> getSearchList() {
		return AjaxDao.getSearchList();
	}

	@Override
	public List<Object> getSearchSite() {
		return AjaxDao.getSearchSite();
	}

	@Override
	public int tmpSearchResult(HashMap<String, String> param) {
		return AjaxDao.tmpSearchResult(param);
	}

	@Override
	public int tmpSearchDelete() {
		return AjaxDao.tmpSearchDelete();
	}
}
