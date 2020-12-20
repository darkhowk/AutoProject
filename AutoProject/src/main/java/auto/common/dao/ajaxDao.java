package auto.common.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "ajaxDao")
public class ajaxDao {

	@Autowired
	private SqlSession session;
	
	public List<Object> getProgramList() {
		return session.selectList("AJAX.getProgramList");
	}

	public int setProgramCreatedList(HashMap<String, String> map) {
		return session.insert("AJAX.setProgramCreatedList", map);
	}

	public int setProgramUpdatedList(HashMap<String, String> map) {
		return session.update("AJAX.setProgramUpdatedList", map);
	}

	public int setProgramDeletedList(HashMap<String, String> map) {
		return session.delete("AJAX.setProgramDeletedList", map);
	}

	public List<Object> getSiteList() {
		return session.selectList("AJAX.getSiteList");
	}
	
	public int setSiteCreatedList(HashMap<String, String> map) {
		return session.insert("AJAX.setSiteCreatedList", map);
	}

	public int setSiteUpdatedList(HashMap<String, String> map) {
		return session.update("AJAX.setSiteUpdatedList", map);
	}

	public int setSiteDeletedList(HashMap<String, String> map) {
		return session.delete("AJAX.setSiteDeletedList", map);
	}

	public List<Object> getSearchList() {
		return session.selectList("AJAX.getSearchList");
	}
	public List<Object> getSearchSite() {
		return session.selectList("AJAX.getSearchSite");
	}

	public int tmpSearchResult(HashMap<String, String> param) {
		return session.insert("AJAX.tmpSearchResult", param);
	}

	public int tmpSearchDelete() {
		return session.delete("AJAX.tmpSearchDelete");
	}
}
