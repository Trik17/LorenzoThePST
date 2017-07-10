package it.polimi.ingsw.GC_04.client.view;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.StringTokenizer;

import it.polimi.ingsw.GC_04.client.view.gui.GameBoardGUI;

public class ViewGUI extends ViewClient implements Runnable{
	
	private GameBoardGUI game;
	
	public ViewGUI() {
		super();
		try {
			game = new GameBoardGUI(this);
//			game.setState(state);
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
	}

	@Override
	public void chooseAction() throws RemoteException {
		game.setState(state);
	
//		printStateOfTheGame(state);

	}

	@Override
	public void setCouncilPrivilege(int nrOfPrivileges) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void printStateOfTheGame(String state) {
		System.out.println(state);
	}

	public void sendInput(String input) {
		StringTokenizer strTok = new StringTokenizer(input);
		if (strTok.nextToken().equals("MARKET"))
			input = sortMarketInput(input);
		try {
			serverStub.notifyObserversARemote(input);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

	private String sortMarketInput(String input) {
		StringTokenizer strTok = new StringTokenizer(input);
		if (strTok.countTokens() != 4)
			return input;
		else {
			String area = strTok.nextToken();
			String shop = strTok.nextToken();
			String dice = strTok.nextToken();
			String servants = strTok.nextToken();
			String ordered = area+" "+dice+" "+servants+" "+shop;
			return ordered;
		}
			
	}

	@Override
	public void run() {
		try {
			chooseAction();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
