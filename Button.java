public class Button extends Provided.AbstractButton{

	public Button(int floor, Provided.AbstractElevatorController control) {
		super(floor, control);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void press(Provided.Person p) {
		// TODO Auto-generated method stub
		control.lock.lock();
		try {
			control.request(floor, p);
			control.buttonPressed.signalAll();
		}
		finally {
			control.lock.unlock();
		}
	}
}