package com.core.StaticFileReadingApp;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> hash_map = new HashMap<String, Integer>();
		  
        // Mapping int values to string keys
        hash_map.put("Geeks", 10);
        hash_map.put("4", 15);
        hash_map.put("Geeks", 20);
        hash_map.put("Welcomes", 25);
        hash_map.put("You", 30);
        if(hash_map.containsKey("You"))
        {
//        	System.out.println("hello");
        }
        
        
        Pattern patt = Pattern.compile("\"([^\"]*)\"");

        String line = "\"530046\"";


          Matcher m = patt.matcher(line);

          while (m.find()) {
            System.out.println(m.group(1));
          }

	}

}
