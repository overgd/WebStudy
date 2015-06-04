package june04;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyNewList extends SimpleTagSupport {

	private char var1;
	private char var2;
	

	public char getVar1() {
		return var1;
	}


	public void setVar1(char var1) {
		this.var1 = var1;
	}


	public char getVar2() {
		return var2;
	}


	public void setVar2(char var2) {
		this.var2 = var2;
	}


	@Override
	public void doTag() throws JspException, IOException {
		
		JspFragment body = getJspBody();
		body.invoke(null);
	
	}

}
