import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class myFrame extends JFrame implements ActionListener
{
	private int height;   //change in height
	private int width;    //change in width
	private JButton button;
	
	public myFrame()
	{
		height = 0;
		width = 0;
		setBounds(100,100,800,600);
		setLayout(null);
		
		button = new JButton("Button");
		button.setSize(100,50);
		button.setLocation(getWidth()/2 - button.getWidth()/2, getHeight()/2 - button.getHeight()/2);    //centers the button
		add(button);
		
		Timer t1 = new Timer(100, this); //100 = 100miliseconds (time), "this" refers to the actionListener
											//every 100 milliseconds, will ping whatever method is in the actionListener
											//every 100ms, my actionPerformed method will run
		t1.start();
		setFocusable(true);
		
		this.addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e) 
			{
				if (e.getKeyCode() == e.VK_UP)
				{
					height = 5;
				}	
				else if (e.getKeyCode() == e.VK_DOWN)
				{
					height = -5;
				}
				if (e.getKeyCode() == e.VK_RIGHT)
				{
					width = 5;
				}	
				else if (e.getKeyCode() == e.VK_LEFT)
				{
					width = -5;
				}
			}
			@Override
			public void keyReleased(KeyEvent e) //0 so that size only increases when clicked
			{
				if (e.getKeyCode() == e.VK_UP)
				{
					height = 0;
				}	
				else if (e.getKeyCode() == e.VK_DOWN)
				{
					height = 0;
				}
				if (e.getKeyCode() == e.VK_RIGHT)
				{
					width = 0;
				}	
				else if (e.getKeyCode() == e.VK_LEFT)
				{
					width = 0;
				}
				
			}
			@Override
			public void keyTyped(KeyEvent arg0) 
			{
				// TODO Auto-generated method stub
				
			}
			
		});
		
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		button.setSize(button.getWidth() + width, button.getHeight() + height);
		button.setLocation(getWidth()/2 - button.getWidth()/2, getHeight()/2 - button.getHeight()/2);  //re-centers the button
		repaint();
	}
	
	public static void main(String[] args)
	{
		new myFrame();
	}
}
