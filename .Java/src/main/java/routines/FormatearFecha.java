package routines;

import java.util.Date;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class FormatearFecha {

    /**
     * 
     * {talendTypes} Date
     * 
     * {Category} User Defined
     * 
     * {param} string("fechaXML") input: Fecha retornada por XML
     * 
     * {example} recortarFecha("world") # hello world !.
     */
    public static Date recortarFecha(String fechaXML) {
        
    	// Quitar nulo
    	if (fechaXML == null || fechaXML == "") {
        	return(null);
        }
        
        // Dejar con el mismo formato
        String fechaRecortada;
        int posicionPunto = StringHandling.INDEX(fechaXML, ("."));
        if (posicionPunto >= 0)
     
        	fechaRecortada = StringHandling.LEFT(fechaXML, posicionPunto);
        else
        	fechaRecortada = fechaXML; 
        
        // Convertir a fecha
        Date fecha = routines.TalendDate.parseDate("yyyy-MM-dd'T'HH:mm:ss", fechaRecortada); 
        
        return(fecha);
    }
}
