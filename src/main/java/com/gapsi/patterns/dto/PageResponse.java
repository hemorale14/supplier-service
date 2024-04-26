package com.gapsi.patterns.dto;

import java.io.Serializable;
import lombok.Getter;

@Getter
public class PageResponse implements Serializable {

  private static final long serialVersionUID = -8132362691798571368L;
  private int currentPage;
  private int pageSize;
  private long from;
  private long to;
  private int total;
  private boolean lastPage;

  public PageResponse(int currentPage, int pageSize, long from, long to, int total,
      boolean lastPage) {
    this.currentPage = currentPage;
    this.pageSize = pageSize;
    this.from = from;
    this.to = to;
    this.total = total;
    this.lastPage = lastPage;
  }

}
