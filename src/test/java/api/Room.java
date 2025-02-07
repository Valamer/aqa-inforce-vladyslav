package api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class Room {
    @JsonProperty
    private int roomid;
    @JsonProperty
    private String roomName;
    @JsonProperty
    private String type;
    @JsonProperty
    private boolean accessible;
    @JsonProperty
    private String image;
    @JsonProperty
    private String description;
    @JsonProperty
    private String[] features;
    @JsonProperty
    private int roomPrice;

    public Room() {
    }

    public Room(String roomName, String type, boolean accessible, String image, String description, String[] features, int roomPrice) {
        this.roomName = roomName;
        this.type = type;
        this.accessible = accessible;
        this.image = image;
        this.description = description;
        this.features = features;
        this.roomPrice = roomPrice;
    }
    public int getRoomId() {
        return roomid;
    }
    public void setRoomId(int roomid) {
        this.roomid = roomid;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String details) {
        this.description = details;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String[] getFeatures() {
        return features;
    }

    public void setFeatures(String[] features) {
        this.features = features;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    @Override
    public String toString() {
        return "Room{" +
                ", roomName='" + roomName + '\'' +
                ", type='" + type + '\'' +
                ", accessible=" + accessible +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", features=" + Arrays.toString(features) +
                ", roomPrice=" + roomPrice +
                '}';
    }

    public static class RoomBuilder {

        private String roomName;
        private String type;
        private boolean accessible;
        private String image;
        private String description;
        private String[] features;
        private int roomPrice;

        public RoomBuilder setRoomName(String roomName) {
            this.roomName = roomName;

            return this;
        }

        public RoomBuilder setType(String type) {
            this.type = type;

            return this;
        }

        public RoomBuilder setAccessible(boolean accessible) {
            this.accessible = accessible;

            return this;
        }

        public RoomBuilder setImage(String image) {
            this.image = image;

            return this;
        }

        public RoomBuilder setDescription(String description) {
            this.description = description;

            return this;
        }

        public RoomBuilder setFeatures(String[] features) {
            this.features = features;

            return this;
        }

        public RoomBuilder setRoomPrice(int roomPrice) {
            this.roomPrice = roomPrice;

            return this;
        }

        public Room build(){
            return new Room(roomName, type, accessible, image, description, features, roomPrice);
        }
    }
}
