package webservice;

public class Main {
	public static void main(String [] args){
	CalculetteProxy calculetteproxy = new CalculetteProxy();
	int somme = 0;
	int mul = 0;
	int sous = 0;
	try {
		somme = calculetteproxy.add(6, 9);
		mul = calculetteproxy.mul(6, 9);
		sous = calculetteproxy.sou(9, 6);
	}
	catch (Exception e) {} 
	System.out.print(somme);
	System.out.print(mul);
	System.out.print(sous);
	}
}
