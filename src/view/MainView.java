package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainView extends JFrame {

	public MainView() {
		this("Standardfenster");
	}
	
	public MainView(String title) {
		this(title, 500, 500);
	}
	
	public MainView(String title, int width, int height) {
		this(title, width, height, true);
	}
	
	public MainView(String title, int width, int height, boolean resizable) {
		this.setTitle(title);	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setResizable(resizable);
		this.setLocationRelativeTo(null);
		
		this.createComponents();

		this.setVisible(true);
	}
	
	private void createComponents() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.add(mainPanel);

		// left panel
		JPanel westPanel = new JPanel(new BorderLayout());
		mainPanel.add(westPanel, BorderLayout.WEST);

		JList<String> accountList = new JList<>();
		westPanel.add(accountList, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel(new GridLayout(1, 0));
		westPanel.add(buttonPanel, BorderLayout.SOUTH);

		JButton addAccountButton = new JButton("Add");
		JButton deleteAccountButton = new JButton("Delete");
		JButton transferButton = new JButton("Transfer");
		buttonPanel.add(addAccountButton);
		buttonPanel.add(deleteAccountButton);
		buttonPanel.add(transferButton);
	}
}
