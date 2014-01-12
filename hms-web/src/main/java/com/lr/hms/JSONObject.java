package com.lr.hms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//TODO: To be changed as per the input JSON object

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class JSONObject {
	
	public JSONObject() {
		// TODO Auto-generated constructor stub
	}

	public JSONObject(String clinicName, String userName) {
		this.clinicName = clinicName;
		this.userName = userName;
	}

	@XmlElement
	public String clinicName;

	@XmlElement
	public String userName;

	@Override
	public String toString() {
		return "[clinicName=" + clinicName + ", userName=" + userName + "]";
	}

}
