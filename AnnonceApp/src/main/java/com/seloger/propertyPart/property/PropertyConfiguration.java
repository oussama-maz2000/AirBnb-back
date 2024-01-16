package com.seloger.propertyPart.property;

import com.seloger.propertyPart.patterns.chain.ChainBuilder;
import com.seloger.propertyPart.patterns.chain.Handler;
import com.seloger.propertyPart.patterns.chain.IChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.IntStream;

@Configuration
public class PropertyConfiguration {
    @Bean
    public IChain<PropertyAnnonce> propertyAnnonceIChain(
            final List<Handler<PropertyAnnonce>> handlers) {

        final ChainBuilder<PropertyAnnonce> builder = ChainBuilder.chainBuilder();
        final ChainBuilder<PropertyAnnonce>.SuccessorBuilder successorBuilder =
                builder.first(handlers.get(0));
        IntStream.range(1, handlers.size()).forEach(i -> successorBuilder.next(handlers.get(i)));

        return successorBuilder.build();
    }
}
