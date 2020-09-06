package snack;

import java.net.*;

import javax.swing.*;

public class data {
	
	//相对路径
	//绝对路径 加/
	public static URL headerURL = data.class.getResource("static/header.png");
	public static ImageIcon header = new ImageIcon(headerURL);
	
	public static URL upURL = data.class.getResource("static/up.png");
	public static ImageIcon up = new ImageIcon(upURL);
	
	public static URL leftURL = data.class.getResource("static/left.png");
	public static ImageIcon left = new ImageIcon(leftURL);
	
	public static URL rightURL = data.class.getResource("static/right.png");
	public static ImageIcon right = new ImageIcon(rightURL);
	
	public static URL downURL = data.class.getResource("static/down.png");
	public static ImageIcon down = new ImageIcon(downURL);
	
	
	public static URL bodyURL = data.class.getResource("static/body.png");
	public static ImageIcon body = new ImageIcon(bodyURL);
	
	public static URL foodURL = data.class.getResource("static/food.png");
	public static ImageIcon food = new ImageIcon(foodURL);
	
	
}
