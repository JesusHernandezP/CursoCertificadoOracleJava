/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.etiq;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 *
 * @author Pedro
 */
public class CuerpoRepTag extends BodyTagSupport {

    int veces = 0;
    BodyContent bc;

    public void setVeces(int veces) {
        this.veces = veces;
    }
    @Override
    public void setBodyContent(BodyContent bc){
        this.bc = bc;
    }
    @Override
    public int doAfterBody() throws JspException {
        if (veces-- > 0){
            try {
                JspWriter out = bc.getEnclosingWriter();
                out.println("<br/>" + bc.getString());
                bc.clearBody();
            } catch (IOException e) {
                System.out.println("Error de IOException en la etiquetaCuerpoRepTag: " + e.getMessage());
            }
            return EVAL_BODY_BUFFERED;
        } else {
            return SKIP_BODY;
        }
    }
}
