package tqsua.lab1stack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TqsSimpleStack<T> {
    private int limit = -1;

    private ArrayList<T> stack;


    public TqsSimpleStack(){
        this.stack = new ArrayList<>();
    }

    public TqsSimpleStack(int limit){
        this.limit = limit;
        this.stack = new ArrayList<>();
    }

    public void push(T val){
        if(this.limit > 0) {    //Check if its a bound stack
            if (this.stack.size() < limit)  //Check if we still have space
                this.stack.add(val);
            else
                throw new IllegalStateException();
        }else {
            this.stack.add(val);
        }
    }

    public T pop(){
        if(this.stack.size() == 0){
            throw new NoSuchElementException();
        }else{
            return this.stack.remove(this.stack.size()-1); //Remove from list and return
        }
    }

    public T peek(){
        if(this.stack.size() == 0){
            throw new NoSuchElementException();
        }else{
            return this.stack.get(this.stack.size()-1);
        }
    }

    public int size(){
        return this.stack.size();
    }

    public boolean isEmpty(){
        return this.stack.size() == 0;
    }
}
