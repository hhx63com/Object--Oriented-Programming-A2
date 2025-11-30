import java.util.*;
import java.io.*;

public class Ride implements RideInterface {
    private String name;
    private Employee operator;
    private Queue<Visitor> waitingQueue;
    private LinkedList<Visitor> rideHistory;
    private int maxRider;
    private int numOfCycles;

    public Ride() {
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.numOfCycles = 0;
    }

    public Ride(String name, Employee operator, int maxRider) {
        this();
        this.name = name;
        this.operator = operator;
        this.maxRider = maxRider;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    // RideInterface methods
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        waitingQueue.add(visitor);
        System.out.println(visitor.getName() + " added to the queue.");
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        Visitor visitor = waitingQueue.poll();
        System.out.println(visitor.getName() + " removed from the queue.");
        return visitor;
    }

    @Override
    public void printQueue() {
        System.out.println("Waiting Queue:");
        for (Visitor visitor : waitingQueue) {
            System.out.println(visitor.getName());
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " added to ride history.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride History:");
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(visitor.getName());
        }
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("No operator assigned. Cannot run the ride.");
            return;
        }
        if (waitingQueue.isEmpty()) {
            System.out.println("No visitors in the queue. Cannot run the ride.");
            return;
        }

        int ridersThisCycle = Math.min(maxRider, waitingQueue.size());
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor visitor = removeVisitorFromQueue();
            if (visitor != null) {
                addVisitorToHistory(visitor);
            }
        }
        numOfCycles++;
        System.out.println("Ran one cycle with " + ridersThisCycle + " visitors.");
    }

    // Additional methods for file I/O
    public void exportRideHistory(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                writer.println(visitor.getName() + "," + visitor.getAge() + "," + visitor.getGender() + "," + visitor.getVisitorId() + "," + visitor.getTickets());
            }
            System.out.println("Ride history exported to " + filename);
        } catch (IOException e) {
            System.out.println("Error exporting ride history: " + e.getMessage());
        }
    }

    public void importRideHistory(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String gender = parts[2];
                    String visitorId = parts[3];
                    int tickets = Integer.parseInt(parts[4]);
                    Visitor visitor = new Visitor(name, age, gender, visitorId, tickets);
                    rideHistory.add(visitor);
                }
            }
            System.out.println("Ride history imported from " + filename);
        } catch (IOException e) {
            System.out.println("Error importing ride history: " + e.getMessage());
        }
    }

    // Method to sort ride history (Part 4B)
    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Ride history sorted.");
    }
}