package com.mzw.model;

import java.util.List;

public class Grade {
    private List<Integer> ids ;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Grade(List<Integer> ids) {
		super();
		this.ids = ids;
	}

	public Grade() {
		super();
	}
     
}
