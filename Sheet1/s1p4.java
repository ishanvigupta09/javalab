import java.util.Scanner;
public class s1p4
{
	public static void main(String[] args) {
		System.out.println("enter a number:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int reverse=0;
		while(n!=0){
		    int digit=n%10;
		    reverse=reverse*10+digit;
		    n=n/10;
		}
		System.out.println("reverse number: "+reverse);
		sc.close();
	}
}