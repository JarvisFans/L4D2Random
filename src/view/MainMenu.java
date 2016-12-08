package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 8458974053615331535L;
	
	// 得到显示器屏幕的宽高
	public int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	public int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	// 定义窗体的宽高
	public int windowsWedth = 200;
	public int windowsHeight = 150;

	public MainMenu() {
		super("L4D2随机工具 by Marika");
		// this.setLayout(new FlowLayout());// 设置布局为流式布局
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭窗口关闭程序

		// 设置窗口位置为显示的中心位置
		// this.setLocationRelativeTo(null);

		this.setSize(200, 150);// 设置窗体大小
		this.setResizable(false);// 是否能够改变大小

		// 设置窗体位置和大小
		this.setBounds((width - windowsWedth) / 2, (height - windowsHeight) / 2, windowsWedth, windowsHeight);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		JButton button1 = new JButton("随机队伍");
		JButton button2 = new JButton("随机地图");

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateRollTeam();
				dispose();
			}
		});
		
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateRollMap();
				dispose();
			}
		});

		// 更改JButton大小
		Dimension preferredSize = new Dimension(200, 60);// 设置尺寸
		button1.setPreferredSize(preferredSize);
		button2.setPreferredSize(preferredSize);

		panel.add(button1);
		panel.add(button2);
		this.add(panel);
		this.setVisible(true);// 是否可见
	}

	public static void main(String[] args) {
		new MainMenu();
	}
}
