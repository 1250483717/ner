package com.ner.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ner.entity.*;
import com.ner.service.nerService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ner {
	@Resource(name = "nerService")
    private nerService ner;

	@RequestMapping(value="/a",method=RequestMethod.POST,produces = "application/json; charset=GBK")
	@ResponseBody
	public Object out(String text) throws Exception {
		Person p = ner.getPer(text);
		ObjectMapper o = new ObjectMapper();
		String s = "";
		s = o.writeValueAsString(p);
		
		return ner.format(s);
	}	    
}
