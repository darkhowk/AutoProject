package auto.common.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;

@SuppressWarnings("rawtypes")
public class commonUtil {
	public ArrayList<HashMap<String, String>> createdList = new ArrayList<HashMap<String, String>>();
	public ArrayList<HashMap<String, String>> deletedList = new ArrayList<HashMap<String, String>>();
	public ArrayList<HashMap<String, String>> updatedList = new ArrayList<HashMap<String, String>>();
	public HashMap<Integer, List<String>> tmpMap = new HashMap<Integer, List<String>>();

	public void getList(HashMap<String, String> param) {
		createdList.clear();
		deletedList.clear();
		updatedList.clear();

		Set set = param.keySet();
		Iterator iter = set.iterator();

		HashMap<String, String> createdMap = new HashMap<String, String>();
		int createdStartindex = 0;

		HashMap<String, String> deletedMap = new HashMap<String, String>();
		int deletedStartindex = 0;

		HashMap<String, String> updatedMap = new HashMap<String, String>();
		int updatedStartindex = 0;

		while (iter.hasNext()) {
			String key = iter.next().toString();
			if (key.contains("createdRows")) {
				int row = 0;
				String colname = "";
				String value = param.get(key);

				int rowStartIndex = key.indexOf("[");
				int rowEndIndex = key.indexOf("]");

				int colNameStartIndex = key.lastIndexOf("[");
				int colNameEndIndex = key.lastIndexOf("]");

				row = Integer.parseInt(key.substring(rowStartIndex + 1, rowEndIndex));
				colname = key.substring(colNameStartIndex + 1, colNameEndIndex);

				if (row == createdStartindex) {
					createdMap.put(colname, value);
				} else {
					createdList.add(createdMap);
					createdMap = new HashMap<String, String>();
					createdMap.put(colname, value);
					createdStartindex++;
				}
			}
			if (key.contains("deletedRows")) {
				int row = 0;
				String colname = "";
				String value = param.get(key);

				int rowStartIndex = key.indexOf("[");
				int rowEndIndex = key.indexOf("]");

				int colNameStartIndex = key.lastIndexOf("[");
				int colNameEndIndex = key.lastIndexOf("]");

				row = Integer.parseInt(key.substring(rowStartIndex + 1, rowEndIndex));
				colname = key.substring(colNameStartIndex + 1, colNameEndIndex);

				if (row == deletedStartindex) {
					deletedMap.put(colname, value);
				} else {
					deletedList.add(deletedMap);
					deletedMap = new HashMap<String, String>();
					deletedMap.put(colname, value);
					deletedStartindex++;
				}
			}
			if (key.contains("updatedRows")) {
				int row = 0;
				String colname = "";
				String value = param.get(key);

				int rowStartIndex = key.indexOf("[");
				int rowEndIndex = key.indexOf("]");

				int colNameStartIndex = key.lastIndexOf("[");
				int colNameEndIndex = key.lastIndexOf("]");

				row = Integer.parseInt(key.substring(rowStartIndex + 1, rowEndIndex));
				colname = key.substring(colNameStartIndex + 1, colNameEndIndex);

				if (row == updatedStartindex) {
					updatedMap.put(colname, value);
				} else {
					updatedList.add(updatedMap);
					updatedMap = new HashMap<String, String>();
					updatedMap.put(colname, value);
					updatedStartindex++;
				}
			}
		}
		createdList.add(createdMap);
		updatedList.add(updatedMap);
		deletedList.add(deletedMap);
	}

	public void getDownFiles(File file) {
		getDownFiles(file, 0);
	}

	public void getDownFiles(File file, int level) {
		List<String> oriFile = new ArrayList<String>();
		if (tmpMap.containsKey(level)) {
			oriFile = (ArrayList<String>) tmpMap.get(level);
		}

		tmpMap.put(level, oriFile);
		for (File tmpFile : file.listFiles()) {
			if (tmpFile.isDirectory()) {
				getDownFiles(tmpFile, level + 1);
			}
			oriFile.add(file.getName());
		}

		Collections.sort(oriFile);
	}

	public Boolean siteCheck(String url) {

		Boolean result = false;
		int code = 0;
		try {
			code = Jsoup.connect(url).execute().statusCode();
		} catch (IOException e) {
			result = false;
		}

		if (code == 200) {
			result = true;
		} else {
			result = false;
		}

		return result;

	}
}
