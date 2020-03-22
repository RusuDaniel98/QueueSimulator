import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Server implements Runnable {

    public int serverId;
    public BlockingQueue<Task> tasks;
    public String tasksAsString = "";
    public int waitingPeriod;    //decremented by current thread once a task is completed
                                  //incremented by scheduler thread when adding a new task

    public Server(){
        //initialise queue and waitingPeriod
        this.tasks = new ArrayBlockingQueue<Task>(100);
        this.waitingPeriod = 0;
    }

    public void run(){
        try {
            synchronized (tasks) {
                while (true) {
                    //take the next task from queue
                    Task nextTask = tasks.take();
                    //tasksAsString += " *";
                    //tasksAsString += nextTask.getClientId() + " ";
                    //stop the thread for a time (task's processingTime)
                    Thread.sleep(nextTask.getProcessingTime() * 1000);
                    //decrement the waitingPeriod
                    this.waitingPeriod -= nextTask.getProcessingTime();
                    tasksAsString = tasksAsString.substring(tasksAsString.indexOf(" ")+1);
                }
            }
        }catch(InterruptedException e){
                System.out.println("Interrupt Exception caught in Server run() method");
                Thread.currentThread().interrupt();
        }
    }

    public synchronized BlockingQueue<Task> getTasks(){
        return this.tasks;
    }

    public synchronized int getWaitingPeriod(){
        return this.waitingPeriod;
    }

    public synchronized int getNumberOfTasks(){
        return this.tasks.size();
    }



}
