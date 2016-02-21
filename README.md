# Recipr

**ANDROID DEVELOPER NANODEGREE - UDACITY**

CHRISTOPH HENNEMANN




### Description
Recipr is an application which enables users to manage their personal recipes. They can add new recipes by entering the required ingredients and the steps to perform. Additionally, they have to provide a name and a category which allows for better organization and search ability. Optionally the user can add an image of his cooking performance to help him to decide what to eat next in the future.
When opened, Recipr presents the user a list of his favorite recipes alphabetically sorted. A swipe to the left reveals all recipes ordered into categories. With this approach the user can fast skim through the available categories to select the flavor for his upcoming meal. He is then presented with a sorted list of all available recipes of this category.

The detail view of one recipe is powered by a full-fledged image (if present) that helps the imagination. Also the user can see his rating of his previous cooking adventures with this recipe for better reference.

If the user wants to he can login in with his Google Account. This enables Recipr to send the recipes to a server to sync them across all devices of the user. Therefore, the user is prompted to login at the first app start. If not wished the user can always skip the sign in process to use Recipr only locally. Sync can be enabled at any later time.



### Intended User
A typical user of Recipr is a person that is responsible for making food or simply enjoys cooking. The user might have some recipe books at home but wishes to use a unified interface where he can find and add all his recipes.



### Features
 - Displaying of recipes
 - Adding of new recipes
 - Ordering recipes inside categories
 - Favor certain recipes
 - Rate recipes
 - Sync recipes with an API
 - Search for recipe by name
 - Deleting of recipes



### User Interface Mocks

##### Screen 1 - Favorites

<img src="https://github.com/chennemann/Recipr/blob/master/externalResources/screen1.png" width="480px" />

Start screen of Recipr. Displays all favored recipes. Promotes the action to add a new recipe. The main screen of Recipr is divided by a View Pager to conveniently add more content and value to the user.

##### Screen 2 - Categories

<img src="https://github.com/chennemann/Recipr/blob/master/externalResources/screen2.png" width="480px" />

The second screen of the View Pager displays the category view where every category is listed. The user can scroll through the list and open a view with all recipes of a single category with a single click.

##### Screen 3 - Single category

<img src="https://github.com/chennemann/Recipr/blob/master/externalResources/screen3.png" width="480px" />

The view the user is presented with when clicking on the ‘more’ option of a single category in the category overview.

##### Screen 4 - Single recipe

<img src="https://github.com/chennemann/Recipr/blob/master/externalResources/screen4.png" width="480px" />

Detail view of a single recipe. Divided into three separate sections. At the top the user finds the title, the category, his rating and a full-fledged image of the recipe. Below the ingredients with their respective quantities are listed. And last but not least the Steps to create the meal are listed at the bottom. The user has the ability to rate this recipe and can mark it as one of his favorites.

##### Screen 5 - Add new recipe

<img src="https://github.com/chennemann/Recipr/blob/master/externalResources/screen5.png" width="480px" />

The screen to add a new recipe asks the user to provide some meta information (such as title and category) for every recipe first. After that the user can add ingredients and steps to complete the recipe. Also he is able to take a picture and assign it to the recipe.

##### Screen 6 - Add step

<img src="https://github.com/chennemann/Recipr/blob/master/externalResources/screen6.png" width="480px" />

Since adding a step requires some more information the user is presented with a dialog where he can enter a title for the step (such as “preparation”) and a detailed instruction.

##### Screen 7 - Favorites (Tablet)

<img src="https://github.com/chennemann/Recipr/blob/master/externalResources/screen7.png" width="480px" />

At bigger screens the content is laid out to use the space to show more recipes at a time.

##### Screen 8 - Categories (Tablet)

<img src="https://github.com/chennemann/Recipr/blob/master/externalResources/screen8.png" width="480px" />

The same considerations are used for the categories view.



### Key Considerations

##### Data persistence
The persistence of Recipr will be implemented using a SQLite Database that can be accessed through a Content Provider. The database schema will follow the illustration below:

<img src="https://github.com/chennemann/Recipr/blob/master/externalResources/data_persistence.png" />


##### Utilized Libraries

 - Glide for image loading and rendering ([https://github.com/bumptech/glide](https://github.com/bumptech/glide))
 - log for easier logging ([https://github.com/zserge/log](https://github.com/zserge/log))
 - FastAdapter for easier Recycler View implementation ([https://github.com/mikepenz/FastAdapter](https://github.com/mikepenz/FastAdapter))
 - compartment for easy MVP ([https://github.com/grandstaish/compartment](https://github.com/grandstaish/compartment))
 - Butter Knife for View Binding ([https://github.com/JakeWharton/butterknife](https://github.com/JakeWharton/butterknife))



### Project phases

##### Task 1 - Project Setup
 - Setup Android Project and configure Gradle
 - Implement small REST API

##### Task 2 - Database
 - Implement Content Provider
 - Implementing Content Loader

##### Task 3 - UI
 - Implementing Activities and Fragments
 - Implement Tablet UI
 - Implement Material Design
 - Implement recipes widget

##### Task 4 - Sync
 - Implement user login
 - Implement Google Sign in
 - Implement Sync Adapter

##### Task 5 - Advertisement
 - Implement Admob
