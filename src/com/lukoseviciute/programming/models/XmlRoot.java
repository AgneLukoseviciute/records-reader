package com.lukoseviciute.programming.models;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name = "List")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlRoot {

    @XmlElement(name="Item")
    private ArrayList<Athlete> XmlAthletes;

    public ArrayList<Athlete> getArray(){
        return XmlAthletes;
    }

}

