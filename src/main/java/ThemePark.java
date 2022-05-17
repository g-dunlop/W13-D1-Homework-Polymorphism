import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<IReviewed> stalls = new ArrayList <>();
    private ArrayList<IReviewed> attractions = new ArrayList<>();
    private HashMap<String, Integer> reviewMap = new HashMap<>();

    public ThemePark(){
        this.stalls = new ArrayList<>();
        this.attractions = new ArrayList<>();
        this.reviewMap = new HashMap<>();
    }


    public HashMap<String, Integer> getReviewMap() {
        return reviewMap;
    }

    public void addReviewsToHashMap(){
        ArrayList<IReviewed> reviews = this.getAllReviewed();
        for(int i = 0; i<reviews.size(); i++){
            this.reviewMap.put(reviews.get(i).getName(), reviews.get(i).getRating());
        }
    }

    public int getItemFromHashMap(String key){
        return this.reviewMap.get(key);
    }
    public ArrayList<IReviewed> getStalls() {
        return stalls;
    }

    public ArrayList<IReviewed> getAttractions() {
        return attractions;
    }

    public void addStall(IReviewed stall){
        this.stalls.add(stall);
    }

    public void addAttraction(IReviewed attraction){
        this.attractions.add(attraction);
    }

    public ArrayList<IReviewed> getAllReviewed(){
        ArrayList<IReviewed> reviews = new ArrayList <>();
        for (int i=0; i<attractions.size(); i++){
            reviews.add(attractions.get(i));
        }
        for (int i=0; i<stalls.size(); i++){
            reviews.add(stalls.get(i));
        }
        return reviews;
    }

    public int getNumberOfReviewed(ArrayList arraylist){
        return arraylist.size();
    }

    public int getNumberOfStalls(){
        return this.stalls.size();
    }

    public int getNumberOfAttractions(){
        return this.attractions.size();
    }

    public void visit(Visitor visitor, Attraction attraction){
        visitor.addAttraction(attraction);
        attraction.incrementVisitCount();


    }
}
