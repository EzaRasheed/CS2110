public class ElevatorController extends Provided.AbstractElevatorController {


	@Override
	/**
	 * Wait for pressed buttons and available elevators by calling 'await'
	 * on the two corresponding Condition objects. When possible, assign an 
	 * Elevator to a waiting person
	 * 
	 * You should not periodically check for pushed buttons and available
	 * elevators; you must use the conditions' await methods.
	 */
	public void run() {
		lock.lock();
		try {
			while (Provided.TERMINATE == false) {
				if (floorQueue.isEmpty()) {//if floor queue is empty there are no button presses so we await 
					buttonPressed.await(); //call await on first condition
				}
				else if (floorQueue.size() > 0 && emptyElevator() == null ) {
					elevatorFinished.await(); 
				}
				isAnElevatorAvailable();
			}	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Controller Interrupted");
		} finally {
			lock.unlock();
		}	
	}
	public boolean isAnElevatorAvailable () {
		for (Provided.AbstractElevator e: elevators) { //for each elevator in elevators
			if (e.isAvailable()) {  // if the elevator is available
				try {
					e.hail(floorQueue.remove(), personQueue.remove()); //the hail method 
					return true; 
				} catch(Provided.OccupiedException d) {
					d.printStackTrace(); }
			}
		}
		return false; 
	}
	
	/*public void process () { // works with await
	try { 
		if (floorQueue.isEmpty()) {//if floor queue is empty there are no button presses so we await 
			buttonPressed.await(); //call await on first condition
		}
		else if (floorQueue.size() > 0 && smallMethod() == null ) {
			elevatorFinished.await(); 
		}
	}
	catch (InterruptedException e) {
		e.printStackTrace(); 
	}

	hailMethod();
	
	}

	public boolean hailMethod () {
		for (Provided.AbstractElevator e: elevators) { //for each elevator in elevators
			if (e.isAvailable()) {  // if the elevator is available
				try {
					e.hail(floorQueue.remove(), personQueue.remove()); //the hail method 
					return true; 
			} 	catch(Provided.OccupiedException d) {
				d.printStackTrace(); }
			}
		}
		return false; 
	}*/
	
	public Provided.AbstractElevator emptyElevator () {	 //check if elevator is available method 
		for (Provided.AbstractElevator e: elevators) {
			if (e.isAvailable()) {
				return e; 
			}		
		}
		return null;
	}

}