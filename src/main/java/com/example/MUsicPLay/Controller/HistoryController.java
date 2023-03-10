package com.example.MUsicPLay.Controller;

import com.example.MUsicPLay.Model.Content;
import com.example.MUsicPLay.Model.History;
import com.example.MUsicPLay.Model.User;
import com.example.MUsicPLay.Service.ContentService;
import com.example.MUsicPLay.Service.HistoryService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class HistoryController {
    @Autowired
    private HistoryService historyService;
    @GetMapping("/history/search")
    public History getLatestContent(@RequestParam Long user_id, @RequestParam Long content_id) {
        return historyService.findByUserAndContent(user_id, content_id);
    }
    @GetMapping("/history/all")
    public List<History> getAllHistory() {
        return historyService.getAllHistory();
    }
    @GetMapping("/history/get/{id}")
    public History getHistoryById(@PathVariable Long id) {
        return historyService.getHistoryById(id);
    }
    @PostMapping("/history/add")
    public History addHistory(@RequestBody History user) {
        History savedContent = historyService.addHistory(user);
        return new ResponseEntity<>(savedContent, HttpStatus.CREATED).getBody();
    }
    @PutMapping("/history/update")
    public History updateHistory(@RequestBody History user) {
        return historyService.updateHistory(user);
    }
    @DeleteMapping("/history/delete/{id}")
    public void deleteHistory(@PathVariable Long id) {
        historyService.deleteHistory(id);
    }
}
