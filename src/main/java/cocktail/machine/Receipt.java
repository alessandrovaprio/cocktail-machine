package cocktail.machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class Receipt extends Observable {
    List<Cocktail> cockatils = new ArrayList<>();
    double total = 0;
    private ArrayList<Observer> followers;
    private int orderNumber = 0;


    public Receipt() {
        followers = new ArrayList<Observer>();
    }
    public Receipt (List<Cocktail> cockatils, double amount ) {
        this.cockatils = cockatils;
        this.total = amount;
        followers = new ArrayList<Observer>();
    }
    public void addCocktail(Cocktail cocktail) {
        this.cockatils.add(cocktail);
        this.setTotal(cocktail.cost());

    }

    public void setTotal(double amount) {
        this.total += amount;

        totalPriceChanged();
    }

    public void totalPriceChanged() {
        setChanged();
        notifyObservers();
        System.out.println("totalPriceChanged");


    }

    public int getOrderNumber() {
        return this.orderNumber;
    }
    public void setOrderNumber(int order) {
        this.orderNumber = order;
    }
    public double getValue()
    {
        return this.total;
    }

    public void removeAllCocktails(){
        this.cockatils.removeAll(this.cockatils);
        this.total = 0;
        totalPriceChanged();
    }


/*
    @Override
    public void register(java.util.Observer o) {
        followers.add(o);
        System.out.println(o + " has started following " + this.total);
    }

    @Override
    public void unregister(java.util.Observer o) {
        followers.remove(o);
        System.out.println(o + " has stopped following " + this.total);
    }

    //Notify all the registered followers
    public void notifyAllObservers(double amount) {
        for(Observer follower : followers)
        {
            follower.update(Subject subject, amount);
        }
        System.out.println();
    }
    //This method updates the tweet.
// It will internally call notifyAllObservers(tweet) method
//after updating the tweet.
    public void notifyUpdate(double amount)
    {
        //System.out.println("\n" + celebrityName + " has tweeted :: " + tweet + "\n");
        notifyAllObservers(amount);
    }*/
}
