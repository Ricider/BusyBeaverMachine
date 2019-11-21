package BusyBeaver;

public class ReturnPackage {
	public boolean direction;
	public boolean value;
	public State state;
	public ReturnPackage(boolean direction,boolean value,State state) {
		this.direction=direction;
		this.value=value;
		this.state=state;
	}
}
