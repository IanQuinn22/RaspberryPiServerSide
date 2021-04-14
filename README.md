# RaspberryPiServerSide
This repository contains the code needed by the Raspberry Pi to stream the video and display the messages from the client application. Note that some parts of the implementation may need to be changed top reflect user-specific needs.

## Environment
In order to use this project, you will need a Raspberry Pi and a Raspberry Pi camera strip. You will also need Java and Python installed.

## Installation/Running
In order to use this application, you will need to install both RaspPiServer.java and RaspberryPiCameraStream.py on your Raspberry Pi. To run the camera stream, simply run the following command:
```
python3 RaspberryPiCameraStream.py
```
To run the server, run the following commands:
```
javac RaspPiServer.java
java RaspPiServer
```

## Parameters
You can change the port number that the server runs on. Currently the port number is set to 12345. To change it, in the runServer() function, simply change the constructor value for ServerSocket.

## Future Improvements
The future of this project should focus on using a camera whose movements can be contrrolled by the application. This would allow the client application to move the camera based on what they are seeing.
