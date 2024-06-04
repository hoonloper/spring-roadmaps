package com.spring_04.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {
  ItemRepository itemRepository = new ItemRepository();

  @AfterEach
  void afterEach() {
    itemRepository.clearStore();
  }

  @Test
  void save() {
    // given
    Item item = new Item("itemA", 10000, 10);

    // when
    Item savedItem = itemRepository.save(item);

    // then
    Item foundItem = itemRepository.findById(savedItem.getId());
    assertThat(foundItem).isEqualTo(savedItem);
  }

  @Test
  void findAll() {
    // given
    Item item1 = new Item("itemA", 10000, 10);
    Item item2 = new Item("itemB",  20000, 20);

    itemRepository.save(item1);
    itemRepository.save(item2);

    // when
    List<Item> items = itemRepository.findAll();

    // then
    assertThat(items.size()).isEqualTo(2);
    assertThat(items).contains(item1, item2);
  }

  @Test
  void updateItem() {
    // given
    Item item = new Item("itemA", 10000, 10);
    Item savedItem = itemRepository.save(item);
    Long id = savedItem.getId();

    // when
    Item updateParam = new Item("item2", 20000, 20);
    itemRepository.update(id, updateParam);

    // then
    Item foundItem = itemRepository.findById(id);

    assertThat(foundItem.getItemName()).isEqualTo(updateParam.getItemName());
    assertThat(foundItem.getPrice()).isEqualTo(updateParam.getPrice());
    assertThat(foundItem.getQuantity()).isEqualTo(updateParam.getQuantity());
  }
}