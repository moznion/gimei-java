package net.moznion.gimei.name;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import net.moznion.gimei.NameUnit;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import lombok.Data;
import lombok.Getter;

class NameDataSupplier {
	private static final NameData NAME_DATA;

	static {
		try (InputStream in = NameDataSupplier.class.getResourceAsStream("/names.yml")) {
			String nameSource;
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
				nameSource = reader.lines().collect(Collectors.joining("\n"));
			}
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
			final List<NameUnit> lastName = new ArrayList<>();
			for (List<String> datam : data) {
				lastName.add(new NameUnit(datam));
			}

			this.lastName = Collections.unmodifiableList(lastName);
		}
	}

	@Getter
	static class FirstName {
		private final List<NameUnit> male;
		private final List<NameUnit> female;

		public FirstName(Map<String, List<List<String>>> data) {
			final List<NameUnit> male = new ArrayList<>();
			for (List<String> datam : data.get("male")) {
				male.add(new NameUnit(datam));
			}
			this.male = Collections.unmodifiableList(male);

			final List<NameUnit> female = new ArrayList<>();
			for (List<String> datam : data.get("female")) {
				female.add(new NameUnit(datam));
			}
			this.female = Collections.unmodifiableList(female);
		}
	}
}
