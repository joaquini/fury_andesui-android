Thanks for helping to grow this project!

# General Contributing Guidelines
If you would like to contribute code to this project you can do so by forking the repository and sending a Pull Request.

When submitting code, please make every effort to follow existing conventions and style in order to keep the code as readable as possible.

## Get involved in how the library actually works.
There are many ways to get involved with Andes UI.
- You already started with the right foot by reading this Contributing file ;)
- You can fly from here and land on the [Wiki](https://github.com/mercadolibre/fury_andesui-android/wiki)
- Now you're ready to watch a movie. Well, is not exactly a movie, but is a video. A tech talk, to be honest.
A tech talk we gave at Mercado Libre that serves as an onboarding to the internals of this library. [Watch it here!](https://drive.google.com/open?id=1a8KBwlILW-JOnrO8cEGuQ7CNYSORJg4A)
- Oh, I see! You want to get your hands dirty. Fork this repo, run the Demo App and start developing a new Andes component. Or maybe you can improve an existing one.

# I want to develop a new component or to fix an existing one
Nice, we like you! Andes UI is a collaborative project, so we need the help of everyone to keep it up.
We expect to be all aboard this boat... and we are a lot. That's why we have some rules!

## Happy path of your new code
- You start by forking this Andes repo.
- You make the necessary changes and you test them in the Demo App.
    - If it's a new component then you'll have to add a new Button inside the main page of the Demo App that links to a new Activity that will be the showcase of that new component. You also will have to add that Activity, based on the existing one. Be aware that all the sample activities have a deeplink. For example, the deeplink of the Button Showcase is `meli://andes/button`. Checkout the Demo App's manifest file. Be sure to follow the existing way of developing those showcases. Or propose us a radical new way :D
    - If it's a variation of an existing component (i.e. you develop a new feature for the Andes Button that allows it to become a jumping button, please add this use case to the existing Button Showcase. We all love animations).
- You are proud of your work. That new feature rocks. (Or thanks to this fix, the component now really rocks). You run `./gradlew check` and everything ran perfectly and smooth. Oh, boy, this needs to be part of Andes UI. Now you commit your latest changes.
- You make a local publish and you test the changes in an external project that consumes this lib.
- In your fork you have a branch called `feature/<name-of-new-andes-component>`, or maybe `fix/<name-of-the-fixed-andes-component>`, and you got all the changes committed there.
- You go to the Andes UI repo and open a Pull Request. You read all the lines inside the suggested template. And also you tick those checkboxes with those ugly questions. You are getting closer to the glory. Take some screenshots and add them to the Pull Request! The world needs to be aware of this.
- You finally create the Pull Request. Continuous Integration starts to work (did we say we use Circle CI?). What am I seeing? All those checks in green! Nice!
- Our guys check that shiny Pull Request, put some evil comments, you agree with them, you make the changes and... Oh, the Pull Request gets merged.
- Nice job! We really thank you.

## How to make a local publish
``
./gradlew build publishToMavenLocal
``

*Pro tip*: First change the version name in gradle.properties to X.XX.X-LOCAL (Note that we use [SemVer](https://semver.org/)).

## Running the Demo App
Before submitting a Pull Request, please make sure the Demo App is able to show the results of your heavy work.

## Running the tests
Before submitting a Pull Request, please run `./gradlew check` and be sure that everything gets green. Or yellow. But certainly not red. Well, with no errors, you know.

## Contact us
We actively monitor this library, but you can ping us yo tell us that we should check out that new Pull Request.