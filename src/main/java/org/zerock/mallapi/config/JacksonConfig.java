package org.zerock.mallapi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@Configuration
public class JacksonConfig {

  private static final String dateFormat = "yyyy-MM-dd";
  private static final String datetimeFormat = "yyyy-MM-dd HH:mm:ss";

//  @Bean
//  public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer(){
//    return jacksonObjectMapperBuilder -> {
//      jacksonObjectMapperBuilder.timeZone(TimeZone.getTimeZone("UTC"));
//      jacksonObjectMapperBuilder.simpleDateFormat(datetimeFormat);
//      jacksonObjectMapperBuilder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)));
//      jacksonObjectMapperBuilder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(datetimeFormat)));
//    };
//  }

//  @Bean
//  public Jackson2ObjectMapperBuilderCustomizer configureJackson() {
//    return builder -> {
//      // JavaTimeModule 등록 (역직렬화/직렬화)
//      builder.modules(new JavaTimeModule());
//      // 타임스탬프를 사용하지 않음
//      builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//    };
//  }
//  @Bean
//  public ObjectMapper objectMapper() {
//    return new ObjectMapper().registerModule( new JavaTimeModule())
//            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
//            .enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//  }

}
