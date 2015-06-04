package june04;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyList extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		
		super.doTag();
		
		JspFragment body = getJspBody();
		body.invoke(null);
		
	}
}
