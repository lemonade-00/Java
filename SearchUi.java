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
import javax.swing.UIManager;//
import javax.swing.table.DefaultTableModel;//
import javax.swing.table.TableCellRenderer;//
import javax.swing.DefaultCellEditor;//
import javax.swing.JTable;//
import javax.swing.JCheckBox;//
import java.awt.Dimension;//
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Component;//


public class SearchUi extends JFrame {
	private JPanel topPanel;//放 搜尋 那行(部分一)
	private JPanel sequencePanel;//放 排序 那行(部分二)
	private JPanel sequencePanel2;//放 排序 第二行(部分三)
	//private JPanel outputPanel;//放 資料(部分四)
	private JScrollPane outputScrollPane;//讓outputPanel放
	private JTable ouyputTable;//放 資料(部分四)
	
	private Label searchLabel;
	//private JLabel picLabel;//資料第一排的文字 pictuer
	//private JLabel bookLabel;//資料第一排的文字 book
	//private JLabel libraryLabel;//資料第一排的文字 library
	//private JLabel buttonLabel;//資料第一排的文字 button
	
	private ButtonGroup searchOptions;//排序方式的按鈕組
	private JRadioButton search1;//排序方式一
	private JRadioButton search2;//排序方式二
	private JRadioButton search3;//排序方式三
	
	private ButtonGroup searchOptions2;
	private JRadioButton button1;
	private JRadioButton button2;
	private JRadioButton button3;
	
	private JTextField searchField;//search柏克萊的文字(搜尋格)
	
	private JButton mainButton;//切換按鈕
	private JButton searchButton;//搜尋按鈕
	private JButton accountButton;//帳戶按鈕
	
	private LoginUi loginUi;//LoginUi 的 ui
	private AccountUi accountUi;//AccountUi 的 ui

	public SearchUi() {
		// TODO
		super("搜尋頁面");//標題
		FlowLayout layout = new FlowLayout();
		layout.setHgap(1000);
		setLayout(layout);//GridLayout(4,1)將介面分成三主要部分(FlowLayout()的排版會比較好看些)
		
		loginUi = new LoginUi(this);//創建登入跟帳戶的介面
		accountUi = new AccountUi(this,loginUi);
		
		mainButton = new JButton("切換至收藏頁面");
		searchField = new JTextField("input search",20);
		
		searchButton = new JButton("搜尋");
		
		accountButton = new JButton("帳戶");
		
		searchLabel = new Label("你的搜尋:                 										");
		
		search1 = new JRadioButton("search1",true);//選擇排序方式的按鈕
		search2 = new JRadioButton("search2",false);
		search3 = new JRadioButton("search3",false);
		searchOptions = new ButtonGroup();
		searchOptions.add(search1);
		searchOptions.add(search2);
		searchOptions.add(search3);
		
		button1 = new JRadioButton("button1",true);//選擇排序方式的按鈕
		button2 = new JRadioButton("button2",false);
		button3 = new JRadioButton("button3",false);
		searchOptions = new ButtonGroup();
		searchOptions.add(button1);
		searchOptions.add(button2);
		searchOptions.add(button3);
		
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
		
		sequencePanel2 = new JPanel();//部份三
		sequencePanel2.setLayout(new FlowLayout());
		sequencePanel2.add(button1);
		sequencePanel2.add(button2);
		sequencePanel2.add(button3);
		
		/*
		outputPanel = new JPanel();//部分四
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
		*/
		Object[][] data={
		{"Kelly","Female","Button1"},
		{"Peter","Male","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Amy","Female","Button1"},
		{"Tony","Male","Button1"}};
		String[] columns={"column1","column2","Button"};
		JTable ouyputTable=new JTable(data,columns);
		ouyputTable.getColumn("Button").setCellRenderer(new ButtonRenderer());
        ouyputTable.getColumn("Button").setCellEditor(new ButtonEditor(new JCheckBox()));
		ouyputTable.setPreferredScrollableViewportSize(new Dimension(400,300));
		outputScrollPane = new JScrollPane(ouyputTable);
		
		add(topPanel);//將四個部分放入JFrame
		add(sequencePanel);
		add(sequencePanel2);
		add(outputScrollPane);
		
		MyEventListner handler = new MyEventListner();//監控 回搜尋頁按鈕、搜尋按鈕、帳戶按鈕、搜尋輸入格
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
				JOptionPane.showMessageDialog(null,"搜尋頁面: 搜尋按鈕 or 搜尋格");
			}
			else if(event.getSource()==accountButton){//帳戶按鈕被按
				JOptionPane.showMessageDialog(null,"搜尋頁面: 帳戶按鈕");
				if(loginUi.getLog_in_or_Not()== 0){//未登入
					loginUi.setVisible(true);//跳出登入畫面
				}
				else{
					accountUi.setVisible(true);//跳出修改帳戶頁面
				}
				setVisible(false);//隱藏搜尋頁面
			}
			else if(event.getSource()==mainButton){//切換按鈕
				JOptionPane.showMessageDialog(null,"搜尋頁面: 切換按鈕");
				if(loginUi.getLog_in_or_Not()== 0){//未登入
					loginUi.setVisible(true);//跳出登入畫面
					JOptionPane.showMessageDialog(null,"請先登入");
				}
				else{
					accountUi.setVisible(true);//跳出收藏頁面
				}
				setVisible(false);//隱藏搜尋頁面
			}
		}
	}
	
	class ButtonRenderer extends JButton implements TableCellRenderer {

		public ButtonRenderer() {
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) {
			if (isSelected) {
				setForeground(table.getSelectionForeground());
				setBackground(table.getSelectionBackground());
			} else {
				setForeground(table.getForeground());
				setBackground(UIManager.getColor("Button.background"));
			}
			setText((value == null) ? "" : value.toString());//設定ButtonRenderer名稱
			return this;
		}
	}
	
	class ButtonEditor extends DefaultCellEditor {

		protected JButton button;
		private String label;
		private boolean isPushed;

		public ButtonEditor(JCheckBox checkBox) {
			super(checkBox);
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();//他把button要做的事寫在另一個地方，所以要寫這個讓listener做事
				}
			});
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value,
				boolean isSelected, int row, int column) {
			if (isSelected) {
				button.setForeground(table.getSelectionForeground());
				button.setBackground(table.getSelectionBackground());
			} else {
				button.setForeground(table.getForeground());
				button.setBackground(table.getBackground());
			}
			label = (value == null) ? "" : value.toString();//設定button名稱
			button.setText(label);
			isPushed = true;
			return button;
		}

		@Override
		public Object getCellEditorValue() {
			if (isPushed) {
				JOptionPane.showMessageDialog(button, label + ": Ouch!");//按鈕做的事
			}
			isPushed = false;
			return label;
		}

		@Override
		public boolean stopCellEditing() {
			isPushed = false;
			return super.stopCellEditing();
		}
	}
}
