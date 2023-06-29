package org.utils;
import java.net.InetAddress;
import java.time.LocalDate;
import java.util.UUID;

public abstract class Participant {

    public Participant(){
        localhost = InetAddress.getLoopbackAddress();
    }

    public InetAddress localhost;

    public abstract Operations Vote();

    public abstract void book();

    public abstract byte[] getAvailableItems(LocalDate startDate, LocalDate endDate, UUID pTransaktionnumber);
}
