# Dice Game Mini Project

*Hatesh Singh Saini | HSS26 | UoL CS | CO2001 | Mini Project| 2018-2019*

## Importance of Usability Principles

Maximising the usability of software is vital to its success. The product is a solution to a problem and the usability of which is a heavy factor in its effectiveness. Software should be built to help the end user solve a problem rather than create more. This means that a comprehensive and thoughtful design should be incorporated from the very beginning of the project. Software that is second nature for a user to use will provide more use than a feature filled but difficult to navigate product.

## Aesthetic and Minimalist Design

In my project, I ensured that I kept my design as minimalistic as possible. This means that all the unnecessary information behinds the scenes are abstracted from the user view, and what remains is only useful and readable information. Minimalistic designs need to be balanced with information because the user still needs input and output interactions with the software. An example of this can be found on the game screen, where there is a lot of information.

I have included a game log to see the previous roll history throughout the gameplay, however, this view isn't necessary, hence why it is at the bottom of the screen, and underneath the previous roll text.

To give a clear indication as to who was winning, I decided to highlight the current winners' background green. This means that there is no need for text indication as well as being much faster for players to read this information.

## Help and Documentation

I also included a help screen, which has a description of the game including the mechanics of the game and as well as the rules. The help screen also includes an annotated game screen so players can understand what each area of the screen is designed to do.

The help page can be accessed from the Main Menu or the Welcome Screen. I chose this on purpose as there is a feature in the game to change the players. This loads the welcome page, therefore some players may need to read the description before beginning. There is also info text on this very screen recommending that player look at the help screen.

## Error Prevention

An example of Error prevention I have taken is in the max score text box. I added an event listener which uses a regex expression to ensure that only number characters can be entered. The result of which is only positive integers.

If a blank string is entered, this is caught and the info label then displays red text indicating that the max score should not be empty.

Currently, there is no maximum value for the max score other than **2,147,483,647**, the inclusive maximum for an `int` datatype, however, this can be easily added.