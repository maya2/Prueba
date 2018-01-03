package com.motoroclock.prueba.inicio;
import javax.swing.JComboBox;

public class Marca {
	private int codigo;
	private String descripcion;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	/**
	 * @wbp.factory
	 */
	public static JComboBox createJComboBox() {
		JComboBox comboBox = new JComboBox();
		return comboBox;
	}
}
