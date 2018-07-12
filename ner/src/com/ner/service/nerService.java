package com.ner.service;

import com.ner.entity.Person;

public interface nerService {
	public Person getPer(String text) throws Exception;

	public StringBuffer format(String s) throws Exception;
		
}
