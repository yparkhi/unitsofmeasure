/*
 * Created on 2004-6-22
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.evsoft.commons.measure.xml;

/**
 * @author user
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MeasureUnit {

	/**
	 * ¹¹Ôìº¯Êý
	 */
	public MeasureUnit() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String  name;
	private String  cnname;
	private String value;
	/**
	 * @return Returns the cnname.
	 */
	public String getCnname() {
		return cnname;
	}
	/**
	 * @param cnname The cnname to set.
	 */
	public void setCnname(String cnname) {
		this.cnname = cnname;
	}
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Returns the standard.
	 */
	public String getStandard() {
		return standard;
	}
	/**
	 * @param standard The standard to set.
	 */
	public void setStandard(String standard) {
		this.standard = standard;
	}
	private String standard;
	/**
	 * @return Returns the value.
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value The value to set.
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
