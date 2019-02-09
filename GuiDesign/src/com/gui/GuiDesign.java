package com.gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiDesign {

	public static void main(String[] args) {
		new Design();
	}
}

class Design extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	CardLayout cl;
	Container c;
	String globalFontType= "Arial";
	int globalFontSize=25;
	boolean fontBold=false;
	boolean fontItalic = false;
	@SuppressWarnings("rawtypes")
	Design() {

		JFrame frame = new JFrame("Exercise 16_14"); //frame to display the required information
		
		frame.setSize(800,400); //it is the size  of the frame
		frame.setResizable(false); //disable to resize frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		c=frame.getContentPane();
		cl=new CardLayout();
		frame.setLayout(null);
		c.setLayout(cl);

		JPanel panel = new JPanel(); //panel on the frame
		panel.setBounds(0, 0, 900, 400);
		c.add(panel);
		panel.setLayout(null);
		panel.setVisible(true);




		JLabel label = new JLabel("Font Name"); //label for the font name
		label.setBounds(90,60,90,20);   
		panel.add(label);


		String font[]={"Courier","Tahoma","Arial","SANS_SERIF"};   //available font (can be add more here)      
		@SuppressWarnings("unchecked")
		JComboBox cb=new JComboBox(font);    
		cb.setBounds(190,60,90,20);    
		cb.setVisible(true);
		panel.add(cb);

		JLabel mainLabel = new JLabel("Programming is fun");
		mainLabel.setBounds(200,60,590,200);
		panel.add(mainLabel);
		mainLabel.setFont(new Font("globalFontType", Font.PLAIN, globalFontSize));


		JLabel labelSize = new JLabel("Font Size");
		labelSize.setBounds(390,60,90,20);   
		panel.add(labelSize);

		JCheckBox boldBox = new JCheckBox("Bold"); //bold checkbox
		boldBox.setBounds(240,260,90,20);   
		panel.add(boldBox);

		JCheckBox italicBox = new JCheckBox("Italic");//italic checkbox
		italicBox.setBounds(340,260,90,20);   
		panel.add(italicBox);


		Integer size[]={8, 12, 16, 24, 30, 36, 42, 48, 56};       //font size  
		@SuppressWarnings("unchecked")
		JComboBox cbSize=new JComboBox(size);    
		cbSize.setBounds(490,60,90,20);    
		cbSize.setVisible(true);
		panel.add(cbSize);


		cb.addActionListener(  new ActionListener() {  //action performed for changing font type
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String newSelection = (String) cb.getSelectedItem();

				globalFontType = newSelection;
				if(boldBox.isSelected() && italicBox.isSelected()){
					mainLabel.setFont(new Font(globalFontType, Font.BOLD | Font.ITALIC, globalFontSize));
				}else if(!boldBox.isSelected() && italicBox.isSelected()){
					mainLabel.setFont(new Font(globalFontType,Font.ITALIC, globalFontSize));
				} else if(boldBox.isSelected() && italicBox.isSelected()){
					mainLabel.setFont(new Font(globalFontType, Font.BOLD , globalFontSize));
				}
				else if(italicBox.isSelected() ){
					mainLabel.setFont(new Font(globalFontType, Font.ITALIC, globalFontSize));
				}
				else if(boldBox.isSelected() ){
					mainLabel.setFont(new Font(globalFontType, Font.BOLD, globalFontSize));
				}else {
					mainLabel.setFont(new Font(globalFontType, Font.PLAIN, globalFontSize));
				}

			}
		});




		cbSize.addActionListener(  new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int newSelection = (Integer) cb.getSelectedItem();
				globalFontSize = newSelection;
				if(boldBox.isSelected() && italicBox.isSelected()){
					mainLabel.setFont(new Font(globalFontType, Font.BOLD | Font.ITALIC, globalFontSize));
				}else if(!boldBox.isSelected() && italicBox.isSelected()){
					mainLabel.setFont(new Font(globalFontType, Font.ITALIC, globalFontSize));
				}else if(boldBox.isSelected() && !italicBox.isSelected()){
					mainLabel.setFont(new Font(globalFontType, Font.BOLD, globalFontSize));
				}
				else if(italicBox.isSelected() ){
					mainLabel.setFont(new Font(globalFontType, Font.ITALIC, globalFontSize));
				}
				else if(boldBox.isSelected() ){
					mainLabel.setFont(new Font(globalFontType, Font.BOLD, globalFontSize));
				}else {
					mainLabel.setFont(new Font(globalFontType, Font.PLAIN, globalFontSize));
				}

			}
		});




		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				if(boldBox.isSelected() && italicBox.isSelected()){
					mainLabel.setFont(new Font(globalFontType, Font.BOLD | Font.ITALIC, globalFontSize));
				}else if(boldBox.isSelected() && !italicBox.isSelected()){
					mainLabel.setFont(new Font(globalFontType, Font.BOLD, globalFontSize));
				}else if(!boldBox.isSelected() && italicBox.isSelected()){
					mainLabel.setFont(new Font(globalFontType,Font.ITALIC, globalFontSize));
				}
				else if(boldBox.isSelected() ){
					mainLabel.setFont(new Font(globalFontType, Font.BOLD, globalFontSize));
				}else {
					mainLabel.setFont(new Font(globalFontType, Font.PLAIN, globalFontSize));
				}
			}
		};
		boldBox.addActionListener(actionListener);


		ActionListener actionListeneritalicBox = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				if(boldBox.isSelected() && italicBox.isSelected()){
					mainLabel.setFont(new Font(globalFontType, Font.BOLD | Font.ITALIC, globalFontSize));
				}else if(boldBox.isSelected() && !italicBox.isSelected()){
					mainLabel.setFont(new Font(globalFontType, Font.BOLD , globalFontSize));
				}else if(!boldBox.isSelected() && italicBox.isSelected()){
					mainLabel.setFont(new Font(globalFontType,Font.ITALIC, globalFontSize));
				}
				else if(italicBox.isSelected() ){
					mainLabel.setFont(new Font(globalFontType, Font.ITALIC, globalFontSize));
				}
				else {
					mainLabel.setFont(new Font(globalFontType, Font.PLAIN, globalFontSize));
				}
			}
		};
		italicBox.addActionListener(actionListeneritalicBox);
		
		frame.setVisible(true);
	}


}
