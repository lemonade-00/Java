import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RegisterUi extends JFrame {
	private int log_in_or_Not;
	
	private JPanel topPanel;
	private JPanel accountPanel;
	private JPanel passwordPanel;
	private JPanel confirmPanel;
	
	private JTextField accountField;
	private JPasswordField passwordField;
	
	private JLabel loginLabel;
	private JLabel accountLabel;
	private JLabel passwordLabel;

	private JButton confirmButton;
	
	private LoginUi loginUi;

	public RegisterUi(LoginUi loginUi) {
		// TODO
		super("Register ui test");
		setLayout(new GridLayout(6,1));//將介面分成四主要部分(GridLayout(6,1)排版比較好看)
		
		this.loginUi = loginUi;
		
		loginLabel = new JLabel("Register");
		
		accountLabel = new JLabel("account:");
		accountField = new JTextField(20);
		passwordLabel = new JLabel("password:");
		passwordField = new JPasswordField(20);
		
		confirmButton = new JButton("confirm");
		
		topPanel = new JPanel();//部分一
		topPanel.add(loginLabel);
		
		accountPanel = new JPanel();//部分二
		accountPanel.add(accountLabel);
		accountPanel.add(accountField);
		
		passwordPanel = new JPanel();//部分三
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordField);
		
		confirmPanel = new JPanel();//部份四
		confirmPanel.add(confirmButton);
		
		add(topPanel);//將四個部分放入JFrame
		add(accountPanel);
		add(passwordPanel);
		add(confirmPanel);
		
		MyEventListner handler = new MyEventListner();//監控 確認按鈕、密碼輸入格
		passwordField.addActionListener(handler);
		confirmButton.addActionListener(handler);
		
		setResizable(false);//使用者不能調整視窗大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//只要按右上角X就會停止程式
		setSize(400, 400);
		setVisible(false);
	}


	private class MyEventListner implements ActionListener {
		// TODO	
		@Override
		public void actionPerformed(ActionEvent event){//確認按鈕被按或密碼格按enter
			JOptionPane.showMessageDialog(null,"register: confirm");
			
			
			
			setVisible(false);//隱藏登入頁面
			loginUi.setVisible(true);//跳回搜尋頁面
		}
	}
}
