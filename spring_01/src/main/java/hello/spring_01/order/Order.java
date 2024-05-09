package hello.spring_01.order;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
class Order {
  private Long memberId;
  private String itemName;
  private int itemPrice;
  private int discountPrice;

  public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
    this.memberId = memberId;
    this.itemName = itemName;
    this.itemPrice = itemPrice;
    this.discountPrice = discountPrice;
  }

  public int calculatePrice() {
    return itemPrice - discountPrice;
  }
}
