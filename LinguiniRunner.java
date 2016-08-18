//Milind Pathiyal
//Period 5 
//AP Comp Sci
//3 Little Pigs, The Big Bad Wolf, and Drake
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
public class LinguiniRunner
{
    public static void main(String[] args)
    {
        BoundedGrid<Actor>grid = new BoundedGrid<Actor>(10,10);
        LinguiniWorld<Actor>world = new LinguiniWorld<Actor>(grid);
        (new LinguiniHead()).putSelfInGrid(grid, new Location(5,3));
        Location loc;
        do
        {
            int c = (int)(Math.random()*grid.getNumCols());
            int r = (int)(Math.random()*grid.getNumRows());
            loc = new Location(r,c);
        }
        while((grid.get(loc) instanceof Actor));
        (new Remy()).putSelfInGrid(grid,loc);
        world.show();
    }
}
    
    

    
    
    