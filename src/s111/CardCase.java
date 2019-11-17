package s111;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CardCase {

	private List<Card> cards = new ArrayList<Card>();

	public CardCase() {
		cards.clear();
	}

	public int count() {
		return cards.size();
	}

	public Card getCard(int index) {
		return cards.get(index);
	}

	public void make() {

		cards.clear();

		int suit = CardUtil.SUIT.length; // 2

		int valu = CardUtil.VALU.length;// 10

		int count = 0;

		while (count != valu * suit) {

			Card c = new Card();

			if (!cards.contains(c)) {

				cards.add(c);
				count++;

			}
		}
	}

	public void shuffle() {
		Collections.shuffle(cards);

	}

	public void print() {

		int valu = CardUtil.VALU.length;

		for (int i = 0; i < cards.size(); i++) {

			Card c = cards.get(i);
			System.out.printf("%s", c.toString());
			if ((i + 1) % valu == 0) {

				System.out.println();
			}

		}

	}

	public void sort() {
		// Collections.sort(cards,new CardComp());
		Comparator<Card> cmp = new Comparator<Card>() {

			@Override
			public int compare(Card c1, Card c2) {
				return c1.getCardVal().compareTo(c2.getCardVal());
			}

		};
		cards.sort(cmp);
	}

	public void rsort() {

		cards.sort(new Comparator<Card>() {

			@Override
			public int compare(Card c1, Card c2) {
				return -c1.getCardVal().compareTo(c2.getCardVal());
			}

		});

	}

	public void lambdasort() {
		cards.sort((c1, c2) -> {
			return c1.getCardVal().compareTo(c2.getCardVal());
		});
	}

	public void lambdasort2() {
		cards.sort(Comparator.comparing(Card::getCardVal));
	}

	public void lambdasort3() {
		cards.sort(Card::compareCard);
	}

	public void lambdarsort() {

		cards.sort((c1, c2) -> {
			return -c1.getCardVal().compareTo(c2.getCardVal());
		});

	}

	public void lambdarsort2() {

		Comparator<Card> myCard = (c1,c2) -> {return c1.getCardVal().compareTo(c2.getCardVal());};
		cards.sort(myCard.reversed());

	}

	public void lambdarsort3() {

		cards.sort(Card::compareRCard);

	}
}
