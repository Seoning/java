import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;
import javax.swing.*;

class Voca_Test extends JFrame{
	JTable table;
	JScrollPane jsp;
	Container contain;
	JButton button;
	
	Vector<String> columnName =null;
	Vector <Vector<String>> voca = null;
	int cnt = 1;
	
	String caption []= {"단어", "뜻"};
	JTextField tf[] = new JTextField[2];
	
	Voca_Test(String title){
		super(title);
		
		columnName = new Vector<String>();
		voca = new Vector<Vector<String>>();
		
		compose();
		write(); //내가 입력해서 넣은거 테이블에 뜨고 파일에 저장되게
	}

	private void write() {
		try {
			File f = new File("c:\\sun\\Esp.txt");
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("c:\\sun\\Esp.txt")));
			bw.newLine();
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	void compose() { //table만들기
		table = new JTable(voca, columnName);
		jsp = new JScrollPane(table);
		contain = getContentPane();
		
		contain.setLayout(null);
		contain.add(jsp,BorderLayout.CENTER);
		jsp.setBounds(200,10,350,250);
		
		for(int i=0;i<caption.length;i++) {
			JLabel jlb = new JLabel();
			jlb.setText(caption[i]);
			jlb.setBounds(10,(i+1)*30,50,20);
			contain.add(jlb);
			
			tf[i] = new JTextField();
			tf[i].setBounds(80,(i+1)*30,90,20);
			contain.add(tf[i]);
		}
		
		button = new JButton("Submit");
		button.setBounds(80,150,90,50);
		contain.add(button);
		button.addActionListener(new Press());
		
		
	}
	
}
class Press implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}

public class Espanol {

	public static void main(String[] args) {
		Voca_Test vt = new Voca_Test("Voca_Test");
		vt.setResizable(false);
		vt.setVisible(true);
		vt.setSize(600,700);

	}

}
