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

        tail.setNext(head); //creating loop, if this is commented no loop is detected

        if(detectLoop()){
            System.out.println("The loop is detected in this Linked list");
        }
        else {
            System.out.println("The loop is not detected.");
        }
    }
    public static void displayList(){
        Node temp=head;
        System.out.println("The Linked List: ");
        while(temp.getNext()!=null){
            System.out.print(temp.getElement()+" -> ");
            temp=temp.getNext();
        }
        System.out.print(tail.getElement()+"\n");
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

    public static boolean detectLoop(){
        Node slow=head,fast=head;
        while(slow!=null && fast!=null && fast.getNext()!=null){
            slow=slow.getNext();
            fast= fast.getNext().getNext();
            if(slow==fast)
                    return true;
        }
        return false;

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
