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

        tail.next=head; //creating loop, if this is commented no loop is detected

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
        while(temp.next!=null){
            System.out.print(temp.element+" -> ");
            temp=temp.next;
        }
        System.out.print(tail.element+"\n");
    }
    public static void addNode(int element){
        Node newNode=new Node(element);
        if(head==null){
            head=newNode;
            tail=head;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
    }

    public static boolean detectLoop(){
        Node slow=head,fast=head;
        while(slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast= fast.next.next;
            if(slow==fast)
                    return true;
        }
        return false;

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
