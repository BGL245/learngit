package snack1;

import javax.swing.*;

public class startgame1 {
	public static void main (String[] args) {
		JFrame jframe = new JFrame();
		//设置窗口大小
		jframe.setBounds(100, 100, 900,720);
		//设置窗口可关闭
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口不可调整
		jframe.setResizable(false);
		
		jframe.add(new gamepanel());
		
		//设置窗口可见
		jframe.setVisible(true);
		
	}
}
