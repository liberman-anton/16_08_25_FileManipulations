package wix.filemanipulations.manipulations;

import java.util.*;

public class Reverse implements IManipulations {

	@Override
	public List<String> manipulate(List<String> inputLines) {
		Collections.reverse(inputLines);
		return inputLines;
	}

}
