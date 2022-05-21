//package com.company;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

import static java.lang.Math.max;

class Node{
    public int value;
    public Node right;
    public Node left;
    public  int length;
    public int height;
    public int length_of_r = 0;
    public int length_of_l= 0;
    public long sum;
    public Node(int in_value)
    {
        value = in_value;
        right = null;
        left = null;
        height = 0;
        sum=0;


    }
    public Node(int in_value, Node left, Node right)
    {
        value = in_value;
        this.right = right;
        this.left = left;
        height = 0;
        sum=0;


    }

}
class BinaryTree {
    public Node root;
    public Node the_right_tree = new Node(0);
    public HashMap<Node,Integer> the_right_trees = new HashMap<>();
    public int the_value;
    public ArrayList<String> numbers = new ArrayList<>();
    public BinaryTree(Node node){
        root = node;
    }
    public void add(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
        } else {
            Node current_node = root;
            while (true) {
                Node parent_node = current_node;
                if (value == current_node.value) {
                    return;
                } else if (value < current_node.value) {
                    current_node = current_node.left;
                    if (current_node == null) {
                        parent_node.left = node;
                        return;
                    }
                } else if (value > current_node.value) {
                    current_node = current_node.right;
                    if (current_node == null) {
                        parent_node.right = node;
                        return;
                    }
                }

            }

        }
    }

    public Node delete_node(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (value > node.value) {
            node.right = delete_node(node.right, value);
            return node;
        } else if (value < node.value) {
            node.left = delete_node(node.left, value);
            return node;
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                int minimum = find_minimum(node.right).value;
                node.value = minimum;
                node.right = delete_node(node.right, minimum);
                return node;
            }
        }


    }

    public Node find_minimum(Node node) {
        if (node.left != null) {
            return find_minimum(node.left);
        }
        return node;
    }

    public int heights(Node node, int left, int right) {
        if (node == null) {
            return 0;
        }
        if (node.left != null) {
            left = heights(node.left, left, right);
        } else {
            left = -1;
        }
        if (node.right != null) {
            right = heights(node.right, left, right);
        } else {
            right = -1;
        }
        node.height = max(right, left) + 1;
        return max(right, left) + 1;
    }


    public int length(Node node)
    {
        if(node==null){
            return 0;
        }
        int length_l = 0;
        boolean has_left = false;
        boolean has_right = false;
        int length_r = 0;
        if (node.left!=null){
            has_left = true;
            length_l = this.length(node.left);
        }
        if (node.right!=null){
            has_right = true;
            length_r = this.length(node.right);
        }
        node.length_of_r = length_r;
        node.length_of_l = length_l;
        node.length =  length_l+length_r+1;
        if(the_right_tree.length< node.length){
            the_right_trees.put(node, node.length);
            the_right_tree = new Node(node.value ,node.left, node.right);

        }
        if(has_left&&has_right){
            return max(length_l,length_r)+1;
        }
        return node.length;

    }
    public int central_node(Node node, int counter)
    {
        if(counter==0){
            the_value = node.value;
            return node.value;
        }
        int length_l = 0;
        boolean has_left = false;
        boolean has_right = false;
        int length_r = 0;
        if(counter==0){
            return the_value;
        }

            if (node.length_of_l > node.length_of_r)
            {
                if(node.left!=null) {
                    has_left = true;
                }
                if(counter==0){
                    return the_value;
                }
                counter--;
                length_l = this.central_node(node.left, counter);
            }
            else {
                if(node.right!=null) {
                    has_right = true;
                }
                if(counter==0){
                    return the_value;
                }
                counter--;
                length_r = this.central_node(node.right, counter);
            }

        if(counter==0){
            return the_value;
        }
        node.length_of_r = length_r;
        node.length_of_l = length_l;
        node.length =  length_l+length_r+1;

        if(has_left&&has_right){
            return max(length_l,length_r)+1;
        }
        return node.length;

    }

    public void go(Node current_node) {

        if (current_node != null) {
            numbers.add(String.valueOf(current_node.value));
            this.go(current_node.left);
            this.go(current_node.right);

        }

    }



    public long sum_of_path(Node node, boolean is_root)
    {
        if(node==null)
        {
            return 0;
        }

        long sum_left, sum_right;
        if(node.left!=null) {
             sum_left = this.sum_of_path(node.left, false);
        }
        else{
             sum_left = 0;
        }
        if(node.right!=null) {
            sum_right = this.sum_of_path(node.right, false);
        }
        else{
            sum_right = 0;
        }
        if(node.right!=null&&node.left!=null&&!is_root)
        {
            if(node.length_of_l>node.length_of_r) {
                return sum_left + node.value;

            }
            else {
                return sum_right + node.value;
            }
        }

        return sum_left+sum_right+node.value;
    }
}

    class Solution implements Runnable {
        public static void main(String[] args) {
            new Thread(null, new Solution(), "", 64 * 1024 * 1024).start();
        }
        public static int max_int(Collection<Integer> values){
            int val1 = 0;
            for(Integer val: values)
            {
                if (val>val1){
                    val1=val;
                }
            }
            return val1;
        }
        public static long max_long(Collection<Long> values, long val1){
            for(Long val: values)
            {
                if (val>val1){
                    val1=val;
                }
            }
            return val1;
        }
        public void run() {
            try {

                FileReader fr = new FileReader("in.txt");
                Scanner sc = new Scanner(fr);
                FileWriter fw = new FileWriter("out.txt");
                BinaryTree tree;
                tree = new BinaryTree(null);
                while (sc.hasNextInt()) {
                    tree.add(sc.nextInt());
                }
                sc.close();
                tree.heights(tree.root, -1, -1);
                tree.length(tree.root);
                //    tree.go_find_the_root(tree.root);
                int max_length = max_int(tree.the_right_trees.values());
                ArrayList<Node> the_best_trees = new ArrayList<>();
                for(Node n: tree.the_right_trees.keySet())
                {
                   int value = tree.the_right_trees.get(n);
                    if(value!=max_length)
                    {
                        continue;
                    }

                    the_best_trees.add(n);
                }
                long max = 0;
                HashMap<Node, Long> finally_final_trees  =new HashMap<>();

                for(Node root: the_best_trees)
                {
                   long sum = tree.sum_of_path(root, true);
                   max = sum;
                   finally_final_trees.put(root, sum);
                }
//                List<Long> nodes = new ArrayList<Long>(finally_final_trees.values());
//                Collections.sort(nodes, Collections.reverseOrder());
                 long max_sum = max_long(finally_final_trees.values(), max);
                 ArrayList<Node> f = new ArrayList<>();
                BinaryTree finally_tree  =new BinaryTree(null);
                 for(Node root: finally_final_trees.keySet())
                 {
                     if(finally_final_trees.get(root)==max_sum)
                     {
                         f.add(root);

                     }
                 }

                finally_tree.root = f.get(0);
                int counter_l = finally_tree.root.length_of_l;
                int counter_r = finally_tree.root.length_of_r;

                int l_o_p = counter_l+counter_r+1;
                int value = finally_tree.root.value;
                if((counter_l+counter_r+1)%2==0){
                    System.out.println(" ");
                }
                else{

                    int h_c = l_o_p/2 + 1;
                    if(h_c> counter_r&& counter_r!=counter_l)
                    {
                        h_c-= counter_r+1;
                        finally_tree.central_node(finally_tree.root.left, h_c-1);
                        int val_central = finally_tree.the_value;
                        finally_tree.delete_node(finally_tree.root, val_central);
                    }
                    else if(counter_l==counter_r){
                        finally_tree.delete_node(finally_tree.root, finally_tree.root.value);
                    }
                    else {
                        h_c-= counter_l+1;
                         finally_tree.central_node(finally_tree.root.right, h_c-1);
                       int  val_central = finally_tree.the_value;
                        finally_tree.delete_node(finally_tree.root, val_central);
                    }
                }

                Node n=tree.delete_node(tree.root,value);
                BinaryTree b = new BinaryTree(n);

                b.go(b.root);
                for (String s : b.numbers) {
                    fw.write(s + "\n");
                }
                fw.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }


    }
