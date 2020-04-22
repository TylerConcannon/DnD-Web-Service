/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.models;

/**
 *
 * @author hanli
 */
public class Monster {
	private String name;
	private String XP;
	private String type;
	private String size;
	private String Alignment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getXP() {
		return XP;
	}

	public void setXP(String CR) {
		this.XP = CR;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getAlignment() {
		return Alignment;
	}

	public void setAlignment(String Alignment) {
		this.Alignment = Alignment;
	}
}
