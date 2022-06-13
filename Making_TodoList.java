import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

class Todo extends JFrame{
	JTable table;
	JScrollPane jscp;
	Container contain;
	Todo(String title){
		super(title);
		
		compose(); //frameµðÀÚÀÎ
		
		
	}

	private void compose() {
			table = new JTable(8,3);
			jscp = new JScrollPane(table);
			contain = getContentPane();
			
			contain.add(jscp,BorderLayout.CENTER);
			
			JButton jb = new JButton("I did");
			contain.add(jb,BorderLayout.EAST);
			jb.addActionListener((ActionListener) new Checking(table));
		}
	
	
}

class Checking implements ActionListener{

	public Checking(JTable table) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
public class Making_TodoList{
	

	public static void main(String[] args) {
		Todo todo= new Todo("To-do_List");
		todo.setVisible(true);
		todo.setResizable(false);
		todo.setSize(500,200);
		
		
	}

}
