// Author: Omar Sobhy
import java.util.NoSuchElementException;

public class RQueue<T>
{
    private T front;
    private RQueue<T> inside;
    private T rear;
    
    // "enqueue" adds an item to the end of the queue
    public void enqueue(T item){
        if (front == null){
            front = item;
        }
        else if (front != null && rear == null) {
            rear = item;
        }
        else if (front != null && rear != null && inside == null) {
            T tempRear = rear;
            rear = item;
            RQueue<T> newQueue = new RQueue<T>();
            inside = newQueue;
            inside.enqueue(tempRear);
        }
        else {
            T tempRear = rear;
            rear = item;
            inside.enqueue(tempRear);
        }
    }
    
    // "peek" returns the item in the front of a queue
    public T peek(){
        if (front == null) {
            throw new NoSuchElementException("Queue is empty! Try again with another queue, or try adding items to the queue first.");
        }
        else {
        return front;
        }
    }
    
    // "dequeue" removes the last item added to a queue
    public T dequeue(){
        if (front == null){
            throw new NoSuchElementException("Queue is empty! Try again with another queue, or try adding items to the queue first.");
        }
        else {
            T frontTemp = front;
            if(rear == null){
                front = null;
            }
            else if (front != null && rear != null && inside == null) {
                front = rear;
                rear = null;
            }
            else{
                front = inside.dequeue();
                if (inside.front == null) {
                    inside = null;
                }
            }
            return frontTemp;
        }
    }
    
    // "display" prints out all the elements in a queue
    public void display(){
        if (front == null){
            throw new NoSuchElementException("Queue is empty! Try again with another queue, or try adding items to the queue first.");
        }
        else if (front != null && rear == null) {
            System.out.print(front);
        }
        else if (front != null && rear != null & inside == null) {
            System.out.print(front + " " + rear);
        }
        else {
            System.out.print(front + " ");
            inside.display();
            System.out.print(" " + rear);
        }
    }
}