package com.lukoseviciute.programming.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.lukoseviciute.programming.models.Athlete;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import com.lukoseviciute.programming.models.XmlRoot;

public class XMLFileReader implements FileReaderI {

	ArrayList<Athlete> xmlAthleteList = new ArrayList<Athlete>();

	public XMLFileReader(){

	}
	@Override
	public List<Athlete> intoObjects(String xmlStr){
		File xmlFile = new File(xmlStr);

		JAXBContext jc = null;
		try {
			jc = JAXBContext.newInstance(XmlRoot.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			XmlRoot root = (XmlRoot) unmarshaller.unmarshal(xmlFile);
			xmlAthleteList = root.getArray();

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return xmlAthleteList;
	}
	
}
