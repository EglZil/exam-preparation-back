package lt.techin.application.meals;

import lt.techin.application.menus.Menu;

import java.util.Objects;

public class MealDto {
    private String title;

    private String description;

    private Integer quantity;

    private Menu menu;

    public MealDto() {
    }

    public MealDto(String title, String description, Integer quantity, Menu menu) {
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.menu = menu;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealDto mealDto = (MealDto) o;
        return Objects.equals(title, mealDto.title) && Objects.equals(description, mealDto.description) && Objects.equals(quantity, mealDto.quantity) && Objects.equals(menu, mealDto.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, quantity, menu);
    }

    @Override
    public String toString() {
        return "MealDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", menu=" + menu +
                '}';
    }
}
