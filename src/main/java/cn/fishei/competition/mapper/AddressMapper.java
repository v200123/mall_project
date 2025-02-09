package cn.fishei.competition.mapper;

import cn.fishei.competition.bean.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {

    int insertAddress(Address address);

    int deleteAddress(int id);

    List<Address> queryAddr(int userId);

    Address queryAddressById(int id);


}
