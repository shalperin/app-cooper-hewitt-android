# Moderne
by Sam Halperin <sqh@me.com>

![](/readme-assets/screenshots.png?raw=true)

## Why this app?
When I was taking an art history class as part of my Fine Arts
Major a million years ago, one of the things we had to do was
accurately place an artifact within a particular artistic period.
(e.g. American Modern, World War II, Victorian )

One of the things I think this app does particularly well is quickly
switch between periods in the Cooper Hewitt collection to display
representative pieces.

[![Download it now on Google Play](/readme-assets/google_play.png?raw=true)](https://play.google.com/store/apps/details?id=com.samhalperin.cooperhewitt)

## Architecture Overview
The app uses an MVP architecture to make testing easier.  Each piece of 
functionality (data, individual screens in the app, etc...) is in its own
package.  For each screen, the Activity is the View, and conforms to 
an interface defined in a Contract for that screen.  There is a Presenter
object also defined in that Contract.  The data Repository also has it's own
interface defined in a RepositoryContract.

This makes JUnit4 tests (i.e. tests that are _not_ instrumented) easier,
as we can just poke at the Presenter and observe changes on a mocked Repository
or View.

*An example MVP Interface from the main screen of the app.*

    public interface MasterContract {

        public interface View {
            void navigateToAboutActivity();
            void navigateToDetailActivity(String id);
            void displayPage(List<SearchObject> items);
            void displayProgressBar();
            void hideProgressBar();
            void clearResults();
        }

        public interface UserActionHandler {
            void loadPage(int pageNumber, boolean clear);
            void selectArtisticPeriod(int period);
            void navigateToDetailActivity(String id);
            void navigateToAboutActivity();
        }
    }

## Where to go from here
### Some questions:
+ Is the selection Spinner for artistic periods "discoverable"?  When landing
in the app, do people know that they can switch from "World War II" to a large
array of other artistic periods?  Should we add some "tour" UI on first load?
+ Idea:  Could implement a "quiz" that would pick an artifact at random and
ask about it's artistic period.
+ What is the copywrite on these images.... if someone wanted a poster would
it be legal to integrate with a custom printing service and have one shipped
to them?
+ What are the user stories for users of this app?  Are they primarily looking
for things like museum hours and location (map), or is the app as it stands
fulfilling their needs?  Is there a use case that would make the app more popular
and/or useful?
+ The Cooper Hewitt API "square" image isn't really representative of the actual
artifact.  Could we retune the app in some way as to show more of the actual artifact
in the thumbnail?

