package lt.techin.application.menus;

import jakarta.xml.bind.ValidationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    public Optional<Menu> getById(Long id) {
        return menuRepository.findById(id);
    }

    public boolean deleteById(Long id) {
        try {
            menuRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }

    public Menu create(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu replaceMenu(Long id, Menu menu) {
        menu.setId(id);
        return menuRepository.save(menu);
    }

    public Menu updateMenu(Long id, Menu menu) {
        var existingMenu = menuRepository.findById(id).orElseThrow();

        existingMenu.setTitle(menu.getTitle());
        existingMenu.setMeals(menu.getMeals());

        return menuRepository.save(existingMenu);
    }
}
