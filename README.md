# Mini Hospital Emergency Management System

## CIT 300 - Data Structures and Algorithms

This project is a Mini Hospital Emergency Management System developed using Java.

The system demonstrates the practical use of different data structures to manage patient records, emergency patients, treatment history, and patient visit history.

## Data Structures Used

- Binary Search Tree (BST) - Patient Records
- Queue - Emergency Patient Queue
- Stack - Treatment History
- Singly Linked List - Patient Visit History

## Main Features

### Patient Records - Binary Search Tree
- Add patient
- Search patient by Patient ID
- Delete patient
- Display patients in ascending order of Patient ID

### Emergency Patient Queue - Queue
- Add patient to emergency queue
- Serve emergency patient
- Display waiting patients
- Uses FIFO (First In, First Out)

### Treatment History - Stack
- Add completed treatment
- Remove most recent treatment
- Display treatment history
- Uses LIFO (Last In, First Out)

### Patient Visit History - Singly Linked List
- Add patient visit
- Search visit
- Remove visit
- Display patient visit history
- Maintains a separate visit history for each patient

## Patient Information

Each patient record contains:

- Patient ID
- Name
- Age
- Contact Number
- Medical Condition

## Visit Information

Each patient visit contains:

- Patient ID
- Visit ID
- Date
- Doctor
- Diagnosis
- Treatment

## Project Structure

```text
CIT 300 Mid Assgment/
│
├── src/
│   ├── Patient.java
│   ├── PatientBST.java
│   ├── PatientQueue.java
│   ├── TreatmentStack.java
│   ├── Visit.java
│   ├── PatientVisitHistory.java
│   └── HospitalManagementSystem.java
│
├── README.md
└── .gitignore