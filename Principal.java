package es.studium.Taller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Principal implements WindowListener, ActionListener{

    Frame ventana = new Frame("Calcular el IVA");
    Funciones funciones = new Funciones();
    Label lab1 = new Label("Introduzca la cantidad");
    Label lab2 = new Label("Introduzca el porcentaje");
    Label lab3 = new Label("Resultado");
    TextField txt1 = new TextField(10);
    TextField txt2 = new TextField(10);
    TextField txtResultado = new TextField(20);
    Button btnCalcular = new Button("Calcular");

    Principal(){
        ventana.setLayout(new FlowLayout());
        // Añadimos los componentes
        ventana.add(lab1);
        ventana.add(txt1);
        ventana.add(lab2);
        ventana.add(txt2);
        ventana.add(btnCalcular);
        ventana.add(lab3);
        txtResultado.setEditable(false);
        ventana.add(txtResultado);
        // Añadir Listeners
        ventana.addWindowListener(this);
        btnCalcular.addActionListener(this);
        // Establecemos el tamaño
        ventana.setSize(300, 180);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        // Hacemos visible la pantalla
        ventana.setVisible(true);
    }

    public static void main(String[] args){
        new Principal();
    }

    public void actionPerformed(ActionEvent e){
        // Averiguar botón pulsado
        Object a = e.getSource();
        if(a.equals(btnCalcular)){
            try{
                // Calculamos el porcentaje a través del objeto funciones
                float resultado = funciones.calcularIva(txt1, txt2);
                // Reseteamos los elementos
                // Colocamos el resultado en el Textfield correspondiente
                // Sumar "" a un número lo transforma en CADENA
                txtResultado.setText(resultado + "");
            }catch(NumberFormatException nfe){
                txtResultado.setText("Introducir numeros");
            }finally{
                txt1.selectAll();
                txt1.setText("");
                txt2.selectAll();
                txt2.setText("");
                // Y ponemos el cursor de nuevo en el primer cuadro de texto
                txt1.requestFocus();
            }
        }
    }

    public void windowClosing(WindowEvent e){
        // Salir
        System.exit(0);
    }

    public void windowActivated(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowOpened(WindowEvent e){}
}
