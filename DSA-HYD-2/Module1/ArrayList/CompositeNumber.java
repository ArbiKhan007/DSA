import java.util.*;

class Main
{

static boolean isPrime(int num){
    for(int i = 2; i*i <= num; i++){
        if(num%i == 0){
            return false;
        }
    }
    return true;
}
static void removeComposite(ArrayList<Integer> li){
	for(int i = 0; i < li.size(); i++){
        int val = li.get(i);
        boolean isPrimeNum = isPrime(val);
        if(isPrimeNum == false){
            li.remove(i);
            i--;
        }
    }
}

public static void main(String[] args)
{
	Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<Integer> list = new ArrayList<>();
    for(int i=0; i<n; i++){
        int val = sc.nextInt();
        list.add(val);
    }
	removeComposite(list);
    for(int val : list) System.out.print(val+" ");

}
}
