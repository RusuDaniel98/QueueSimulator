public class Task {

    private int clientId;
    private int arrivalTime;
    private int processingTime;
    private int finishTime;
    private int waitingPeriodOnChosenServer;

    public int getArrivalTime(){
        return this.arrivalTime;
    }

    public int getProcessingTime(){
        return this.processingTime;
    }

    public int getFinishTime(){
        return this.finishTime;
    }

    public int getWaitingPeriodOnChosenServer() {
        return waitingPeriodOnChosenServer;
    }

    public int getClientId(){
        return this.clientId;
    }

    public void setArrivalTime(int arrivalTime){
        this.arrivalTime = arrivalTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public void setWaitingPeriodOnChosenServer(int waitingPeriodOnChosenServer) {
        this.waitingPeriodOnChosenServer = waitingPeriodOnChosenServer;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
