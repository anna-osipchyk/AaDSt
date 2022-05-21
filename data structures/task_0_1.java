import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;



public class Main {
    public static boolean union(int child1, int child2, int[] size, int[] parent) {
        int father1 =find(child1, parent);
        int father2= find(child2, parent);

        if (father1!=father2){
            if(size[father1]<size[father2]) {
                int tmp = father1;
                father1 = father2;
                father2 = tmp;

            }
                parent[father2] = father1;
                size[father1]+=size[father2];
            return true;
            }

        return false;
    }

    public static int find(int x, int[]parent){
        if(parent[x]==x){
            return x;
        }
        return parent[x] =find(parent[x], parent);
    }
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("input.txt");
        BufferedReader bf = new BufferedReader(fr);
        FileWriter fw = new FileWriter("output.txt");
        int n, q;
        String data [] = bf.readLine().split(" ");
        n = Integer.parseInt(data[0]);
        q = Integer.parseInt(data[1]);
        int size []  =new int[n+1];
        int parent[] = new int[n+1];
        size[0]=0;
        for(int i =0; i< n+1;i++){
            size[i] =1;
            parent[i] =i;
        }
        int  j=0;
        int coherency = n;
        while(j<q){
             data = bf.readLine().split(" ");
             int r1, r2;
            r1 = Integer.parseInt(data[0]);
            r2 = Integer.parseInt(data[1]);
             if(union(r1, r2, size, parent)) {
                 coherency--;

             }
            fw.write(coherency + "\n");
            j++;
        }
        fw.close();
    }
}
