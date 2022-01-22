package richcity.core;

public class MoneyTracker {
	int money = 1000000;
	double owned_BTC 	= 0;
	double owned_ETH 	= 0;
	double owned_DODGE 	= 0;
	
	//Money $
	
	public void addMoney(int amount) {
		money+=amount;
	}
	
	public void takeMoney(int amount) {
		money-=amount;
	}
	
	public int getMoney() {
		return money;
	}
	
	//Cryptos
	
	public void addBTC(double amount) {
		owned_BTC += amount;
	}
	
	public void addETH(double amount) {
		owned_ETH += amount;
	}
	
	public void addDODGE(double amount) {
		owned_DODGE += amount;
	}
	
	public void takeBTC(double amount) {
		owned_BTC -= amount;
	}
	
	public void take(double amount) {
		owned_ETH -= amount;
	}
	
	public void takeDODGE(double amount) {
		owned_DODGE -= amount;
	}
	
	
	
	public double getBTC() {
		return owned_BTC;
	}
	public double getETH() {
		return owned_ETH;
	}
	public double getDODGE() {
		return owned_DODGE;
	}
}
