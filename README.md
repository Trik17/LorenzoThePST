Prova Finale (Ingegneria del Software)
Gruppo 4
Andrea Tricarico, Miriam Peta (Laureanda) , Luigi Spiguzza 

Starting the game needs to start MainServer.class (in package server) and then 
MainClient.class (in package client) one time for each player.

All rules are implemented (permanent effects, excommunications, leader cards, timer, disconnection, multiple match at the same time).
Connection used: RMI.

The game works with CLI but there is also a beginning of a GraphicalUserInterface, made without automatic tools, that can be started starting MainGUI.class (in package client.view.gui); it is not linked with the rest of the game but it can open and show a given state of the game. It is possible to open cards and choose a family member. (Resolution used 1366x768)

In the main folder of the project there is a folder "classesSocketCommented" with some classes used previously for socket connection but unLinked for problems during the game.