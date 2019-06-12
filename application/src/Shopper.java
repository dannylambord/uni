

public class Shopper {

private int numItems;
private int simTime; 
private int timeEntered;
private int timeExit;
private int timeStart;
private int startingItems;
	
	public Shopper() {
	
		numItems = 0;
		timeEntered = 0;
		startingItems = 0;
	}
        
          public static void main(String[] args)
            {
                Shopper s = new Shopper();
                Application a = new Application(5);
                for(int i = 0; i < 30; i++)
                {
                    a.add(s);
                    
                }
                
                a.displaySummary();

            }
	
	public int getStartingItems(){
		return startingItems;
	}
	public int getArrivalTime(){
		return timeEntered;
	}
	
	public void timeStart(int time){
		timeStart = time;
	}
	
	public void process(){
		numItems--;
	}
	
	public int getItems(){
		return numItems;
	}
	
	public int exit(int time){
		timeExit = time;
		int waitTime = timeExit - timeEntered - 5*startingItems;
		return waitTime;
	}
        
        public int getCurrentTime()
        {
            return timeExit;
        }
	
	
	
}