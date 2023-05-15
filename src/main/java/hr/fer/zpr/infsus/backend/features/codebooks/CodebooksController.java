package hr.fer.zpr.infsus.backend.features.codebooks;

import hr.fer.zpr.infsus.backend.features.codebooks.data.Codebook;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CodebooksController {

    private final CodebooksService codebooksService;

    @GetMapping("/codebooks")
    private Map<String, List<Codebook>> getCodebooks() {
        return this.codebooksService.getCodebooks();
    }

    @GetMapping("/codebooks/{codebooks}")
    private Map<String, List<Codebook>> getCodebooks(@PathVariable List<String> codebooks) { return this.codebooksService.getCodebooks(codebooks); }
}
