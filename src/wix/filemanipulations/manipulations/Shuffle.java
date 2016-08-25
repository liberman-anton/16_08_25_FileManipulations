package wix.filemanipulations.manipulations;

import java.util.*;

public class Shuffle implements IManipulations {

	@Override
	public List<String> manipulate(List<String> inputLines) {
		Collections.shuffle(inputLines);
		return inputLines;
	}

}
