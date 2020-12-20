package auto.common.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "utilDao")
public class utilDao {

	@Autowired
	private SqlSession session;

	public List<HashMap<String, String>> getSite(HashMap<String, String> param) {
		return session.selectList("UTIL.getSite", param);

	}

	public List<HashMap<String, String>> getSites() {
		return session.selectList("UTIL.getSites");

	}

}
