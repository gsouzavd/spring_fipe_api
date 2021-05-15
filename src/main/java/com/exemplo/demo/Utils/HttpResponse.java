package com.exemplo.demo.Utils;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude( Include.NON_NULL )
@JsonIgnoreProperties( ignoreUnknown = true )
public class HttpResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8668176334547945413L;

	private Integer status;

	private Object object;

	private List< ? > objects;

	public HttpResponse( HttpStatus status ) {
		this.status = status.value();
	}

	public HttpResponse( HttpStatus status, Object object ) {
		this.status = status.value();
		this.object = object;
	}

	public HttpResponse( HttpStatus status, List< ? > objects ) {
		this.status = status.value();
		this.objects = objects;
	}
	
	public static HttpResponse insertSuccess() {
		return new HttpResponse( HttpStatus.OK, "Registro(s) inserido(s) com sucesso!" );
	}
	
	public static HttpResponse updateSuccess() {
		return new HttpResponse( HttpStatus.OK, "Registro(s) atualizado(s) com sucesso!" );
	}
	
	public static HttpResponse insertError() {
		return new HttpResponse( HttpStatus.INTERNAL_SERVER_ERROR, "Registro(s) inserido(s) com sucesso!" );
	}
	
	public static HttpResponse updateError() {
		return new HttpResponse( HttpStatus.INTERNAL_SERVER_ERROR, "Registro(s) atualizado(s) com sucesso!" );
	}

	public static HttpResponse responseSuccess() {
		return new HttpResponse( HttpStatus.ACCEPTED );
	}

	public static HttpResponse responseError() {
		return new HttpResponse( HttpStatus.BAD_REQUEST );
	}

	public static HttpResponse responseSuccess( Object object ) {
		return new HttpResponse( HttpStatus.ACCEPTED, object );
	}

	public static HttpResponse responseWarning( Object object ) {
		return new HttpResponse( HttpStatus.CONFLICT, object );
	}

	public static HttpResponse response( Object object ) {
		return new HttpResponse( HttpStatus.OK, object );
	}

	public static HttpResponse response( List< ? > objects ) {
		return new HttpResponse( HttpStatus.OK, objects );
	}

	public Integer getStatus() {
		return status;
	}

	public Object getObject() {
		return object;
	}

	public List< ? > getObjects() {
		return objects;
	}
}