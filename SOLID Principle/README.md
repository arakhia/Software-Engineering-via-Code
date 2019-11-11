# SOLID Principle

SOLID is an acronym for
<br>
S &nbsp; => Single Responsibility Principle
<br>
O &nbsp; => Open-closed Principle
<br>
L &nbsp; => Liskov Substitution Principle
<br>
I &nbsp;  => Interface Segregation
<br>
D &nbsp;  => Dependency Inversion

<br>

## Single Responsibility Principle
This is simple and very clear principle, which basicly means that a class should only have a single responsibility. In another word, a class should have only one job. Imagine the following scenario, you have a Student class as the following
```
public class StudentController {
    


    public void addStudent(Student student)
    {
        // add student logic
    }

    public void updateStudentInfo(Student student)
    {
        // update student logic
    }

    public void deleteStudent(Student student)
    {
        // delete student logic
    }

    public void getStudentGrade(Student student)
    {
        // get grade logic
    }

    public void addGradeToStudent(Student student, Grade grade)
    {
        // add grade logic
    }
    
}
```
The above Student Controller class handles the CRUD operation for the Student, however, it also handles the grading which is too much for one class to be responsible for. The solution could be by ceating GradingController class which will be responsible for all grading operations. This will help decoupling the code, so in case of any modification happen to grading methodology we only change one place which is GradingController.

### Solution
```
    
public class StudentController {

    public void addStudent(Student student)
    {
        // add student logic
    }

    public void updateStudentInfo(Student student)
    {
        // update student logic
    }

    public void deleteStudent(Student student)
    {
        // delete student logic
    }
    
}

public class GradingController {

    public void getStudentGrade(Student student)
    {
        // get grade logic
    }

    public void addGradeToStudent(Student student, Grade grade)
    {
        // add grade logic
    }
    
}
```