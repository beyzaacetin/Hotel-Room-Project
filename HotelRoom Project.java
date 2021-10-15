package HW;


import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class HW5_Cetin_Beyza {
    public static void main(String[] args) throws FileNotFoundException {
    String fileString;
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter file name: ");
    fileString = scan.nextLine();
    Hotel hotel = readHotel(fileString);
    System.out.println("\nHotelName: "+hotel.getNAME());

    System.out.println("HotelPhone: "+hotel.getPhone());
    System.out.println("\n"+hotel);
    scan.close();
}
    private static Hotel readHotel(String filename) throws FileNotFoundException
    {
        int roomN, capacity, grade;
        Scanner scan = new Scanner(new File(filename));

        String name, receptionPhone, phoneNum;
        Hotel hotel;

        name = scan.nextLine();
        receptionPhone = scan.next();
        hotel = new Hotel(name, receptionPhone);
        while(scan.hasNext())
        {
            roomN = scan.nextInt();

            phoneNum = scan.next();
            capacity = scan.nextInt();
            grade = scan.nextInt();

            HotelRoom hotelRoom = new HotelRoom(roomN);
            hotelRoom.setCapacity(capacity);
            hotelRoom.setPhoneNumber(phoneNum);

            hotelRoom.setGrade(grade);


            hotel.addRoom(hotelRoom);
        }
        scan.close();
        return hotel;
    }
    public static class Hotel {
        private ArrayList<HotelRoom> roomList;
        private String name;

        private String phone;

        public Hotel(String NAME, String phone)
        {
            this.name = NAME;
            this.phone = phone;

            roomList = new ArrayList<>();
        }
        public String getNAME()
        {
            return name;
        }
        public String getPhone()
        {
            return phone;
        }

        public void addRoom(HotelRoom room)
        {
            roomList.add(room);
        }
        public String toString()
        {
            StringBuilder stringBuilder = new StringBuilder("ROOMS: ");
            for (HotelRoom hotelRoom : roomList) stringBuilder.append("\n")
                    .append(hotelRoom).append("\n");
            return stringBuilder.toString();
        }
    }
    public static class HotelRoom {
        private int Grade;
        private int RoomNo;
        private String PhoneNum;
        private int Capacity;

        public void setCapacity(int capacity)
        {
            this.Capacity = capacity;
        }
        public void setPhoneNumber(String phoneNumber)
        {
            this.PhoneNum = phoneNumber;
        }
        public HotelRoom(int roomNumber)
        {
            this.RoomNo = roomNumber;
        }
        public void setGrade(int grade)
        {
            this.Grade = grade;
        }
        public String toString()
        {
            return "RoomNo: "+ RoomNo +"\nPhoneNum: "+PhoneNum+"\nCapacity: "+ Capacity +"\nGrade:"+Grade;
        }
    }


}
