package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private int roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public Reservation() {

    }

    public Reservation(int roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }



    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    // long é melhor para se trabalhar com datas
    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }

    @Override
    public String toString() {
        return "Room number: "
                + roomNumber
                + ", Check-in date(dd/MM/yyyy): "
                + sdf.format(checkIn)
                +", Check-out date(dd/MM/yyyy): "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + "nights";

    }
}
