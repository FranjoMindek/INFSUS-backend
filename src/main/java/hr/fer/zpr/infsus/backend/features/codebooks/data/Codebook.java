package hr.fer.zpr.infsus.backend.features.codebooks.data;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Codebook {
    String id;
    String name;
}
