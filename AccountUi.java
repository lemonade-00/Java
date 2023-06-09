import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;

public class AccountUi extends JFrame {
	private JPanel topPanel;//放 搜尋 那行(部分一)
	private JPanel sequencePanel;//放 更新按鈕 那行(部分二)
	private JPanel outputPanel;//放 資料(部分三)
	private JScrollPane outputScrollPane;//讓outputPanel放
	
	private Label searchLabel;//"your collect:"
	private JLabel picLabel;//資料第一排的文字 pictuer
	private JLabel bookLabel;//資料第一排的文字 book
	private JLabel libraryLabel;//資料第一排的文字 library
	private JLabel buttonLabel;//資料第一排的文字 button
	
	private JButton refreshButton;//更新按鈕
	private JButton clearButton;//清除按鈕
	
	private JTextField searchField;//search收藏的文字(搜尋格)
	
	private JButton mainButton;//切換按鈕
	private JButton searchButton;//搜尋按鈕
	private JButton accountButton;//更改用戶資訊按鈕
	private JButton logoutButton;//登出按鈕
	
	private SearchUi searchUi;//SearchUi 的 ui
	private LoginUi loginUi;
	private ChangeUserInfoUi changeUserInfoUi;//ChangeUserInfoUi 的 ui
	

	public AccountUi(SearchUi searchUi,LoginUi loginUi) {
		// TODO
		super("收藏頁面");
		setLayout(new GridLayout(3,1));//將介面分成三主要部分(FlowLayout()的排版會比較好看些)
		
		this.searchUi = searchUi;
		this.loginUi = loginUi;
		changeUserInfoUi = new ChangeUserInfoUi(this);
		
		mainButton = new JButton("切換至搜尋頁面");
		searchField = new JTextField("input search",20);
		
		searchButton = new JButton("搜尋");
		accountButton = new JButton("更改用戶資訊");
		logoutButton = new JButton("登出");
		
		searchLabel = new Label("你的收藏:                 										");
		
		refreshButton = new JButton("更新");
		clearButton = new JButton("清除");
		
		topPanel = new JPanel();//部分一
		topPanel.setLayout(new FlowLayout());
		topPanel.add(mainButton);
		topPanel.add(searchField);
		topPanel.add(searchButton);
		topPanel.add(accountButton);
		topPanel.add(logoutButton);
		
		sequencePanel = new JPanel();//部分二
		sequencePanel.setLayout(new FlowLayout());
		sequencePanel.add(searchLabel);
		sequencePanel.add(refreshButton);
		sequencePanel.add(clearButton);
		
		
		outputPanel = new JPanel();//部分三
		outputPanel.setLayout(new GridLayout(10,4));//**********************數字需要改成(印出資料數+1,4)************
		picLabel = new JLabel("pictuer");
		bookLabel = new JLabel("book");
		libraryLabel = new JLabel("library");
		buttonLabel = new JLabel("button");
		outputPanel.add(picLabel);
		outputPanel.add(bookLabel);
		outputPanel.add(libraryLabel);
		outputPanel.add(buttonLabel);
		for(int i=0;i<9;i++){
			ImageIcon img = new  ImageIcon("test_pic.png");//test_pic.png為測試 設定圖片
			JLabel pictureInfoLabel = new JLabel();//存照片
			pictureInfoLabel.setIcon(img);
			JLabel bookInfoLabel = new JLabel();//存柏克萊文字
			JLabel libraryInfoLabel = new JLabel();//存圖書館文字
			
			String bookInfo = "<html>"+"書名:"+ "<br>" +"語言:"+"</html>";//設定柏克萊文字輸出
			bookInfoLabel.setText(bookInfo);
			
			String libraryInfo = "<html>"+"書名:"+ "<br>" +"語言:"+"</html>";//設定圖書館文字輸出
			libraryInfoLabel.setText(libraryInfo);
			
			final String name = String.format("%03d", i + 1);//button的命名
            JButton button = new JButton(name);
            button.addActionListener(new ActionListener() {//各個button的監控
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(AccountUi.this,"You click button is " + name);
                }
            });
			outputPanel.add(pictureInfoLabel);
			outputPanel.add(bookInfoLabel);
			outputPanel.add(libraryInfoLabel);
            outputPanel.add(button);
		}
		outputScrollPane = new JScrollPane(outputPanel);
		
		
		add(topPanel);//將三個部分放入JFrame
		add(sequencePanel);
		add(outputScrollPane);
		
		MyEventListner handler = new MyEventListner();//監控 切換按鈕、搜尋按鈕、更改用戶資訊按鈕、登出按鈕、搜尋輸入格、更新按鈕、清除按鈕
		mainButton.addActionListener(handler);
		searchButton.addActionListener(handler);
		accountButton.addActionListener(handler);
		logoutButton.addActionListener(handler);
		refreshButton.addActionListener(handler);
		clearButton.addActionListener(handler);
		searchField.addActionListener(handler);
		
		setResizable(false);//使用者不能調整視窗大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//只要按右上角X就會停止程式
		setSize(1000, 1000);
		setVisible(false);
	}


	private class MyEventListner implements ActionListener {
		// TODO	
		@Override
		public void actionPerformed(ActionEvent event){
			if(event.getSource()==searchButton || event.getSource()==searchField){//搜尋被按或輸入格按enter
				JOptionPane.showMessageDialog(null,"收藏頁面: 搜尋按鈕 or 搜尋格");
			}
			else if(event.getSource()==accountButton){//更改用戶資訊按鈕被按
				JOptionPane.showMessageDialog(null,"收藏頁面: 更改用戶資訊");
				changeUserInfoUi.setVisible(true);//跳出更改用戶資訊畫面
				setVisible(false);//隱藏收藏頁面
			}
			else if(event.getSource()==refreshButton){//更新按鈕被按
				JOptionPane.showMessageDialog(null,"收藏頁面: 更新按鈕");
			}
			else if(event.getSource()==clearButton){//清除按鈕被按
				JOptionPane.showMessageDialog(null,"收藏頁面: 清除按鈕");
			}
			else if(event.getSource()==mainButton){//切換按鈕被按
				JOptionPane.showMessageDialog(null,"收藏頁面: 切換按鈕");
				searchUi.setVisible(true);//跳回搜尋頁面
				setVisible(false);//隱藏收藏頁面
			}
			else if(event.getSource()==logoutButton){//登出按鈕被按
				JOptionPane.showMessageDialog(null,"收藏頁面: 登出按鈕");
				loginUi.setLog_in_or_Not(0);//登出
				searchUi.setVisible(true);//跳回搜尋頁面
				setVisible(false);//隱藏收藏頁面
			}
		}
	}
}
