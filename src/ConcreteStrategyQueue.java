import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteStrategyQueue implements Strategy {

    @Override
    public void addTask(List<Server> servers, Task t){
        //Iterate trough the servers, find the one with the lowest number of tasks and add the task to that server
        Server server = Collections.min(servers, Comparator.comparing(s->s.getNumberOfTasks()));
        server.tasks.add(t);
        server.waitingPeriod += t.getProcessingTime();
        t.setWaitingPeriodOnChosenServer(server.getWaitingPeriod());
    }

}
