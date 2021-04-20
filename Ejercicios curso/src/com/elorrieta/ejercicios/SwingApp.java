package com.elorrieta.ejercicios;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingApp extends JFrame {

	/**
	 * Crear tres objetos de la clase JLabel, ubicarlos uno debajo de otro y mostrar
	 * nombres de colores
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label1, label2, label3;

	public SwingApp() {
		setLayout(null);
		label1 = new JLabel("Texto 1");
		label1.setBounds(10, 30, 100, 30);
		Color color1 = new Color(15, 20, 200);
		label1.setForeground(color1);
		add(label1);
		label2 = new JLabel("Texto 2");
		label2.setBounds(10, 50, 100, 30);
		Color color2 = new Color(200, 10, 20);
		label2.setForeground(color2);
		add(label2);
		label3 = new JLabel("Texto 3");
		label3.setBounds(10, 70, 100, 30);
		Color color3 = new Color(20, 200, 15);
		label3.setForeground(color3);
		add(label3);

	}

	public static void main(String[] args) {
		SwingApp sa = new SwingApp();
		sa.setBounds(0, 0, 300, 200);
		sa.setResizable(false);
		sa.setVisible(true);
		sa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
