import java.util.HashMap;
import java.util.Map;

public class Storage<K, V> {

  private int capacity;

  private Map<K, Node<K, V>> store = new HashMap<>();
  private Node<K, V> firstNode;
  private Node<K, V> lastNode;

  public Storage(int capacity) {
    this.capacity = capacity;
    this.firstNode = null;
    this.lastNode = null;

  }

  public void put(K key, V value) {
    if (store.size() == 0) {
      Node<K, V> node = new Node<K, V>(null, key, value);
      lastNode = firstNode = node;
      store.put(key, node);
      return;
    }
    if (store.containsKey(key)) {
      Node<K, V> node = store.get(key);
      node.setValue(value);
      rebaseNode(node);
      return;
    }

    insertNode(key, value);
  }

  public V get(K key) {
    Node<K, V> node = store.get(key);
    if (node == null) {
      return null;
    }
    rebaseNode(node);
    return node.getValue();
  }

  private void rebaseNode(Node<K, V> node) {
    if (this.lastNode.equals(node)) {
      return;
    }
    if (this.firstNode.equals(node)) {
      this.firstNode = node.getNext();
      this.firstNode.setPrev(null);
      rebaseNodeToEnd(node);
      return;
    }
    Node<K, V> prev = node.getPrev();
    Node<K, V> next = node.getNext();
    prev.setNext(next);
    next.setPrev(prev);
    rebaseNodeToEnd(node);
  }

  private void rebaseNodeToEnd(Node<K, V> node) {
    this.lastNode.setNext(node);
    node.setPrev(this.lastNode);
    node.setNext(null);
    this.lastNode = node;
  }

  private void deleteFirstNode() {
    store.remove(firstNode.getKey());
    firstNode = firstNode.getNext();
    firstNode.setPrev(null);
  }

  private void insertNode(K key, V value) {
    if (store.size() == capacity) {
      deleteFirstNode();
    }
    Node<K, V> node = new Node<K, V>(lastNode, key, value);
    store.put(key, node);
    lastNode.setNext(node);
    lastNode = node;
  }
}
