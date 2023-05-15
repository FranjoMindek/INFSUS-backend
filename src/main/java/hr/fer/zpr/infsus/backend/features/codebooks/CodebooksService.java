package hr.fer.zpr.infsus.backend.features.codebooks;

import hr.fer.zpr.infsus.backend.features.codebooks.data.Codebook;
import hr.fer.zpr.infsus.backend.features.codebooks.data.CodebookEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CodebooksService {

    private final CodebooksRepository codebooksRepository;

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
