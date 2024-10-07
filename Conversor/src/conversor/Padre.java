package conversor;
public class Padre {
    protected String comboBox2; // Cambiado a protected para que sea accesible en las clases hijas
    protected String comboBox3;
    protected String texto1;
    protected String texto2;
    protected String textoComboBox;

    // Constructor que acepta las selecciones y textos
    public Padre(String comboBox2, String comboBox3, String texto1, String texto2, String textoComboBox) {
        this.comboBox2 = comboBox2;
        this.comboBox3 = comboBox3;
        this.texto1 = texto1;
        this.texto2 = texto2;
        this.textoComboBox = textoComboBox;
    }

    public void realizarAccion() {
        if ("Área".equals(textoComboBox)) {
            Area area = new Area(comboBox2, comboBox3, texto1, texto2, textoComboBox);
            area.realizarAccion();
        } else if ("Ángulo Plano".equals(textoComboBox)) {
            AnguloPlano anguloPlano = new AnguloPlano(comboBox2, comboBox3, texto1, texto2, textoComboBox);
            anguloPlano.realizarAccion();
        }
    }
}

