package Library_Management;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Entity_2{
	private int bookid;
	private String bookname;
	private double price;
	public Entity_2(int bookid, String bookname, double price) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.price = price;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "[bookid=" + bookid + ", bookname=" + bookname + ", price=" + price + "]";
	}
}
class Set_1{
	Scanner sc=new Scanner(System.in);
	ArrayList<Entity_2>al=new ArrayList<Entity_2>();
	public void add() {
//		ArrayList<Entity_2>al=new ArrayList<Entity_2>();
		System.out.println("Enter Book ID: ");
		int id=sc.nextInt();sc.nextLine();
		System.out.println("Enter Book Name: ");
		String name=sc.nextLine();
		System.out.println("Enter Price: ");
		double price=sc.nextDouble();sc.nextLine();
		
		al.add(new Entity_2(id,name,price));
		System.out.println("\n");
	}
	public void modify() {
		System.out.println("Enter Book ID to Modify: ");
		int id=sc.nextInt();sc.nextLine();
		
		boolean condition=false;
		for(Entity_2 e:al) {
			if(e.getBookid()==id) {
				System.out.println("Book Id Founded!!...");
				System.out.println("Enter new Book Name: ");
				String namenew=sc.nextLine();
				System.out.println("Enter new Price: ");
				double newprice=sc.nextDouble();sc.nextLine();
				e.setBookname(namenew);
				e.setPrice(newprice);
				condition=true;
				System.out.println("Updated Successful!!...");
			}
		}
		if(!condition) {
			System.out.println("Book Id Not Founded");
		}
		System.out.println("\n");
	}
	public void delete() {
		System.out.println("Enter Book ID to Delete: ");
		int id=sc.nextInt();sc.nextLine();
		
		boolean condition=al.removeIf(s->s.getBookid()==id);
		if(condition) {
			System.out.println("Book History Deleted Successful!!...");
		}else {
			System.out.println("Book ID Not Founded");
		}
		System.out.println("\n");
	}
	public void display() {
		if(al.isEmpty()) {
			System.out.println("No Records Found");
		}else {
			System.out.println("\n#===Book History===#");
			for(Entity_2 e:al) {
				System.out.println(e);
			}
		}
		System.out.println("\n");
	}
	public void sort() {
		if(al.isEmpty()) {
			System.out.println("Please First Add Details");
		}else {
			System.out.println("1.Sort by Id");
			System.out.println("2.Sort by Name");
			System.out.println("3.Sort by Price");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				Collections.sort(al,Comparator.comparing(a->a.getBookid()));
				for(Entity_2 e:al) {
					System.out.println(e);
				}
				break;
				
			case 2:
				Collections.sort(al,Comparator.comparing(b->b.getBookname()));
				for(Entity_2 e:al) {
					System.out.println(e);
				}
				break;
				
			case 3:
				Collections.sort(al,Comparator.comparing(c->c.getPrice()));
				for(Entity_2 e:al) {
					System.out.println(e);
				}
				break;
			}
		}
		System.out.println("\n");
	}
	public void exit() {
		System.exit(0);
	}
}
public class Library_Management_System {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Set_1 ob=new Set_1();
		int ch;
		while(true) {
			System.out.println("#===Book Management System===#");
			System.out.println("1.Add Book Details");
			System.out.println("2.Modify Book Details");
			System.out.println("3.Delete Book Details");
			System.out.println("4.Display Book Details");
			System.out.println("5.Sort Book Details");
			System.out.println("6.Exit from System");
			ch=sc.nextInt();
			
			switch(ch) {
			case 1:
				ob.add();
				break;
				
			case 2:
				ob.modify();
				break;
				
			case 3:
				ob.delete();
				break;
				
			case 4:
				ob.display();
				break;
				
			case 5:
				ob.sort();
				break;
				
			case 6:
				ob.exit();
				break;
				
				default:
					System.out.println("Invalid Choice");
					break;
			}
		}
		
	}

}
