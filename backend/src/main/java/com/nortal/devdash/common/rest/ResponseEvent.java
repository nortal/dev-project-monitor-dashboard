package com.nortal.devdash.common.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Alrik Peets
 */
public class ResponseEvent<T> {

    private T entity;
    private boolean entityFound;
    private HttpStatus httpStatus = HttpStatus.OK;

    public ResponseEvent() {
    }

    public ResponseEvent(T entity) {
        this.entity = entity;
        this.entityFound = entity != null;
    }

    public ResponseEvent<T> withStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public ResponseEvent<T> withEntity(T entity) {
        this.entity = entity;
        this.entityFound = entity != null;
        return this;
    }

    public HttpHeaders getHeaders() {
        return new HttpHeaders();
    }

    public T getEntity() {
        return entity;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public boolean isEntityFound() {
        return entityFound;
    }

    /**
     * Constructs {@link ResponseEntity}.
     * 
     * @return
     */
    public ResponseEntity<T> response() {
        return new ResponseEntity<>(getEntity(), getHeaders(), httpStatus);
    }

    /**
     * Constructs {@link ResponseEntity}. If entity is null {@link HttpStatus.NOT_FOUND} is used as response status code.
     * 
     * @return
     */
    public ResponseEntity<T> requiredResponse() {
        if (entityFound) {
            return response();
        }
        return new ResponseEntity<>(getEntity(), getHeaders(), HttpStatus.NOT_FOUND);
    }

    /**
     * Constructs {@link ResponseEntity}. If entity is null specified httpStatys is used as response status code.
     * 
     * @return
     */
    public ResponseEntity<T> requiredResponse(HttpStatus httpStatus) {
        if (entityFound) {
            return response();
        }
        return new ResponseEntity<>(getEntity(), getHeaders(), httpStatus);
    }

    // =========== Static initializers for common response scenarios ==========

    /**
     * Common response, without conversion
     * 
     * @param entity
     */
    public static <T> ResponseEvent<T> create(T entity) {
        return new ResponseEvent<T>(entity);
    }

    public static ResponseEvent<Void> noContent(HttpStatus httpStatus) {
        return new ResponseEvent<Void>(null).withStatus(httpStatus);
    }

    /**
     * NOT_FOUND response. HTTP status code 404
     */
    public static <T> ResponseEvent<T> notFound() {
        return new ResponseEvent<T>(null).withStatus(HttpStatus.NOT_FOUND);
    }

    public static <T> ResponseEvent<T> badRequest() {
        return new ResponseEvent<T>(null).withStatus(HttpStatus.BAD_REQUEST);
    }

    /**
     * Invalid input response. HTTP status code 422. Used when input object fails validation
     */
    public static <T> ResponseEvent<T> invalid() {
        return new ResponseEvent<T>(null).withStatus(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * NOT_ALLOWED response. HTTP status code 405. Used when authenticated user has required privileges, but for some reason is still not allowed to use
     * requested resource
     */
    public static <T> ResponseEvent<T> notAllowed() {
        return new ResponseEvent<T>(null).withStatus(HttpStatus.METHOD_NOT_ALLOWED);
    }

    public static <T> ResponseEvent<T> forbidden() {
        return new ResponseEvent<T>(null).withStatus(HttpStatus.FORBIDDEN);
    }

}
