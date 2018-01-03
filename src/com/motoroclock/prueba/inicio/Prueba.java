package com.motoroclock.prueba.inicio;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

public class Prueba extends JPanel {

	private BindingGroup m_bindingGroup;
	private com.motoroclock.prueba.inicio.Cliente cliente = new com.motoroclock.prueba.inicio.Cliente();
	private JTextField codigoJTextField;
	private JComboBox marcaJComboBox;
	private JTextField nombreJTextField;

	public Prueba(com.motoroclock.prueba.inicio.Cliente newCliente) {
		this();
		setCliente(newCliente);
	}

	public Prueba() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0E-4 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0E-4 };
		setLayout(gridBagLayout);

		JLabel codigoLabel = new JLabel("Codigo:");
		GridBagConstraints labelGbc_0 = new GridBagConstraints();
		labelGbc_0.insets = new Insets(5, 5, 5, 5);
		labelGbc_0.gridx = 0;
		labelGbc_0.gridy = 0;
		add(codigoLabel, labelGbc_0);

		codigoJTextField = new JTextField();
		GridBagConstraints componentGbc_0 = new GridBagConstraints();
		componentGbc_0.insets = new Insets(5, 0, 5, 5);
		componentGbc_0.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_0.gridx = 1;
		componentGbc_0.gridy = 0;
		add(codigoJTextField, componentGbc_0);

		JLabel marcaLabel = new JLabel("Marca:");
		GridBagConstraints labelGbc_1 = new GridBagConstraints();
		labelGbc_1.insets = new Insets(5, 5, 5, 5);
		labelGbc_1.gridx = 0;
		labelGbc_1.gridy = 1;
		add(marcaLabel, labelGbc_1);

		marcaJComboBox = Marca.createJComboBox();
		GridBagConstraints componentGbc_1 = new GridBagConstraints();
		componentGbc_1.insets = new Insets(5, 0, 5, 5);
		componentGbc_1.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_1.gridx = 1;
		componentGbc_1.gridy = 1;
		add(marcaJComboBox, componentGbc_1);

		JLabel nombreLabel = new JLabel("Nombre:");
		GridBagConstraints labelGbc_2 = new GridBagConstraints();
		labelGbc_2.insets = new Insets(5, 5, 5, 5);
		labelGbc_2.gridx = 0;
		labelGbc_2.gridy = 2;
		add(nombreLabel, labelGbc_2);

		nombreJTextField = new JTextField();
		GridBagConstraints componentGbc_2 = new GridBagConstraints();
		componentGbc_2.insets = new Insets(5, 0, 5, 5);
		componentGbc_2.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_2.gridx = 1;
		componentGbc_2.gridy = 2;
		add(nombreJTextField, componentGbc_2);

		if (cliente != null) {
			m_bindingGroup = initDataBindings();
		}
	}

	public com.motoroclock.prueba.inicio.Cliente getCliente() {
		return cliente;
	}

	public void setCliente(com.motoroclock.prueba.inicio.Cliente newCliente) {
		setCliente(newCliente, true);
	}

	public void setCliente(com.motoroclock.prueba.inicio.Cliente newCliente, boolean update) {
		cliente = newCliente;
		if (update) {
			if (m_bindingGroup != null) {
				m_bindingGroup.unbind();
				m_bindingGroup = null;
			}
			if (cliente != null) {
				m_bindingGroup = initDataBindings();
			}
		}
	}

	protected BindingGroup initDataBindings() {
		BeanProperty<Cliente, Integer> codigoProperty = BeanProperty.create("codigo");
		BeanProperty<JTextField, String> textProperty = BeanProperty.create("text");
		AutoBinding<Cliente, Integer, JTextField, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ, cliente, codigoProperty, codigoJTextField, textProperty);
		autoBinding.bind();
		//
		BeanProperty<Cliente, Marca> marcaProperty = BeanProperty.create("marca");
		BeanProperty<JComboBox, Integer> selectedIndexProperty = BeanProperty.create("selectedIndex");
		AutoBinding<Cliente, Marca, JComboBox, Integer> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, cliente, marcaProperty, marcaJComboBox, selectedIndexProperty);
		autoBinding_1.bind();
		//
		BeanProperty<Cliente, String> nombreProperty = BeanProperty.create("nombre");
		BeanProperty<JTextField, String> textProperty_1 = BeanProperty.create("text");
		AutoBinding<Cliente, String, JTextField, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, cliente, nombreProperty, nombreJTextField, textProperty_1);
		autoBinding_2.bind();
		//
		BindingGroup bindingGroup = new BindingGroup();
		//
		bindingGroup.addBinding(autoBinding);
		bindingGroup.addBinding(autoBinding_1);
		bindingGroup.addBinding(autoBinding_2);
		return bindingGroup;
	}
}
