package tree;

/**
 * Сбалансированное АВЛ-дерево для целых чисел
 */
public class AVLTree {
    private class Node {
        int value;
        int height = 1;
        Node left = null;
        Node right = null;

        Node(int k) {
            value = k;
        }
    }

    /**
     * Корневой элемент
     */
    private Node root = null;


    public AVLTree() {

    }

    public AVLTree(int k) {
        this();
        root = add(root, k);
    }

    public AVLTree(Integer[] c) {
        this();
        for (Integer integer : c) {
            root = add(root, integer);
        }
    }

    /**
     * Возвращает высоту узла p
     *
     * @param p
     * @return
     */
    private int height(Node p) {
        return (p != null) ? p.height : 0;
    }

    /**
     * Вычислияет balance factor узла
     *
     * @param p
     * @return
     */
    private int bfactor(Node p) {
        return height(p.right) - height(p.left);
    }

    /**
     * Восстанавливает корректное значение поля height узла p
     *
     * @param p
     */
    private void fixHeight(Node p) {
        int hl = height(p.left);
        int hr = height(p.right);
        p.height = (hl > hr ? hl : hr) + 1;
    }

    private Node rightRotate(Node p) {
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight(p);
        fixHeight(q);
        return q;
    }

    private Node leftRotate(Node p) {
        Node q = p.right;
        p.right = q.left;
        q.left = p;
        fixHeight(p);
        fixHeight(q);
        return q;
    }

    /**
     * Балансировка узла p
     *
     * @param p
     * @return
     */
    private Node balance(Node p) {
        fixHeight(p);
        if (bfactor(p) == 2) {
            if (bfactor(p.right) < 0) {
                p.right = rightRotate(p.right);
            }
            return leftRotate(p);
        }
        if (bfactor(p) == -2) {
            if (bfactor(p.left) > 0) {
                p.left = leftRotate(p.left);
            }
            return rightRotate(p);
        }
        return p;
    }

    private Node add(Node p, int k) {
        if (p == null) return new Node(k);
        if (k < p.value) p.left = add(p.left, k);
        else if (k > p.value) p.right = add(p.right, k);
        return balance(p);
    }

    public void insert(int k) {
        root = add(root, k);
    }

    /**
     * Поиск узла с минимальным ключом
     *
     * @param p
     * @return
     */
    private Node findMin(Node p) {
        return (p.left != null) ? findMin(p.left) : p;
    }

    /**
     * удаление узла с минимальным ключом
     *
     * @param p
     * @return
     */
    private Node removeMin(Node p) {
        if (p.left == null)
            return p.right;
        p.left = removeMin(p.left);
        return balance(p);
    }

    private Node delete(Node p, int k) {
        if (p == null) return null;
        if (k < p.value)
            p.left = delete(p.left, k);
        else if (k > p.value)
            p.right = delete(p.right, k);
        else {
            Node q = p.left;
            Node r = p.right;
            if (r == null) return q;
            Node min = findMin(r);
            min.right = removeMin(r);
            min.left = q;
            return balance(min);
        }
        return balance(p);
    }

    public void remove(int k) {
        root = delete(root, k);
    }

    private void print(Node p) {
        if (p != null) {
            System.out.print(p.value + " ");
            print(p.left);
            print(p.right);
        }
    }

    /**
     * Прямой обход дерева
     */
    public void print() {
        if (root == null) return;
        print(root);
        System.out.println();
    }

    private Node clear(Node p) {
        if (p == null) return null;
        p.left = clear(p.left);
        p.right = clear(p.right);
        return null;
    }

    public void clear() {
        root = clear(root);
    }

    private Node find(Node p, int k) {
        if (p == null) return null;
        Node q;
        if (k < p.value)
            q = find(p.left, k);
        else if (k > p.value)
            q = find(p.right, k);
        else return p;
        return q;
    }

    public boolean find(int k) {
        return find(root, k) != null;
    }
}
