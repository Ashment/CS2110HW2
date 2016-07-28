CS2110 HW3

Collaboration: done by Baizhou and Baichuan Hou

Question 1
The proofs for question 1 are named proof1a.pdf and proof1b.pdf and proof1c.pdf. Please take a look.


Question 2
To launch, run the .jar file or run Manager.class through eclipse. In the console there is all the background things being printed, such as customers moving from queue to queue and customer joining queues. The program runs on 11 separate threads, with each cashier being its own individual thread, and a customer feeder, adding customers to cashier queues running in parallel. As mentioned from previous homework, the queue class is highly extendable, and has been implemented for the practical purpose of this assignment.

The method of queue optimization is done by checking if there is a queue short enough to inspire a longer queue’s customer to join the other queue. Each queue has its own time keeping thread, which waits a random amount of time based on a deviation before clearing each customer. After each time a customer is added or removed or moved, the output window is updated, giving an accurate representation of the current status of the queues. Random numbers are utilized for adding customers to queues, too. It is also used to create realism in that the queues are not always being optimized.

The program successfully demonstrates not only the extendability mentioned from the last homework, but also shows an understanding of multi-threaded processing, and use of “busy” flag and time keeping mechanism to simulate a real-time scenario while avoiding any processing conflicts.