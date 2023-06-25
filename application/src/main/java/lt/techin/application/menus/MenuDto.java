package lt.techin.application.menus;

import lt.techin.application.meals.Meal;

import java.util.Objects;
import java.util.Set;

public class MenuDto {
    private String title;

    public MenuDto() {
    }

    public MenuDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuDto menuDto = (MenuDto) o;
        return Objects.equals(title, menuDto.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "MenuDto{" +
                "title='" + title + '\'' +
                '}';
    }
}
