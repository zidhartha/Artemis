import java.util.Scanner;

public class CompanySimulation {
    public static void main(String[] args) {
        simulation("Novak","ATP");
    }

    private static void simulation(String ceoName, String companyName) {
        Employee ceo = new Employee(ceoName,null);
        ceo.setID(0);
        Company company = new Company(companyName,ceo);
        Scanner scanner = new Scanner(System.in);
        String numberOfQueries = scanner.nextLine();

        for (int k = 0; k < Integer.parseInt(numberOfQueries); k++) {
            String query = scanner.nextLine();
            String[] s = query.split(" ");
            if (s[0].equalsIgnoreCase("employeeWithID")) {
                System.out.println(company.findByID(Integer.parseInt(s[1])).toString());
                continue;
            }
            if (s[0].equalsIgnoreCase("add")) {
                String name = s[1];
                Employee boss = company.findByID(Integer.parseInt(s[2]));
                if (boss == null)
                    System.out.println("invalid input, boss with given ID doesn't exist.");
                else
                    company.addEmployee(new Employee(name,boss));
                continue;
            }
            if (s[0].equalsIgnoreCase("fire")) {
                int id = Integer.parseInt(s[1]);
                if (company.findByID(id) == null)
                    System.out.println("Invalid input, employee with given ID doesn't exist");
                else
                    company.fireEmployee(Integer.parseInt(s[1]));
                continue;
            }
            if (s[0].equalsIgnoreCase("findCommonBoss")) {
                try {
                    int firstID = Integer.parseInt(s[1]);
                    int secondID = Integer.parseInt(s[2]);
                    if (company.findByID(firstID) == null || company.findByID(secondID) == null)
                        System.out.println("one of the employees with given ID doesn't exist");
                    else {
                        Employee e1 = company.findByID(firstID);
                        Employee e2 = company.findByID(secondID);
                        System.out.println(company.findCommonBoss(e1,e2).toString());
                    }

                }
                catch(NumberFormatException e) {
                    System.out.println("input format is wrong, please try again");
                }
                continue;
            }
            System.out.println("Wrong format of input");
        }
        scanner.close();
    }
}

