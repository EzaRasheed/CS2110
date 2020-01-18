public class Elevator extends Provided.AbstractElevator {

	public Elevator(Provided.AbstractElevatorController control) {
		super(control);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void hail(int floor, Provided.Person p) throws Provided.OccupiedException {
		// TODO Auto-generated method stub
		lock.lock(); //calls the elevator lock 
		try {
			if (!this.isAvailable()) throw new Provided.OccupiedException(this.id + "is not available"); {	//if the elevator is available 
				passenger = p; 
				targetFloor = floor; 	
			}
		}
		finally {
			lock.unlock();
		}
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		super.thread = new Thread(this);
		super.thread.start();
	}

	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		if(!carrying && passenger == null) {
			return true;
		}
		return false;
	}

	@Override
	protected void pickUp() {
		// TODO Auto-generated method stub
			passenger.board(this);
			targetFloor = passenger.getDestination();	
			carrying = true;

	}

	@Override
	protected boolean shouldPickUp() {
		// TODO Auto-generated method stub
			if(passenger != null && !carrying && !isMoving()) {
				return true;
			}
			return false;
	}

	@Override
	protected void offload() {
		// TODO Auto-generated method stub
		control.lock.lock();
		try {
			passenger.exit();
			carrying = false;
			passenger = null;
			control.elevatorFinished.signalAll();
		}
		finally{
			control.lock.unlock();
		}
	}

	@Override
	protected boolean shouldOffload() {
		if(carrying && !isMoving()) {
			return true;
		}
		return false;
		// TODO Auto-generated method stub
		
	}
}