package com.example.flowchart.service;

import com.example.flowchart.model.Edge;
import com.example.flowchart.model.Flowchart;
import com.example.flowchart.model.Node;
import com.example.flowchart.repository.FlowchartRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FlowchartService {
    private final FlowchartRepository repository;

    public FlowchartService(FlowchartRepository repository) {
        this.repository = repository;
    }

    public Flowchart createFlowchart(Flowchart flowchart) {
        return repository.save(flowchart);
    }

    public Flowchart getFlowchart(String id) {
        return repository.findById(id);
    }

    public Flowchart updateFlowchart(String id, Flowchart updatedFlowchart) {
        if (repository.existsById(id)) {
            updatedFlowchart.setId(id);
            return repository.save(updatedFlowchart);
        }
        return null;
    }

    public void deleteFlowchart(String id) {
        repository.deleteById(id);
    }

    public List<Edge> getOutgoingEdges(String flowchartId, String nodeId) {
        Flowchart flowchart = repository.findById(flowchartId);
        return flowchart.getEdges().stream()
                .filter(edge -> edge.getFromNodeId().equals(nodeId))
                .collect(Collectors.toList());
    }

    public Set<String> getConnectedNodes(String flowchartId, String nodeId) {
        Flowchart flowchart = repository.findById(flowchartId);
        Set<String> visited = new HashSet<>();
        dfs(nodeId, flowchart.getEdges(), visited);
        return visited;
    }

    private void dfs(String nodeId, List<Edge> edges, Set<String> visited) {
        if (visited.contains(nodeId)) return;
        visited.add(nodeId);
        for (Edge edge : edges) {
            if (edge.getFromNodeId().equals(nodeId)) {
                dfs(edge.getToNodeId(), edges, visited);
            }
        }
    }
}
