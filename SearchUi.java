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

public class SearchUi extends JFrame {
	private JPanel topPanel;
	private JPanel sequencePanel;
	private JPanel outputPanel;
	private JScrollPane outputScrollPane;
	
	private Label searchLabel;
	private JLabel picLabel;
	private JLabel bookLabel;
	private JLabel libraryLabel;
	private JLabel buttonLabel;
	
	private ButtonGroup searchOptions;
	private JRadioButton search1;
	private JRadioButton search2;
	private JRadioButton search3;
	
	private JTextField searchField;
	
	private JButton mainButton;
	private JButton searchButton;
	private JButton accountButton;
	
	private LoginUi loginUi;
	private AccountUi accountUi;

	public SearchUi() {
		// TODO
		super("search ui test");//標題
		setLayout(new GridLayout(3,1));//將介面分成三主要部分(FlowLayout()的排版會比較好看些)
		
		loginUi = new LoginUi(this);//創建登入跟帳戶的介面
		accountUi = new AccountUi(this);
		
		mainButton = new JButton("main");
		searchField = new JTextField("input search",20);
		
		searchButton = new JButton("search");
		
		accountButton = new JButton("account");
		
		searchLabel = new Label("your search:                 										");
		
		search1 = new JRadioButton("search1",true);//選擇排序方式的按鈕
		search2 = new JRadioButton("search2",false);
		search3 = new JRadioButton("search3",false);
		searchOptions = new ButtonGroup();
		searchOptions.add(search1);
		searchOptions.add(search2);
		searchOptions.add(search3);
		
		topPanel = new JPanel();//部分一
		topPanel.setLayout(new FlowLayout());
		topPanel.add(mainButton);
		topPanel.add(searchField);
		topPanel.add(searchButton);
		topPanel.add(accountButton);
		
		sequencePanel = new JPanel();//部分二
		sequencePanel.setLayout(new FlowLayout());
		sequencePanel.add(searchLabel);
		sequencePanel.add(search1);
		sequencePanel.add(search2);
		sequencePanel.add(search3);
		
		
		outputPanel = new JPanel();//部分三(未完成)
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
                    JOptionPane.showMessageDialog(SearchUi.this,"You click button is " + name);
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
		
		MyEventListner handler = new MyEventListner();//監控 搜尋按鈕、帳戶按鈕、搜尋輸入格
		mainButton.addActionListener(handler);
		searchButton.addActionListener(handler);
		accountButton.addActionListener(handler);
		searchField.addActionListener(handler);
		
		setResizable(false);//使用者不能調整視窗大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//只要按右上角X就會停止程式
		setSize(1000, 1000);
		setVisible(true);
	}

	private class MyEventListner implements ActionListener {
		// TODO	
		@Override
		public void actionPerformed(ActionEvent event){
			if(event.getSource()==searchField || event.getSource()==searchButton){//搜尋被按或輸入格按enter
				JOptionPane.showMessageDialog(null,"searchUi: search");
			}
			else if(event.getSource()==accountButton){//帳戶按鈕被按
				JOptionPane.showMessageDialog(null,"searchUi: account");
				if(loginUi.getLog_in_or_Not()== 0){//未登入
					loginUi.setVisible(true);//跳出登入畫面
				}
				else{
					accountUi.setVisible(true);//跳出收藏頁面
				}
				setVisible(false);//隱藏搜尋頁面
			}
			else if(event.getSource()==mainButton){
				JOptionPane.showMessageDialog(null,"searchUi: main");
			}
		}
	}
}
