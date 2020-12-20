package auto.common.site;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import auto.common.service.ajaxService;
import auto.common.util.commonUtil;

public class torrentqq {

	@Autowired
	private static ajaxService ajaxService;
	
	private static commonUtil util = new commonUtil();
	private String url = "";
	
	public torrentqq() {
		if (util.siteCheck(url)){
			System.out.println("aaaa");
		}
		else {
			System.out.println("bbb");
		}
	}

	public static ArrayList<LinkedHashMap<String, String>> findItem(String url, String item) throws Exception {
		
		Connection conn = Jsoup.connect(url+item);
		Document doc = conn.get();
		ArrayList<LinkedHashMap<String, String>> result = new ArrayList<LinkedHashMap<String, String>>();
		// 페이지 존재하면 마지막 페이지 세팅
		Elements els = doc.select(".pagination li a");
		int lastPage = 1;
		if (!els.isEmpty()) {
			Element el = els.last();
			lastPage = Integer.parseInt(el.attr("data-ci-pagination-page"));
		}
		
		url = url+item + "&page=";
		
		System.out.println(url);
		for (int i = 1 ; i <= lastPage ; i ++) {
			url = url + i;
			Connection tmpConn = Jsoup.connect(url);
			Document tmpDoc = tmpConn.get();
			Elements tmpEls = tmpDoc.select(".subject");
			
			for (Element tmpEl : tmpEls) {
				if (tmpEl.text().contains(item)) {
					LinkedHashMap<String, String> tmpData = new LinkedHashMap<String, String>();
					tmpData.put("NAME", tmpEl.text());
					tmpData.put("URL", tmpEl.attr("href"));
					tmpData.put("SITE", "0007");
					result.add(tmpData);
				}
			}
			
		}
		return result;

	}
	
	private static String getMagnet(String url) throws Exception {
		String result = "";

		Connection conn = Jsoup.connect(url);
		Document doc = conn.get();

		Elements els = doc.select(".table-bordered tbody tr td ul li");

		for (Element el : els) {
			if (el.text().contains("Info Hash:")) {
				String tmpHash = el.text();
				result = "magnet:?xt=urn:btih:" + tmpHash.replace("Info Hash: ", "");
			}
		}

		return result;
	}
}
