import java.io.IOException;
import java.io.PrintWriter;

public interface BST<K extends Comparable<K>, V> {
    void insert(K key, V value);
    V remove(K key);
    V search(K key);
    boolean update(K key, V value);
    boolean isEmpty();
    void clear();
    void showStructure(PrintWriter pw) throws IOException;
    void printInOrder(PrintWriter pw) throws IOException;
}