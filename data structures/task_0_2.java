import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


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
        int n, m,q;
        String[] data = bf.readLine().split(" ");
        n = Integer.parseInt(data[0]);
        m =Integer.parseInt(data[1]);
        q = Integer.parseInt(data[2]);
        int coh = n;
        int[] saved = new int[m+1];
        int[] earthquakes = new int[q+1];
        int[][] matrix = new int[m+1][2];
        int[] size =new int[n+1];
        int[] parent = new int[n+1];
        char[]res =new char[q];
        size[0]=0;
        for(int i =0; i< n+1;i++){
            size[i] =1;
            parent[i] =i;

        }
        int  j=0;

        while(j<m) {
            saved[j+1] = 1;
            data = bf.readLine().split(" ");
            matrix[j+1][0] = Integer.parseInt(data[0]);
            matrix[j+1][1] = Integer.parseInt(data[1]);
            j++;

        }
        j=0;
        while(j<q) {
            String data1 = bf.readLine();
            earthquakes[q-j]=Integer.parseInt(data1);
            saved[earthquakes[q-j]]=0;
            j++;
        }
        j =0;
        saved[0]=0;
        for(int el: saved)
        {
            if(el==1){
                int r1 = matrix[j][0];
                int r2 = matrix[j][1];
                if(union(r1, r2, size, parent))
                    coh--;
            }
            j++;
        }
        for(j = 0; j< q; j++ ) {
            int d = earthquakes[j + 1];
            if(coh>1) {
                int r1 = matrix[d][0];
                int r2 = matrix[d][1];
                if (union(r1, r2, size, parent)) {
                    coh--;

                }
                res[j]='0';

                    }
            else {
                res[j]='1';
                }
            }

        for(j = res.length-1; j>-1; j--) {
            fw.write(String.valueOf(res[j]));
        }
        fw.close();
    }
}
