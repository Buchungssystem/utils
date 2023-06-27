package org.utils;
import java.net.InetAddress;
import java.time.LocalDate;

public abstract class Participant {

    public Participant(){
        localhost = InetAddress.getLoopbackAddress();
    }

    public InetAddress localhost;

    public abstract VoteOptions Vote();

    public abstract void book();

    public abstract void getAvailableItems(LocalDate startDate, LocalDate endDate);
}
