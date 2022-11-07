# Flight Gear Android App
An Android remote control application that interfaces with the Flight Gear simulator 


#### Created by:
- Raviv Haham
- Peleg Haham

![UML](https://imgur.com/WyUWqqz.png)


Project Description
-
In this project, we worked on several features:
- We created an Android remote control application that allows the user to enter the IP and port address, and by pressing on the "LET'S GO" button the user connect to the IP where the flight simulator is running (and to the port that the simulator listens), so he can start controlling the airplain in the Flight Gear simulator.
- The app has two SeekBars, one for the Throttle and the second for the Rudder. The app also has a virtual joystick that communicates with the simulator.
  The X-axis determines the value of the Elevator and the Y-axis determines the value of the Aileron of the airplane in the Flight Gear simulator.



- A YouTube clip that explains our work: 

   https://youtu.be/Ub19cbKgylQ




## Requirements:

- Flight Gear simulator is necessary in order to run and play the simulation [(download link)](https://www.flightgear.org/download/).
- Android Studio is also necessary in order to run the project [(download link)](https://developer.android.com/studio).
- Of course another option to run our remote is to download the software to your personal mobile device.
- After installation, run the application, open the flight simulator- FlightGear, then in the Settings tab go to "Additional Settings"
 and write the following setting:
"--telnet = socket, in, 10,127.0.0.1,6400, tcp". Now connect to the IP where the flight simulator is running and to the port that the simulator listens, and just start and start flying your plane.

## Project structure:

In this project we focused on MVVM architecture(Model, View, View-Model), that could be seen a lot throughout the code.
We created a View ("MainActivity.java" and it's design "activity_main.xml". The View contains EditText for the IP and Port, and a Connect button.
The seekBar of the throttle is vertical, and the seekBar of the rudder is horizontal. The joystick is also responsible for changing the aileron value for X-axis displacement and the elevator value for Y-axis displacement. This view also contains the "JoystickView.java" class that serves as an external joystick component wich doesn't recognize the View-Model at all. The view have a View-Model- "ViewModel.java", so it communicates with it's view-model by data-binding with which it transmits the value of the Throttle and the Rudder (that set with the seekBars). The view also transmits the value of the Elevator and the Aileron (that set with the joystick), with the help of an external function (Runnable onChange) which is passed to the "JoystickView.java" class from the "MainActivity.java" class, and by this we impliment the dependency injection Strategy patern. The Model is- "FGPlayer.java", all the instructions are sent to the flight simulator from this class. The model reveals methods for the movements of the rudders, Aileron, elevator, and throttle .In addition it connects to the flight simulator, and sends the relevant strings (by PrintWriter) to the flight simulator respectively. In the Model all this operations are performed in a separate thread from the thread that initiates the operations, by using the Active Object design and by this we achieve decoupling between the initiating thread and the operating thread.
So we can see that the View involves to the ViewModel by using Data Binding, which in turn will give commands to the Model, and the Model communicate with the flight simulator.


![UML](https://imgur.com/NPSxlAi.png)

## Running this project on a brand new machine:

- Install Flight Gear simulator and Android Studio (as mentioned above).

### Running

- Clone out repo using git clone
- To run our remote app write the following commands in the Settings tab -> Additional Settings" in the flight simulator- FlightGear:

>    --telnet = socket, in, 10,127.0.0.1,6400, tcp

- Go into the Android Studio and run the app.
- Connect to the IP where the flight simulator is running and to the port that the simulator listens and click the  "LET'S GO" button.
- take a flight and Enjoy!


## Future improvements:

As we continue to work on this app, we encourage anyone that wants to help out to do so!
Just open the project in Android Studio and add your own touches!
Other than that, we would appreciate if you would try to stick to our design language and patterns.
Have fun with this project and don't forget to create a pull request once you're done so this project could have a little bit of YOU in it!
