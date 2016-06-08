public class main {

	public static void main(String[] args) {
		
		//BDD.sauverEnBase("sintesli", "azer2", "0");
		BDD.sauverEnBase("lvincent", "azer", "0");
		BDD.lireEnBase();
		String admin = BDD.verifLoginEnBase("lvincent", "azer");
	}
	


}
