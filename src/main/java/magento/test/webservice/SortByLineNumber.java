package magento.test.webservice;

import java.util.Comparator;

public class SortByLineNumber implements Comparator<Line> {

	public int compare(Line line1, Line line2) {
		return line1.getLine_number() - line2.getLine_number();
	}
}
