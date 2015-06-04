package june04;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyBox extends SimpleTagSupport {

	
	
	@Override
	public void doTag() throws JspException, IOException {
	
		super.doTag();
		
		JspContext context = getJspContext();
		JspWriter writer = context.getOut();
		JspFragment body = getJspBody();
		
		writer.print("<table border=1 cellpadding=20><tr><td>");
		body.invoke(null);
		writer.print("</td></tr></table>");
	}

}