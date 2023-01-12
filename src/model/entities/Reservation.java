package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date chekout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date chekout) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.chekout = chekout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getChekout() {
        return chekout;
    }

    public long duration(){
        long diff = chekout.getTime() - checkIn.getTime();
        // converte milissegudos para dias
        return  TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date chekout){
        this.checkIn = checkIn;
        this.chekout = chekout;
    }

    @Override
    public String toString(){
        return "Room "
               + roomNumber
               + ", check-in: "
               + sdf.format(checkIn)
               + ", "
               + duration()
               + " nigths";
    }
}
