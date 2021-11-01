package coffee.machine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties
public class CoffeeMachineInput {
    @JsonProperty("machine")
    private Machines machine;

    @Data
    @JsonIgnoreProperties
    public static class Machines {
        @JsonProperty("outlets")
        private Outlets outlets;
        @JsonProperty("total_items_quantity")
        private Map<String, Integer> quantity;
        @JsonProperty("beverages")
        private Map<String, Map<String, Integer>> beverages;
    }

    @Data
    @JsonIgnoreProperties
    public static class Outlets {
        @JsonProperty("count_n")
        private int count;
    }
}
