package com.example.flowchart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flowchart {
    private String id = UUID.randomUUID().toString();
    private List<Node> nodes;
    private List<Edge> edges;
}
