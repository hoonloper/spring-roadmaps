package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); //static
    private static long sequence = 0L; //static

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item foundItem = findById(itemId);
        foundItem.setItemName(updateParam.getItemName());
        foundItem.setPrice(updateParam.getPrice());
        foundItem.setQuantity(updateParam.getQuantity());
        foundItem.setOpen(updateParam.getOpen());
        foundItem.setRegions(updateParam.getRegions());
        foundItem.setItemType(updateParam.getItemType());
        foundItem.setDeliveryCode(updateParam.getDeliveryCode());
    }

    public void clearStore() {
        store.clear();
    }

}
