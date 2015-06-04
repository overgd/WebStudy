package june04;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyRow extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		JspTag tag = getParent();
		
		if((tag == null) || !(tag instanceof MyList)) {
			throw new JspException("잘못된 태그 사용!");
		}
		
		JspContext context = getJspContext();
		JspWriter out = context.getOut();
		JspFragment body = getJspBody();
		out.print("-");
		body.invoke(null);
		out.print("<br/>");
		
	
	}

}
