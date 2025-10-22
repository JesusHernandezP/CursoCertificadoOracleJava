package es.etiq;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Pete
 */
public class HolaMundoTag extends TagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     *
     * @return
     * @throws javax.servlet.jsp.JspException
     */
    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.println("<font size='6' color='#cc0066'>Hola, mundo</font>");
        } catch (IOException ioe) {
            System.out.println(" > Error de etiqueta: " + ioe.getMessage());
        }
        return super.doEndTag();
    }
}
