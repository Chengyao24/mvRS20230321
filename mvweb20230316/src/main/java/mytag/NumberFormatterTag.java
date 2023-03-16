package mytag;


import java.io.IOException;
import java.text.DecimalFormat;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class NumberFormatterTag extends SimpleTagSupport {
	private String format;
	private String number;

	public NumberFormatterTag() {
	}

	public void setFormat(String format) { //把Number 1:<mytags:formatNumber number="100050.574" format="#,###.00"/><br><br>
		                                   //帶入到這個class(上面)
		this.format = format;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("Number is:" + number);
		System.out.println("Format is:" + format);
		try {
			double amount = Double.parseDouble(number);
			DecimalFormat formatter = new DecimalFormat(format); //格式化
			String formattedNumber = formatter.format(amount);
			getJspContext().getOut().write(formattedNumber);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SkipPageException("Exception in formatting " + number + " with format " + format);
		}
	}
}
