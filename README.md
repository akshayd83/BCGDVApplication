# Basic Application to add Tasks(Notes).

   Uses Of RecyclerView to populate task
   
   
   **It has 3 classes:**
     1)	Task: This is an Object Model representation of each task user adds. Contains String task name and a boolean status (done or not done).
     2)	MyTaskActivity: The only activity in the application responsible to display user the tasks and inflate the RecyclerView to show the added tasks.
     3) MyTaskAdapter: A RecyclerView Adapter responsible to show the list of added Tasks.
   
   
   **Overflow menu to Check and Uncheck Tasks**
     The default state of all tasks is unchecked.
     An overflow menu is provided to check and uncheck all the added tasks in the list.
   

   
   **App Limitations**
   Kindly note some of the app constraints:
     1) For the time's sake, the app only supports portrait mode
     2)  The tasks added are not persisted by the application i.e. if the application is exited, all the tasks are lost.
             
   
   


