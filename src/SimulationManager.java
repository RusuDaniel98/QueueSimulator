import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SimulationManager extends SimulatorFrame implements Runnable{

    int maxRunningTime = 60;
    //data read from UI
    public int timeLimit = 30; //maximum processing time (in which clients can be generated) - read from UI
    public int maxProcessingTime = 10;
    public int numberOfServers = 3;
    public int numberOfClients = 24;
    public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;
    private Scheduler scheduler;
    private SimulatorFrame frame;
    private List<Task> generatedTasks = new ArrayList<Task>();

    public SimulationManager(){
        scheduler = new Scheduler(numberOfServers, 50);
        frame = new SimulatorFrame();
        generateNRandomTasks(); //stores in generatedTasks
    }

    private void generateNRandomTasks(){
        for (int i=0; i<numberOfClients*2; i++){
            Task task = new Task();
            int randProcessingTime = (int)(Math.random()*maxProcessingTime + 1);
            int randArrivalTime = (int)(Math.random()*timeLimit + 1);
            task.setProcessingTime(randProcessingTime);
            task.setArrivalTime(randArrivalTime);
            task.setClientId(i);
            generatedTasks.add(task);
        }
        //sort list with respect to arrivalTime
        Collections.sort(generatedTasks, new SortByArrivalTime());
    }

    @Override
    public void run(){
        int currentTime = 0;

        try{
            synchronized (generatedTasks){
            while (currentTime < maxRunningTime) {
                Iterator<Task> iterator = generatedTasks.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().getArrivalTime() == currentTime) {
                        scheduler.dispatchTask(iterator.next(), frame);
                        iterator.remove();
                    }
                }
                currentTime++;
                frame.displayData(scheduler, currentTime);
                Thread.sleep(1000);
            }
            }
        }catch(InterruptedException e){
            System.out.println("Interrupted Exception caught in the run() method of SimulationManager class");
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args){
        SimulationManager gen = new SimulationManager();
        Thread t = new Thread(gen);
        t.start();
    }

}
