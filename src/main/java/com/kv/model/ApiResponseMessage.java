package com.kv.model;

@javax.xml.bind.annotation.XmlRootElement
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-03-28T13:06:53.817Z")
public class ApiResponseMessage {

	ApiError error;
	Object data;
	Object meta;
	Object links;

	public ApiResponseMessage() {
	}

	/**
	 * 
	 * @param code
	 * @param message
	 * @param detail
	 */
	public ApiResponseMessage(Object data) {
		this(data, null);
	}
	
	/**
	 * 
	 * @param code
	 * @param message
	 * @param detail
	 */
	public ApiResponseMessage(ApiError error) {
		this(null, error);
	}


	public ApiResponseMessage(Object data, ApiError error) {
		this(data, error, null);
	}

	public ApiResponseMessage(Object data, ApiError error, Object meta) {
		this(data, error, meta, null);
	}

	public ApiResponseMessage(Object data, ApiError error, Object meta, Object links) {
		this.data = data;
		this.error = error;
		this.meta = meta;
		this.links = links;
	}

	public Object getError() {
		return error;
	}

	public ApiResponseMessage error(ApiError error) {
		this.error = error;
		return this;
	}

	public Object getData() {
		return data;
	}

	public ApiResponseMessage data(Object data) {
		this.data = data;
		return this;

	}

	public Object getMeta() {
		return meta;
	}

	public ApiResponseMessage meta(Object meta) {
		this.meta = meta;
		return this;

	}

	public Object getLinks() {
		return links;
	}

	public ApiResponseMessage links(Object links) {
		this.links = links;
		return this;

	}

}
