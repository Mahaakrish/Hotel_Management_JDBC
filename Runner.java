package pra;
import java.util.Scanner;
public class Runner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int flag=0,ch1,ch2;
		String eid,name,job,addr,msg;
		int phno,id,gid;
		while(flag==0) {
			System.out.println("Operate as:\n1. Manager\n2. Guest\n3. Exit");
			System.out.println("Enter your choice: ");
			ch1 = sc.nextInt();
			switch(ch1) {
			
			//Manager
			case 1:
				Manager m = new Manager();
				flag = 1;
				while(flag==1) {
					System.out.println("-------------------------------");
					System.out.println("1. Add Staff\n2. Remove Staff\n3. Exit from Manager");
					System.out.println("Enter your choice: ");
					ch2 = sc.nextInt();sc.nextLine();
					switch(ch2) {
					case 1:
						System.out.println("Enter id: ");
						eid = sc.nextLine();
						System.out.println("Enter Name: ");
						name = sc.nextLine();
						System.out.println("Enter phno: ");
						phno = sc.nextInt();sc.nextLine();
						System.out.println("Enter Job: ");
						job = sc.nextLine();
						m.addStaff(eid, name, phno, job);
						break;
					case 2:
						System.out.println("Enter Employee id to remove: ");
						eid = sc.nextLine();
						m.removeStaff(eid);
						break;
					case 3:
						flag = 0;
						System.out.println("-------------------------------");
						break;
					default:
						System.out.println("Invalid Choice");
					}
				}
				break;
				
			//Guest
			case 2:
				Guest g = new Guest();
				flag = 1;
				while(flag==1) {
					System.out.println("-------------------------------");
					System.out.println("1. Check-in new Guest\n2. Order Food\n3. Complain\n4. Give Feedback\n5. Check-out\n6. Exit from Guest");
					System.out.println("Enter your choice: ");
					ch2 = sc.nextInt();sc.nextLine();
					System.out.println("-------------------------------");
					switch(ch2) {
					case 1:
						System.out.println("Enter Guest ID: ");
						id = sc.nextInt();sc.nextLine();
						System.out.println("Enter Guest Name: ");
						name = sc.nextLine();
						System.out.println("Enter Guest Phone No.: ");
						phno = sc.nextInt();sc.nextLine();
						System.out.println("Enter Guest Address: ");
						addr = sc.nextLine();
						g.checkIn(id, name, phno, addr);
						break;
					case 2:
						System.out.println("Enter Guest ID: ");
						gid = sc.nextInt();
						System.out.println("1. Idli\n2. Dosa\n3. Biryani\n4. Full Meals");
						System.out.println("Enter Food ID: ");
						id = sc.nextInt();
						g.orderFood(gid, id);
						break;
					case 3:
						System.out.println("Enter Guest ID: ");
						gid = sc.nextInt();sc.nextLine();
						System.out.println("Enter Complaint: ");
						msg = sc.nextLine();
						g.complain(gid, msg);
						break;
					case 4:
						System.out.println("Enter Guest ID: ");
						gid = sc.nextInt();sc.nextLine();
						System.out.println("Enter Feedback: ");
						msg = sc.nextLine();
						g.submitFeedback(gid, msg);
						break;
					case 5:
						System.out.println("Enter Guest ID: ");
						gid = sc.nextInt();sc.nextLine();
						g.checkOut(gid);
						break;
					case 6:
						flag = 0;
						System.out.println("-------------------------------");
						break;
					default:
						System.out.println("Invalid Choice");
					}
				}
				break;
				
			case 3:
				flag = 1;
				break;
			default:
				System.out.println("");
			}
		}
	}
}
