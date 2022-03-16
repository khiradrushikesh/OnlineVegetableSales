package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;

	@NotNull
	@NotEmpty(message = "Rate Name is Required")
	@Size(min = 6, max = 9)
	private String vegName;

	@NotNull
	@NotEmpty(message = "Rate Name is Required")
	@Size(min = 6, max = 9)
	private String rate;

	@NotNull
	@NotEmpty(message = "comment is Required")
	private String comment;


	@OneToOne
    @JoinColumn(name = "oid")
    private Orders order;
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getVegName() {
		return vegName;
	}

	public void setVegName(String vegName) {
		this.vegName = vegName;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Comment{" + "cid=" + cid + ", vegName='" + vegName + '\'' + ", rate='" + rate + '\'' + ", comment='"
				+ comment + '\'' + '}';
	}
}
