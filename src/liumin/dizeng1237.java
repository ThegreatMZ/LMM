package liumin;

public class dizeng1237 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printX(1237);
	}
	public static void printX(int n){
		System.out.println("X="+n);
		if(n<5000)
			printX(2*n);
		else {
			printx(n/2);
		}
	}
private static void printx(int n){
	if(n>=1237){
		System.out.println("x="+n);
		printx(n/2);
	}
}
}