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
            lluviasCentro[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la lluvia en la región Centro para el mes " + (i+1) + ":"));
            promedioSemestralCentro += lluviasCentro[i];
            lluviasSur[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la lluvia en la región Sur para el mes " + (i+1) + ":"));
            if (lluviasSur[i] < menorLluviaSur) {
                menorLluviaSur = lluviasSur[i];
                mesMenorLluviaSur = i+1;
            }
            lluviasNorte[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la lluvia en la región Norte para el mes " + (i+1) + ":"));
        }

        double sumaLluviasNorte = 0;
        for (int i = 0; i < tamanoVector; i++) {
            sumaLluviasNorte += lluviasNorte[i];
        }

        double sumaLluviasSur = 0;
        for (int i = 0; i < tamanoVector; i++) {
            sumaLluviasSur += lluviasSur[i];
        }

        if (sumaLluviasNorte > sumaLluviasSur && sumaLluviasNorte > promedioSemestralCentro) {
            regionMayorLluviaSemestral = "Norte";
        } else if (sumaLluviasSur > sumaLluviasNorte && sumaLluviasSur > promedioSemestralCentro) {
            regionMayorLluviaSemestral = "Sur";
        } else {
            regionMayorLluviaSemestral = "Centro";
        }

        JOptionPane.showMessageDialog(null, "El promedio semestral de la región Centro es: " + promedioSemestralCentro/tamanoVector);
        JOptionPane.showMessageDialog(null, "El mes y registro con menor lluvia en la región Sur es: " + mesMenorLluviaSur + " - " + menorLluviaSur);
        JOptionPane.showMessageDialog(null, "La región con mayor lluvia semestral es: " + regionMayorLluviaSemestral);
    }
}