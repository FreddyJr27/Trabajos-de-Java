package conversor;

public class Area extends Padre {

    // Constructor que llama al constructor de la clase Padre
    public Area(String comboBox2, String comboBox3, String texto1, String texto2, String textoComboBox) {
        super(comboBox2, comboBox3, texto1, texto2, textoComboBox); // Llama al constructor de Padre
    }

    @Override
    public void realizarAccion() {
        System.out.println("Realizando acción para conversión de área.");
        
        // Comprobar si comboBox2 es "kilómetro cuadrado" y comboBox3 es "Metro Cuadrado"
        if (comboBox2.equalsIgnoreCase("kilómetro cuadrado")) {
            if (comboBox3.equals("Metro Cuadrado")) {
                try {
                    double valor = Double.parseDouble(texto1);  // Convertir el valor ingresado en texto1
                    double resultado = valor * 1e+6;            // Realizar la conversión

                    // Mostrar el resultado en la consola
                    System.out.println("Resultado de la conversión: " + resultado);
                
                    // Asignar el resultado a texto2
                    this.texto2 = String.valueOf(resultado);

                } catch (NumberFormatException e) {
                    System.out.println("Error: El valor ingresado en texto1 no es un número válido.");
                    this.texto2 = "Error"; // En caso de error, mostrar "Error"
                }
            }
        } else {
            System.out.println("No se requiere conversión para " + comboBox2 + " a " + comboBox3);
            this.texto2 = "No se requiere conversión";
        }
    }

    
    public String getTexto2() {
        return this.texto2;
    }
}
