package com.example.demo.memo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller                      // ← RestController 아님!
@RequestMapping("/memos")        // ← method 지정하지 말기
@RequiredArgsConstructor
public class MemoController {

    private final MemoService service;

    @GetMapping                   // GET /memos
    public String list(Model model) {
        model.addAttribute("memos", service.list());
        return "memos";             // ← 뷰 이름 명시
    }

    @PostMapping                  // POST /memos
    public String add(@RequestParam String title, RedirectAttributes ra) {
        if (title != null && !title.isBlank()) {
            service.add(title.trim());
            ra.addFlashAttribute("msg", "메모가 추가되었습니다.");
        }
        return "redirect:/memos";
    }

    @PostMapping("/{id}/toggle")
    public String toggle(@PathVariable Long id) {
        service.toggle(id);
        return "redirect:/memos";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/memos";
    }
}
