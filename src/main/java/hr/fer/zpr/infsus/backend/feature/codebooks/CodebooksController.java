package hr.fer.zpr.infsus.backend.feature.codebooks;

import hr.fer.zpr.infsus.backend.feature.codebooks.data.Codebook;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity<Map<String, List<Codebook>>> getCodebooks() {
        return ResponseEntity.ok(this.codebooksService.getCodebooks());
    }

    @GetMapping("/codebooks/{codebooks}")
    private ResponseEntity<Map<String, List<Codebook>>> getCodebooks(@PathVariable List<String> codebooks) {
        return ResponseEntity.ok(this.codebooksService.getCodebooks(codebooks));
    }
}
