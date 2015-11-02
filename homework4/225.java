class MyStack {
    Queue<Integer> queue1 = new LinkedList<Integer>();  
    Queue<Integer> queue2 = new LinkedList<Integer>();  
    Queue<Integer> q = new LinkedList<Integer>();  
    
    public void push(int x) {
        queue1.offer(x); 
    }

    
    public void pop() {
        while(queue1.size()>1) queue2.offer(queue1.poll());  
        queue1.poll();  
        Queue<Integer> q = queue1;  
        queue1 = queue2;  
        queue2 = q;  
    }

    
    public int top() {
        while(queue1.size()>1) queue2.offer(queue1.poll());  
        int x = queue1.poll();  
        queue2.offer(x);  
        Queue<Integer> q = queue1;  
        queue1 = queue2;  
        queue2 = q;  
        return x;  
    }

   
    public boolean empty() {
        return queue1.isEmpty(); 
    }
}