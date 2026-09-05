public class PatientVisitHistory {

    private class Node {
        Visit visit;
        Node next;

        Node(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    private Node head;

    // Add a new visit
    public void addVisit(Visit visit) {
        Node newNode = new Node(visit);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Visit added successfully.");
    }

    // Remove a visit using Visit ID
    public void removeVisit(int visitId) {
        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            System.out.println("Visit removed successfully.");
            return;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.visit.getVisitId() == visitId) {
                current.next = current.next.next;
                System.out.println("Visit removed successfully.");
                return;
            }

            current = current.next;
        }

        System.out.println("Visit not found.");
    }

    // Search a visit using Visit ID
    public Visit searchVisit(int visitId) {
        Node current = head;

        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    // Display all visit history
    public void displayVisits() {
        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        System.out.println("Patient Visit History:");

        Node current = head;

        while (current != null) {
            System.out.println(current.visit);
            current = current.next;
        }
    }
}