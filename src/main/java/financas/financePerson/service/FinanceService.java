package financas.financePerson.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import financas.financePerson.dto.FinanceDTO;
import financas.financePerson.model.Finance;
import financas.financePerson.repository.FinanceRepository;

import java.util.List;

@Service
public class FinanceService {

    @Autowired
    private FinanceRepository financeRepository;

    public ResponseEntity<List<FinanceDTO>> listarFinancas() {
        List<Finance> pizza = financeRepository.findAll();
        return ResponseEntity.ok(FinanceDTO.converter(pizza));

    }
}
