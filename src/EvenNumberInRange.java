import java.util.Scanner;

public class EvenNumberInRange {
    static int[] evenNumberInRange(int[] A, int Q, int[][] query){
        int[] p = new int[A.length];
        int q[] = new int[A.length];
        p[0] = A[0]%2==0?1:0;
        for(int i = 1; i < A.length; i++){
            p[i] = p[i-1]+(A[i]%2==0?1:0);
        }
        int i = 0;
        while(Q>0){
            if(query[Q-1][0] == 0){
                q[i] = p[query[Q-1][1]];
            }else{
                q[i] = p[query[Q-1][1]] - p[query[Q-1][0] - 1];
            }
            Q--;
            i++;
        }
        return q;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Array size: ");
        int N = scanner.nextInt();
        int array[] = new int[N];
        System.out.print("Array Elements: ");
        for(int i = 0; i < N; i++){
            array[i] = scanner.nextInt();
        }
        System.out.print("Number of Queries: ");
        int Q = scanner.nextInt();
        int[][] query = new int[Q][2];
        for(int i = 0; i < Q; i++){
            query[i][0] = scanner.nextInt();
            query[i][1] = scanner.nextInt();
        }
        int[] q = evenNumberInRange(array, Q, query);
        System.out.print("[");
        for(int i = q.length-1; i >= 0; i--){
            if(q[i] == 0){
                continue;
            }
            if(i == 0){
                System.out.print(q[i]);
                break;
            }
            System.out.print(q[i]+", ");
        }
        System.out.print("]");
    }
}
