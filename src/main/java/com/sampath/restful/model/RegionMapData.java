package com.sampath.restful.model;

import java.io.Serializable;

/**
 * st2 : { id : 2, name : "AL", shortname : "AL", link : "", comment : "", image
 * : "", color_map : "#7798BA", color_map_over : "#bf92b4" }
 * 
 * @author SAMPATH
 *
 */
public class RegionMapData implements Serializable{

	private static final long serialVersionUID = 24353346575765756L;
	
	private Long id;
	private String name;
	private String shortname;
	private String link;
	private String comment;
	private String image;
	private String color_map;
	private String color_map_over;
	
	public RegionMapData(Long id, String name, String shortname, String link, String comment, String image,
			String color_map, String color_map_over) {
		super();
		this.id = id;
		this.name = name;
		this.shortname = shortname;
		this.link = link;
		this.comment = comment;
		this.image = image;
		this.color_map = color_map;
		this.color_map_over = color_map_over;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getColor_map() {
		return color_map;
	}

	public void setColor_map(String color_map) {
		this.color_map = color_map;
	}

	public String getColor_map_over() {
		return color_map_over;
	}

	public void setColor_map_over(String color_map_over) {
		this.color_map_over = color_map_over;
	}

}
