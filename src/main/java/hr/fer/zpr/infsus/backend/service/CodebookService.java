package hr.fer.zpr.infsus.backend.service;

import hr.fer.zpr.infsus.backend.model.Codebook;
import hr.fer.zpr.infsus.backend.model.enums.CodebookEnum;
import hr.fer.zpr.infsus.backend.repository.CodebookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CodebookService {

    private final CodebookRepository codebooksRepository;

    public Map<String, List<Codebook>> getCodebooks() {
        Map<String, List<Codebook>> map = new HashMap<>();
        for (CodebookEnum codebook : CodebookEnum.values()) {
            map.put(codebook.name(), this.codebooksRepository.getCodebookTemplate(codebook));
        }
        return map;
    }

    public Map<String, List<Codebook>> getCodebooks(List<String> codebooks) {
        Map<String, List<Codebook>> map = new HashMap<>();
        for (String codebook : codebooks) {
            map.put(codebook, this.codebooksRepository.getCodebookTemplate(CodebookEnum.valueOf(codebook)));
        }
        return map;
    }

}
