package s105;


public class CardMain {

	public static void main(String[] args) {

		Card c1 = new Card("H4");
		Card c2 = new Card("H4");

		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());

		System.out.println(c1.getCardVal());
		System.out.println(c2.getCardVal());

		System.out.println(c1.equals(c2));
		


		/*
		 * for (int i = 0; i < CardUtil.SUIT.length; i++) {
		 * 
		 * for (int j = 0; j < CardUtil.VALU.length; j++) { Card c = new Card(); // 임의로
		 * 카드 생성 - 기본생성자() System.out.printf("%s\t", c);// c.toString() }
		 * System.out.println(); }
		 */

	}

}
