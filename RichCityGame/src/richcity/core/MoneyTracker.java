package richcity.core;

public class MoneyTracker {
	int money = 0;
	
	public void addMoney(int amount) {
		money+=amount;
	}
	
	public void takeMoney(int amount) {
		money-=amount;
	}
	public int getMoney() {
		return money;
	}
}
