package org.zerock.mallapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

  private Long tno;

  private String title;

  private String writer;

  private boolean complete;

  //@DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
  private LocalDate due_date;
}
