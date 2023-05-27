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


public class ChangeUserInfoUi extends JFrame {
	private JPanel topPanel;//放 "更改用戶資訊" 那行(部分一)
	private JPanel accountPanel;//放 "帳號:" 那行(部分二)
	private JPanel passwordPanel;//放 "密碼:" 那行(部份三)
	private JPanel emailPanel;//放 "email:" 那行(部分四)
	private JPanel confirmPanel;//放 confirmButton 那行(部份五)
	
	private JTextField accountField;//帳號輸入格
	private JTextField passwordField;//密碼輸入格
	private JTextField emailField;//email輸入格
	
	private JLabel loginLabel;//放 "更改用戶資訊"
	private JLabel accountLabel;//放 "帳號:"
	private JLabel passwordLabel;//放 "密碼:"
	private JLabel emailLabel;//放 "email:"

	private JButton confirmButton;//確認按鈕
	
	private AccountUi accountUi;//AccountUi 的 ui

	public ChangeUserInfoUi(AccountUi accountUi) {
		// TODO
		super("更改用戶資訊頁面");
		setLayout(new GridLayout(6,1));//將介面分成四主要部分(GridLayout(6,1)排版比較好看)
		
		this.accountUi = accountUi;
		
		loginLabel = new JLabel("更改用戶資訊");
		
		accountLabel = new JLabel("帳號:");
		accountField = new JTextField(20);
		passwordLabel = new JLabel("密碼:");
		passwordField = new JTextField(20);
		emailLabel = new JLabel("email:");
		emailField = new JTextField(20);
		
		confirmButton = new JButton("確認");
		
		topPanel = new JPanel();//部分一
		topPanel.add(loginLabel);
		
		accountPanel = new JPanel();//部分二
		accountPanel.add(accountLabel);
		accountPanel.add(accountField);
		
		passwordPanel = new JPanel();//部分三
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordField);
		
		emailPanel = new JPanel();//部分四
		emailPanel.add(emailLabel);
		emailPanel.add(emailField);
		
		confirmPanel = new JPanel();//部份五
		confirmPanel.add(confirmButton);
		
		add(topPanel);//將五個部分放入JFrame
		add(accountPanel);
		add(passwordPanel);
		add(emailPanel);
		add(confirmPanel);
		
		MyEventListner handler = new MyEventListner();//監控 確認按鈕、email輸入格
		emailField.addActionListener(handler);
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
			JOptionPane.showMessageDialog(null,"更改用戶資訊頁面: 確認按鈕");
			
			
			
			setVisible(false);//隱藏更改用戶資訊頁面
			accountUi.setVisible(true);//跳回收藏頁面
		}
	}
}
