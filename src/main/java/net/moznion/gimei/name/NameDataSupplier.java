package net.moznion.gimei.name;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;
import lombok.Getter;
import net.moznion.gimei.Gimei;
import net.moznion.gimei.NameUnit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class NameDataSupplier {
	private static final NameData NAME_DATA;

	static {
		ClassLoader classLoader = Gimei.class.getClassLoader();
		Path path = Paths.get(classLoader.getResource("names.yml").getFile());
		try {
			byte[] nameSource = Files.readAllBytes(path);
			ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
			NAME_DATA = mapper.readValue(nameSource, NameData.class);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load names.yml file.");
		}
	}

	public static NameData getNameData() {
		return NAME_DATA;
	}

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	static class NameData {
		private FirstName firstName;

		private List<NameUnit> lastName;

		@JsonProperty("first_name")
		public void setFirstName(Map<String, List<List<String>>> data) {
			this.firstName = new FirstName(data);
		}

		@JsonProperty("last_name")
		public void setLastName(List<List<String>> data) {
			this.lastName = Collections.unmodifiableList(
				data.stream()
					.map(NameUnit::new)
					.collect(Collectors.toList())
				);
		}
	}

	@Getter
	static class FirstName {
		private final List<NameUnit> male;
		private final List<NameUnit> female;

		public FirstName(Map<String, List<List<String>>> data) {
			male = Collections.unmodifiableList(
				data.get("male").stream()
					.map(NameUnit::new)
					.collect(Collectors.toList())
				);
			female = Collections.unmodifiableList(
				data.get("female").stream()
					.map(NameUnit::new)
					.collect(Collectors.toList())
				);
		}
	}
}
