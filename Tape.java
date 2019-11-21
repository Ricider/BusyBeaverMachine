package BusyBeaverMachine;

public class Tape {
	
	int length;
	int index;
	boolean value[];
	
	public Tape(int len) {
		length=len;
		index=length/2;
		value=new boolean[length];
	}
	
	public boolean getValue() {
		return value[index];
	}
	
	public boolean getValue(int offset) {
		return value[index+offset];
	}
	
	public void setValue(boolean val) {
		value[index]=val;
	}
	
	public void moveLeft() {
		index--;
	}
	
	public void moveRight() {
		index++;
	}
}
