package coreJava.rb;

import java.util.ListResourceBundle;

public class Ch13Q11rb_en_US extends ListResourceBundle {

	private Object[][] contents = { 
			{ "defaultPaperSize",new double[] { 216, 279 } } 
	};

	@Override
	protected Object[][] getContents() {
		return contents;
	}

}
