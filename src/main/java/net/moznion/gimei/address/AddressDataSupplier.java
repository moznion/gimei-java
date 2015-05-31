package net.moznion.gimei.address;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;
import net.moznion.gimei.Gimei;
import net.moznion.gimei.NameUnit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class AddressDataSupplier {
    public static final AddressData ADDRESS_DATA;

    static {
        ClassLoader classLoader = Gimei.class.getClassLoader();
        Path path = Paths.get(classLoader.getResource("addresses.yml").getFile());
        try {
            byte[] nameSource = Files.readAllBytes(path);
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            ADDRESS_DATA = mapper.readValue(nameSource, AddressData.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load addresses.yml file.");
        }
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class AddressData {
        private List<NameUnit> prefectures;
        private List<NameUnit> cities;
        private List<NameUnit> towns;

        @JsonProperty("addresses")
        public void setAll(Map<String, List<List<String>>> data) {
            prefectures = data.get("prefecture").stream()
                    .map(NameUnit::new)
                    .collect(Collectors.toList());
            cities = data.get("city").stream()
                    .map(NameUnit::new)
                    .collect(Collectors.toList());
            towns = data.get("town").stream()
                    .map(NameUnit::new)
                    .collect(Collectors.toList());
        }
    }
}
