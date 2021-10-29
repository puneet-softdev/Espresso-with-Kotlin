# Espresso-with-Kotlin
Espresso UI Automation Test

The Espresso testing framework provides a set of APIs to build UI tests to test user flows within an app primarily to write automated UI tests

-- Steps to write First UI test case --

1. Create Test using JUnit4 (Currently no support of JUnit5)
  • Example:- MainActivityTest

2. Launch Activity for every test case
  • Example:- ActivityScenario.launch(MainActivity::class.java)


3. Find View i.e ViewMatcher
  • Find View By Id:- onView(withId(R.id.fab))
  • Find View By Text:- onView(withText("SET ALARM"))

4. Perform Action i.e Click, Typing
  • .perform(click())
  • .perform(typeText(“Hello I am typing some text“))

5. ViewAssertion
  • Example:- Check if View’s current state is displayed
    then pass this test case
  • .check(matches(isDisplayed()))

This project is build in Android with Kotlin Language using Espresso UI Framework for Test cases
Basic level push can get using this project, It primarily contains:-

-> Activity Launch, Display Test cases
-> Views find, View Perform Actions Test cases on Button, Edittext Typing etc.
-> RecyclerView Testcases
-> Action /or  Testcases on Menus and Overflow menus in Android

This project has 2 Activities, 1 Fab Button, EditText, Menu options, Recycler-view with local Data Source etc
