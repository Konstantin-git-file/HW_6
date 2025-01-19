package org.example.hw;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point {
    private int x;
    private int y;

    public String getTextRepresentation() {
        return "{" + x + ";" + y + "}";
    }
}
