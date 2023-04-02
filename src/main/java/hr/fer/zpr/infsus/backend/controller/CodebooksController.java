package hr.fer.zpr.infsus.backend.controller;

import hr.fer.zpr.infsus.backend.model.Codebook;
import hr.fer.zpr.infsus.backend.service.CodebookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CodebooksController {

    private final CodebookService codebookService;

    @GetMapping("/codebooks")
    private Map<String, List<Codebook>> getCodebooks() {
        return this.codebookService.getCodebooks();
    }
}
