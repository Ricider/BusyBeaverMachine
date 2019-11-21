package BusyBeaverMachine;

public class ReturnPackage {
	public int direction;
	public boolean value;
	public State state;
	public ReturnPackage(int direction,boolean value,State state) {
		this.direction=direction; //0=left 1=null 2=right
		this.value=value;
		this.state=state;
	}
}
