package BusyBeaverMachine;

public enum State {
	HALT{
		public ReturnPackage execute(boolean current) {
			if (!halted) {
				halted=true;
				System.out.println("Now at state HALT");
			}
			return null;
		}
	},
	A{
		public ReturnPackage execute(boolean current) {
			System.out.println("Now at state A");
			if (current)
				return new ReturnPackage(0,true,State.C);
			else return new ReturnPackage(2,true,State.B);
		}
	},
	B{
		public ReturnPackage execute(boolean current) {
			System.out.println("Now at state B");
			if (current)
				return new ReturnPackage(2,true,State.B);
			else return new ReturnPackage(0,true,State.A);
		}
	},
	C{
		public ReturnPackage execute(boolean current) {
			System.out.println("Now at state C");
			if (current)
				return new ReturnPackage(1,true,State.HALT);
			else return new ReturnPackage(0,true,State.B);
		}
	};

	boolean halted;
	abstract ReturnPackage execute(boolean current);
}
