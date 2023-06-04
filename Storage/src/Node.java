public class Node<K, V> {
  Node<K, V> prev;
  Node<K, V> next;
  K key;
  V value;

  public Node(Node<K, V> prev, K key, V value) {
    this.prev = prev;
    this.key = key;
    this.value = value;
  }

  public void setPrev(Node<K, V> prev) {
    this.prev = prev;
  }

  public void setNext(Node<K, V> next) {
    this.next = next;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public Node<K, V> getPrev() {
    return prev;
  }

  public Node<K, V> getNext() {
    return next;
  }

  public V getValue() {
    return value;
  }

  public K getKey() {
    return key;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((key == null) ? 0 : key.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    @SuppressWarnings("unchecked")
    Node<K, V> other = (Node<K, V>) obj;
    if (key == null) {
      if (other.key != null)
        return false;
    } else if (!key.equals(other.key))
      return false;
    return true;
  }

}
