package view;

import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import random.Random;
import random.RandomImp;

public class CreateRollTeam extends JFrame {

	private static final long serialVersionUID = -500848879617409188L;

	public CreateRollTeam() {
		// this.setLayout(new FlowLayout());
		this.setTitle("L4D2随机队伍  By Marika");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭窗口关闭程序
		this.setLocationRelativeTo(null);// 设置窗口位置为显示的中心位置
		// this.setResizable(false);// 是否能够改变大小
		JPanel jp = new JPanel();
		jp.setSize(500, 500);
		jp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));

		JLabel jl = new JLabel("请输入复数玩家的名字");
		jp.add(jl);
		List<TextField> list = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			list.add(new TextField(50));
			jp.add(list.get(i));
		}

		JButton submit = new JButton("随机队伍");
		JButton main = new JButton("主菜单");
		
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> list2 = new ArrayList<>();

				for (int i = 0; i < 8; i++) {
					if (list.get(i).getText().length() == 0) {

					} else
						list2.add(list.get(i).getText());
				}
				int len = list2.size();
				Random random = new RandomImp();
				random.SortTeam(list2);
				/*
				 * for(String l:list2) System.out.print(l+" ");
				 * System.out.println();
				 */
				JFrame jf2 = new JFrame("分队结果");
				jf2.setLayout(new FlowLayout());
				JPanel jp2 = new JPanel();
				JPanel jp3 = new JPanel();
				JPanel jp4 = new JPanel();

				StringBuffer survivor = new StringBuffer();
				StringBuffer infected = new StringBuffer();
				survivor.append("<html>" + "生还者" + "<br/>");
				infected.append("<html>" + "感染者" + "<br/>");
				// jp2.add(new JLabel("生还者"));
				// jp4.add(new JLabel("感染者"));

				ImageIcon ii = new ImageIcon("image/vs.jpg");
				JLabel lb = new JLabel(ii);
				lb.setSize(157, 150);
				jp3.add(lb);

				for (int i = 0; i < len / 2; i++) {
					// jp2.add(new JLabel(list2.get(i)));
					// jp3.add(new JLabel(list2.get(len - 1 - i)));
					survivor.append(list2.get(i) + "<br/>");
					infected.append(list2.get(len - 1 - i) + "<br/>");
				}
				survivor.append("</html>");
				infected.append("</html>");
				// System.out.println(survivor.toString());
				// System.out.println(infected.toString());
				jp2.add(new JLabel(survivor.toString()));
				jp4.add(new JLabel(infected.toString()));

				jp2.setSize(80, 100);
				jp3.setSize(157, 150);
				jp4.setSize(80, 100);
				jf2.setSize(400, 200);

				jf2.add(jp2);
				jf2.add(jp3);
				jf2.add(jp4);

				jf2.setLocationRelativeTo(null);
				jf2.setVisible(true);
			}

		});
		jp.add(submit);
		jp.add(main);
		this.add(jp);
		this.setVisible(true);
		
		main.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainMenu();
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		new CreateRollTeam();
	}
}
