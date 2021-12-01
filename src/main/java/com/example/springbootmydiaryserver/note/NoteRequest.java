package com.example.springbootmydiaryserver.note;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class NoteRequest {

    @NotNull
    @Min(5)
    private String title;

    @NotNull
    @Min(5)
    private String content;
}
