package main.java.org.utils;
import java.time.LocalDate;

public abstract class Participant {
    public void Vote(VoteOptions vo){}

    public void book(){}

    public void getAvailableItems(LocalDate startDate, LocalDate endDate) {}
}