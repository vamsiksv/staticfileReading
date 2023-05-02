package com.core.StaticFileReadingApp.staticService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.core.StaticFileReadingApp.model.StateCodeObj;

@Service
public class StaticServiceImpl implements StaticService {

	private HashMap<String,String> stateCodeMap ;
	@Override
	public StateCodeObj validateStateCode(String code) {

		StateCodeObj obj =new StateCodeObj(null, null);
		if(stateCodeMap == null)
		{
			System.out.println("loading staticfile");
			stateCodeMap = loadStaticFile();
			for(Map.Entry<String, String> entry: stateCodeMap.entrySet() )
			{
				System.out.println( entry.getKey() + ":"+ entry.getValue());
			}
			System.out.println(code);
		}
		
		if(stateCodeMap.containsKey(code)) {
			System.out.println("inside code");
			obj.setStateCode(code);
			obj.setIndicator("Y");
		}
		System.out.println(obj);
		return obj;
	}

	public HashMap<String, String> loadStaticFile() {
		
		System.out.println("loading");
		HashMap<String, String> map = new HashMap<String, String>();
		BufferedReader br = null;

		try {

			// create file object
			File file = new File("/Users/vamsikopparthi/Documents/workspace-spring-tool-suite-4-4.13.1.RELEASE/StaticFileReadingApp/src/main/resources/static/staticFIle");

			// create BufferedReader object from the File
			br = new BufferedReader(new FileReader(file));

			Pattern patt = Pattern.compile("\"([^\"]*)\"");
			String line = null;

			// read file line by line
			while ((line = br.readLine()) != null) {

				// split the line by :
				String[] parts = line.split(":");
//				for(String s:parts)
//				{
//					System.out.println(s);
//				}
				// first part is name, second is number
//				System.out.println(line);
				Matcher m = patt.matcher(parts[0].trim());
				Matcher s = patt.matcher(parts[1].trim());


				while (m.find() && s.find()) {
					map.put(m.group(1), s.group(1));};
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			//  closing the BufferedReader
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					
				}
				;
			}
		}

		return map;
	}
	
	public StateCodeObj getPostalCd(List<StateCodeObj> stateCodeObj)
	{
		for(StateCodeObj s:stateCodeObj)
		{
			if(s.getIndicator() == "Y")
			{
				return s;
			}
		}
		return null;
		
	}

}
