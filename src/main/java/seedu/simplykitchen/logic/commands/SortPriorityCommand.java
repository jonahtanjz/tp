package seedu.simplykitchen.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.simplykitchen.model.util.ComparatorUtil.SORT_BY_ASCENDING_EXPIRY_DATE;
import static seedu.simplykitchen.model.util.ComparatorUtil.SORT_BY_DESCENDING_PRIORITY;
import static seedu.simplykitchen.model.util.ComparatorUtil.SORT_BY_FIRST_CHARACTER;
import static seedu.simplykitchen.model.util.ComparatorUtil.SORT_BY_LEXICOGRAPHICAL_ORDER;

import seedu.simplykitchen.model.Model;


/**
 * Sorts food items in FoodInventory by priority from high to low, then by expiry date from oldest to newest,
 * then by description.
 */
public class SortPriorityCommand extends Command {

    public static final String COMMAND_WORD = "sortpriority";

    public static final String MESSAGE_SUCCESS = "Sorted by priority from high to low";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.sortFoodInventory(SORT_BY_LEXICOGRAPHICAL_ORDER,
                SORT_BY_FIRST_CHARACTER,
                SORT_BY_ASCENDING_EXPIRY_DATE,
                SORT_BY_DESCENDING_PRIORITY);
        model.commitFoodInventory();
        return new CommandResult(MESSAGE_SUCCESS);
    }

}
