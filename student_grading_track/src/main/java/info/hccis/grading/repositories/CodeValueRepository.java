package info.hccis.grading.repositories;

import info.hccis.grading.jpa.entity.CodeValue;
import info.hccis.grading.jpa.entity.TicketOrder;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeValueRepository extends CrudRepository<CodeValue, Integer> {
        List<CodeValue> findByCodeTypeId(Integer codeTypeId);
}