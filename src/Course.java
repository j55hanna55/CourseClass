 import java.util.*;
class Course {
    private String name;
    private Student[] rosterStudents;
    private Student[] waitListStudents;
    private static int maxStudentsOnRoster;
    private static int maxStudentsOnWaitList;


    public Course(String courseName, int RosterMaxNumber, int waitListMaxNumber) {
        name = courseName;
        maxStudentsOnRoster = RosterMaxNumber;
        maxStudentsOnWaitList = waitListMaxNumber;
        rosterStudents = new Student[RosterMaxNumber];
        waitListStudents = new Student[waitListMaxNumber];
    }

    //setters
    public void setName(String courseName) {
        name = courseName;
    }

    // getters
    public String getName() {
        return name;
    }

    public static int getMaxStudentsOnRoster() {
        return maxStudentsOnRoster;
    }

    public static int getMaxStudentsOnWaitList() {
        return maxStudentsOnWaitList;
    }

    public String getRosterStudents() {
        String str = "";
        for (int i = 0; i < maxStudentsOnRoster; i++) {
            if (rosterStudents[i] != null) {
                str += rosterStudents[i];
            }
        }
        return str;
    }

    public String getWaitListStudents() {
        String str = "";
        for (int i = 0; i < maxStudentsOnWaitList; i++) {
            if (waitListStudents[i] != null) {
                str += waitListStudents[i];
            }
        }
        return str;
    }

    public String toString() {
        String str = "--> Course Name: " + name + "\n"
                + "\n--> Max Students On Roster: " + maxStudentsOnRoster
                + "\n--> Roster Of Enrolled Students: \n" + getRosterStudents()
                + "\n--> Max Students On Waitlist: " + maxStudentsOnWaitList
                + "\n--> Students On The Waitlist: \n" + getWaitListStudents();
        return str;
    }
    public boolean addStudent(Student student){
        if (student.isTuitionPaid()&& !Arrays.asList(rosterStudents).contains(student.getName())
                && !Arrays.asList(waitListStudents).contains(student.getName())){
            if (rosterStudents.length<maxStudentsOnRoster){
                for (int x=0; x<rosterStudents.length; x++){
                    if (rosterStudents[x]==null){
                        rosterStudents[x]=student;
                        return true;
                    }
                }
            }
            if (waitListStudents.length<maxStudentsOnWaitList){
                for (int x=0; x<waitListStudents.length; x++){
                    if (waitListStudents[x]==null){
                        waitListStudents[x]=student;
                        return true;
                    }
                }
            }
        }
        // I would add an else but then i would need to return something different
        // Plus, if it gets all the way down here, thats the same as an else
        return false;
    }

    // declare function dropStudent
    public boolean dropStudent(Student student) {
        boolean removed = false;
// iterate through entire array and if found, remove it
        for (int i = 0; i < maxStudentsOnWaitList; i++) {
            if (waitListStudents[i] == student) {
                waitListStudents[i] = null;
                removed = true;
                break;
            }
        }
        return removed;
    }

}