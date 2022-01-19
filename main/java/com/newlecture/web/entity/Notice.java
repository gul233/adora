package com.newlecture.web.entity;

import java.util.Date;

public class Notice {
	
	private int id;
	private String title;
	private String writerid;
	private String content;
	private Date regdate;
	private String hit;
	private String files;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}
	
	public Notice(int id, String title, String writerid, String content, Date regdate, String hit, String files) {

		this.id = id;
		this.title = title;
		this.writerid = writerid;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.files = files;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriterid() {
		return writerid;
	}

	public void setWriterid(String writerid) {
		this.writerid = writerid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", writerid=" + writerid + ", content=" + content
				+ ", regdate=" + regdate + ", hit=" + hit + ", files=" + files + "]";
	}
	
}
