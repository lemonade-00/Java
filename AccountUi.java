import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;

public class AccountUi extends JFrame {
	private JPanel topPanel;
	private JPanel sequencePanel;
	private JScrollPane outputPanel;
	
	private Label searchLabel;
	
	private JButton refreshButton;
	private JButton clearButton;
	
	private JTextField searchField;
	
	private JButton mainButton;
	private JButton searchButton;
	private JButton accountButton;
	
	private SearchUi searchUi;

	public AccountUi(SearchUi searchUi) {
		// TODO
		super("account ui test");
		setLayout(new GridLayout(3,1));//將介面分成三主要部分(FlowLayout()的排版會比較好看些)
		
		this.searchUi = searchUi;
		
		mainButton = new JButton("main");
		searchField = new JTextField("input search",20);
		
		searchButton = new JButton("search");
		
		accountButton = new JButton("account");
		
		searchLabel = new Label("your collect:                 										");
		
		refreshButton = new JButton("refresh");
		clearButton = new JButton("clear");
		
		topPanel = new JPanel();//部分一
		topPanel.setLayout(new FlowLayout());
		topPanel.add(mainButton);
		topPanel.add(searchField);
		topPanel.add(searchButton);
		topPanel.add(accountButton);
		
		sequencePanel = new JPanel();//部分二
		sequencePanel.setLayout(new FlowLayout());
		sequencePanel.add(searchLabel);
		sequencePanel.add(refreshButton);
		sequencePanel.add(clearButton);
		
		
		outputPanel = new JScrollPane();//部分三(未完成)
		
		
		
		add(topPanel);//將三個部分放入JFrame
		add(sequencePanel);
		add(outputPanel);
		
		MyEventListner handler = new MyEventListner();//監控 回搜尋頁面按鈕、搜尋按鈕、帳戶按鈕、搜尋輸入格、更新按鈕、清除按鈕
		mainButton.addActionListener(handler);
		searchButton.addActionListener(handler);
		accountButton.addActionListener(handler);
		refreshButton.addActionListener(handler);
		clearButton.addActionListener(handler);
		searchField.addActionListener(handler);
		
		setResizable(false);//使用者不能調整視窗大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//只要按右上角X就會停止程式
		setSize(500, 500);
		setVisible(false);
	}


	private class MyEventListner implements ActionListener {
		// TODO	
		@Override
		public void actionPerformed(ActionEvent event){
			if(event.getSource()==searchButton || event.getSource()==searchField){//搜尋被按或輸入格按enter
				JOptionPane.showMessageDialog(null,"accountUi: search");
			}
			else if(event.getSource()==accountButton){//這按鈕好像沒要做的事
				JOptionPane.showMessageDialog(null,"accountUi: account");
			}
			else if(event.getSource()==refreshButton){//更新按鈕被按
				JOptionPane.showMessageDialog(null,"accountUi: refresh");
			}
			else if(event.getSource()==clearButton){//清除按鈕被按
				JOptionPane.showMessageDialog(null,"accountUi: clear");
			}
			else if(event.getSource()==mainButton){
				JOptionPane.showMessageDialog(null,"accountUi: main");
				searchUi.setVisible(true);//跳回搜尋頁面
				setVisible(false);//隱藏收藏頁面
			}
		}
	}
}
