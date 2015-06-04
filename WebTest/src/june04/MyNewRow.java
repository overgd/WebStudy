package june04;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyNewRow extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		
		JspTag parent = getParent();
		
		if((parent == null) || !(parent instanceof MyNewList)) {
			throw new JspException("잘못된 태그 사용!");
		}
		
		JspContext context = getJspContext();
		JspWriter out = context.getOut();
		JspFragment body = getJspBody();
		
		char ch1 = ((MyNewList)parent).getVar1();
		char ch2 = ((MyNewList)parent).getVar2();
		
		out.print(ch1);
		body.invoke(null);
		out.print(ch2+"<br/>");
		
	}

}
