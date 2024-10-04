package conversor;

import java.awt.Font;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        String[] opciones = {"Área", "Ángulo Plano"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setBounds(100, 20, 400, 30);
        comboBox.setBackground(new Color(250, 250, 250));

        // ComboBox2
        String[] opciones2 = {"Kilómetro cuadrado", "Metro cuadrado", "Milla cuadrada",
                "Yarda cuadrada", "Pie cuadrado", "Pulgada cuadrada",
                "Hectárea", "Acre"};
        JComboBox<String> comboBox2 = new JComboBox<>();
        comboBox2.setBounds(50, 140, 230, 40);
        comboBox2.setBackground(new Color(250, 250, 250));

        // ComboBox3
        String[] opciones3 = {"Grado", "Grado centesimal", "Miliradián",
                "Minuto de arco", "Radián", "Segundo de arco"};
        JComboBox<String> comboBox3 = new JComboBox<>();
        comboBox3.setBounds(310, 140, 230, 40);
        comboBox3.setBackground(new Color(250, 250, 250));

        // Texto 1
        JTextField Texto1 = new JTextField("");
        Texto1.setBounds(50, 80, 230, 50);

        // Label igual
        JLabel igual = new JLabel("=");
        igual.setBounds(288, 93, 50, 20);

        // Texto 2
        JTextField Texto2 = new JTextField("");
        Texto2.setBounds(310, 80, 230, 50);
        
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
            if ("Área".equals(textocomboBox)) {
                comboBox2.setModel(new DefaultComboBoxModel<>(opciones2)); // Establecer opciones para área
                comboBox3.setModel(new DefaultComboBoxModel<>(opciones2)); // Usar las opciones para ángulo plano
            } else {
                comboBox2.setModel(new DefaultComboBoxModel<>(opciones3)); // Establecer opciones para ángulo plano
                comboBox3.setModel(new DefaultComboBoxModel<>(opciones3)); // Usar las opciones para área
            }
        });

        // ActionListener para comboBox2
        comboBox2.addActionListener(e -> {
            String seleccion2 = (String) comboBox2.getSelectedItem();
            String seleccion3 = (String) comboBox3.getSelectedItem();

            // Si se selecciona la misma opción en comboBox3, cambiar el comboBox3
            if (seleccion2.equals(seleccion3)) {
                // Cambiar comboBox3 a otra opción que no sea la seleccionada en comboBox2
                for (int i = 0; i < comboBox3.getItemCount(); i++) {
                    String item = (String) comboBox3.getItemAt(i);
                    if (!item.equals(seleccion2)) {
                        comboBox3.setSelectedItem(item);
                        break; // Salir después de seleccionar una opción diferente
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
                // Cambiar comboBox2 a otra opción que no sea la seleccionada en comboBox3
                for (int i = 0; i < comboBox2.getItemCount(); i++) {
                    String item = (String) comboBox2.getItemAt(i);
                    if (!item.equals(seleccion3)) {
                        comboBox2.setSelectedItem(item);
                        break; // Salir después de seleccionar una opción diferente
                    }
                }
            }
        });
    }

   
}

