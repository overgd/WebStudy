package june04;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyMin extends SimpleTagSupport {

	private int num1;
	private int num2;
	
	private String var;
	
	public void setVar(String var) {
		this.var = var;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	@Override
	public void doTag() throws JspException, IOException {
	
		super.doTag();
		
		JspContext context = getJspContext();
		if(num1 < num2) {
			
			context.setAttribute(var, num1);
			
		}else {
			
			context.setAttribute(var, num2);
			
		}
	
	}
}
