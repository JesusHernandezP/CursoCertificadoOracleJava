/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etiq;

import java.io.IOException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import static javax.servlet.jsp.tagext.Tag.EVAL_PAGE;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;

/**
 *
 * @author Pedro
 */
public class HolaMundoTag extends SimpleTagSupport {
    PageContext pageContext;
    public int doStartTag() throws JspException {
    try{
            pageContext.getOut().print("Hola Mundo");
        } catch (IOException e) {
            throw new JspException ("Error: IOException" + e.getMessage());
        }
        return SKIP_BODY;
    }
    public void setPageContext(PageContext pc){
        this.pageContext = pc;
    }
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
