import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Map.Entry;
public class Company {

    private Employee CEO;
    private Tree<Integer> employeesTree;
    private Map<Integer,Employee> employees;
    private Queue<Integer> availableIDs;
    private static int availableID = 1;
    private String name;

    public Company(String name, Employee CEO) {
        this.name = name;
        this.CEO = CEO;
        employeesTree = new Tree<>(0);
        availableIDs = new PriorityQueue<>();
        employees = new HashMap<>();
        employees.put(0,CEO);
    }

    public void addEmployee(Employee newEmployee) {
        boolean isBossPresent = employeesTree.containsKey(newEmployee.getBoss().getID());
        if(!isBossPresent)
            return;
        int IDCandidate = availableID;
        if (!availableIDs.isEmpty())
            IDCandidate = availableIDs.remove();
        else
            availableID++;

        newEmployee.setID(IDCandidate);
        employeesTree.insert(newEmployee.getID(), newEmployee.getBoss().getID());
        employees.put(newEmployee.getID(), newEmployee);
    }

    public void fireEmployee(int ID) {
        availableIDs.add(ID);
        employees.remove(ID);
        employeesTree.remove(ID);
    }

    public Employee findCommonBoss(Employee e1, Employee e2) {
        return findByID(employeesTree.LCA(e1.getID(),e2.getID()));

    }

    public Employee findByID(int ID) {
        for (Entry<Integer,Employee> entry : employees.entrySet())
            if (entry.getKey() == ID)
                return entry.getValue();
        return null;
    }

}
