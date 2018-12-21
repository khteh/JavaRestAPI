package com.restapi.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	public ResourceNotFoundException(String name, String field, Object value) {
		super(String.format("%s not found with %s: '%s'", name, field, value));
		resourceName = name;
		fieldName = field;
		fieldValue = value;
	}
	public String getResourceName() { return resourceName; }
	public String getFieldName() { return fieldName; }
	public Object getFieldValue() { return fieldValue; }
}