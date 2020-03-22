import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteStrategyTime implements Strategy {

//    public ArrayList<Integer> avgTimes = new ArrayList<>();

    @Override
    public void addTask(List<Server> servers, Task t){
        //Iterate trough the servers, find the one with the lowest waiting time and add the task to that server
        Server server = Collections.min(servers, Comparator.comparing(s->s.getWaitingPeriod()));
        t.setFinishTime(t.getArrivalTime() + t.getProcessingTime() + server.getWaitingPeriod());
        t.setWaitingPeriodOnChosenServer(t.getFinishTime() - t.getArrivalTime());
        server.tasks.add(t);
        server.waitingPeriod += t.getProcessingTime();
        server.tasksAsString += t.getClientId() + " ";

        //calculate the average waiting time for all clients

//        avgTimes.add(server.getWaitingPeriod());

    }

//    public int calculateAvgWaitingTimes(){
//        int sum=0;
//        if (!avgTimes.isEmpty()) {
//            for (Integer time : avgTimes) {
//                sum += time;
//            }
//        }
//        return sum/avgTimes.size();
//    }

}
