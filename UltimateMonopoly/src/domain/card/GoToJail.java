package domain.card;

import domain.Player;

public class GoToJail extends ChanceCard{

	protected GoToJail(String n, String d) {
		super(n, d);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player p, String s) {
		// TODO Auto-generated method stub
		p.goToJail();
	}

}
