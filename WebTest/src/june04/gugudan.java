package june04;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class gugudan extends SimpleTagSupport {
	
	private int dan;
	
	public void setDan(int dan) {
		this.dan = dan;
	}


	@Override
	public void doTag() throws JspException, IOException {
	
		super.doTag();
		
		JspContext context = getJspContext();
		JspWriter writer = context.getOut();
		
		for(int i = 0; i < 10; i++) {
			
			writer.print(dan+" X "+i+" = "+i*dan+"<br/>");
			
		}	
	
	}
}
