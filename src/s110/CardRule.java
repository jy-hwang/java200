package s110;

public class CardRule {

	/*
	 * C3C8    3000
	 * C1C3  C1C8   2000
	 * CTST X100 1000
	 * CXSX X100 X00
	 * C1S2 C2S1 99 ¾Ë¸®
	 * C1S4 S1C4 98 µ¶»ç
	 * C1S9 S9C1 97 »æ
	 * C1ST STC1 96 Àå»æ
	 * CTS4 STC4 95 Àå»ç
	 * C4S6 S4C6 94 ¼¼·ú
	 * ²ý X10
	 * 
	 */
	
	public int toV(Card c) {
		int count = 0;
		switch (c.getCardVal().charAt(1)) {
		case 'A':
			count = 1;
			break;
		case 'T':
			count = 10;
			break;
		default:
			count = c.getCardVal().charAt(1) - '0';
			break;// '7'-'0'
		}

		return count;

	}
	
	
	
	// ±¤ SUIT C

	public boolean isLight(Card c) {
		boolean isL = false;
		if (c.getCardVal().charAt(0) == 'C') {
			isL = true;
		}

		return isL;

	}
	
	
	// ±¤(C) ÀÌ¸é¼­ º§·ù°¡ 1,3,8 -> C1,C3,C8

	public boolean is138(Card c) {
		boolean isC = false;
		if(isLight(c)) {
			
		
		if (c.getCardVal().charAt(0) == '1' || c.getCardVal().charAt(1) == '3' || c.getCardVal().charAt(1) == '8' ){
			isC = true;
		}
		}
		return isC;

	}
	
	public int rule(Card c1, Card c2) {

		int count = 0;

		if (is138(c1) && is138(c2)) {

			// ±¤ Ã³¸® 1,3,8

			if ((toV(c1) * toV(c2) == 24) && (toV(c1) + toV(c2) == 11)) { // 3 8
				count = 3000;

			} else if ((toV(c1) * toV(c2) == 3) && (toV(c1) + toV(c2) == 4)) { // 1 3
				count = 2000;

			} else if ((toV(c1) * toV(c2) == 8) && (toV(c1) + toV(c2) == 9)) { // 1 8
				count = 2000;

			}

		} else {
			// ¶¯ Ã³¸® ¿ø Æä¾î!! ¾ÆÇÏ ¤»¤»¤»
			if ((toV(c1) == toV(c2))) { // 10, 10 -> 10000
				count = toV(c1) * 100;
			} else {
				// ³´ ¶¯!
				if ((toV(c1) * toV(c2) == 2) && (toV(c1) + toV(c2) == 3)) { // 1 2
					count = 99;
				} else if ((toV(c1) * toV(c2) == 4) && (toV(c1) + toV(c2) == 5)) { // 1 4
					count = 98;
				} else if ((toV(c1) * toV(c2) == 9) && (toV(c1) + toV(c2) == 10)) { // 1 9
					count = 97;
				} else if ((toV(c1) * toV(c2) == 10) && (toV(c1) + toV(c2) == 11)) { // 1 10
					count = 96;
				} else if ((toV(c1) * toV(c2) == 40) && (toV(c1) + toV(c2) == 14)) { // 4 10
					count = 95;
				} else if ((toV(c1) * toV(c2) == 24) && (toV(c1) + toV(c2) == 20)) { // 4 6
					count = 94;
				} else {
					// ²ý
					count = ((toV(c1) + toV(c2)) % 10) * 10;
				}
			}
		}
		return count;
	}

}
