package es.etiq;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * CuerpoTag.java: Ejemplo de uso de etiquetas personalizadas que evalúan el
 * cuerpo de una etiqueta e imprime la longitud de la cadena introducida
 * @author Pedro
 */
public class CuerpoTag extends BodyTagSupport {

    /**
     * Creates new instance of tag handler
     */
    public CuerpoTag() {
        super();
    }
    @Override
    public int doAfterBody() throws JspException {
        try {
            BodyContent bc = getBodyContent();
            String cuerpo = bc.getString();
            JspWriter out = bc.getEnclosingWriter();
            if (cuerpo != null){
                out.print("la longitud de " + cuerpo + " es: " + cuerpo.length());
            }
        } catch (IOException e){
            throw new JspException("Error IOException: " + e.getMessage());
        }
        return SKIP_BODY;
    }
}
