import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class task_0_5 {
    public static int h(int x, int i, int c, int m){
        return (x%m + c*i)%m;
    }
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("input.txt");
        FileWriter fw  = new FileWriter("output.txt");
        Scanner sc = new Scanner(fr);
        int m = sc.nextInt();
        int c = sc.nextInt();
        int n = sc.nextInt();
        int hash []= new int [m];
        for(int i=0;i<m; i++){
            hash[i] = -1;
        }
        while(sc.hasNextInt()){
            int x = sc.nextInt();
            for(int i =0; i< m; i++){
                int j = h(x, i,c,m);
                if (hash[j]==-1){
                    hash[j] = x;
                    break;
                }
                else if(hash[j]==x){
                    break;
                }
            }
        }
        for(int i=0;i<m; i++){
           fw.write(String.valueOf(hash[i])+" ");
        }  fw.close();
    }
}
