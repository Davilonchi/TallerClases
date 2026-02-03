package es.studium.Taller;

import java.awt.*;

public class Funciones{

    Funciones(){}

    public float calcularIva(TextField txt1, TextField txt2){
        float resultado = Float.parseFloat(txt1.getText())*Float.parseFloat(txt2.getText())/(float)100.0;
        return resultado;
    }
    public float calcularIvaReducido(){
        return 0.0f;
    }
}
