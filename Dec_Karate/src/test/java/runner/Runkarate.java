package runner;

import org.junit.runner.RunWith;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;

@RunWith(Karate.class)
@KarateOptions(features = {"src/test/java/features/IncidentManagement2.feature"})
public class Runkarate {

}
