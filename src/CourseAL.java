import java.util.*;
class CourseAL {
    private String name;
    private ArrayList<Student>  rosterStudents;
    private ArrayList<Student> waitListStudents;
    private static int maxStudentsOnRoster;
    private static int maxStudentsOnWaitList;


    public CourseAL(String courseName, int RosterMaxNumber, int waitListMaxNumber) {
        name = courseName;
        maxStudentsOnRoster = RosterMaxNumber;
        maxStudentsOnWaitList = waitListMaxNumber;
        rosterStudents = new ArrayList<>();
        waitListStudents = new ArrayList<>();
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
            if (rosterStudents.get(i) != null) {
                str += rosterStudents.get(i);
            }
        }
        return str;
    }

    public String getWaitListStudents() {
        String str = "";
        for (int i = 0; i < maxStudentsOnWaitList; i++) {
            if (waitListStudents.get(i) != null) {
                str += waitListStudents.get(i);
            }
        }
        return str;
    }

    public String toString() {
        String str = "--> Course Name: " + name + "\n"
                + "\n--> Max Students On Roster: " + maxStudentsOnRoster
                + "\n--> Roster Of Enrolled Students: \n" + getRosterStudents() + " "
                + "\n--> Max Students On Waitlist: " + maxStudentsOnWaitList
                + "\n--> Students On The Waitlist: \n" + getWaitListStudents();
        return str;
    }
    public boolean addStudent(Student student){
        if (student.isTuitionPaid()&& !Arrays.asList(rosterStudents).contains(student.getName())
                && !Arrays.asList(waitListStudents).contains(student.getName())){
            if (rosterStudents.size() <maxStudentsOnRoster){
                for (int x=0; x<rosterStudents.size(); x++){
                    if (rosterStudents.get(x)==null){
                        rosterStudents.set(x, student);
                        return true;
                    }
                }
            }
            else if (waitListStudents.size()<maxStudentsOnWaitList){
                for (int x=0; x<waitListStudents.size(); x++){
                    if (waitListStudents.get(x)==null){
                        waitListStudents.set(x, student);
                        return true;
                    }
                }
            }
        }
        // I would add an else but then i would need to return something different
        // Plus, if it gets all the way down here, thats the same as an else
        return false;
    }

}