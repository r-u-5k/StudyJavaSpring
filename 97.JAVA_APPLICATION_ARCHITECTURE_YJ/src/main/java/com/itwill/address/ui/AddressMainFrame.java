package com.itwill.address.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.address.Address;
import com.itwill.address.AddressService;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddressMainFrame extends JFrame {
	/****** 1.AddressService 멤버필드선언 ******/
	AddressService addressService;
	/****************************************/

	private JPanel contentPane;
	private JTextField insertNameTextField;
	private JTextField insertPhoneTextField;
	private JTextField insertAddressTextField;
	private JTextField detailNameTextField;
	private JTextField detailPhoneTextField;
	private JTextField detailAddressTextField;
	private JTextField detailInputNoTextField;
	private JTable addressListTable;
	private JTextField detailNoTextField;
	private JButton updateFormButton;
	private JTabbedPane addressTabbedPane;
	private JButton addressDeleteButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressMainFrame frame = new AddressMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddressMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		addressTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		addressTabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				switch (addressTabbedPane.getSelectedIndex()) {
				case 0:
					break;
				case 1:
					displayAddressList();
					break;
				case 2:
					break;
				}
			}
		});
		contentPane.add(addressTabbedPane, BorderLayout.CENTER);

		JPanel addressInsertPanel = new JPanel();
		addressTabbedPane.addTab("주소록쓰기", null, addressInsertPanel, null);
		addressInsertPanel.setLayout(null);

		JLabel insertNameLabel = new JLabel("이름");
		insertNameLabel.setBounds(68, 45, 57, 15);
		addressInsertPanel.add(insertNameLabel);

		JLabel insertPhoneLabel = new JLabel("전화번호");
		insertPhoneLabel.setBounds(68, 98, 57, 15);
		addressInsertPanel.add(insertPhoneLabel);

		JLabel insertAddressLabel = new JLabel("주소");
		insertAddressLabel.setBounds(68, 147, 57, 18);
		addressInsertPanel.add(insertAddressLabel);

		insertNameTextField = new JTextField();
		insertNameTextField.setBounds(200, 42, 116, 21);
		addressInsertPanel.add(insertNameTextField);
		insertNameTextField.setColumns(10);

		insertPhoneTextField = new JTextField();
		insertPhoneTextField.setBounds(200, 95, 116, 21);
		addressInsertPanel.add(insertPhoneTextField);
		insertPhoneTextField.setColumns(10);

		insertAddressTextField = new JTextField();
		insertAddressTextField.setBounds(200, 146, 116, 21);
		addressInsertPanel.add(insertAddressTextField);
		insertAddressTextField.setColumns(10);

		JButton addressInsertButton = new JButton("주소록 쓰기");
		addressInsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/******* 주소록쓰기 *********/
				try {
					// 1.TextField로부터데이타얻기
					String name = insertNameTextField.getText();
					String phone = insertPhoneTextField.getText();
					String addr = insertAddressTextField.getText();
					Address address1 = Address.builder()
												.name(name)
												.phone(phone)
												.address(addr)
												.build();
					// 2.addressService.addressWrite(Address address) 메소드 호출
					int rowCount = addressService.addressWrite(address1);
					JOptionPane.showMessageDialog(null, "주소 쓰기 성공");
					// 3. 주소록 리스트 화면 보여주기
					addressTabbedPane.setSelectedIndex(1);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "주소 쓰기 실패");
					e1.printStackTrace();
				}
				/**************************/
			}
		});
		addressInsertButton.setBounds(119, 219, 150, 23);
		addressInsertPanel.add(addressInsertButton);

		JPanel addressListPanel = new JPanel();
		addressTabbedPane.addTab("주소록리스트", null, addressListPanel, null);
		addressListPanel.setLayout(null);

		JButton addressListButton = new JButton("주소록 리스트");
		addressListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/********* 주소록리스트 ***********/
				try {
					displayAddressList();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				/**********************************/
			}
		});
		addressListButton.setBounds(49, 235, 150, 23);
		addressListPanel.add(addressListButton);

		JScrollPane addressListScrollPane = new JScrollPane();
		addressListScrollPane.setBounds(12, 10, 359, 180);
		addressListPanel.add(addressListScrollPane);

		addressListTable = new JTable();
		addressListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*** 테이블 클릭 시 선택된 Address의 번호 얻기 ***/
				int columnIndex = addressListTable.getSelectedColumn();
				int rowIndex = addressListTable.getSelectedRow();
				addressDeleteButton.setEnabled(true);
			}
		});
		addressListTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		addressListTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, },
				new String[] { "\uBC88\uD638", "\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC8FC\uC18C" }));
		addressListScrollPane.setViewportView(addressListTable);
		
		addressDeleteButton = new JButton("선택한 행 삭제");
		addressDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int columnIndex = addressListTable.getSelectedColumn();
					int rowIndex = addressListTable.getSelectedRow();
					int selectAddressNo = (int) addressListTable.getValueAt(rowIndex, 0);
					int deleteRowCount = addressService.addressDelete(selectAddressNo);
					displayAddressList();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		addressDeleteButton.setEnabled(false);
		addressDeleteButton.setBounds(211, 235, 130, 23);
		addressListPanel.add(addressDeleteButton);

		JPanel addressDetailPanel = new JPanel();
		addressDetailPanel.setLayout(null);
		addressTabbedPane.addTab("주소록상세보기", null, addressDetailPanel, null);

		JLabel detailNameLabel = new JLabel("이름");
		detailNameLabel.setBounds(73, 109, 57, 15);
		addressDetailPanel.add(detailNameLabel);

		JLabel detailPhoneLabel = new JLabel("전화번호");
		detailPhoneLabel.setBounds(73, 162, 57, 15);
		addressDetailPanel.add(detailPhoneLabel);

		JLabel detailAddressLabel = new JLabel("주소");
		detailAddressLabel.setBounds(73, 211, 57, 18);
		addressDetailPanel.add(detailAddressLabel);

		detailNameTextField = new JTextField();
		detailNameTextField.setEditable(false);
		detailNameTextField.setColumns(10);
		detailNameTextField.setBounds(205, 106, 116, 21);
		addressDetailPanel.add(detailNameTextField);

		detailPhoneTextField = new JTextField();
		detailPhoneTextField.setEditable(false);
		detailPhoneTextField.setColumns(10);
		detailPhoneTextField.setBounds(205, 159, 116, 21);
		addressDetailPanel.add(detailPhoneTextField);

		detailAddressTextField = new JTextField();
		detailAddressTextField.setEditable(false);
		detailAddressTextField.setColumns(10);
		detailAddressTextField.setBounds(205, 210, 116, 21);
		addressDetailPanel.add(detailAddressTextField);

		JButton addressDetailButton = new JButton("번호로 찾기");
		addressDetailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/************** 주소록1개상세보기 ************/
				try {
					String noStr = detailInputNoTextField.getText();
					/************* 유효성체크 ***************/
					if (noStr == null || noStr.equals("")) {
						JOptionPane.showMessageDialog(null, "번호를 입력하세요");
						detailInputNoTextField.requestFocus();
						return;
					}
					int no = Integer.parseInt(noStr);
					/***** addressService.addressDetail(no)호출 *****/
					Address findAddress = addressService.addressDetail(no);
					if (findAddress != null) {
						detailNoTextField.setText(findAddress.getNo() + "");
						detailNameTextField.setText(findAddress.getName());
						detailPhoneTextField.setText(findAddress.getPhone());
						detailAddressTextField.setText(findAddress.getAddress());
						/*** 수정폼버튼 활성화 ***/
						updateFormButton.setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(null, "주소가 존재하지 않음");
						detailNoTextField.setText("");
						detailNameTextField.setText("");
						detailPhoneTextField.setText("");
						detailAddressTextField.setText("");
						updateFormButton.setEnabled(false);
					}
					detailInputNoTextField.requestFocus();
					detailInputNoTextField.setSelectionStart(0);
					detailInputNoTextField.setSelectionEnd(noStr.length());
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				/*******************************************/
			}
		});
		addressDetailButton.setBounds(205, 22, 116, 23);
		addressDetailPanel.add(addressDetailButton);

		detailInputNoTextField = new JTextField();
		detailInputNoTextField.setBounds(130, 23, 63, 21);
		addressDetailPanel.add(detailInputNoTextField);
		detailInputNoTextField.setColumns(10);

		JLabel detailInputNoLabel = new JLabel("<html><b>번호입력:</b></html>");
		detailInputNoLabel.setBounds(73, 22, 57, 19);
		addressDetailPanel.add(detailInputNoLabel);

		JLabel detailNoLabel = new JLabel("번호");
		detailNoLabel.setBounds(73, 61, 57, 15);
		addressDetailPanel.add(detailNoLabel);

		detailNoTextField = new JTextField();
		detailNoTextField.setEditable(false);
		detailNoTextField.setColumns(10);
		detailNoTextField.setBounds(205, 58, 116, 21);
		addressDetailPanel.add(detailNoTextField);
		
		updateFormButton = new JButton("수정폼");
		updateFormButton.setEnabled(false);
		updateFormButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*** TextField를 수정 가능하도록 변경 ***/
				detailNoTextField.setEditable(true);
				detailNameTextField.setEditable(true);
				detailPhoneTextField.setEditable(true);
				detailAddressTextField.setEditable(true);
			}
		});
		updateFormButton.setBounds(142, 264, 97, 23);
		addressDetailPanel.add(updateFormButton);
		/********** 2.AddressService객체생성 **********/
		try {
			addressService = new AddressService();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		/******************************************/
	}// 생성자 끝
	
	/*** 주소록 리스트 보여주기 ***/
	private void displayAddressList() {
		List<Address> addressList;
		try {
			addressList = addressService.addressList();
			Vector<String> columnVector = new Vector<>();
			columnVector.add("번호");
			columnVector.add("이름");
			columnVector.add("전화번호");
			columnVector.add("주소");
			
			Vector tableVector = new Vector();
			for (Address address : addressList) {
				Vector rowVector = new Vector();
				rowVector.add(address.getNo());
				rowVector.add(address.getName());
				rowVector.add(address.getPhone());
				rowVector.add(address.getAddress());
				tableVector.add(rowVector);
			}
			DefaultTableModel tableModel = new DefaultTableModel(tableVector, columnVector);
			addressListTable.setModel(tableModel);
			addressDeleteButton.setEnabled(false);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "호갱님 죄송합니다.");
		}
		
	}
	
	
}//클래스 끝
