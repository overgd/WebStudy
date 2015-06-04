package june04;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class LineTag extends SimpleTagSupport {

	private String color;
	private int size;
	
	public void setColor(String color) {
		this.color = color;
	}


	public void setSize(int size) {
		this.size = size;
	}


	@Override
	public void doTag() throws JspException, IOException {
	
		super.doTag();
		
		JspContext context = getJspContext();
		JspWriter writer = context.getOut();
		writer.print("<font color="+color+">");
		for(int i = 0; i < size ;i++){
			writer.print("=");
		}
		writer.print("</font>");
	
	}

}
