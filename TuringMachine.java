package BusyBeaverMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TuringMachine extends JPanel implements Runnable, ActionListener{

	private static final long serialVersionUID = 1L;

	Tape tape;
	State currentState;

	Timer timer;

	JFrame mainFrame;
	JLabel tapeLabel;
	String labelStr;

	public TuringMachine() {
		currentState=State.A;
		timer= new Timer(500,this);
		this.tape=new Tape(2048);
		this.labelStr=" 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";
		this.tapeLabel=new JLabel(labelStr);
		this.add(tapeLabel);
		Font sample=tapeLabel.getFont().deriveFont(50f);
		tapeLabel.setFont(sample);
		javax.swing.SwingUtilities.invokeLater(this);
	}

	public void updateLabel() {
		for (int i=1;i<42;i+=2) {
			labelStr = labelStr.substring(0, i) + ((tape.getValue(((i-1)/2)-10))?1:0) + labelStr.substring(i + 1);
		}
		this.tapeLabel.setText(labelStr);
	}

	public void actionPerformed(ActionEvent e) {
		ReturnPackage outputs= currentState.execute(tape.getValue());
		if (outputs!=null) {
			tape.setValue(outputs.value);
			switch (outputs.direction) {
			case 0:
				tape.moveLeft();
				break;
			case 1:
				break;
			case 2:
				tape.moveRight();
				break;
			}
			currentState=outputs.state;
			updateLabel();
		}
	}

	@Override
	public void run() {
		mainFrame=new JFrame("Busy Beaver");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setContentPane(this);
		mainFrame.pack();
		mainFrame.setVisible(true);
		timer.start();
	}

	public static void main(String[] args) {
		new TuringMachine();
	}
}
