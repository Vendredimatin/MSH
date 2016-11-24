package blservice.hotelblservice;

import util.City;
import util.ResultMessage;
import util.RoomType;
import vo.FilterFlagsVO;
import vo.HotelRoomVO;
import vo.Hotel_DetailVO;
import vo.RoomChangeInfoVO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by SilverNarcissus on 16/10/12.
 */
public class HotelBLService_Stub implements HotelBLService {
    public ArrayList<Hotel_DetailVO> searchHotel(FilterFlagsVO flags) {
        System.out.println("Search Success!");
        return new ArrayList<Hotel_DetailVO>();
    }


    public Hotel_DetailVO getHotel(String hotelID) {
        if (hotelID.equals("000000")) {
            System.out.println("Get hotel Success!");
            return new Hotel_DetailVO(null, null, City.NanJing, null, null, 0, null, null, null, 0, 0);
        }
        return null;
    }

    public ArrayList<HotelRoomVO> getRoom(String hotelID) {
        if (hotelID.equals("000000")) {
            System.out.println("Get hotel room Success!");
            return new ArrayList<HotelRoomVO>();
        }
        return null;
    }

    public ResultMessage updateHotel(Hotel_DetailVO hvo) {
        if (hvo.ID.equals("000000")) {
            System.out.println("Update hotel Success!");
            return ResultMessage.SUCCESS;
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage updateHotelRoom(HotelRoomVO rvo) {
        if (rvo != null) {
            System.out.println("Update hotel room Success!");
            return ResultMessage.SUCCESS;
        }
        return ResultMessage.FAILED;
    }

    @Override
    public ResultMessage updateHotelRoomQuantity(RoomChangeInfoVO roomChangeInfoVO) {
        return null;
    }

    public ResultMessage addHotel(Hotel_DetailVO hvo) {
        if (hvo.ID.equals("000000")) {
            System.out.println("Add hotel Success!");
            return ResultMessage.SUCCESS;
        }
        return ResultMessage.NOT_EXIST;
    }

    public ResultMessage addRoom(HotelRoomVO rvo) {
        if (rvo != null) {
            System.out.println("Add hotel room Success!");
            return ResultMessage.SUCCESS;
        }
        return ResultMessage.EXIST;
    }

    public ResultMessage deleteHotel(String hotelID) {
        if (hotelID.equals("000000")) {
            System.out.println("Delete Success!");
            return ResultMessage.SUCCESS;
        }
        return ResultMessage.NOT_EXIST;
    }

    public ResultMessage deleteHotelRoom(String hotelID, RoomType type) {
        if (hotelID.equals("000000")) {
            System.out.println("Delete Success!");
            return ResultMessage.SUCCESS;
        }
        return ResultMessage.NOT_EXIST;
    }

    @Override
    public ResultMessage setRoomWillBeCancel(String hotelID, RoomType type) {
        return null;
    }

    @Override
    public ResultMessage isOrdered(String hotelID, RoomType type) {
        return null;
    }

    @Override
    public Iterator<Hotel_DetailVO> priceAscendingSort(ArrayList<Hotel_DetailVO> hotel_detailVOs) {
        return null;
    }

    @Override
    public Iterator<Hotel_DetailVO> priceDescendingSort(ArrayList<Hotel_DetailVO> hotel_detailVOs) {
        return null;
    }

    @Override
    public Iterator<Hotel_DetailVO> starAscendingSort(ArrayList<Hotel_DetailVO> hotel_detailVOs) {
        return null;
    }

    @Override
    public Iterator<Hotel_DetailVO> starDescendingSort(ArrayList<Hotel_DetailVO> hotel_detailVOs) {
        return null;
    }

    @Override
    public Iterator<Hotel_DetailVO> scoreAscendingSort(ArrayList<Hotel_DetailVO> hotel_detailVOs) {
        return null;
    }

    @Override
    public Iterator<Hotel_DetailVO> scoreDescendingSort(ArrayList<Hotel_DetailVO> hotel_detailVOs) {
        return null;
    }
}
