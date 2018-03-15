import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.scheffer.erik.androidjokelibrary.ShowJokeActivity.JOKE_EXTRA_ID;

@RunWith(AndroidJUnit4.class)
public class MainTest {
    @Rule
    public IntentsTestRule<MainActivity> recipesActivityRule =
            new IntentsTestRule<>(MainActivity.class);
    private IdlingResource idlingResource;

    @Before
    public void setUp() throws Exception {
        recipesActivityRule.getActivity()
                           .getSupportFragmentManager().beginTransaction();
        idlingResource = recipesActivityRule.getActivity().getIdlingResource();
        Espresso.registerIdlingResources(idlingResource);
    }

    @Test
    public void verifyStepListActivityOpened() {
        onView(withId(R.id.tell_joke_button)).perform(click());
        intended(hasExtra(JOKE_EXTRA_ID, "This is totally a funny joke"));
    }

    @After
    public void unregisterIdlingResource() {
        if (idlingResource != null) {
            Espresso.unregisterIdlingResources(idlingResource);
        }
    }
}
