import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class StorageTest {
  @Test
  public void test_get_ItemNotFound_ReturnNull() {
    Storage<String, Integer> storage = new Storage<>(10);
    assertNull(storage.get("a"));
  }

  @Test
  public void test_put_NoStorageSpaceLeft_ItemUntouchedForTheMostTimeIsRemoved() {
    Storage<String, String> storage = new Storage<>(2);
    storage.put("a", "val_1");
    storage.put("b", "val_2");
    storage.get("a");
    storage.put("c", "val_3");
    assertNotNull(storage.get("a"));
    assertNull(storage.get("b"));
    assertNotNull(storage.get("c"));
  }

  @Test
  public void test_put_PriorityOfAnItemReset() {
    Storage<String, String> storage = new Storage<>(2);
    storage.put("a", "val_1");
    storage.put("b", "val_2");

    storage.put("a", "val_1_2");
    storage.put("c", "val_3");
    assertNotNull(storage.get("a"));

    assertNull(storage.get("b"));
    assertNotNull(storage.get("c"));

  }
}
