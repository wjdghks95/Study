package ch16;

public abstract class PlayerLevel implements Action {
	
	public abstract void showLevelMessage();
	
	final public void go(int count) {
		
		run();
		
		for(int i = 0; i<count; i++) {
			jump();
		}
		
		for(int i = 0; i<count; i++) {
			turn();
		}
		
	}
}
