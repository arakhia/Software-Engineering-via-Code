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
<br>

## Open-closed Principle
This simply means that a class should be closed for modifications and open for extension, meaning that when we want to extend a class we don't have to modify it. Take the following Shape class as an example, this class has calculateSize method which calculate based on the type of given shape, what about if we want to add (extend) new shape to it? in this scenario we will have to modify the class which break the SOLID principle.

```
public class Shape {

    public void calculateSize(Object object)
    {
        if (object.type == "square")
        {
            return object.width * object.width;
        } else if (object.type == "rectangle")
        {
            return object.width * object.height;
        }
    }
}
```
### Solution
The solution to this type of problem by providing a Shape class and create Square and Rectangle classes which extend it and implement (override) their own calculateArea method. Check the following code
```

public class Shape {
    public void calculateArea()
    {
        // general method of calculate area
    }
}

public class Square extends Shape {

    @Override
    public void calculateArea()
    {
        // calculate the area of Square
    }
}

public class Rectangle extends Shape {

    @Override
    public void calculateArea()
    {
        // calculate the area of Rectangle
    }
}
```

<br>

## Liskov Substitution Principle
According to Design Principles and Design Patterns Paper by Robert C. Martin, Liskov principle is
```
Derived classes should be substitutable for their base classes. That is, a user of a base class should continue to function properly if a derivative of that base class is passed to it.
```

To give clear idea about the principle, lets take the following example
```
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
```

In the previous example FullTime & PartTime students have required hours, but VisitorStudent doesn't. So when we subtituted VisitorStudent as a derived class of Student class with the method getStudentRequiredHours(), it didn't perform will and hence this is a violation for Liskov Principle.
