# How can we improve the walk-in waiting room experience?

## UOTTAHack2018 Team: OverLevel9000

### Team Members:
* [Arsalan Sadiq](https://github.com/arsalansadiq)
* [Benoît Jeaurond](https://github.com/BenJeau)
* [Fahim Farque](https://github.com/farque65)
* [Lucas Anderson](https://github.com/EarlyHemisphere)

### UOTTAHACK2018 RL Systems Hacking Challenge
  A multidevice app created to perform Client/Admin tasks based on the login commands which needs to be dispatched. Once the client information has been submitted, then a push notification is released which informs the client about the current waiting time in order to proceed to the Doctors walk-in hours. This communicates with a firebase app server by sending a message on to the firebase database. There is a function running on the server listening for updates to database information. When there is a new entry in the RequestApprove data a notification is sent to the admin. Once the admin approves the request, the wait time begins for the admin.
