import java.util.Scanner;

public class Runner {
	
	public static void main(String[] args) {
		
		User[] users = new User[4];
		
		Book book1 = new Book("001", "The Secret History", "Donna Taratt", 50);
		Book book2 = new Book("002", "Brideshead Revisited", "Evelyn Waugh", 45);
		Book book3 = new Book("003", "Anna Karenina", "Leo Tolstoy", 67);
		
		Book[] books = {book1, book2, book3};
		
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		
		while(flag) {
		
			System.out.println("Press 1 for Registartion, Press 2 for Login and Press 0 for Exit");
			
			int choice = sc.nextInt();
			
			if(choice == 1) {
				
				System.out.println("Enter your Name!!");
				String name = sc.next();
				
				System.out.println("Enter your Username!!");
				String username = sc.next();
				
				System.out.println("Enter your password");
				String password = sc.next();
				
				System.out.println("Enter your Email-Id");
				String email = sc.next();
				
//				User user = new User();
//				user.username = username;   user.password = password;   user.name = name;   user.email = email;
				
				User user = new User(username, password, username, email);
				
				for(int i = 0; i < users.length; i++) {
					
					if(users[i] == null) {
						users[i] = user;
						break;
					}
				}			
			}
			else if(choice == 2) {
				
				boolean loginFlag = true;
				
				while(loginFlag) {
				
					System.out.println("Enter your Username!!");
					String username = sc.next();
					
					System.out.println("Enter your Password!!");
					String password = sc.next();
					
					for(int i = 0; i < users.length; i++) {
						
						if(users[i] == null) {
							System.out.println("Credentials wrong, please try again!!");
							break;
						}
						
						String uname = users[i].getUsername();
						String pwd = users[i].getPassword();
						
						if(uname.equals(username) && pwd.equals(password)) {
							System.out.println("Welcome "+users[i].getName());
							
							for(Book book : books) {
								
								System.out.println(book.getBookId()+", "+book.getBookName()+", "+book.getBookDesc()+", "+book.getPrice());
							}
							
							
							loginFlag = false;
							break;
						}
//						else {
//							if(users.length-1 == i) {
//								System.out.println("Credentials wrong, please try again!!");	
//							}	
//						}
					}
				}		
			}
			else {
				System.out.println("Goodbye, see you again!!");
				flag = false;
			}
		}
		
		
	}

}
