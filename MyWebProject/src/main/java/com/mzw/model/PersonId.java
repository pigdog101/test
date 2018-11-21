package com.mzw.model;

import java.io.Serializable;

public class PersonId implements Serializable{
	    private int cardid;
	    private String perinfo;
		public int getCardid() {
			return cardid;
		}
		public void setCardid(int cardid) {
			this.cardid = cardid;
		}
		public String getPerinfo() {
			return perinfo;
		}
		public void setPerinfo(String perinfo) {
			this.perinfo = perinfo;
		}
}
