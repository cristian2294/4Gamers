# 4Gamers

In this application you can get a list of games, if you select one you will go to the detail view.

you can see the game's title, developer name, creation date, and a complete description of the game. Additionally, at the bottom of the screen, you will have a button that when clicked will add the game to your favorites.

In the favorites section, you will have a list of your favorite games, for each game in the upper right you will find a heart icon. The game will be removed from your favorites section if you click on the heart.

Finally, in the Categories section, you can see a list of game categories, for each type or category you have a game catalog

### Topics
some topics and frameworks that I implemented in this app were:

- Architecture: MVVM
- Repository pattern
- Clean Architecture
- LiveData
- ROOM for local storage (Favorite Section)
- Retrofit and GSON for consuming API
- MOCKK for unit test
- Coroutines for thread management
- Hilt Dagger for dependencies injection
- SplashScreen Framework
- Nested Recyclerview in the categories section

## Architecture

for the development of this application, I decided to use an MVVM, MVP is a good option for small Apps but when you use MVVM you don't have to worry about the persistence of the data for example when you rotate the smartphone because the liveData allows that the data conserves.

Also, I Implemented clean architecture because is the better option for keeping a clean code. I dived the project into four layers:

data, di, domain, and ui

For the data layer, I have files for the consuming API, repository pattern, local storage, and the class model

For the di layer, I have all about Dependencies Injection Setup

For the domain layer, I have all about business logic (Use cases)

Finally, for the UI layer, I have all about the user interface, views, viewmodels, adapters, fragments, viewholders.

## Screenshots

here share with you some screenshots:

#### Splash Screen

![ScreenShot](https://github.com/cristian2294/4Gamers/blob/main/app/src/main/res/drawable/img0.jpeg)

#### Home
![ScreenShot](https://github.com/cristian2294/4Gamers/blob/main/app/src/main/res/drawable/img1.jpeg)
![ScreenShot](https://github.com/cristian2294/4Gamers/blob/main/app/src/main/res/drawable/img2.jpeg)

#### Detail
![ScreenShot](https://github.com/cristian2294/4Gamers/blob/main/app/src/main/res/drawable/img3.jpeg)

#### Favorites
![ScreenShot](https://github.com/cristian2294/4Gamers/blob/main/app/src/main/res/drawable/img4.jpeg)

#### Categories
![ScreenShot](https://github.com/cristian2294/4Gamers/blob/main/app/src/main/res/drawable/img5.jpeg)
