package com.ner.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.ner.entity.Person;
import com.ner.entity.Result;
import com.ner.service.nerService;

@Service
public class nerServiceImpl implements nerService{

	@Override
	public Person getPer(String text)  throws Exception{
		Person per = new Person();
		per.setRequest_id("1");
		Result result = new Result();
		List<String> location = new ArrayList<>();
		location.add("中国");
		//location.add("河南");
		result.setLocation(location);
		
		per.setResult(result);
		per.setStatus("OK");
		
		return per;
	}
	@Override
	public StringBuffer format(String s)  throws Exception{
		 int level = 0;
	        
	        StringBuffer jsonForMatStr = new StringBuffer();
	        for(int index=0;index<s.length();index++)
	        {	         
	            char c = s.charAt(index);
	            if (level > 0 && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
	                jsonForMatStr.append(getLevelStr(level));

	            }     
	            switch (c) {	       
	            case '{':
	                jsonForMatStr.append(c + "\n");
	                level++;
	                break;
	            case ',':
	                jsonForMatStr.append(c + "\n");            
	                break;	         
	            case '}':
	                jsonForMatStr.append("\n");
	                level--;
	                jsonForMatStr.append(getLevelStr(level));
	                jsonForMatStr.append(c);
	                break;
	            default:
	                jsonForMatStr.append(c);
	                break;
	            }
	        }	     
		return jsonForMatStr;
	}
	 public String getLevelStr(int level) {
	        StringBuffer levelStr = new StringBuffer();
	        for (int levelI = 0; levelI < level; levelI++) {
	            levelStr.append("  ");
	        }
	        return levelStr.toString();
	    }

}
