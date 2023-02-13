package runner;

import mapping.MappingStep;
import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;

public class SearchingEmbedder extends ConfigurableEmbedder {
    public Embedder embedder;
    @Override
    @Test
    public void run() {
        embedder = configuredEmbedder();
        embedder.configuration();
        System.out.println("hahahahahah running embdder");

        List<String> storyPaths = new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(),
                Collections.singletonList("**/*.story"), Arrays.asList(""));
        embedder.runStoriesAsPaths(storyPaths);

    }

    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(codeLocationFromClass(this.getClass()))
                        .withFormats(CONSOLE, HTML));
    }


    public InjectableStepsFactory stepsFactory(){
        return new InstanceStepsFactory(configuration(), new MappingStep());
    }
}
