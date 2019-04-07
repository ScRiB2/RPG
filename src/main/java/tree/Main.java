package tree;

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree(new Integer[] {2,10});
        tree.insert(1);
        tree.print();
        tree.insert(2);
        tree.print();
        tree.insert(-3);
        tree.print();
        tree.insert(4);
        tree.print();

        System.out.println("Удалил 2");
        tree.remove(2);
        tree.print();

        System.out.println("Поиск -3");
        System.out.println(tree.find(-3));
        System.out.println("Поиск 0");
        System.out.println(tree.find(0));

        System.out.println("Очистка дерева");
        tree.clear();
        tree.print();
    }
}
