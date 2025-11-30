import java.util.*;

public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();

        // Example demonstrations for each part
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }

    public void partThree() {
        Ride ride = new Ride("Roller Coaster", new Employee("Hans Wang", 30, "Male", "E001", "Operator"), 5);
        Visitor v1 = new Visitor("Zhang San", 20, "Male", "001", 2);
        Visitor v2 = new Visitor("Li Si", 21, "Male", "002", 1);
        Visitor v3 = new Visitor("Wang Wu", 22, "Male", "003", 3);
        Visitor v4 = new Visitor("Xiao Mei", 23, "Female", "004", 2);
        Visitor v5 = new Visitor("Xiao Ming", 24, "Male", "005", 1);

        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);

        ride.printQueue();

        ride.removeVisitorFromQueue();
        ride.printQueue();

        System.out.println("------------------------------------------------------");
    }

    public void partFourA() {
        Ride ride = new Ride("Water Ride", new Employee("Jake Chen", 40, "Male", "E002", "Operator"), 4);
        Visitor v1 = new Visitor("Du HaiHuang", 25, "Male", "006", 2);
        Visitor v2 = new Visitor("Ma HaoNing", 26, "Male", "007", 1);
        Visitor v3 = new Visitor("Yang JiaYuan", 27, "Male", "008", 3);
        Visitor v4 = new Visitor("Xin XiaoMen", 28, "Female", "009", 2);
        Visitor v5 = new Visitor("Wang HanZhe", 29, "Male", "010", 1);

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        System.out.println("Number of visitors in history: " + ride.numberOfVisitors());
        ride.printRideHistory();

        System.out.println("Is visitor Frank in history?" + ride.checkVisitorFromHistory(v1));

        System.out.println("------------------------------------------------------");
    }

    public void partFourB() {
        Ride ride = new Ride("Ferris Wheel", new Employee("SuperMen", 40, "Male", "E003", "Operator"), 3);
        Visitor v1 = new Visitor("Xi YangYang", 30, "Male", "011", 2);
        Visitor v2 = new Visitor("Mei YangYang", 31, "Female", "012", 1);
        Visitor v3 = new Visitor("Fei YangYang", 32, "Male", "013", 3);
        Visitor v4 = new Visitor("Nuan YangYang", 33, "Female", "014", 2);
        Visitor v5 = new Visitor("Lan YangYang", 34, "Male", "015", 1);

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        System.out.println("Before sorting:\n");
        ride.printRideHistory();

        ride.sortRideHistory();

        System.out.println("After sorting:\n");
        ride.printRideHistory();

        System.out.println("------------------------------------------------------");
    }

    public void partFive() {
        Ride ride = new Ride("Bumper Cars", new Employee("IronMan", 40, "Male", "E004", "Operator"), 2);
        Visitor v1 = new Visitor("Bob", 18, "Male", "016", 2);
        Visitor v2 = new Visitor("Alice", 19, "Female", "017", 1);
        Visitor v3 = new Visitor("Mike", 20, "Male", "018", 3);
        Visitor v4 = new Visitor("Top", 21, "Male", "019", 2);
        Visitor v5 = new Visitor("Milk", 22, "Male", "020", 1);
        Visitor v6 = new Visitor("Tina", 23, "Female", "021", 3);
        Visitor v7 = new Visitor("HaHa", 24, "Male", "022", 2);
        Visitor v8 = new Visitor("Li", 25, "Female", "023", 1);
        Visitor v9 = new Visitor("Happy", 26, "Male", "024", 3);
        Visitor v10 = new Visitor("Sad", 27, "Female", "025", 2);

        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);
        ride.addVisitorToQueue(v6);
        ride.addVisitorToQueue(v7);
        ride.addVisitorToQueue(v8);
        ride.addVisitorToQueue(v9);
        ride.addVisitorToQueue(v10);


        System.out.println("Queue before running a cycle:\n");
        ride.printQueue();


        ride.runOneCycle();

        System.out.println("Queue after running a cycle:");
        ride.printQueue();

        System.out.println("\n");
        System.out.println("Ride history after running a cycle:");
        ride.printRideHistory();

        System.out.println("------------------------------------------------------");
    }

    public void partSix() {
        Ride ride = new Ride("Haunted House", new Employee("Wang XiaoMing", 40, "Male", "E005", "Operator"), 4);
        Visitor v1 = new Visitor("Fa Lao", 20, "Male", "026", 2);
        Visitor v2 = new Visitor("Chen ZhengYu", 21, "Male", "027", 1);
        Visitor v3 = new Visitor("Chen BaoJan", 22, "Female", "028", 3);
        Visitor v4 = new Visitor("Huang LiYuan", 23, "Male", "029", 2);
        Visitor v5 = new Visitor("San Mu", 24, "Male", "030", 1);


        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        ride.exportRideHistory("ride_history.txt");

        System.out.println("------------------------------------------------------");
    }

    public void partSeven() {
        Ride ride = new Ride("Merry-Go-Round", new Employee("BiLiBiLi", 30, "Male", "E006", "Operator"), 3);
        ride.importRideHistory("ride_history.txt");

        System.out.println("Number of visitors in history after import: " + ride.numberOfVisitors());
        ride.printRideHistory();

        System.out.println("------------------------------------------------------");
    }
}