package com.gapsi.patterns.dto;

import java.io.Serializable;

public class Metadata implements Serializable {

	  private static final long serialVersionUID = -7130394627311696504L;

	  private PageResponse page;

	  public Metadata(final PageResponse page) {
	    this.page = page;
	  }

	  public PageResponse getPage() {
	    return this.page;
	  }
	}
