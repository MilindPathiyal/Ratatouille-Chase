//Milind Pathiyal
//Period 5 
//AP Comp Sci
//3 Little Pigs, The Big Bad Wolf, and Drake
import java.awt.Color;
import info.gridworld.actor.Rock;
public class Squad extends Rock
{
    private int age;
    public Squad()
    {
        setColor(null);
        age = 0;
    }
    public void act()
    {
        age++;
        if(age==LinguiniHead.EGGS)
            removeSelfFromGrid();
    }
    public int getAge()
    {
        return age;
    }
}