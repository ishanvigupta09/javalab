import java.util.Scanner;
public class s1p5{
    public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.print("enter a number: ");
	int N=sc.nextInt();
	int factorial=1;
	for(int i=1;i<=N;i++){
	    factorial=factorial*i;
	}
	System.out.println(factorial);
	sc.close();
    }
}