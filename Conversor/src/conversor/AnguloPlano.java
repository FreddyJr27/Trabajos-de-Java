package conversor;

// Clase hija que hereda de Padre
public class AnguloPlano extends Padre {

    // Constructor que llama al constructor de la clase Padre
    public AnguloPlano(String seleccion2, String seleccion3, String texto1, String texto2, String textoComboBox) {
        super(seleccion2, seleccion3, texto1, texto2, textoComboBox); // Llama al constructor de Padre
    }

    // Método sobrescrito para la lógica específica de ángulo plano
   
    
    public void realizarAccion() {
        System.out.println("Realizando acción para conversión de ángulo plano.");
        
    }
}

