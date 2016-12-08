package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import random.Random;
import random.RandomImp;

public class CreateRollMap extends JFrame {

	private static final long serialVersionUID = -8280215387545056538L;

	public CreateRollMap() {
		this.setTitle("L4D2随机地图  By Marika");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭窗口关闭程序
		this.setLocationRelativeTo(null);// 设置窗口位置为显示的中心位置

		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(5, 3));
		List<JCheckBox> list = new ArrayList<>();
		list.add(new JCheckBox("死亡中心", true));
		list.add(new JCheckBox("黑色嘉年华", true));
		list.add(new JCheckBox("沼泽激战", true));
		list.add(new JCheckBox("暴风骤雨", true));
		list.add(new JCheckBox("教区", true));
		list.add(new JCheckBox("短暂时刻", false));
		list.add(new JCheckBox("牺牲", false));
		list.add(new JCheckBox("毫不留情", true));
		list.add(new JCheckBox("坠机险途", false));
		list.add(new JCheckBox("死亡丧钟", true));
		list.add(new JCheckBox("静寂时分", true));
		list.add(new JCheckBox("血腥收获", true));
		list.add(new JCheckBox("刺骨寒溪", false));

		for (int i = 0; i < list.size(); i++) {
			jp.add(list.get(i));
		}

		
		JButton submit = new JButton("随机地图");
		JButton main = new JButton("主菜单");
				
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> list2 = new ArrayList<>();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).isSelected()) {
						list2.add(list.get(i).getText());
					}
				}
				if (list2.size() == 0) {
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null, "你确定什么图都不选？", "随机地图结果", JOptionPane.PLAIN_MESSAGE);
				} else {
					Random rd = new RandomImp();
					String result = rd.SelectMap(list2);
					JFrame jf = new JFrame("随机地图结果:");
					jf.add(new JLabel("比赛地图" + result));
					jf.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
					jf.setSize(300, 100);
					jf.setLocationRelativeTo(null);
					jf.setVisible(true);
				}
			}
		});
		
		main.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainMenu();
				dispose();
			}
		});
		
		jp.add(submit);
		jp.add(main);
		jp.setSize(400, 380);
		
		this.add(jp);
		this.setVisible(true);

	}
}
