package june04;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class replace extends SimpleTagSupport {

	private String oldword1;
	private String newword1;
	private String oldword2;
	private String newword2;

	public void setOldword1(String oldword1) {
		this.oldword1 = oldword1;
	}

	public void setNewword1(String newword1) {
		this.newword1 = newword1;
	}

	public void setOldword2(String oldword2) {
		this.oldword2 = oldword2;
	}

	public void setNewword2(String newword2) {
		this.newword2 = newword2;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
	
		super.doTag();
		
		JspContext context = getJspContext();
		JspWriter out = context.getOut();
		JspFragment body = getJspBody();
		
		StringWriter sWriter = new StringWriter();
		body.invoke(sWriter);// 태그 몸통을 StringWriter로 전송
		
		String str = sWriter.toString();//String으로 변환
		
		String newstr = str.replaceAll(oldword1, newword1);
		newstr = newstr.replaceAll(oldword2, newword2);
		out.print(newstr);
		
		
	}
}
