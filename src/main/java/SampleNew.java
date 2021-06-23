public class SampleNew {
    class Node{
        int data;
        Node left, right;
    }

    Node root;
    public static void main(String[] args) {
        //bottom - 6,7,2,7,1,5 - top
        // if its empty
        // min and max = stack[0]

        // push (int data)
        // data <= min update min
        // data >= max update max


        //minLL - 1,2,6
        // maxLL - 7,7,6



        // pop()
        // int data = s.pop();
        //6,7,1,2
        // data = 2
        // data > min
        // min = 1

//            6
//          2   8
//        0 1   7 9
//

        // 0 1 || 6----
         //getLCA(root, n1, n2);
        // find the path of the n1 and n2,
        // if the n1 || n2 doesn't exits in the root. return -1
        // if the path is found check the parent for both. if the n1 and n2 are child/nodes of the same root then that will be LCA
        // else
            //


        //getLCA(root, n1, n2);
        //if n1 and n2 are less than the root data, then check for left. root.left and root.right
            // moved to left part of tree,
            // if root.data = n1|n2
            // return the root.data
        //  right side same thing if its > than root
        // one is gtr and one is less then root will be the LCA


        }
       // static int getLCA(Node root, int n1, int n2) {
//           if(root.data)
//        }
    }






