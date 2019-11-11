
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