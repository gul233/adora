package com.newlecture.web.entity;

import java.util.Date;

public class NoticeView extends Notice {
	
	private int cmtCount;
	
	
	public int getCmtCount() {
		return cmtCount;
	}

	
	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}

	
	public NoticeView(int id, String title, String writerid, Date regdate, String hit, String files, int cmtCount) {
		
		super(id, title, writerid, "", regdate, hit, files);
		this.cmtCount = cmtCount;
	}
	
}
