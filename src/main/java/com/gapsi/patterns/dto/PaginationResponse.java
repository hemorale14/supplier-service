package com.gapsi.patterns.dto;

import java.util.List;

public class PaginationResponse<T> {
	
	private Metadata meta;
	  private List<T> data;

	  public PaginationResponse(Metadata meta, List<T> data) {
	    this.meta = meta;
	    this.data = data;
	  }

	  public Metadata getMeta() {
	    return meta;
	  }

	  public List<T> getData() {
	    return data;
	  }
}
