package edu.cwnu.hospital.Mapper;

        import edu.cwnu.hospital.Pojo.Hospital;
        import org.hibernate.validator.constraints.EAN;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface HospitalMapper {
    public Hospital findById(int h_id) ;
    public List<Hospital> findByAddress(String h_address);

    List<Hospital> findAll();
}
