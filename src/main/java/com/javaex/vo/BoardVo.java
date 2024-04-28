package com.javaex.vo;

public class BoardVo {
	
	private int no;
	private String writer;
	private String title;
	private String content;
	private String regDate;
	private int views;
	private int userNo;
	
	//생성자
	public BoardVo() {
		
	}

	public BoardVo(int no, String writer, String title, String content, String regDate, int views, int userNo) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.views = views;
		this.userNo = userNo;
	}

	//g/s
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", writer=" + writer + ", title=" + title + ", content=" + content + ", regDate="
				+ regDate + ", views=" + views + ", userNo=" + userNo + "]";
	}
	
	
	
	
	
	

	
	

}
