package com.example.flowchart.controller;

import com.example.flowchart.model.Edge;
import com.example.flowchart.model.Flowchart;
import com.example.flowchart.service.FlowchartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/flowcharts")
public class FlowchartController {
    private final FlowchartService service;

    public FlowchartController(FlowchartService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Flowchart> create(@RequestBody Flowchart flowchart) {
        return ResponseEntity.ok(service.createFlowchart(flowchart));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flowchart> get(@PathVariable String id) {
        return ResponseEntity.ok(service.getFlowchart(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flowchart> update(@PathVariable String id, @RequestBody Flowchart flowchart) {
        return ResponseEntity.ok(service.updateFlowchart(id, flowchart));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteFlowchart(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{flowchartId}/nodes/{nodeId}/outgoing-edges")
    public ResponseEntity<List<Edge>> getOutgoingEdges(@PathVariable String flowchartId, @PathVariable String nodeId) {
        return ResponseEntity.ok(service.getOutgoingEdges(flowchartId, nodeId));
    }

    @GetMapping("/{flowchartId}/nodes/{nodeId}/connected-nodes")
    public ResponseEntity<Set<String>> getConnectedNodes(@PathVariable String flowchartId, @PathVariable String nodeId) {
        return ResponseEntity.ok(service.getConnectedNodes(flowchartId, nodeId));
    }
}
