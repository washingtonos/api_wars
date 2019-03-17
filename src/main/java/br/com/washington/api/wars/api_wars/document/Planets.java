package br.com.washington.api.wars.api_wars.document;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Planets {
	private long count;
	private String next;
	private Object previous;
	private List<Result> results;

	@JsonProperty("count")
	public long getCount() {
		return count;
	}

	@JsonProperty("count")
	public void setCount(long value) {
		this.count = value;
	}

	@JsonProperty("next")
	public String getNext() {
		return next;
	}

	@JsonProperty("next")
	public void setNext(String value) {
		this.next = value;
	}

	@JsonProperty("previous")
	public Object getPrevious() {
		return previous;
	}

	@JsonProperty("previous")
	public void setPrevious(Object value) {
		this.previous = value;
	}

	@JsonProperty("results")
	public List<Result> getResults() {
		return results;
	}

	@JsonProperty("results")
	public void setResults(List<Result> value) {
		this.results = value;
	}

	@Override
	public String toString() {
		return "Planets [count=" + count + ", next=" + next + ", previous=" + previous + ", results=" + results + "]";
	}

}
