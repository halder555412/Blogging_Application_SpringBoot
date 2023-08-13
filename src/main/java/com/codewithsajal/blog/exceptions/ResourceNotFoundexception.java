package com.codewithsajal.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundexception extends RuntimeException{
	
	String resourcename;
	String fieldName;
	long fieldvalue;
	
	public ResourceNotFoundexception(String resourcename, String fieldName, long fieldvalue) {
		super(String.format("%s not found with %s : %s", resourcename,fieldName,fieldvalue));
		this.resourcename = resourcename;
		this.fieldName = fieldName;
		this.fieldvalue = fieldvalue;
	}

}
