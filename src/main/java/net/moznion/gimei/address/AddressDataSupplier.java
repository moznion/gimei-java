package net.moznion.gimei.address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import net.moznion.gimei.NameUnit;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import lombok.Data;

class AddressDataSupplier {
	public static final AddressData ADDRESS_DATA;

	static {
		try (InputStream in = AddressDataSupplier.class.getResourceAsStream("/addresses.yml")) {
			String addressDataSource;
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
				addressDataSource = reader.lines().collect(Collectors.joining("\n"));
			}
			ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
			ADDRESS_DATA = mapper.readValue(addressDataSource, AddressData.class);
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
