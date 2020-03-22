import java.util.ArrayList;
import java.util.List;

public class Scheduler {

    private List<Server> servers = new ArrayList<Server>();
    public int maxNoServers;
    private int maxTasksPerServer;
    private Strategy strategy = new ConcreteStrategyTime();

    public Scheduler(int maxNoServers, int maxTasksPerServer){
        for (int i=0; i<maxNoServers; i++){
            Server server = new Server();
            server.serverId = i;
            servers.add(server);
            new Thread(server).start();
        }
    }

    public void changeStrategy(SelectionPolicy policy){
        //apply strategy pattern to instantiate the strategy with the concrete strategy corresponding to policy
        if(policy == SelectionPolicy.SHORTEST_QUEUE){
            strategy = new ConcreteStrategyQueue();
        }
        if(policy == SelectionPolicy.SHORTEST_TIME){
            strategy = new ConcreteStrategyTime();
        }
    }

//    public synchronized void dispatchTask(Task task){
//        //call the strategy addTask method
//        strategy.addTask(servers, task);
//        System.out.println(task.getClientId() + " at time " + task.getArrivalTime()
//                + " -- processing time " + task.getProcessingTime() + " finish time " + task.getFinishTime()
//                + " => has waited " + task.getWaitingPeriodOnChosenServer());
//    }

    public synchronized void dispatchTask(Task task, SimulatorFrame frame){
        //call the strategy addTask method
        strategy.addTask(servers, task);
        frame.textAreaInfo.append("Client " + task.getClientId()
                + " has arrived at time " + task.getArrivalTime() + " "
                + "and left at time " + task.getFinishTime() + "\n");
    }

    public List<Server> getServers(){
        return this.servers;
    }


}
