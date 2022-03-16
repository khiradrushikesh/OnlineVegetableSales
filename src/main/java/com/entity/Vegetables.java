package com.entity;


import java.util.function.Supplier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.*;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name="VEGETABLES")

public class Vegetables {
	
    @Id
	@NotNull
	private int vid;
	@NotBlank
	@Size(min=2,message="Category name should have atleast 2 characters")
	private String vcategory;
	@NotBlank
	@Size(min=2,message="Vegetable name should have atleast 2 characters")
	private String vname;
	
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVcategory() {
		return vcategory;
	}
	public void setVcategory(String vcategory) {
		this.vcategory = vcategory;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	
	@Override
	public String toString() {
		return "Vegetables [vid=" + vid + ", vcategory=" + vcategory + ", vname=" + vname + "]";
	}

}
