package auto.common.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import auto.common.service.ajaxService;
import auto.common.site.torrentqq;

/**
 * Handles requests for the application home page.
 */
@SuppressWarnings({"rawtypes","unchecked"})
@Controller
public class HomeController {

	@Autowired
	private ajaxService ajaxService;
 
	private final String PATH = "/DATA/watch/";
	@Autowired
	MappingJackson2JsonView jsonView;
	
	@ResponseBody
	@RequestMapping(value = "ajax", method = { RequestMethod.POST, RequestMethod.GET })
	public List<Object> ajax(@RequestBody LinkedHashMap<String, Object> params) throws Exception {
		String ProcName = params.get("ProcName").toString();
		String subProcName = params.get("subProcName").toString();
		List<Object> result = new ArrayList<Object>();

		if (ProcName.equals("setting")) {

			if (subProcName.equals("getProgramList")) {
				result = ajaxService.getProgramList();
			}
			if (subProcName.equals("getSiteList")) {
				result = ajaxService.getSiteList();

				Object a = result.get(0);
				System.out.println(a);
			}
		}
		
		if (ProcName.equals("search")) {
			ajaxService.tmpSearchDelete();
			if (subProcName.equals("getList")) {
				result = ajaxService.getSearchList();
			}
			else {
				List<Object> site_list = ajaxService.getSearchSite();
				for (Object site_object : site_list) {
					HashMap<String, String> site_map = (HashMap<String, String>) site_object;
					String url = site_map.get("SITE_URL");
					String name = site_map.get("SITE_NAME");
					if (name.equals("토렌트큐큐")) {
						ArrayList<LinkedHashMap<String, String>> item = torrentqq.findItem(url, subProcName);
						for (LinkedHashMap<String, String> param : item) {
							ajaxService.tmpSearchResult(param);
						}
						
					}
					
				}
			}
		}

		return result;

	}


	@ResponseBody
	@RequestMapping(value = "fileAjax", method = { RequestMethod.POST, RequestMethod.GET }, produces = "text/plain")
	public ModelAndView fileAjax(MultipartHttpServletRequest request) throws Exception {

		// 응답용 객체를 생성하고, jsonView 를 사용하도록 합니다.
		ModelAndView model = new ModelAndView();
		model.setView(jsonView);

		Iterator itr = request.getFileNames();

		if (itr.hasNext()) {
			List mpf = request.getFiles(itr.next().toString());
			// 임시 파일을 복사한다.
			for (int i = 0; i < mpf.size(); i++) {

				MultipartFile tmpFile = (MultipartFile) mpf.get(i);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				Date date = new Date();

				File file = new File(PATH + sdf.format(date) + ".torrent");
				tmpFile.transferTo(file);

			}

			// 업로드된 파일이 있을경우 응답입니다.
			JSONObject json = new JSONObject();
			json.put("code", "true");
			model.addObject("result", json);
			return model;

		} else {

			// 파일이 없을 경우 응답 입니다.
			JSONObject json = new JSONObject();
			json.put("code", "false");
			model.addObject("result", json);
			return model;

		}

	}
}
