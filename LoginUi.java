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


public class LoginUi extends JFrame {
	private int log_in_or_Not;//是否登入的判斷 否:0 是:1
	
	private JPanel topPanel;//放 "登入" 那行(部分一)
	private JPanel accountPanel;//放 "帳號:" 那行(部分二)
	private JPanel passwordPanel;//放 "密碼:" 那行(部份三)
	private JPanel confirmPanel;//放 confirmButton 那行(部份四)
	private JPanel registerPanel;//放 registerButton 那行(部份五)
	
	private JTextField accountField;//帳號輸入格
	private JPasswordField passwordField;//密碼輸入格
	
	private JLabel loginLabel;//放 "登入"
	private JLabel accountLabel;//放 "帳號:"
	private JLabel passwordLabel;//放 "密碼:"

	private JButton confirmButton;//確認按鈕
	private JButton registerButton;//註冊按鈕
	
	private SearchUi searchUi;//SearchUi 的 ui
	private RegisterUi registerUi;//RegisterUi 的 ui

	public LoginUi(SearchUi searchUi) {
		// TODO
		super("登入頁面");
		setLayout(new GridLayout(6,1));//將介面分成四主要部分(GridLayout(6,1)排版比較好看)
		
		this.searchUi = searchUi;
		registerUi = new RegisterUi(this);//註冊頁面
		this.log_in_or_Not = 0;//未登入:0 已登入:1
		
		loginLabel = new JLabel("登入");
		
		accountLabel = new JLabel("帳號:");
		accountField = new JTextField(20);
		passwordLabel = new JLabel("密碼:");
		passwordField = new JPasswordField(20);
		
		confirmButton = new JButton("確認");
		registerButton = new JButton("註冊");
		
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
		
		registerPanel = new JPanel();//部份五
		registerPanel.add(registerButton);
		
		add(topPanel);//將四個部分放入JFrame
		add(accountPanel);
		add(passwordPanel);
		add(confirmPanel);
		add(registerPanel);
		
		MyEventListner handler = new MyEventListner();//監控 確認按鈕、密碼輸入格、註冊按鈕
		passwordField.addActionListener(handler);
		confirmButton.addActionListener(handler);
		registerButton.addActionListener(handler);
		
		setResizable(false);//使用者不能調整視窗大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//只要按右上角X就會停止程式
		setSize(400, 400);
		setVisible(false);
	}


	private class MyEventListner implements ActionListener {
		// TODO	
		@Override
		public void actionPerformed(ActionEvent event){//確認按鈕被按或密碼格按enter
			if(event.getSource()==confirmButton){
				JOptionPane.showMessageDialog(null,"登入頁面: 確認按鈕");
			
				setLog_in_or_Not(1);//假設已登入
			
				setVisible(false);//隱藏登入頁面
				searchUi.setVisible(true);//跳回搜尋頁面
			}
			else if(event.getSource()==registerButton){
				JOptionPane.showMessageDialog(null,"登入頁面: 註冊按鈕");
				setVisible(false);//隱藏登入頁面
				registerUi.setVisible(true);//跳出註冊畫面
			}
		}
	}
	
	public void setLog_in_or_Not(int num){
		this.log_in_or_Not = num;
	}
	
	public int getLog_in_or_Not(){
		return this.log_in_or_Not;
	}
}
