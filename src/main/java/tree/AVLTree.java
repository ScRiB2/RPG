package tree;

/**
 * Сбалансированное АВЛ-дерево
 *
 * @param <T>
 */
public class AVLTree<T> {
    /**
     * высота листа
     */
    private final int HIGHT_LIST = 1;
    /**
     * Высота пустого дерева
     */
    private final int HIGHT_NULL_TREE = 0;

    private class Node<T> {
        T key;
        int height = HIGHT_LIST;
        Node<T> left = null;
        Node<T> right = null;

        Node(T k) {
            key = k;
        }
    }

    /**
     * Возвращает высоту узла p
     *
     * @param p
     * @return
     */
    private int height(Node<T> p) {
        return (p != null) ? p.height : HIGHT_NULL_TREE;
    }

    /**
     * Вычислияет balance factor узла
     *
     * @param p
     * @return
     */
    private int bfactor(Node<T> p) {
        return height(p.right) - height(p.left);
    }

    /**
     * Восстанавливает корректное значение поля height узла p
     *
     * @param p
     */
    private void fixHeight(Node<T> p) {
        int hl = height(p.left);
        int hr = height(p.right);
        p.height = (hl > hr ? hl : hr) + 1;
    }

    private Node<T> rightRotate(Node<T> p) {
        Node<T> q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight(p);
        fixHeight(q);
        return q;
    }

    private Node<T> leftRotate(Node<T> p) {
        Node<T> q = p.right;
        p.right = q.left;
        q.left = p;
        fixHeight(p);
        fixHeight(q);
        return q;
    }

    /**
     * Балансировка узла p
     * @param p
     * @return
     */
    private Node<T> balance(Node<T> p) {
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
}
