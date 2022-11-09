package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

//        MyLinkedList list = new MyLinkedList(null);
//        list.traverse(list.getRoot());
//
//        // Create a string data array to avoid typing loads of addItem instructions
//        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
//
//        String[] data = stringData.split(" ");
//        for (String s: data) {
//            // create new item with value set to the string s
//            list.addItem(new Node(s));
//        }
//        list.traverse(list.getRoot());
//
//        list.removeItem(new Node("Perth"));
//        list.traverse(list.getRoot());
//
//        list.removeItem(new Node("Darwin"));
//        list.traverse(list.getRoot());

        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());

        // Create a string data array to avoid typing loads of addItem instructions
        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";

        String[] data = stringData.split(" ");
        for (String s: data) {
            // create new item with value set to the string s
            tree.addItem(new Node(s));
        }
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("Perth"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("Darwin"));
        tree.traverse(tree.getRoot());

    }
}
