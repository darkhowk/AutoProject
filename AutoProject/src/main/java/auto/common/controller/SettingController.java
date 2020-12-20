package auto.common.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import auto.common.service.ajaxService;
import auto.common.util.commonUtil;

@Controller
@RequestMapping(value = "setting")
public class SettingController {

	private static commonUtil util = new commonUtil();
	@Autowired
	private ajaxService ajaxService;


	@RequestMapping(value = "addSite", method = { RequestMethod.POST, RequestMethod.GET })
	public String site(Model model) {
		return "setting/site";
	}

	@ResponseBody
	@RequestMapping(value = "modifySite", method = { RequestMethod.POST, RequestMethod.GET })
	public HashMap<String, Object> modifySite(@RequestParam HashMap<String, String> params) throws Exception {

		HashMap<String, Object> result = new HashMap<String, Object>();

		util.getList(params);

		int count = 0;
		for (HashMap<String, String> map : util.createdList) {
			if (!map.isEmpty()) {
				count += setSiteCreatedList(map);
			}
		}

		for (HashMap<String, String> map : util.updatedList) {
			if (!map.isEmpty()) {
				count += setSiteUpdatedList(map);
			}
		}

		for (HashMap<String, String> map : util.deletedList) {
			if (!map.isEmpty()) {
				count += setSiteDeletedList(map);
			}
		}

		result.put("result", count);

		return result;
	}

	public int setSiteCreatedList(HashMap<String, String> map) {
		return ajaxService.setSiteCreatedList(map);
	}

	public int setSiteUpdatedList(HashMap<String, String> map) {
		return ajaxService.setSiteUpdatedList(map);
	}

	public int setSiteDeletedList(HashMap<String, String> map) {
		return ajaxService.setSiteDeletedList(map);
	}

	/*
	 * PROGRAM
	 * 
	 */
	@RequestMapping(value = "addProgram", method = { RequestMethod.POST, RequestMethod.GET })
	public String program(Model model) {
		return "setting/program";
	}

	@ResponseBody
	@RequestMapping(value = "getProgramList", method = { RequestMethod.POST, RequestMethod.GET })
	public List<Object> getProgramList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return ajaxService.getProgramList();

	}

	@ResponseBody
	@RequestMapping(value = "modifyProgram", method = { RequestMethod.POST, RequestMethod.GET })
	public HashMap<String, Object> modifyProgram(@RequestParam HashMap<String, String> params) throws Exception {

		HashMap<String, Object> result = new HashMap<String, Object>();

		util.getList(params);

		int count = 0;
		
		
		
		for (HashMap<String, String> map : util.createdList) {
			if (!map.isEmpty()) {
				count += setProgramCreatedList(map);
			}
		}

		for (HashMap<String, String> map : util.updatedList) {
			if (!map.isEmpty()) {
				count += setProgramUpdatedList(map);
			}
		}

		for (HashMap<String, String> map : util.deletedList) {
			if (!map.isEmpty()) {
				count += setProgramDeletedList(map);
			}
		}

		result.put("result", count);

		return result;
	}

	public int setProgramCreatedList(HashMap<String, String> map) {
		return ajaxService.setProgramCreatedList(map);
	}

	public int setProgramUpdatedList(HashMap<String, String> map) {
		return ajaxService.setProgramUpdatedList(map);
	}

	public int setProgramDeletedList(HashMap<String, String> map) {
		return ajaxService.setProgramDeletedList(map);
	}

	/*
	 *  FOLDER
	 * 
	 * */
	@RequestMapping(value = "folder", method = { RequestMethod.POST, RequestMethod.GET })
	public String folder(Model model) {
		File file = new File("Z://");
		util.getDownFiles(file);
		model.addAttribute("list", util.tmpMap);
		return "setting/folder";
	}
	@ResponseBody
	@RequestMapping(value = "getFolderList", method = { RequestMethod.POST, RequestMethod.GET })
	public List<JSONObject> getFolderList(@RequestParam HashMap<String, String> params) throws Exception {
		List<JSONObject> result = new ArrayList<JSONObject>();
			
		return result;
	} 
}
