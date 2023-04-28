package com.core.StaticFileReadingApp.staticService;

import com.core.StaticFileReadingApp.model.StateCodeObj;

public interface StaticService {
	
	public StateCodeObj validateStateCode(String code);

}
