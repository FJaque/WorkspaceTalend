package routines;

public class Util {

    public static String ReemplazarVacios(String campo) {
        String respuesta = campo;
    	if (campo == null || campo.trim().equals("") || campo.trim() == "") {
    		respuesta = "Nulo";
        }
        return (respuesta);
    }
    
    public static String ReemplazarPipe(String campo){
    	String respuesta = campo;
    	if (campo != null) {
    		respuesta = campo.replaceAll("\\|"," ");
        }
        return (respuesta);
    }
}