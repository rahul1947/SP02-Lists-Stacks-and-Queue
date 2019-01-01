# Short Project 02 SP2: Implementation of Bounded Queue
 
 * Rahul Nalawade
 * Bharath Rudra
 
 Date: 2018-Aug-08
 

1. Extract the rsn170330.zip 

2. Compile: 
	$javac rsn170330/*.java

3. Run: 
	$java rsn170330.BoundedQueue

4. You may input integers 
	- 1 <space><integer> to offer(x) where x is the integer
	- 2 to poll()
	- 3 to peek()
	- 4 to call size() 
	- 5 isEmpty()
	- 6 clear()
	- 7 toArray()
	- 8 to Quit

Note:

- Pointers (front,rear) are initially at (-1,-1).

- whenever the queue is emptied, pointers are reset to (-1,-1)

- whenever the element is added (offer), rear is incremented and then added at rear

- whenever the element is removed (poll), front is incremented returning the correct front
