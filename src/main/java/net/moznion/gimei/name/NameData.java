package net.moznion.gimei.name;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;
import lombok.Getter;
import net.moznion.gimei.Gimei;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class NameData {
    public static final NameYAML nameYAML;

    static {
        ClassLoader classLoader = Gimei.class.getClassLoader();
        Path path = Paths.get(classLoader.getResource("names.yml").getFile());
        try {
            byte[] nameSource = Files.readAllBytes(path);
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            nameYAML = mapper.readValue(nameSource, NameYAML.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load names.yml file.");
        }
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class NameYAML {
        private FirstName firstName;

        private List<NameUnit> lastName;

        @JsonProperty("first_name")
        public void setFirstName(Map<String, List<List<String>>> data) {
            this.firstName = new FirstName(data);
        }

        @JsonProperty("last_name")
        public void setLastName(List<List<String>> data) {
            this.lastName = data.stream()
                    .map(NameUnit::new)
                    .collect(Collectors.toList());
        }
    }

    @Getter
    static class FirstName {
        private final List<NameUnit> male;
        private final List<NameUnit> female;

        public FirstName(Map<String, List<List<String>>> data) {
            male = data.get("male").stream()
                    .map(NameUnit::new)
                    .collect(Collectors.toList());
            female = data.get("female").stream()
                    .map(NameUnit::new)
                    .collect(Collectors.toList());
        }
    }
}
