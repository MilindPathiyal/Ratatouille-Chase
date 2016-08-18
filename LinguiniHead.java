//Milind Pathiyal
//Period 5 
//AP Comp Sci
//3 Little Pigs, The Big Bad Wolf, and Drake
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
public class LinguiniHead extends Bug
{
    public static int EGGS = 1;
    private int eggsLast = EGGS;
    public LinguiniHead()
    {
        setColor(null);
    }
    public boolean canMove()
    {
        return true;
    }
    public void act()
    {
        if(EGGS>eggsLast && EGGS<(getGrid().getNumRows())*(getGrid().getNumCols()))
        {
            Location loc;
            do
            {
                int c = (int)(Math.random()*getGrid().getNumCols());
                int r = (int)(Math.random()*getGrid().getNumRows());
                loc = new Location(r,c);
            }
                    
            while((getGrid().get(loc) instanceof Actor));
            (new Remy()).putSelfInGrid(getGrid(),loc);
            eggsLast = EGGS;
        }
        if(getGrid().get(getLocation().getAdjacentLocation(getDirection())) instanceof Remy)
            EGGS++;
        Location temp = getLocation();
        moveTo(getLocation().getAdjacentLocation(getDirection()));
        (new Squad()).putSelfInGrid(getGrid(), temp);
    }
}
    
    
    
    
    
    
    
    
    
    
