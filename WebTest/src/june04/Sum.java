package june04;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Sum extends SimpleTagSupport {

	private int to;
	private int from;
	
	public void setTo(int to) {
		this.to = to;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
	
		JspContext context = getJspContext();
		JspWriter writer = context.getOut();
		
		int sum = 0;
		
		for(int i = from; i <= to; i++) {
			sum = sum + i;
		}
		writer.print(sum);
	}
	
	
	
}
