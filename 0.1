import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;


class Solution implements Runnable {
    public static void main(String[] args) {
        new Thread(null, new Solution(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        try {
            FileReader fr = new FileReader("input.txt");
            Scanner sc = new Scanner(fr);
            FileWriter fw = new FileWriter("output.txt");
            BinaryTree tree;
            tree = new BinaryTree(sc.nextInt());
            while (sc.hasNextInt()) {
                tree.add(sc.nextInt());
            }
            sc.close();
            tree.go(tree.root);
            for (String s : tree.numbers) {
                fw.write(s + "\n");
            }
            fw.close();
        }
        catch (Exception ex)
        {

        }
    }
}
class Node{
    public int value;
    public Node right;
    public Node left;
    public Node(int in_value)
    {
        value = in_value;
        right = null;
        left = null;

    }

}
class BinaryTree{
    public Node root;
    public ArrayList<String> numbers = new ArrayList<>();
    public BinaryTree(int value){
        root = new Node(value);
    }
    public void add(int value){
        Node node = new Node(value);
        if (root==null){
            root = node;
        }
        else{
            Node current_node = root;
            while(true){
                Node parent_node = current_node;
                if(value==current_node.value){
                    return;
                }
                else if(value<current_node.value)
                {
                    current_node = current_node.left;
                    if(current_node==null)
                    {
                        parent_node.left = node;
                        return;
                    }
                }
                else if(value>current_node.value){
                    current_node = current_node.right;
                    if(current_node==null)
                    {
                        parent_node.right = node;
                        return ;
                    }
                }

            }

        }
    }
    public void go(Node current_node)
    {
        if(current_node!=null){
            numbers.add(String.valueOf(current_node.value));
            this.go(current_node.left);
            this.go(current_node.right);
        }
    }

}
