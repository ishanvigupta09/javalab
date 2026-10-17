import java.util.Scanner;
public class s1p6
{
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.print("ënter a number: ");
	int n=sc.nextInt();
	int count=0;
	for(int i=1;i<=n;i++){
	    if(n%i==0){
	        count++;
	    }
	}
	if(count==2)
	System.out.println("number is prime");
	else
	System.out.println("number is not prime");
	}
}
