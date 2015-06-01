package net.moznion.gimei;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NounDataSupplier {
	private static final NounData NOUN_DATA;

	static {
		ClassLoader classLoader = Gimei.class.getClassLoader();
		Path path = Paths.get(classLoader.getResource("nouns.yml").getFile());
		try {
			byte[] nounSource = Files.readAllBytes(path);
			ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
			NOUN_DATA = mapper.readValue(nounSource, NounData.class);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load nouns.yml file.");
		}
	}

	public static NounData getNounData() {
		return NOUN_DATA;
	}

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class NounData {
		private List<NameUnit> nouns;

		@JsonProperty("nouns")
		public void setNouns(List<List<String>> data) {
			this.nouns = Collections.unmodifiableList(
				data.stream()
					.map(NameUnit::new)
					.collect(Collectors.toList())
				);
		}
	}
}
