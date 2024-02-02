package com.itwill.layout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;

public class ProductListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel productContentListPanel;

	/**
	 * Create the panel.
	 */
	public ProductListPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0), 10));
		setBackground(Color.ORANGE);
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		productContentListPanel = new JPanel();
		productContentListPanel.setPreferredSize(new Dimension(180, 1000));
		productContentListPanel.setMaximumSize(new Dimension(10, 10));
		FlowLayout fl_productContentListPanel = (FlowLayout) productContentListPanel.getLayout();
		fl_productContentListPanel.setAlignment(FlowLayout.LEFT);
		scrollPane.setViewportView(productContentListPanel);
		
		/* 제품 1개 poductPanel */
		/*
		JPanel productPanel = new JPanel();
		productPanel.setBackground(SystemColor.inactiveCaption);
		productPanel.setPreferredSize(new Dimension(150, 150));
		productContentListPanel.add(productPanel); // 중요
		productPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ProductListPanel.class.getResource("/images/50bigle.jpg")));
		lblNewLabel.setBounds(12, 10, 57, 50);
		productPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html>\r\n이름:~~<br>\r\n성별:~~<br>\r\n특징:~~\r\n</html>");
		lblNewLabel_1.setBounds(81, 10, 57, 50);
		productPanel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("담기");
		btnNewButton.setIcon(new ImageIcon(ProductListPanel.class.getResource("/images/cart20.png")));
		btnNewButton.setBounds(55, 66, 83, 31);
		productPanel.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboBox.setBounds(12, 70, 33, 23);
		productPanel.add(comboBox);
		*/
		displayProductList();
	}
	
	/* 상품 리스트 출력 */
	public void displayProductList() {
		
		productContentListPanel.removeAll();
		
		for (int i = 0; i < 3; i++) {
			JPanel productPanel = new JPanel();
			productPanel.setBackground(SystemColor.inactiveCaption);
			productPanel.setPreferredSize(new Dimension(150, 150));
			productContentListPanel.add(productPanel); // 중요
			productPanel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(ProductListPanel.class.getResource("/images/50bigle.jpg")));
			lblNewLabel.setBounds(12, 10, 57, 50);
			productPanel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("<html>\r\n이름:~~<br>\r\n성별:~~<br>\r\n특징:~~\r\n</html>");
			lblNewLabel_1.setBounds(81, 10, 57, 50);
			productPanel.add(lblNewLabel_1);
			
			JButton btnNewButton = new JButton("담기");
			btnNewButton.setIcon(new ImageIcon(ProductListPanel.class.getResource("/images/cart20.png")));
			btnNewButton.setBounds(55, 66, 83, 31);
			productPanel.add(btnNewButton);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
			comboBox.setBounds(12, 70, 33, 23);
			productPanel.add(comboBox);
		}
		
	}
	
}
