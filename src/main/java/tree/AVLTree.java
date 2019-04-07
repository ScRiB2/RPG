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
    private void fixheight(Node<T> p) {
        int hl = height(p.left);
        int hr = height(p.right);
        p.height = (hl > hr ? hl : hr) + 1;
    }
}
