package com.serializers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonDateTimeSerializer extends JsonSerializer<LocalDateTime> {

  @Override
  public void serialize(LocalDateTime dataParaSerializar, JsonGenerator dataSerializada,
      SerializerProvider provider) {

    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    LocalDateTime localDateTime = LocalDateTime.parse(dataParaSerializar.toString());

    String formatLocalDateTime = formatter.format(localDateTime);

    try {
      dataSerializada.writeString(formatLocalDateTime);
    } catch (IOException e) {
      System.err.println("NÃo foi possivel Serializar " + dataParaSerializar);
      e.printStackTrace();
    }
  }
}
