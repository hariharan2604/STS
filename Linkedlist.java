import java.util.Scanner;
public class Main {
    public static Node head=null;
    public static Node tail=head;
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
        while(temp.getNext()!=null){
            System.out.println(temp.getElement());
            temp=temp.getNext();
        }
        System.out.println(tail.getElement());
    }
    public static void addNode(int element){
        Node newNode=new Node(element);
        if(head==null){
            head=newNode;
            tail=head;
        }
        else{
            tail.setNext(newNode);
            tail=newNode;
        }

    }
}

class Node {
    protected  int element;
    protected Node next;

    Node(int data){
        this.element=data;
        this.next=null;
    }

    public int getElement(){
        return this.element;
    }

    public Node getNext(){
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
