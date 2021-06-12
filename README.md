# FlightGearAndroidApp
An Android remote control application that interfaces with the Flight Gear simulator 


#### Created by:
- Raviv Haham
- Peleg Haham



Project Description
-
In this project, we worked on several features:
- We created an Android remote control application that allows the user to enter the IP and port address, and by pressing on the "LET'S GO" button the user can start controlling the airplain in the Flight Gear simulator.


- A YouTube clip that explains our work: 

https://youtu.be/L7Bb8yZS0XY


## Requirements:

- Node.js is necessary in order to run the the project [(download link)](https://nodejs.org/en/).
- After installation, run the server and start investigate the anomalies.

## Project structure:

In this project we focused on MVC (Model, View, Controller), that could be seen a lot throughout the code.
We created a View ("index.html" and it's design "style.css". This view have a controller- "expServer.js" and Model- "anomalyHandler.js" of it's own.


![UML](https://imgur.com/NPSxlAi.png)

## Running this project on a brand new machine:

- Install Node.js (as mentioned above).

### Running

- Clone out repo using git clone
- To run the server side run the following commands:

>    cd FlightInspectionWebApp/Controller

>    node ./expserver.js

- Go into localhost:8080
- Upload the training csv file and test csv file to the website and click submit.
- Enjoy!


## Future improvements:

As we continue to work on this app, we encourage anyone that wants to help out to do so!
Just open the project in Visual Studio Code and add your own touches!
Other than that, we would appreciate if you would try to stick to our design language and patterns.
Have fun with this project and don't forget to create a pull request once you're done so this project could have a little bit of YOU in it!
