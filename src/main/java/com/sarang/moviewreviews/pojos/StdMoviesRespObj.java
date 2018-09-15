package com.sarang.moviewreviews.pojos;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.sarang.moviewreviews.model.Movie;

@Component
public class StdMoviesRespObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String executionId;
	private String userId;
	private List<Movie> resultsObj;
	private HttpStatus status;
	private Exception MovieReviewsAppException;
	private String message;

	public String getExecutionId() {
		return executionId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Movie> getResultsObj() {
		return resultsObj;
	}

	public void setResultsObj(List<Movie> object) {
		this.resultsObj = object;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Exception getMovieReviewsAppException() {
		return MovieReviewsAppException;
	}

	public void setMovieReviewsAppException(Exception movieReviewsAppException) {
		MovieReviewsAppException = movieReviewsAppException;
	}

	@Override
	public String toString() {
		return "StandardResponseObj [executionId=" + executionId + ", userId=" + userId + ", resultsObj=" + resultsObj
				+ ", status=" + status + ", MovieReviewsAppException=" + MovieReviewsAppException + ", message="
				+ message + "]";
	}

}
