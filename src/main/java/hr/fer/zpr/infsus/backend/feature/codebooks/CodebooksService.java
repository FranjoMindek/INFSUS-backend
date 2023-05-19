package hr.fer.zpr.infsus.backend.feature.codebooks;

import hr.fer.zpr.infsus.backend.feature.codebooks.data.Codebook;
import hr.fer.zpr.infsus.backend.feature.codebooks.data.CodebookEnum;
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

    public List<Codebook> getCodebook(String codebook) {
        return this.codebooksRepository.getCodebookTemplate(CodebookEnum.valueOf(codebook));
    }


    public Map<String, List<Codebook>> getCodebooksByEnum(List<CodebookEnum> codebooks) {
        Map<String, List<Codebook>> map = new HashMap<>();
        for (CodebookEnum codebook : codebooks) {
            map.put(codebook.getName(), this.codebooksRepository.getCodebookTemplate(codebook));
        }
        return map;
    }

    public List<Codebook> getCodebookByEnum(CodebookEnum codebook) {
        return this.codebooksRepository.getCodebookTemplate(codebook);
    }

}
