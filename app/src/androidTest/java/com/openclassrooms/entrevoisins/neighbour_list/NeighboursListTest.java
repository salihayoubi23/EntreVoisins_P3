
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.contrib.ViewPagerActions.scrollRight;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;

    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);


    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(ViewMatchers.withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .perform(actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(ViewMatchers.withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT-1));
    }
    /**
     *  when you click on an item in the list, the details screen is launched
     */
    @Test
    public void myNeighboursList_clickAction_shouldDisplayNeighbourDetails()
    {

        onView(withId(R.id.list_neighbours)).perform(click());
        onView(withId(R.id.activity_neighbours_details)).check(matches(isDisplayed()));
    }

    /**
     *  at the start of the new screen, the TextView indicating the name of the user in question is filled in;
     */

    @Test
    public void myNeighboursList_clickItemAction_shouldDisplayNeighbourNameInDetails()
    {
        onView(withId(R.id.list_neighbours)).perform(click());
        onView(withId(R.id.name_1)).check(matches(not(withText(""))));

    }

    /**
     *  test that the Favorites tab only displays favorite neighbors and at the click of the button of suppression, the list of users counts well a user in less
     * @return
     */

    @Test
    public void myFavoriteNeighboursList_shouldOnlyDeleteFavoriteNeighbours(){
        onView(ViewMatchers.withId(R.id.favorite)).check(withItemCount(0));
        for (int i = 0; i < 3; i++){
            onView(withId(R.id.list_neighbours))
                    .perform(RecyclerViewActions.actionOnItemAtPosition(i,click()));
            onView(withId(R.id.btn_favorite)).perform(click());
            onView(withId(R.id.back_btn)).perform(click());
        }
        onView(withId(R.id.container)).perform(scrollRight());
        onView(ViewMatchers.withId(R.id.favorite)).check(withItemCount(3));
        onView(ViewMatchers.withId(R.id.favorite))
                .perform(RecyclerViewActions.actionOnItemAtPosition( 0, new DeleteViewAction()));
        onView(ViewMatchers.withId(R.id.favorite)).check(withItemCount(2));
    }
    }
