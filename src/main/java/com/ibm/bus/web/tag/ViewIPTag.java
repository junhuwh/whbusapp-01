package com.ibm.bus.web.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ViewIPTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {

		HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
		
		JspWriter out = this.pageContext.getOut();
		
		String ip = request.getRemoteAddr();
		try {
			out.print(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}

		
		return super.doStartTag();
	}

	
	
}
