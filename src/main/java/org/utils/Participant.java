package org.utils;
import java.net.InetAddress;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public abstract class Participant {

    public static final int travelBrokerPort = 4446;
    public static final int uiPort = 4447;

    public static final int hotelPort = 4448;

    public static final int rentalCarPort = 4449;

    public static final InetAddress localhost = InetAddress.getLoopbackAddress();


    public abstract Operations prepare(BookingData bookingData, UUID transaktionId);

    public abstract boolean commit(UUID transaktionId);

    public abstract boolean abort(UUID transaktionId);

    public abstract ArrayList<Object> getAvailableItems(LocalDate startDate, LocalDate endDate);


}
