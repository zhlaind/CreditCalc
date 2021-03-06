package com.nezcafe.calc;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Color;

public class CreditCalcWithWB {

	private JFrame frame;
	private JLabel amountLb;
	private JLabel procentLb;
	private JTextField procentText;
	private JTextField timeText;
	private JPanel actionPanel;
	private JLabel resultLb;
	private JLabel result2Lb;
	private JTextArea resultField;
	private JLabel errorLbl;
	private JToggleButton toggleButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreditCalcWithWB window = new CreditCalcWithWB();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreditCalcWithWB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.setTitle(
				"\u041A\u0440\u0435\u0434\u0438\u0442\u043D\u044B\u0439 \u043A\u0430\u043B\u044C\u043A\u0443\u043B\u044F\u0442\u043E\u0440 V2.0");
		frame.setBounds(100, 100, 362, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		actionPanel = new JPanel();

		actionPanel.setBounds(0, 0, 356, 172);
		frame.getContentPane().add(actionPanel);
		actionPanel.setLayout(null);

		amountLb = new JLabel("\u0421\u0443\u043C\u043C\u0430 \u041A\u0440\u0435\u0434\u0438\u0442\u0430");
		amountLb.setBounds(28, 8, 150, 20);
		actionPanel.add(amountLb);

		JTextField amountText = new JTextField();

		amountText.setBounds(173, 8, 150, 20);
		actionPanel.add(amountText);
		amountText.setColumns(10);

		procentLb = new JLabel(
				"\u041F\u0440\u043E\u0446\u0435\u043D\u0442\u043D\u0430\u044F \u0441\u0442\u0430\u0432\u043A\u0430");
		procentLb.setBounds(28, 39, 135, 20);
		actionPanel.add(procentLb);

		procentText = new JTextField();

		procentText.setBounds(173, 39, 150, 20);
		actionPanel.add(procentText);
		procentText.setColumns(10);

		JLabel timeLb = new JLabel(
				"\u041A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u043C\u0435\u0441\u044F\u0446\u0435\u0432");
		timeLb.setBounds(28, 71, 135, 20);
		actionPanel.add(timeLb);

		timeText = new JTextField();

		timeText.setBounds(173, 71, 150, 20);
		actionPanel.add(timeText);
		timeText.setColumns(10);

		JButton resultButton = new JButton("\u0420\u0430\u0441\u0441\u0447\u0438\u0442\u0430\u0442\u044C");
		resultButton.setBounds(10, 141, 105, 20);
		actionPanel.add(resultButton);
		
		JButton clearButton = new JButton("\u041E\u0447\u0438\u0441\u0442\u0438\u0442\u044C");
		clearButton.setBounds(126, 141, 105, 20);
		actionPanel.add(clearButton);
				clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				amountText.setText("");
				procentText.setText("");
				timeText.setText("");
				resultField.setText("");
				errorLbl.setVisible(false);
				toggleButton.setEnabled(false);
				result2Lb.setText("");
				if (frame.getHeight() > 200)
					frame.setSize(362, 200);
				
			}
		});
		
		toggleButton = new JToggleButton("\u0421\u043F\u0438\u0441\u043E\u043A");
		toggleButton.setEnabled(false);
		toggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frame.getHeight() < 420)
					frame.setSize(362, 420);
				else
					frame.setSize(362, 200);
			}
		});

		toggleButton.setBounds(241, 141, 105, 20);
		actionPanel.add(toggleButton);

		resultLb = new JLabel("\u041C\u0435\u0441\u044F\u0447\u043D\u044B\u0439 \u043A\u0440\u0435\u0434\u0438\u0442:");
		resultLb.setBounds(28, 102, 135, 20);
		actionPanel.add(resultLb);

		result2Lb = new JLabel("");
		result2Lb.setBounds(173, 102, 105, 20);
		actionPanel.add(result2Lb);
		
		errorLbl = new JLabel("\u041D\u0435 \u0432\u0441\u0435 \u0434\u0430\u043D\u043D\u044B\u0435 \u043A\u043E\u0440\u0440\u0435\u043A\u0442\u043D\u044B \u0438\u043B\u0438 \u0432\u0432\u0435\u0434\u0435\u043D\u044B!");
		errorLbl.setForeground(Color.RED);
		errorLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		errorLbl.setBounds(28, 121, 295, 14);
		errorLbl.setVisible(false);
		actionPanel.add(errorLbl);

		JPanel secondPanel = new JPanel();
		secondPanel.setBounds(10, 173, 336, 209);
		frame.getContentPane().add(secondPanel);
		secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.X_AXIS));

		resultField = new JTextArea();
		resultField.setEditable(false);
		secondPanel.add(resultField);

		JScrollPane scrollPane = new JScrollPane(resultField);
		secondPanel.add(scrollPane, BorderLayout.CENTER);

		resultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int amount = Integer.parseInt(amountText.getText());
					double procent = Double.parseDouble(procentText.getText());
					int time = Integer.parseInt(timeText.getText());

					resultField.setText("");
					ArrayList<Double> list = new ArrayList<Double>();

					Resulting result = new Resulting(amount, time, procent);
					result2Lb.setText("" + NumberFormat.getCurrencyInstance().format(result.getMontlyPayment()));
					
					toggleButton.setEnabled(true);
					errorLbl.setVisible(false);

					list = result.getMonthsArray();

					for (int i = 0; i < list.size(); i++) {
						resultField.setText(resultField.getText() + (i + 1) + " \u043c\u0435\u0441\u044f\u0446: "
								+ NumberFormat.getCurrencyInstance().format(list.get(i)) + "\n");
					}
				} catch (Exception e) {
					errorLbl.setVisible(true);
				}

			}
		});
	}
}
