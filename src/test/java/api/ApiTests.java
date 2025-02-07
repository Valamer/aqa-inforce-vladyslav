package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApiTests {

    String url = "https://automationintesting.online/";
    static String token;
    static int roomId;

    @BeforeAll
    public static void setup() {
        Auth auth = new Auth("admin", "password");
        Response response = given()
                .contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("https://automationintesting.online/auth/login");
        token = response.getCookie("token");
    }

    @Test
    @Order(1)
    public void roomCreationTest() {
        Room roomPayload = new Room.RoomBuilder()
                .setRoomName("Test Room")
                .setType("Single")
                .setAccessible(true)
                .setDescription("Test Description")
                .setImage("https://picsum.photos/id/237/200/300")
                .setRoomPrice(50)
                .setFeatures(new String[] {"TV", "WiFi", "Radio"})
                .build();
        Response response = given()
                .cookie("token", token)
                .contentType(ContentType.JSON)
                .body(roomPayload)
                .when()
                .post(url + "room/");
        roomId = response.getBody().as(Room.class).getRoomId();
        assertEquals(201, response.statusCode());
    }

    @Test
    @Order(2)
    public void roomBookingTest() {
        Booking bookingPayload = new Booking.BookingBuilder()
                .bookingdates(new Booking.Dates(LocalDate.now().toString(), LocalDate.parse(LocalDate.now().toString()).plusDays(3).toString()))
                .depositpaid(false)
                .email("Email@gmail.com")
                .firstname("Name")
                .lastname("Lastname")
                .phone("111111111111")
                .roomid(roomId)
                .build();
        Response response = given()
                .cookie("token", token)
                .contentType(ContentType.JSON)
                .body(bookingPayload)
                .when()
                .post(url + "booking/");

        assertEquals(201, response.statusCode());
    }

    @Test
    @Order(3)
    public void roomEditTest() {
        Room roomPayload = new Room.RoomBuilder()
                .setRoomName("Updated Room")
                .setType("Double")
                .setAccessible(true)
                .setDescription("Updated Description")
                .setImage("https://picsum.photos/id/237/200/300")
                .setRoomPrice(100)
                .setFeatures(new String[] {"TV", "WiFi", "Radio"})
                .build();
        Response response = given()
                .cookie("token", token)
                .contentType(ContentType.JSON)
                .body(roomPayload)
                .when()
                .put(url + "room/" + roomId);

        assertEquals(202, response.statusCode());
    }

    @Test
    @Order(4)
    public void roomDeleteTest() {
        Response response = given()
                .cookie("token", token)
                .contentType(ContentType.JSON)
                .when()
                .delete(url + "room/" + roomId);

        assertEquals(202, response.statusCode());
    }

}
