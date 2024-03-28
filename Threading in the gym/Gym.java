import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Gym {
    private int totalGymMembers;
    private Map<MachineType,Integer> availableMachine;

    public Gym(int totalGymMembers,Map<MachineType, Integer> availableMachine) {
        this.availableMachine = availableMachine;
        this.totalGymMembers = totalGymMembers;
    }
    public void openForTheDay() {
        List<Thread> gymMembersRoutines = IntStream.
                rangeClosed(1,this.totalGymMembers).
                mapToObj((id) -> {
                    Member member = new Member(id);
                    return new Thread(() -> {
                        try{
                            member.performRoutine();

                        }catch(Exception e){
                            System.out.println("dayum");
                        }
                    });
                }).collect(Collectors.toList());
//        gymMembersRoutines.forEach((t) -> t.start()); igivea orive
        Thread Supervisor =  createSupervisor(gymMembersRoutines);
        Supervisor.start();
        gymMembersRoutines.forEach(Thread::start);

    }

    private Thread createSupervisor(List<Thread> threads){
        Thread Supervisor = new Thread(() ->{
                ;while(true) {
                List<String> runningThreads = threads.stream().
                        filter(x -> x.isAlive()).
                        map(y -> y.getName()).
                        collect(Collectors.toList());
                System.out.println(Thread.currentThread().getName() + " - " +
                        runningThreads.size() + " members currently exercising: " +
                        runningThreads + "\n");

                if(runningThreads.isEmpty()){
                    break;
                }
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        System.out.println("All threads have finished working." +
                Thread.currentThread().getName());
        Supervisor.setName("Gym Staff");
        return Supervisor;

}
}
