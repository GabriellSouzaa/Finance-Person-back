package financas.financePerson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import financas.financePerson.model.Finance;

@Repository
public interface FinanceRepository extends JpaRepository<Finance,Long> {

}
