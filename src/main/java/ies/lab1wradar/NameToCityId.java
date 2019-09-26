package ies.lab1wradar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NameToCityId {

	Map<String, Integer> nameToCityId = new HashMap<>();

	public NameToCityId(List<CityInfo> cityInfo) {
		for (CityInfo ci : cityInfo) {
			nameToCityId.put(ci.getLocal(), ci.getGlobalIdLocal());
		}
	}

	public Integer getCityId(String cityName) {
		return nameToCityId.get(cityName);
	}

}
