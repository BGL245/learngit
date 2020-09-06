package snack1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;

import snack.data;

public class gamepanel extends JPanel implements KeyListener,ActionListener {
	
	int length;
	int[] snakex = new int[500];
	int[] snakey = new int[600];
	
	int foodx;
	int foody;
	Random random= new Random();
	
	boolean isStart = false;
	boolean isFail = false;
	
	Timer timer = new Timer(100,this);
	
	String fx = "R";
	
	public gamepanel() {
		init();//初始化
		this.setFocusable(true); //获取焦点事件
        this.addKeyListener(this); //键盘监听事件
        timer.start();
	}
	
	
	public void init() {
		length=3;
		snakex[0]=100;snakey[0]=100;
		snakex[1]=75;snakey[1]=100;
		snakex[2]=50;snakey[2]=100;
		foodx=25+25*random.nextInt(34);
		foody=75+25*random.nextInt(24);
		
	}
	

	//画组件
	public void paintComponent(Graphics g) {
		super.paintComponent(g);//清屏
		this.setBackground(Color.white);//设置背景颜色
		g.fillRect(25, 75, 850, 600);//画矩形
		data.header.paintIcon(this, g, 25, 11);
		
		//画小蛇
		//蛇头
		if(fx.equals("R")) {
			data.right.paintIcon(this, g, snakex[0], snakey[0]);
		}else if(fx.equals("U")) {
			data.up.paintIcon(this, g, snakex[0], snakey[0]);
		}else if(fx.equals("D")) {
			data.down.paintIcon(this, g, snakex[0], snakey[0]);
		}else if(fx.equals("L")) {
			data.left.paintIcon(this, g, snakex[0], snakey[0]);
		}
		//蛇体
		for(int i=1;i<length;i++) {
			data.body.paintIcon(this, g, snakex[i], snakey[i]);
		}
		
		data.food.paintIcon(this, g, foodx, foody);
		
		
		//游戏开始
		if (isStart==false){
            g.setColor(Color.white);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格开始游戏!",300,300);
        }
        //失败判断
        if (isFail){
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("失败, 按下空格重新开始",200,300);
        }

		
		
	}

	//键盘监听
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keycode = e.getKeyCode();
		//空格暂停开始
		if(keycode == KeyEvent.VK_SPACE) {
			if(isFail) {
				isFail= false;
				init();
			}else{
				isStart = !isStart;
			}
			repaint();
		}
		//方向
		if(keycode == KeyEvent.VK_RIGHT) {
			fx="R";
		}else if (keycode == KeyEvent.VK_UP) {
			fx="U";
		}else if (keycode == KeyEvent.VK_DOWN) {
			fx="D";
		}else if (keycode == KeyEvent.VK_LEFT) {
			fx="L";
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(isStart && isFail == false){
			//身体移动，移到前一个的位置即可
			for(int i = length-1;i>0;i--) {
				snakex[i]=snakex[i-1];
				snakey[i]=snakey[i-1];
			}
			if (fx.equals("R")){
                snakex[0] = snakex[0]+25;
                if (snakex[0]>850) snakex[0] = 25;
            }else if (fx.equals("L")){
                snakex[0] = snakex[0]-25;
                if (snakex[0]<25) snakex[0] = 850;
            }else if (fx.equals("U")){
                snakey[0] = snakey[0]-25;
                if (snakey[0]<75) snakey[0] = 650;
            }else if (fx.equals("D")){
                snakey[0] = snakey[0]+25;
                if (snakey[0]>650) snakey[0] = 75;
            }
			
			if(snakex[0]==foodx && snakey[0]==foody) {
				length++;
				foodx = 25 + 25* random.nextInt(34);
                foody = 75 + 25* random.nextInt(24);
			}
			
			for(int i=1;i<length;i++) {
				if(snakex[0] == snakex[i] && snakey[0] == snakey[i]) {
					isFail = true;
				}
			}
			
			repaint();
		}
		timer.start();
	}
}
