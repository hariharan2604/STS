// You are using Java
import java.util.Scanner;
public class Main {
    public static Node head=null;
    public static Node temp=head;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number of Elements: ");
        int n=scanner.nextInt();
        while(n>0){
            System.out.println("Enter data: ");
            int data=scanner.nextInt();
            addNode(data);
            n--;
        }
        displayList();
    }
    public static void displayList(){
        Node temp=head;
        System.out.println("The Linked List: ");
        while(temp.next!=null){
            System.out.println(temp.element);
            temp=temp.next;
        }
        System.out.println(tail.element);
    }
    public static void addNode(int element){
        Node newNode=new Node(element);
        if(head==null){
            head=newNode;
            temp=head;
        }
        else{
            temp.next=newNode;
            temp=newNode;
        }

    }
}

class Node {
    public  int element;
    public Node next;

    Node(int data){
        this.element=data;
        this.next=null;
    }
}
