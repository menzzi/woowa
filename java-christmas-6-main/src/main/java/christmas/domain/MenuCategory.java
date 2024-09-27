package christmas.domain;

import java.util.List;

public class MenuCategory {
    private String categoryName;
    private List<MenuItem> items;

    public MenuCategory(String categoryName, List<MenuItem> items){
        this.categoryName = categoryName;
        this.items = items;
    }
    public MenuItem getItemByName(String name) throws IllegalArgumentException {
        for (MenuItem item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    public String getCategoryName() {
        return categoryName;
    }
}
