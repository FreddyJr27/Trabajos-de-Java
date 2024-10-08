package conversor;

import java.awt.Font;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Interfaz extends JFrame {
   
    public Interfaz() {
        setTitle("Conversor");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contenedor = new JPanel();
        contenedor.setLayout(null);
        contenedor.setBackground(Color.white);
        setResizable(false);

        // ComboBox1
        String[] opciones = {"Area", "Angulo Plano"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setBounds(100, 20, 400, 30);
        comboBox.setBackground(new Color(250, 250, 250));

        // ComboBox2
        String[] opciones2 = {"Kilometro cuadrado", "Metro cuadrado", "Milla cuadrada",
                "Yarda cuadrada", "Pie cuadrado", "Pulgada cuadrada",
                "Hectarea", "Acre"};
        JComboBox<String> comboBox2 = new JComboBox<>();
        comboBox2.setBounds(50, 140, 230, 40);
        comboBox2.setBackground(new Color(250, 250, 250));

        // ComboBox3
        String[] opciones3 = {"Grado", "Grado centesimal", "Miliradian",
                "Minuto de arco", "Radian", "Segundo de arco"};
        JComboBox<String> comboBox3 = new JComboBox<>();
        comboBox3.setBounds(310, 140, 230, 40);
        comboBox3.setBackground(new Color(250, 250, 250));

        // Texto 1
        JTextField Texto1 = new JTextField("");
        Texto1.setBounds(50, 80, 230, 50);

        // Label igual
        JLabel igual = new JLabel("=");
        igual.setBounds(288, 93, 50, 20);

        // Texto 2 (no editable)
        JTextField Texto2 = new JTextField("");
        Texto2.setBounds(310, 80, 230, 50);
        Texto2.setEditable(false);
        
        JLabel formula = new JLabel("Formula:");
        formula.setOpaque(true);
        formula.setBounds(50,210,85,20);
        formula.setBackground(Color.yellow);
        
        JLabel respuesta = new JLabel("");
        respuesta.setBounds(170,210,100,20);
        

        // Añadir componentes al contenedor
        contenedor.add(respuesta);
        contenedor.add(comboBox3);
        contenedor.add(comboBox2);
        contenedor.add(Texto2);
        contenedor.add(igual);
        contenedor.add(Texto1);
        contenedor.add(comboBox);
        contenedor.add(formula);
        add(contenedor);

        // Tamaño de las letras
        Font font = new Font("Arial", Font.PLAIN, 20); // Tipo de fuente, estilo, tamaño
        Texto1.setFont(font);
        Texto2.setFont(font);
        igual.setFont(font);
        formula.setFont(font);

        setLocationRelativeTo(null);
        setVisible(true);

        // Solicitar el foco en el JTextField
        SwingUtilities.invokeLater(() -> Texto1.requestFocusInWindow());

        // ActionListener para comboBox
        comboBox.addActionListener(e -> {
             // Obtener el elemento seleccionado
             String textocomboBox = (String) comboBox.getSelectedItem();

             // Actualizar las opciones de los comboBox2 y comboBox3 según la selección
             if ("Area".equals(textocomboBox)) {
                 comboBox2.setModel(new DefaultComboBoxModel<>(opciones2)); // Establecer opciones para área
                 comboBox3.setModel(new DefaultComboBoxModel<>(opciones2));
                 
             } else {
                 comboBox2.setModel(new DefaultComboBoxModel<>(opciones3)); // Establecer opciones para ángulo plano
                 comboBox3.setModel(new DefaultComboBoxModel<>(opciones3));
             }
        });

        // ActionListener para comboBox2
        comboBox2.addActionListener(e -> {
            String seleccion2 = (String) comboBox2.getSelectedItem();
            String seleccion3 = (String) comboBox3.getSelectedItem();
            
            // Si se selecciona la misma opción en comboBox3, cambiar el comboBox3
            if (seleccion2.equals(seleccion3)) {
                for (int i = 0; i < comboBox3.getItemCount(); i++) {
                    String item = (String) comboBox3.getItemAt(i);
                    if (!item.equals(seleccion2)) {
                        comboBox3.setSelectedItem(item);
                        break;
                    }
                }
            }
        });

        // ActionListener para comboBox3
        comboBox3.addActionListener(e -> {
            String seleccion2 = (String) comboBox2.getSelectedItem();
            String seleccion3 = (String) comboBox3.getSelectedItem();
           
            // Si se selecciona la misma opción en comboBox2, cambiar el comboBox2
            if (seleccion3.equals(seleccion2)) {
                for (int i = 0; i < comboBox2.getItemCount(); i++) {
                    String item = (String) comboBox2.getItemAt(i);
                    if (!item.equals(seleccion3)) {
                        comboBox2.setSelectedItem(item);
                        break;
                    }
                }
            }
        });

        // KeyListener para actualizar Texto2 cuando se escribe en Texto1
        Texto1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                
                String seleccion4 = (String) comboBox2.getSelectedItem();
                String seleccion5 = (String) comboBox3.getSelectedItem();
                String texto1 = Texto1.getText();
                String texto2 = Texto2.getText();
                String textoComboBox = (String) comboBox.getSelectedItem();

                // Crear una instancia de Padre y realizar la conversión
                Padre padre = new Padre(seleccion4, seleccion5, texto1 , texto2, textoComboBox);  
                padre.realizarAccion();  
        
                // Actualizar el campo de texto2 con el resultado de la conversión
                Texto2.setText(padre.getTexto2());
            }
        });
    }
}
