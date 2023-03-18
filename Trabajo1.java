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

       static int tamanoVector = 6;

    public static void main(String[] args) {

        double[] lluviasCentro = new double[tamanoVector];
        double[] lluviasNorte = new double[tamanoVector];
        double[] lluviasSur = new double[tamanoVector];

        double promedioSemestralCentro = 0;
        double menorLluviaSur = Double.MAX_VALUE;
        int mesMenorLluviaSur = 0;
        String regionMayorLluviaSemestral = "";

        for (int i = 0; i < tamanoVector; i++) {
            lluviasCentro[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de lluvia en la region Centro para el mes " + (i+1)));
            lluviasNorte[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de lluvia en la region Norte para el mes " + (i+1)));
            lluviasSur[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de lluvia en la region Sur para el mes " + (i+1)));

            promedioSemestralCentro += lluviasCentro[i];

            if (lluviasSur[i] < menorLluviaSur) {
                menorLluviaSur = lluviasSur[i];
                mesMenorLluviaSur = i+1;
            }
        }

        promedioSemestralCentro /= tamanoVector;

        double totalLluviasCentro = 0;
        double totalLluviasNorte = 0;
        double totalLluviasSur = 0;

        for (int i = 0; i < tamanoVector; i++) {
            totalLluviasCentro += lluviasCentro[i];
            totalLluviasNorte += lluviasNorte[i];
            totalLluviasSur += lluviasSur[i];
        }

        if (totalLluviasCentro > totalLluviasNorte && totalLluviasCentro > totalLluviasSur) {
            regionMayorLluviaSemestral = "Centro";
        } else if (totalLluviasNorte > totalLluviasSur) {
            regionMayorLluviaSemestral = "Norte";
        } else {
            regionMayorLluviaSemestral = "Sur";
        }

        JOptionPane.showMessageDialog(null, "Promedio semestral de la región Centro: " + promedioSemestralCentro + "\n" +
                                            "Mes con menor lluvia en la región Sur: " + mesMenorLluviaSur + "\n" +
                                            "Región con mayor lluvia semestral: " + regionMayorLluviaSemestral);
    }

}