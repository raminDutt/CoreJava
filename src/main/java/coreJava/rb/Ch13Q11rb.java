package coreJava.rb;

import java.util.ListResourceBundle;

public class Ch13Q11rb extends ListResourceBundle {

	Object[][] contents = new Object[1][2];

	@Override
	protected Object[][] getContents() {

		return contents;
	}

	public Ch13Q11rb() {
		String key1 = "defaultPaperSize";
		double[] value1 = new double[] { 210, 297 };

		contents[0][0] = key1;
		contents[0][1] = value1;
	}

}
