package ch16.gameplayer;

public abstract class PlayerLevel {
	
	public abstract void run();
	public abstract void jump();
	public abstract void turn();
	public abstract void showLevelMessage();
	
	public void go(int count) {
		
		run();
		
		int i;
		for(i=0; i<count; i++) {
			jump();
		}
		
		for(i=0; i<count; i++) {
			turn();
		}
	}
	
}
