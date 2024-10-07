package conversor;

public class Area extends Padre {

    // Constructor que llama al constructor de la clase Padre
    public Area(String comboBox2, String comboBox3, String texto1, String texto2, String textoComboBox) {
        super(comboBox2, comboBox3, texto1, texto2, textoComboBox); // Llama al constructor de Padre
    }

    public void realizarAccion() {
        System.out.println("Realizando acción para conversión de área.");
        
        // Comprobar si el comboBox2 es "kilómetro cuadrado"
        if (comboBox2.equalsIgnoreCase("kilómetro cuadrado")) {
            if(comboBox3.equals("Metro Cuadrado")){
                
            }
           
            
            
            
        } 
    }
}