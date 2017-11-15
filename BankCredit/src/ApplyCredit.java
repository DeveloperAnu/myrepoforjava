import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class ApplyCredit {

	public static void main(String[] args) {

		UserDetails user1 = new UserDetails();
		user1.setAccount_Number(1111111111L);
		user1.setAddress("3251 s parker rd");
		user1.setBalance(10500.00);
		user1.setCitizenship("GC1");
		user1.setDob("01/01");
		user1.setEmail_Address("linga.anusha1");
		user1.setName("AAA");
		user1.setPhone_Number(1234567890l);
		user1.setSsn(1111);

		UserDetails user2 = new UserDetails();
		user2.setAccount_Number(2222222222L);
		user2.setAddress("3252 s parker rd");
		user2.setBalance(10000.00);
		user2.setCitizenship("GC2");
		user2.setDob("02/02");
		user2.setEmail_Address("linga.anusha2");
		user2.setName("BBB");
		user2.setPhone_Number(2345678901l);
		user2.setSsn(2222);

		UserDetails user3 = new UserDetails();
		user3.setAccount_Number(3333333333L);
		user3.setAddress("3253 s parker rd");
		user3.setBalance(7800.00);
		user3.setCitizenship("GC3");
		user3.setDob("03/03");
		user3.setEmail_Address("linga.anusha3");
		user3.setName("CCC");
		user3.setPhone_Number(3456789012l);
		user3.setSsn(3333);

		UserDetails user4 = new UserDetails();
		user4.setAccount_Number(4444444444L);
		user4.setAddress("3254 s parker rd");
		user4.setBalance(6300.00);
		user4.setCitizenship("GC4");
		user4.setDob("04/04");
		user4.setEmail_Address("linga.anusha4");
		user4.setName("DDD");
		user4.setPhone_Number(4567890123l);
		user4.setSsn(4444);

		UserDetails user5 = new UserDetails();
		user5.setAccount_Number(5555555555L);
		user5.setAddress("3255 s parker rd");
		user5.setBalance(5300.00);
		user5.setCitizenship("GC5");
		user5.setDob("05/05");
		user5.setEmail_Address("linga.anusha5");
		user5.setName("EEE");
		user5.setPhone_Number(5678901234l);
		user5.setSsn(5555);

		UserDetails user6 = new UserDetails();
		user6.setAccount_Number(6666666666L);
		user6.setAddress("3256 s parker rd");
		user6.setBalance(3700.00);
		user6.setCitizenship("GC6");
		user6.setDob("06/06");
		user6.setEmail_Address("linga.anusha6");
		user6.setName("FFF");
		user6.setPhone_Number(6789012345l);
		user6.setSsn(6666);

		UserDetails user7 = new UserDetails();
		user7.setAccount_Number(7777777777L);
		user7.setAddress("3257 s parker rd");
		user7.setBalance(2700.00);
		user7.setCitizenship("GC7");
		user7.setDob("07/07");
		user7.setEmail_Address("linga.anusha7");
		user7.setName("GGG");
		user7.setPhone_Number(7890123456l);
		user7.setSsn(7777);

		Map<Integer, UserDetails> map = new HashMap<>();
		map.put(user1.getSsn(), user1);
		map.put(user2.getSsn(), user2);
		map.put(user3.getSsn(), user3);
		map.put(user4.getSsn(), user4);
		map.put(user5.getSsn(), user5);
		map.put(user6.getSsn(), user6);
		map.put(user7.getSsn(), user7);

		Iterator<Entry<Integer, UserDetails>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			UserDetails ua = it.next().getValue();
			System.out.println("print Name..> " + ua.getName() + "  " + "balance..>" + "    " + ua.getBalance());

			setUserCreditScore(ua);

		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ssn ");
		Integer s = sc.nextInt();
		// map.keySet().contains(s);
		// System.out.println("print keyset..>");

		if (!map.containsKey(s)) {
			System.out.println("not an existing customer");
		} else {
			System.out.println("credit score...>" + map.get(s).getCredit_Score());
			displayCreditApprovedOrNot(map.get(s));
		}
		
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Do you want to apply for new card...(Y/N)...>");
		String s1 = sc1.nextLine();

		// double balance;

		if (s1.equalsIgnoreCase("Y")) {
			System.out.println("enter ssn");
			Scanner sc2 = new Scanner(System.in);
			int ssn = sc2.nextInt();

			if (!map.containsKey(ssn)) {
				System.out.println(" not eligiable to apply");
			} else {

				UserDetails usrDet = map.get(ssn);
				double existingBalance = usrDet.getBalance();
				System.out.println("Apply ...>" + existingBalance);

				double newBalance = existingBalance - 1000;
				System.out.println(newBalance);

				usrDet.setBalance(newBalance);
				
				setUserCreditScore(usrDet);
				
				displayCreditApprovedOrNot(usrDet);
				//System.out.println("credit ...>" +(balance));
			}

			//

		}
		// Iterator<Entry<Integer, UserDetails>> it1 =
		// map.entrySet().iterator();
		// while (it1.hasNext()) {
		// UserDetails ua1 = it1.next().getValue();
		//
		//
		//
		//
		// //System.out.println("print Name..> " + ua1.getName() + " " +
		// "balance..>" + " " + ua1.getBalance());
		// }
	}


	public static void setUserCreditScore(UserDetails ua) {
		double balance = ua.getBalance();
		if (balance > 10000) {
			ua.setCredit_Score(500);

			// System.out.println("print credit score is 500");
			// System.out.println("Decline");
		} else if (balance > 7500 && balance < 10000) {
			ua.setCredit_Score(600);
			// System.out.println("print credit score is 600");
			// System.out.println("print credit approval limit 2500");
		} else if (balance > 5000 && balance < 7500) {
			ua.setCredit_Score(650);
			// System.out.println("print credit score is 650");
			// System.out.println("print credit approval limit 5000");
		} else if (balance > 2500 && balance < 5000) {
			ua.setCredit_Score(700);
			// System.out.println("print credit score is 700");
			// System.out.println("print credit approval limit 7500");
		} else {
			// System.out.println("print credit score is 750");
			ua.setCredit_Score(750);
			// System.out.println("print credit approval limit 10000");
		}
	}

	public static void displayCreditApprovedOrNot(UserDetails userDetails) {
		Double creditScore = userDetails.getCredit_Score();
		System.out.println(creditScore);
		
		if (creditScore== 750) {
			System.out.println("Approve credit limit..> 10000");

		} else if (creditScore== 700) {
			System.out.println("approve credit limit...>7500");
		} else if (creditScore == 650) {
			System.out.println("approve credit limit...>5000");
		} else if (creditScore== 600) {
			System.out.println("approve credit limit...>2500");
		} else {
			System.out.println("decline");
		}

	}
}
