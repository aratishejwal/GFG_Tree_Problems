import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;


class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Tree {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String tt = br.readLine();
            Node rootT = buildTree(tt);

            String s = br.readLine();
            Node rootS = buildTree(s);

            Solution tr = new Solution();
            boolean st = tr.isSubtree(rootT, rootS);
            if (st == true) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
        System.out.print("It prints 0 not subtree present and 1 subtree is present.");
    }
}

// User function Template for Java

class Solution {
    public boolean isIdentical(Node rootT, Node rootS) {
        if (rootT == null && rootS == null) {
            return true;
        }
        if (rootT == null || rootS == null) {
            return false;
        }
        if (rootT.data == rootS.data) {
            return isIdentical(rootT.left, rootS.left) && isIdentical(rootT.right, rootS.right);
        } else {
            return false;
        }
    }

    public boolean isSubtree(Node rootT, Node rootS) {
        if (rootS == null) {
            return true;
        }
        if (rootT == null) {
            return false;
        }
        if (rootT.data == rootS.data) {
            if (isIdentical(rootT, rootS)) {
                return true;
            }
        }
        return isSubtree(rootT.left, rootS) || isSubtree(rootT.right, rootS);
    }
}
