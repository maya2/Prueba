package com.motoroclock.prueba.inicio;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;

public class MarcaJPanel extends JPanel {

	private BindingGroup m_bindingGroup;
	private com.motoroclock.prueba.inicio.Marca marca = new com.motoroclock.prueba.inicio.Marca();
	private JLabel codigoJLabel;
	private JTextField descripcionJTextField;

	public MarcaJPanel(com.motoroclock.prueba.inicio.Marca newMarca) {
		this();
		setMarca(newMarca);
	}

	public MarcaJPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0E-4 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0E-4 };
		setLayout(gridBagLayout);

		JLabel codigoLabel = new JLabel("Codigo:");
		GridBagConstraints labelGbc_0 = new GridBagConstraints();
		labelGbc_0.insets = new Insets(5, 5, 5, 5);
		labelGbc_0.gridx = 0;
		labelGbc_0.gridy = 0;
		add(codigoLabel, labelGbc_0);

		codigoJLabel = new JLabel();
		GridBagConstraints componentGbc_0 = new GridBagConstraints();
		componentGbc_0.insets = new Insets(5, 0, 5, 5);
		componentGbc_0.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_0.gridx = 1;
		componentGbc_0.gridy = 0;
		add(codigoJLabel, componentGbc_0);

		JLabel descripcionLabel = new JLabel("Descripcion:");
		GridBagConstraints labelGbc_1 = new GridBagConstraints();
		labelGbc_1.insets = new Insets(5, 5, 5, 5);
		labelGbc_1.gridx = 0;
		labelGbc_1.gridy = 1;
		add(descripcionLabel, labelGbc_1);

		descripcionJTextField = new JTextField();
		GridBagConstraints componentGbc_1 = new GridBagConstraints();
		componentGbc_1.insets = new Insets(5, 0, 5, 5);
		componentGbc_1.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_1.gridx = 1;
		componentGbc_1.gridy = 1;
		add(descripcionJTextField, componentGbc_1);

		if (marca != null) {
			m_bindingGroup = initDataBindings();
		}
	}

	protected BindingGroup initDataBindings() {
		BeanProperty<com.motoroclock.prueba.inicio.Marca, java.lang.Integer> codigoProperty = BeanProperty
				.create("codigo");
		BeanProperty<javax.swing.JLabel, java.lang.String> textProperty = BeanProperty.create("text");
		AutoBinding<com.motoroclock.prueba.inicio.Marca, java.lang.Integer, javax.swing.JLabel, java.lang.String> autoBinding = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ, marca, codigoProperty, codigoJLabel, textProperty);
		autoBinding.bind();
		//
		BeanProperty<com.motoroclock.prueba.inicio.Marca, java.lang.String> descripcionProperty = BeanProperty
				.create("descripcion");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_1 = BeanProperty.create("text");
		AutoBinding<com.motoroclock.prueba.inicio.Marca, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_1 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, marca, descripcionProperty,
						descripcionJTextField, textProperty_1);
		autoBinding_1.bind();
		//
		BindingGroup bindingGroup = new BindingGroup();
		bindingGroup.addBinding(autoBinding);
		bindingGroup.addBinding(autoBinding_1);
		//
		return bindingGroup;
	}

	public com.motoroclock.prueba.inicio.Marca getMarca() {
		return marca;
	}

	public void setMarca(com.motoroclock.prueba.inicio.Marca newMarca) {
		setMarca(newMarca, true);
	}

	public void setMarca(com.motoroclock.prueba.inicio.Marca newMarca, boolean update) {
		marca = newMarca;
		if (update) {
			if (m_bindingGroup != null) {
				m_bindingGroup.unbind();
				m_bindingGroup = null;
			}
			if (marca != null) {
				m_bindingGroup = initDataBindings();
			}
		}
	}

}
