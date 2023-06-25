package lt.techin.application.meals;

import lt.techin.application.menus.MenuRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {
    private final MealRepository mealRepository;
    private final MenuRepository menuRepository;

    public MealService(MealRepository mealRepository, MenuRepository menuRepository) {
        this.mealRepository = mealRepository;
        this.menuRepository = menuRepository;
    }

    public List<Meal> getAll() {
        return mealRepository.findAll();
    }

    public Optional<Meal> getById(Long id) {
        return mealRepository.findById(id);
    }

    public boolean deleteById(Long id) {
        try {
            mealRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }

    public Meal create(Meal meal) {
        return mealRepository.save(meal);
    }

    public Meal replaceMeal(Long id, Meal meal) {
        meal.setId(id);
        return mealRepository.save(meal);
    }

    public Meal updateMeal(Long id, Meal meal) {
        Meal existingMeal = mealRepository.findById(id).orElseThrow();

        existingMeal.setTitle(meal.getTitle());
        existingMeal.setDescription(meal.getDescription());
        existingMeal.setQuantity(meal.getQuantity());
        existingMeal.setMenu(meal.getMenu());

        return mealRepository.save(existingMeal);
    }

    public List<Meal> getAllByMenuId(Long mealId) {
        return mealRepository.findMealsByMenuId(mealId);
    }
}
