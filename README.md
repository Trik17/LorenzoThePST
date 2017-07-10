Prova Finale (Ingegneria del Software)
Gruppo 4
Andrea Tricarico, Miriam Peta (Laureanda) , Luigi Spiguzza 

GAME START: start MainServer.class (in package server), then MainClient.class (in package client) one time for each player.

All rules are implemented (permanent effects, excommunication tiles, leader cards, timer, disconnection, multiple match at the same time).
Connection used: RMI.

There are Json file to configure cards, timer, actionSpaces, personalBonusTiles, excommunicationTiles.

It is possible to carry out a full match with CLI, but there's also an unfinished GraphicalUserInterface, made without automatic tools.
It allows you to do only actions that doesn't request Controller.class interaction and shows other bugs. (Resolution used 1366x768) 

In the main folder of the project there is a folder "classesSocketCommented" with some classes used previously for socket connection but unLinked for problems during the game.