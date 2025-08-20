package com.example.demo.memo;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Memo {
    private  Long id;
    private  String title;
    private  boolean done;
    private LocalDateTime createdAt;
}
