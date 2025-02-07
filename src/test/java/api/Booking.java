package api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Booking {
    @JsonProperty
    Dates bookingdates;
    @JsonProperty
    boolean depositpaid;
    @JsonProperty
    String email;
    @JsonProperty
    String firstname;
    @JsonProperty
    String lastname;
    @JsonProperty
    String phone;
    @JsonProperty
    int roomid;

    public Booking(Dates bookingdates, boolean depositpaid, String email, String firstname, String lastname, String phone, int roomid) {
        this.bookingdates = bookingdates;
        this.depositpaid = depositpaid;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.roomid = roomid;
    }
    public static class BookingBuilder {

        private Dates bookingdates;
        private boolean depositpaid;
        private String email;
        private String firstname;
        private String lastname;
        private String phone;
        private int roomid;

        public BookingBuilder bookingdates(Dates bookingdates) {
            this.bookingdates = bookingdates;
            return this;
        }
        public BookingBuilder depositpaid(boolean depositpaid) {
            this.depositpaid = depositpaid;
            return this;
        }
        public BookingBuilder email(String email) {
            this.email = email;
            return this;
        }
        public BookingBuilder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }
        public BookingBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }
        public BookingBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public BookingBuilder roomid(int roomid) {
            this.roomid = roomid;
            return this;
        }
        public Booking build() {
           return new Booking(bookingdates, depositpaid, email, firstname, lastname, phone, roomid);
        }
    }

    public static class Dates{
        @JsonProperty
        String checkin;
        @JsonProperty
        String checkout;
        public Dates(String checkin, String checkout) {
            this.checkin = checkin;
            this.checkout = checkout;
        }
    }
}
