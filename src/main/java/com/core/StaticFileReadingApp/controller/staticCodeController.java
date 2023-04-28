package com.core.StaticFileReadingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.core.StaticFileReadingApp.model.StateCodeObj;
import com.core.StaticFileReadingApp.staticService.StaticService;

@RestController
@RequestMapping("api/v1.0/staticFile")
public class staticCodeController {

	@Autowired
	private StaticService staticService;

	@GetMapping("/statecode")
	public ResponseEntity<?> validateStateCode(@RequestParam String code) {

		StateCodeObj obj = null;
         System.out.println("in controller");
		if (!StringUtils.isEmpty(code)) {
			System.out.println("calling service");
			obj = staticService.validateStateCode(code);
		}
		if (obj.getStateCode() == null) {
			return new ResponseEntity<String>("StateCode not found", HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<StateCodeObj>(obj, HttpStatus.OK);
	}

}
