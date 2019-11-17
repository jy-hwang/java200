package s111;

import java.util.Date;
import java.util.Scanner;

public class Sutda {

	CardCase cc = new CardCase();
	CardRule rule = new CardRule();
	Card[] cc1 = new Card[CardUtil.SUTDA];
	Card[] cc2 = new Card[CardUtil.SUTDA];

	public Sutda() {
		cc.make();
	}

	private void divide() {
		for (int i = 0; i < CardUtil.SUTDA; i++) {

			cc1[i] = cc.getCard(i); // 0  ,   1 
			cc2[i] = cc.getCard(i + CardUtil.SUTDA); // 2    ,    3

		}

	}

	public void divide2() {
		for(int i = 0,j=0;i<cc1.length ; i++,j+=2) {
			cc1[i]=cc.getCard(j); 	//0 , 2
			cc2[i]=cc.getCard(j+1); // 1 , 3
		}
		
		
	}
	public void play() {
		Scanner scan = new Scanner(System.in);
		System.out.println("!!!Welcome to CardGame" + new Date() + "!!!");
		
		System.out.println("Start");
		String ss = "N";
		do {
			cc.shuffle();
			//divide();
			divide2();
			
			int v1 = rule.rule(cc1[0],cc1[1]);
			int v2 = rule.rule(cc2[0],cc2[1]);
			
			if( v1 > v2 ) {
				System.out.println("YOU WIN!!");
				
			}else if ( v1 < v2 ) {
			System.out.println("YOU LOSE!!");	
			}else {
				System.out.println("SAME SAME!!");
			}
			
			cc.print();
			System.out.println("YOU");
			System.out.printf(cc1[0]+" " + cc1[1]);
			System.out.println(rule.rule(cc1[0], cc1[1]));
			
			System.out.println("COM");
			System.out.printf(cc2[0]+" " + cc2[1]);
			System.out.println(rule.rule(cc2[0], cc2[1]));			
			
			System.out.println("!!!Welcome to CardGame" + new Date() + "!!!");
			System.out.println("Do you want to replay again?(Y/N)");
			ss = scan.next();
			
		}while ((ss.toUpperCase()).equalsIgnoreCase("Y")); //적어도 한번의 게임을 함
		System.out.println("Good Bye ~~~~");
		
	}
	
	
	
	
}
