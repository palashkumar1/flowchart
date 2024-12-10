package com.example.flowchart.repository;

import com.example.flowchart.model.Flowchart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class FlowchartRepository {
    private final Map<String, Flowchart> flowcharts = new HashMap<>();

    public Flowchart save(Flowchart flowchart) {
        flowcharts.put(flowchart.getId(), flowchart);
        return flowchart;
    }

    public Flowchart findById(String id) {
        return flowcharts.get(id);
    }

    public Map<String, Flowchart> findAll() {
        return flowcharts;
    }

    public void deleteById(String id) {
        flowcharts.remove(id);
    }

    public boolean existsById(String id) {
        return flowcharts.containsKey(id);
    }
}
