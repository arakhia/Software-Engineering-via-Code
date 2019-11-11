
public abstract class Student {
    // variables of Student class gois here

    public abstract int getStudentRequiredHours(int id);
}


public class FullTimeStudent extends Student {

    @Override
    public int getStudentRequiredHours(int id)
    {
        // logic goes hete
    }
}

public class PartTimeStudent extends Student {

    @Override
    public int getStudentRequiredHours(int id)
    {
        // logic goes hete
    }
}

public class VisitorStudent extends Student {

    @Override
    public int getStudentRequiredHours(int id)
    {
        // lets assume a visitor student isn't included in the required hours
        // so here will either will handle the case manually or throw exception
    }

}

public class DemoStudent {
    Student student1 = new FullTimeStudent();
    Student student2 = new PartTimeStudent();

    print(student1.getStudentRequiredHours().toString());
    // print 15
    print(student2.getStudentRequiredHours().toString());
    // print 10

    Student student3 = new VisitorStudent();
    print(student3.getStudentRequiredHours().toString());
    // will throw exception
}