package tree;

/**
 * Сбалансированное АВЛ-дерево для целых чисел
 */
public class AVLTree {
    /**
     * высота листа
     */
    private final int HIGHT_LIST = 1;
    /**
     * Высота пустого дерева
     */
    private final int HIGHT_NULL_TREE = 0;

    private class Node {
        int value;
        int height = HIGHT_LIST;
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

    /**
     * Возвращает высоту узла p
     *
     * @param p
     * @return
     */
    private int height(Node p) {
        return (p != null) ? p.height : HIGHT_NULL_TREE;
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
        if (root == null) return root = new Node(k);
        if (k < p.value) p.left = add(p.left, k);
        else if (k > p.value) p.right = add(p.right, k);
        else return root;
        return balance(p);

    }

    public void insert(int k){
        add(root,k);
    }

    AVLTree() {

    }
}
