package it.polimi.ingsw.GC_04.view;

import it.polimi.ingsw.GC_04.model.action.Action;
import java.util.List;

import it.polimi.ingsw.GC_04.model.effect.Effect;
import it.polimi.ingsw.GC_04.model.resource.Resource;

public class ViewGUI extends View {

	@Override
	public void chooseAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Resource setCouncilPrivilege() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAction(Action action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateResource(Resource resource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] setRequestedAuthorizationEffects(List<Effect> effects) {
		return	new int[0];	
	}

	@Override
	public int[] setFurtherCheckNeededEffect(Effect effect) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource setDiscount(Resource rawMaterial) {
		return rawMaterial;
		// TODO Auto-generated method stub
		
	}

}
