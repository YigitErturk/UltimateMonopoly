package domain.square;

import domain.Player;

public class BirthdayGift extends Square {

	public BirthdayGift() {
		super("Birthday Gift", "dsc");
	}

	@Override
	public void landOn(Player player) {
		super.landOn(player);
		// TODO implement square specific logic
		int money = 100;
		player.increaseMoney(money);
	}

}
