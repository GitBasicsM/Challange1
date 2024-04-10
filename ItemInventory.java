package Challange1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemInventory {
    private List<Item> items = new ArrayList<>();

    public ItemInventory() {
        // Initial set of items
        items.add(new Item("Textbook", "Books", 50.0, "user1@quinnipiac.edu"));
        items.add(new Item("Desk Lamp", "Electronics", 20.0, "user2@quinnipiac.edu"));
        items.add(new Item("Laptop Sleeve", "Electronics", 25.0, "user3@quinnipiac.edu"));
        items.add(new Item("Basketball", "Sports", 30.0, "user4@quinnipiac.edu"));
        items.add(new Item("Backpack", "Accessories", 45.0, "user5@quinnipiac.edu"));
    }

    public void addItem(String name, String category, double price, String sellerEmail) {
        items.add(new Item(name, category, price, sellerEmail));
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItemsBySeller(String sellerEmail) {
        return items.stream()
                    .filter(item -> item.getSellerEmail().equals(sellerEmail))
                    .collect(Collectors.toList());
    }
}
