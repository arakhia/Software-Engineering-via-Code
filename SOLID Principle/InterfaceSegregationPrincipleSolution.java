

public interface StudentInterface {

    public void getStudentInfo();
}

public interface PermenentStudentInterface {

    public viod getStudentRequiredHours();
}

public class FullTimeStudent implements StudentInterface, PermenentStudentInterface {
    
    public void getStudentInfo(){
        // get info logic
    }

    public viod getStudentRequiredHours(){
        // get student houd logic
    }
}

public class VisitorStudent implements StudentInterface {

    public void getStudentInfo(){
        // get info logic
    }
}