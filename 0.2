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
            int value_to_delete = sc.nextInt();
            sc.nextLine();
            tree = new BinaryTree(sc.nextInt());
            while (sc.hasNextInt()) {
                tree.add(sc.nextInt());
            }
            sc.close();
            Node node = tree.delete_node(tree.root, value_to_delete);
            tree.root = node;
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
    public Node delete_node(Node node, int value)
    {
        if(node==null)
        {
            return null;
        }
        if (value>node.value)
        {
            node.right = delete_node(node.right, value);
            return node;
        }
        else if(value<node.value)
        {
            node.left = delete_node(node.left, value);
            return node;
        }
        else
        {
            if(node.left==null)
            {
                return node.right;
            }
            else if(node.right==null)
            {
                return node.left;
            }
            else
            {
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


    public void go(Node current_node)
    {
        if(current_node!=null){
            numbers.add(String.valueOf(current_node.value));
            this.go(current_node.left);
            this.go(current_node.right);
        }
    }

}
