//Milind Pathiyal
//Period 5 
//AP Comp Sci
//3 Little Pigs, The Big Bad Wolf, and Drake
import java.util.ArrayList;
import info.gridworld.world.World;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class LinguiniWorld<Actor> extends World<Actor>
{
    private boolean gameOn = true;
    public LinguiniWorld(BoundedGrid<Actor> grid)
    {
        super(grid);
        setMessage("Use A, S, D, and W to control Linguini.");
    }

    public void step()
    {
        ArrayList<Location>locs = getGrid().getOccupiedLocations();
        for(int i = locs.size()-1;i>=0;i--)
        {
            if(getGrid().get(locs.get(i)) instanceof Squad)
            {
                try
                {
                    ((Squad) getGrid().get(locs.get(i))).act();
                }
                catch(Exception e)
                {
                }
                if(!(getGrid().get(locs.get(i)) instanceof LinguiniHead))
                {
                    locs.remove(i);
                }
            }
        }
        if(!gameOn)
            return;
        LinguiniHead linguini = (LinguiniHead)(getGrid().get(locs.get(0)));
        
        try
        {
             linguini.act();
        }
        catch(Exception e)
        {
             setMessage("You're Dead!");
             gameOn = false;
             linguini.removeSelfFromGrid();
        }
    }
    
    public boolean keyPressed(String description, Location loc)
    {
        if(!gameOn) 
            return true;
        ArrayList<Location>locs = getGrid().getOccupiedLocations();
        for(int i = locs.size() - 1;i >= 0;i--)
        {
            if(!(getGrid().get(locs.get(i)) instanceof LinguiniHead))
            {
                locs.remove(i);
            }
        }
        LinguiniHead linguini = (LinguiniHead)(getGrid().get(locs.get(0)));
        if(description.equals("A"))
            linguini.setDirection(Location.WEST);
        if(description.equals("W"))
            linguini.setDirection(Location.NORTH);
        if(description.equals("S"))
            linguini.setDirection(Location.SOUTH);
        if(description.equals("D"))
            linguini.setDirection(Location.EAST);
        return true;
    }
}
    
    
    
    
    
    
    
    
    
    
    