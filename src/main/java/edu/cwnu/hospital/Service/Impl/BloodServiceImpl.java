package edu.cwnu.hospital.Service.Impl;

import edu.cwnu.hospital.Mapper.BloodMapper;
import edu.cwnu.hospital.Pojo.Blood;
import edu.cwnu.hospital.Service.BloodService;
import edu.cwnu.hospital.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodServiceImpl implements BloodService {
    @Autowired
    private BloodMapper bloodMapper;
    @Override
    public Blood findById(int b_id) {
        return bloodMapper.findById(b_id);
    }

    @Override
    public PageBean<Blood> findByPage(int currentPage) {
        PageBean<Blood> pageBean=new PageBean<Blood>();
        int totalcount=bloodMapper.findAll().size();
        int totalPage = totalcount % 10 == 0 ? totalcount / 10 :(totalcount / 10) + 1 ;
        int start=10*(currentPage-1);
        List<Blood> byPage = bloodMapper.findByPage(start);
        pageBean.setCurrentPage(currentPage);
        pageBean.setList(byPage);
        pageBean.setTotalCount(totalcount);
        pageBean.setTotalPage(totalPage);


        return pageBean;
    }

    @Override
    public List<Blood> findMyself(int u_id) {
        return bloodMapper.findMyself(u_id);
    }

    @Override
    public void insertone(Blood blood) {
        bloodMapper.insertone(blood);
    }

    @Override
    public void updateState(Blood blood) {
           bloodMapper.updateState(blood);
    }

    @Override
    public void deleteById(int b_id) {
        bloodMapper.deleteById(b_id);
    }

    @Override
    public PageBean<Blood> selectByState(String state) {
        PageBean<Blood> pageBean=new PageBean<>();
        List<Blood> bloodList=bloodMapper.selectByState(state);
        pageBean.setList(bloodList);

        return pageBean;
    }
}
