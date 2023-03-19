/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabajo1;
/**
 *
 * @author Daimer
 */
import javax.swing.JOptionPane;

public class Trabajo1 {

        //Declaración del tamaño del vector
    
       static int tVector = 6;

    public static void main(String[] args) {

        double[] lluviaCentro = new double[tVector]; //vector de la región central
        double[] lluviaNorte = new double[tVector]; //vector de la región Norte
        double[] lluviaSur = new double[tVector]; //vector de la región sur

        double promSemestreCentro = 0;
        double minLluviaSur = Double.MAX_VALUE;
        int mesMinLluviaSur = 0;
        String regionMasLluviaSemestre = "";

        for (int i = 0; i < tVector; i++) {
            //solicitando la información de la lluvias
            lluviaCentro[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de lluvia en la region Centro para el mes " + (i+1)));
            lluviaNorte[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de lluvia en la region Norte para el mes " + (i+1)));
            lluviaSur[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de lluvia en la region Sur para el mes " + (i+1)));
            
            //se suma el total de las lluvias de la region centro    
            
            promSemestreCentro += lluviaCentro[i];

            if (lluviaSur[i] < minLluviaSur) {
                //obteniendo el mes con la menor cantidad de lluvia en el sur
                minLluviaSur = lluviaSur[i];
                mesMinLluviaSur = i+1;
            }
        }
        //se saca el promedio de lluvias de la region centro
        promSemestreCentro /= tVector;
        //se declaran las variables que van recorrer los vectores y sumar los 
        //valores de los seis meses del las tres regiones
        double totLluviaCentro = 0;
        double totLluviaNorte = 0;
        double totLluviaSur = 0;

        for (int i = 0; i < tVector; i++) {
            totLluviaCentro += lluviaCentro[i];
            totLluviaNorte += lluviaNorte[i];
            totLluviaSur += lluviaSur[i];
        }
        //evaluar cuál es la región en la cuál más llueve en el valle de aburrá
        if (totLluviaCentro > totLluviaNorte && totLluviaCentro > totLluviaSur) {
            regionMasLluviaSemestre = "Centro";
        } else if (totLluviaNorte > totLluviaSur) {
            regionMasLluviaSemestre = "Norte";
        } else {
            regionMasLluviaSemestre = "Sur";
        }
        
        //Se imprime la información solicitada
        
        JOptionPane.showMessageDialog(null, "Promedio semestral de la región Centro: " + promSemestreCentro + "\n" +
                                            "Mes con menor lluvia en la región Sur: " + mesMinLluviaSur + "\n" +
                                            "Región con mayor lluvia semestral: " + regionMasLluviaSemestre);
    }

}