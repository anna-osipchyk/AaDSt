import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


class Main{
    public static void main(String[] args) throws Exception{
        try {
            BufferedReader sc
                    = new BufferedReader(new FileReader("bst.in"));
            int size = Integer.parseInt(sc.readLine());
            double[] values = new double[size + 1];
            double[] inf = new double[size + 1];
            double[] sup = new double[size + 1];
            System.out.println(Double.MAX_VALUE+ " "+Double.MIN_VALUE);
            boolean is_right = true;
            values[1] = Double.parseDouble(sc.readLine());
            inf[1] = -Double.MAX_VALUE;
            sup[1] = Double.MAX_VALUE;
            int line_counter = 2;
            for (line_counter = 2; line_counter < size+1; line_counter++) {
                String data[] = sc.readLine().split(" ");
                double value, father_idx;
                String left_or_right;
                value = Double.parseDouble(data[0]);
                father_idx = Integer.parseInt(data[1]);
                left_or_right = data[2];
                double father_value, father_sup, father_inf;
                father_value = values[(int)father_idx];
                father_sup = sup[(int)father_idx];
                father_inf = inf[(int)father_idx];
                values[line_counter] = value;
                if (left_or_right.equals("L")) {
                    sup[line_counter] = father_value-0.5;
                    inf[line_counter] = father_inf;
                    if (value >= sup[line_counter] || value < inf[line_counter]) {
                        is_right = false;
                        break;
                    }
                } else if (left_or_right.equals("R")) {
                    sup[line_counter] = father_sup;
                    inf[line_counter] = father_value;
                    if (value > sup[line_counter] || value < inf[line_counter]) {
                        is_right = false;
                        break;
                    }
                }


            }

            FileWriter fw = new FileWriter("bst.out");
            if (is_right) {
                fw.write("YES");

            } else {
                fw.write("NO");

            }
            fw.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
