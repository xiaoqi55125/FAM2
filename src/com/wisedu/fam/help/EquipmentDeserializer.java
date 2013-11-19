package com.wisedu.fam.help;

import java.text.ParseException;

import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.wisedu.fam.model.Equipment;

public class EquipmentDeserializer {

	public Equipment deserialize(JsonObject json) throws ParseException {
		int reject = 0;
		String  rejectDate = null, possessDate = null, purchaseDate = null;
		String lastUserId = null, equipmentSqlName = null, equipmentName = null, equipmentId = null;
		if (!(json.get("rejectDate") instanceof JsonNull)) {
			
			rejectDate = json.get("rejectDate").getAsString();
		}
		if (!(json.get("possessDate") instanceof JsonNull)) {
			possessDate = json.get("possessDate").getAsString();
		}
		if (!(json.get("purchaseDate") instanceof JsonNull)) {
			purchaseDate = json.get("purchaseDate").getAsString();
		}
		if (!(json.get("reject") instanceof JsonNull)) {
			reject = json.get("reject").getAsInt();
		}
		if (!(json.get("lastUserId") instanceof JsonNull)) {
			lastUserId = json.get("lastUserId").getAsString();
		}
		if (!(json.get("equipmentSqlName") instanceof JsonNull)) {
			equipmentSqlName = json.get("equipmentSqlName").getAsString();
		}
		if (!(json.get("equipmentName") instanceof JsonNull)) {
			equipmentName = json.get("equipmentName").getAsString();
		}
		if (!(json.get("equipmentId") instanceof JsonNull)) {
			equipmentId = json.get("equipmentId").getAsString();
		}

		return new Equipment(rejectDate, reject, possessDate, purchaseDate,
				lastUserId, equipmentSqlName, equipmentName, equipmentId);

	}
}