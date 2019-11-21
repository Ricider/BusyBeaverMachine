package BusyBeaverMachine;

public enum State {
	HALT{
		public ReturnPackage execute(State state, boolean current) {
			return null;
		}
	},
	ALWLEFT{
		public ReturnPackage execute(State state, boolean current) {
			return new ReturnPackage(false,true,State.ALWLEFT);
		}
	};
	abstract ReturnPackage execute(State state, boolean current);
}
