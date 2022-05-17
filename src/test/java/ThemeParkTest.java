import attractions.Attraction;
import attractions.Park;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.ParkingSpot;
import stalls.Stall;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;
    Stall stall;
    Attraction attraction;
    Park park;
    RollerCoaster rollerCoaster;
    CandyflossStall candyflossStall;
    Visitor visitor;

    @Before
    public void before() {
        themePark = new ThemePark();
        park = new Park("Leafy Meadows", 9);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        candyflossStall = new CandyflossStall("Candy Land", 3, "Harry Belafonte", ParkingSpot.A1);
        visitor = new Visitor(14, 1.2, 40.0);
    }

    @Test
    public void canAddStall(){
        themePark.addStall(candyflossStall);
        assertEquals(1, themePark.getNumberOfStalls());
    }

    @Test
    public void canAddAttraction(){
        themePark.addAttraction(rollerCoaster);
        assertEquals(1, themePark.getNumberOfAttractions());
    }

    @Test
    public void canGetAllReviewed(){
        themePark.addStall(candyflossStall);
        themePark.addAttraction(rollerCoaster);
        ArrayList<IReviewed> reviews = themePark.getAllReviewed();
        assertEquals(2, themePark.getNumberOfReviewed(reviews));
    }

    @Test
    public void visitorCanVisitAttraction(){
        themePark.visit(visitor, rollerCoaster );
        assertEquals(1, visitor.getNumberOfAttractions());
        assertEquals(1, rollerCoaster.getVisitCount());
    }

    @Test
    public void canAddToHashMap(){
        themePark.addAttraction(rollerCoaster);
        themePark.addReviewsToHashMap();
        assertEquals(10, themePark.getItemFromHashMap("Blue Ridge"));
    }

}
