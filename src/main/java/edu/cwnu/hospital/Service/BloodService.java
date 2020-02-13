package edu.cwnu.hospital.Service;

import edu.cwnu.hospital.Pojo.Blood;
import edu.cwnu.hospital.utils.PageBean;

import java.util.List;

public interface BloodService {
    Blood findById(int b_id);
    PageBean<Blood> findByPage(int currentPage);
    List<Blood> findMyself(int u_id);
    void insertone(Blood blood);

    void updateState(Blood blood);

    void deleteById(int b_id);

    PageBean<Blood> selectByState(String state);
}
