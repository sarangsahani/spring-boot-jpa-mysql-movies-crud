package com.sarang.moviewreviews.pojos;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sarang.moviewreviews.model.Movie;

@Component
public class StdMoviesRqstObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String executionId;
	private String userId;

	private List<Movie> dataObj;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getExecutionId() {
		return executionId;
	}

	public String getUserId() {
		return userId;
	}

	public List<Movie> getDataObj() {
		return dataObj;
	}

	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setDataObj(List<Movie> dataObj) {
		this.dataObj = dataObj;
	}

	@Override
	public String toString() {
		return "StandardRequestObj [executionId=" + executionId + ", userId=" + userId + ", dataObj=" + dataObj + "]";
	}

}
