package com.lukoseviciute.programming.util;

import java.util.List;
import com.lukoseviciute.programming.models.Athlete;

public interface FileReaderI {
	public List<Athlete> intoObjects(String fileStr);

}
